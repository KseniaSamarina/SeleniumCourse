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

public class BusinessTripsPage extends BaseTest {

    private final Properties properties = getInstance().getProperties();

    @FindBy(xpath = "//a[@class='btn back icons-holder-text ']")
    private WebElement submitCreateBusinessTrip;

    @FindBy(xpath = "//h1[text() = 'Создать командировку']")
    private WebElement titleCreateBusinessTrip;

    @Step("Нажатие кнопки 'Создать командировку'")
    public void createBusinessTrip() {
        submitCreateBusinessTrip.click();
        loading();
        wait.until(visibilityOf(titleCreateBusinessTrip));

        assertTrue(titleCreateBusinessTrip.isDisplayed(), "Страница не загрузилась");
        assertEquals("Создать командировку", titleCreateBusinessTrip.getText(),
                "Заголовок на странице не совпадает");
    }
}
