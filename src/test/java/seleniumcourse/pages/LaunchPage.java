package seleniumcourse.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import seleniumcourse.BaseTest;
import seleniumcourse.testproperties.TestProperties;

import java.util.Properties;

public class LaunchPage extends BaseTest {
    private final Properties properties = TestProperties.getInstance().getProperties();

    @FindBy(xpath = "//ul[contains(@class,'main-menu')]/li/a/span[text() = 'Расходы']")
    private WebElement costList;

    @FindBy(xpath = "//span[text()='Командировки']")
    private WebElement clickBusinessTrips;

    public void openBusinessTrips() {
        costList.click();
        clickBusinessTrips.click();
        loading();
    }
}
