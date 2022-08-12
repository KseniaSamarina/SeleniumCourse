package seleniumcourse.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumcourse.BaseTest;
import seleniumcourse.testproperties.TestProperties;

import java.util.Properties;

public class CreateBusinessTrip extends BaseTest {

    private final Properties properties = TestProperties.getInstance().getProperties();

    @FindBy(xpath = "//select[@name='crm_business_trip[businessUnit]']")
    private WebElement openDepartmentMenu;

    @FindBy(xpath = "//option[@value='4' and text() = 'Центр разработки и сопровождения']")
    private WebElement selectDepartment;

    @FindBy(xpath = "//a[@id='company-selector-show' and text() = 'Открыть список']")
    private WebElement openCompany;

    @FindBy(xpath = "//a[@class='select2-choice select2-default']")
    private WebElement showCompanyList;

    @FindBy(xpath = "//div[@class='select2-result-label' and text() = '(Хром) Призрачная Организация Охотников']")
    private WebElement selectCompany;

    @FindBy(xpath = "//input[@type='checkbox' and @value='1']")
    private WebElement selectCheckbox;

    @FindBy(xpath = "//input[@name='crm_business_trip[arrivalCity]']")
    private WebElement enterArrivalCity;

    @FindBy(xpath = "//input[contains(@id, 'date_selector_crm_business_trip_departureDatePlan')]")
    private WebElement enterDepartureDate;

    @FindBy(xpath = "//div[@id='oro-dropdown-mask']")
    private WebElement clickSomewhere;

    @FindBy(xpath = "//input[contains(@id, 'date_selector_crm_business_trip_returnDatePlan')]")
    private WebElement enterReturnDate;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    private WebElement clickSaveAndClose;

    @FindBy(xpath = "//span[@class='validation-failed']")
    private WebElement messageValidationFailed;

    @FindBy(xpath = "//input[@name='crm_business_trip[company]']")
    private WebElement company;

    public void enterValues() {
        openDepartmentMenu.click();
        selectDepartment.click();
        openCompany.click();
        showCompanyList.click();
        selectCompany.click();
        selectCheckbox.click();
        enterArrivalCity.sendKeys("Россия, Магадан");
        enterDepartureDate.sendKeys("22.10.2022");
        clickSomewhere.click();
        enterReturnDate.sendKeys("22.10.2099");
        clickSomewhere.click();
    }

    public void dataVerification() {
        Assertions.assertEquals("Центр разработки и сопровождения",
                selectDepartment.getText(), "Поле заполнено неверно");
        Assertions.assertEquals("(Хром) Призрачная Организация Охотников",
                company.getAttribute("value"), "Поле заполнено неверно");
        Assertions.assertTrue(selectCheckbox.isSelected(), "Чекбокс 'Заказ билетов' не выбран");
        Assertions.assertEquals("Россия, Магадан", enterArrivalCity.getAttribute("value"), "Поле заполнено неверно");
        Assertions.assertEquals("22.10.2022", enterDepartureDate.getAttribute("value"), "Поле заполнено неверно");
        Assertions.assertEquals("22.10.2099", enterReturnDate.getAttribute("value"), "Поле заполнено неверно");
    }

    public void popupMessage() {
        clickSaveAndClose.click();
        loading();
        messageValidationFailed.isDisplayed();

        Assertions.assertTrue(messageValidationFailed.isDisplayed(), "Страница не загрузилась");
        Assertions.assertEquals("Список командируемых сотрудников не может быть пустым", messageValidationFailed.getText(), "Сообщения об ошибке валидации не появилось!");
    }
}
