package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import project.BaseTest;

import java.util.Properties;

import static testproperties.TestProperties.getInstance;

public class LaunchPage extends BaseTest {
    private final Properties properties = getInstance().getProperties();

    @FindBy(xpath = "//ul[contains(@class,'main-menu')]/li/a/span[text() = 'Расходы']")
    private WebElement costList;

    @FindBy(xpath = "//span[text()='Командировки']")
    private WebElement clickBusinessTrips;

    @Step("Открытие раздела 'Командировки'")
    public void openBusinessTrips() {
        costList.click();
        clickBusinessTrips.click();
        loading();
    }
}