package SeleniumCourse.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FirstTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 10, 1000);

        driver.get("http://training.appline.ru/user/login");
    }

    @Test
    public void firstTest() {
        //Шаг 1. Авторизация
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                "//form[@id='login-form']"))));
        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys(
                "Sekretar Kompanii");
        driver.findElement(By.xpath("//input[@name='_password']")).sendKeys("testing");
        driver.findElement(By.xpath("//button[@class='btn btn-large  btn-primary pull-right']")).click();

        WebElement titlePanel = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));

        Assert.assertTrue("Страница не загрузилась", titlePanel.isDisplayed());
        Assert.assertEquals("Заголовок на странице не совпадает", "Панель быстрого запуска",
                titlePanel.getText());

        //Шаг 2. Переход на страницу командировок
        WebElement costsList = driver.findElement(By.xpath(
                "//ul[contains(@class,'main-menu')]/li/a/span[text() = 'Расходы']"));
        costsList.click();
        wait.until(ExpectedConditions.visibilityOf(costsList.findElement(By.xpath(
                "./ancestor::li//ul[@class='dropdown-menu menu_level_1']"))));
        driver.findElement(By.xpath("//span[text()='Командировки']")).click();
        loading();
        driver.findElement(By.xpath("//a[@class='btn back icons-holder-text ']")).click();
        loading();

        WebElement titleCreateBusinessTrip = driver.findElement(By.xpath(
                "//h1[text() = 'Создать командировку']"));

        Assert.assertTrue("Страница не загрузилась", titleCreateBusinessTrip.isDisplayed());
        Assert.assertEquals("Заголовок на странице не совпадает", "Создать командировку",
                titleCreateBusinessTrip.getText());

        //Шаг 3. Создание командировки, заполнение полей
        WebElement departmentList = driver.findElement(By.xpath(
                "//select[@name='crm_business_trip[businessUnit]']"));
        departmentList.click();
        driver.findElement(By.xpath(
                "//option[@value='4' and text() = 'Центр разработки и сопровождения']")).click();
        driver.findElement(By.xpath(
                "//a[@id='company-selector-show' and text() = 'Открыть список']")).click();
        driver.findElement(By.xpath(
                "//a[@class='select2-choice select2-default']")).click();
        driver.findElement(By.xpath(
                        "//div[@class='select2-result-label' and text() = '(Хром) Призрачная Организация Охотников']")).
                click();
        driver.findElement(By.xpath(
                "//input[@type='checkbox' and @value='1']")).click();
        driver.findElement(By.xpath(
                "//input[@name='crm_business_trip[arrivalCity]']")).sendKeys("Россия, Магадан");
        driver.findElement(By.xpath(
                        "//input[contains(@id, 'date_selector_crm_business_trip_departureDatePlan')]")).
                sendKeys("22.10.2022");
        driver.findElement(By.xpath("//div[@id='oro-dropdown-mask']")).click();
        driver.findElement(By.xpath("//input[contains(@id, 'date_selector_crm_business_trip_returnDatePlan')]")).
                sendKeys("22.10.2099");
        driver.findElement(By.xpath("//div[@id='oro-dropdown-mask']")).click();

        //Шаг 4. Проверка заполненных полей
        WebElement selectDepartment = driver.findElement(By.xpath(
                "//span[text() = 'Центр разработки и сопровождения']"));
        WebElement selectCompany = driver.findElement(By.xpath(
                "//span[text() = '(Хром) Призрачная Организация Охотников']"));
        WebElement checkbox = driver.findElement(By.xpath(
                "//input[contains(@id, 'crm_business_trip_tasks_1')]"));
        WebElement arrivalCity = driver.findElement(By.xpath("//input[@name='crm_business_trip[arrivalCity]']"));
        WebElement departureDate = driver.findElement(By.xpath(
                "//input[contains(@id, 'date_selector_crm_business_trip_departureDatePlan')]"));
        WebElement returnDate = driver.findElement(By.xpath("//input[contains(@id, 'date_selector_crm_business_trip_returnDatePlan')]"));
        Assert.assertEquals("Поле заполнено неверно", "Центр разработки и сопровождения",
                selectDepartment.getText());
        Assert.assertEquals("Поле заполнено неверно", "(Хром) Призрачная Организация Охотников",
                selectCompany.getText());
        Assert.assertTrue("Чекбокс 'Заказ билетов' не выбран", checkbox.isSelected());
        Assert.assertEquals("Поле заполнено неверно", "Россия, Магадан", arrivalCity.getAttribute("value"));
        Assert.assertEquals("Поле заполнено неверно", "22.10.2022", departureDate.getAttribute("value"));
        Assert.assertEquals("Поле заполнено неверно", "22.10.2099", returnDate.getAttribute("value"));

        //Шаг 5. Проверка, что на странице появилось сообщение "Список командируемых сотрудников не может быть пустым"
        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
        loading();

        WebElement messageValidationFailed = driver.findElement(By.xpath("//span[@class='validation-failed']"));

        Assert.assertTrue("Страница не загрузилась", messageValidationFailed.isDisplayed());
        Assert.assertEquals("Сообщения об ошибке валидации не появилось!",
                "Список командируемых сотрудников не может быть пустым", messageValidationFailed.getText());
    }

    @After
    public void after() {
        driver.quit();
    }

    public void loading() {
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                "//div[@class='loader-content']")))));
    }
}
