package seleniumcourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    @FindBy(xpath = "//div[@class='loader-content']")
    private WebElement loadingIcon;
    protected static WebDriver driver = DriverManager.getWebDriver();
    protected static WebDriverWait wait = new WebDriverWait(driver, 10, 1000);

    public BaseTest() {
        PageFactory.initElements(driver, this);
    }

    public void loading() {
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(loadingIcon)));
    }
}
