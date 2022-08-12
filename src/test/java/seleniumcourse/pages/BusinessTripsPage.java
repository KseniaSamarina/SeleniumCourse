package seleniumcourse.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import seleniumcourse.BaseTest;
import seleniumcourse.testproperties.TestProperties;

import java.util.Properties;

public class BusinessTripsPage extends BaseTest {

    private final Properties properties = TestProperties.getInstance().getProperties();

    @FindBy(xpath = "//a[@class='btn back icons-holder-text ']")
    private WebElement submitCreateBusinessTrip;

    @FindBy(xpath = "//h1[text() = 'Создать командировку']")
    private WebElement titleCreateBusinessTrip;

    public void createBusinessTrip() {
        submitCreateBusinessTrip.click();
        loading();
        wait.until(ExpectedConditions.visibilityOf(titleCreateBusinessTrip));

        Assertions.assertTrue(titleCreateBusinessTrip.isDisplayed(), "Страница не загрузилась");
        Assertions.assertEquals("Создать командировку", titleCreateBusinessTrip.getText(),
                "Заголовок на странице не совпадает");
    }
}

