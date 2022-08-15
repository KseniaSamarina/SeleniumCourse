package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.PageFactory.initElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static project.DriverManager.getWebDriver;

public class BaseTest {
    @FindBy(xpath = "//div[@class='loader-content']")
    private WebElement loadingIcon;
    protected static WebDriver driver = getWebDriver();
    protected static WebDriverWait wait = new WebDriverWait(driver, ofSeconds(5));

    public BaseTest() {
        initElements(driver, this);
    }

    public void loading() {
        wait.until(not(visibilityOf(loadingIcon)));
    }
}