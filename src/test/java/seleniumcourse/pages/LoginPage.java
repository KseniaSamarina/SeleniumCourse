package seleniumcourse.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import seleniumcourse.BaseTest;
import seleniumcourse.testproperties.TestProperties;

import java.util.Properties;

public class LoginPage extends BaseTest {

    private final Properties properties = TestProperties.getInstance().getProperties();
    @FindBy(xpath = "//form[@id='login-form']")
    private WebElement loginFormWindow;

    @FindBy(xpath = "//input[@name='_username']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='btn btn-large  btn-primary pull-right']")
    private WebElement submitButton;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement subtitle;

    @Step("Ввод логина и пароля")
    public void enterLoginAndPassword() {
        wait.until(ExpectedConditions.visibilityOf(loginFormWindow));
        loginField.sendKeys(properties.getProperty("LOGIN"));
        passwordField.sendKeys(properties.getProperty("PASSWORD"));
    }

    public void submitClick() {
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(subtitle));

        Assertions.assertTrue(subtitle.isDisplayed(), "Страница не загрузилась");
        Assertions.assertEquals("Панель быстрого запуска",
                subtitle.getText(), "Заголовок на странице не совпадает");
    }

}
