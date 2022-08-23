package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import project.BaseTest;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static testproperties.TestProperties.getInstance;

public class LoginPage extends BaseTest {

    private final Properties properties = getInstance().getProperties();
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

    public LoginPage enterLoginAndPassword(String login, String password) {
        wait.until(visibilityOf(loginFormWindow));
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        return pageManager.getLoginPage();
    }

    public LaunchPage submitClick() {
        submitButton.click();
        wait.until(visibilityOf(subtitle));

        assertTrue(subtitle.isDisplayed(), "Страница не загрузилась");
        assertEquals("Панель быстрого запуска",
                subtitle.getText(), "Заголовок на странице не совпадает");
        return pageManager.getLaunchPage();
    }
}