package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.DriverManager;
import project.PageManager;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.PageFactory.initElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static project.DriverManager.closeDriver;
import static project.DriverManager.getWebDriver;

public class Hooks {

    @Before
    public void before () {
        initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='loader-content']")
    private WebElement loadingIcon;
    protected static WebDriver driver = getWebDriver();
    protected static WebDriverWait wait = new WebDriverWait(driver, ofSeconds(5));
    protected PageManager pageManager = PageManager.getInstance();

    public void loading() {
        wait.until(not(visibilityOf(loadingIcon)));
    }

    @After
    public void tearDown(Scenario scenario) {
        String screenshotName = scenario.getName().replace(" ", "_");
        try {
            if (scenario.isFailed()) {
                scenario.log("Alarm!");
                TakesScreenshot ts = (TakesScreenshot) DriverManager.getWebDriver();
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeDriver();
    }
}
