package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

import static java.lang.System.setProperty;
import static java.time.Duration.ofSeconds;
import static testproperties.TestProperties.getInstance;

public class DriverManager {
    private static WebDriver driver;
    private static final Properties properties = getInstance().getProperties();

    public static WebDriver getWebDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void initDriver() {
        setProperty(properties.getProperty("WEB_DRIVER"), properties.getProperty("WEB_DRIVER_PATH"));
        driver = new ChromeDriver();
        driver.get(properties.getProperty("HOSTNAME"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(5));
    }

    public static void closeDriver() {
        driver.quit();
    }
}