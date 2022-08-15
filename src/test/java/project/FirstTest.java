package project;

import extension.AllureExtension;
import extension.DriverExtension;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.BusinessTripsPage;
import pages.CreateBusinessTrip;
import pages.LaunchPage;
import pages.LoginPage;
import java.util.Properties;

import static testproperties.TestProperties.getInstance;

@ExtendWith({DriverExtension.class, AllureExtension.class})
@DisplayName("Учусь писать автотесты")
public class FirstTest {

    private final Properties properties = getInstance().getProperties();

    @Epic("Оформление командировки")
    @Feature("Функции сайта")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @DisplayName("Проверка авторизации и создания командировки")
    @Description("Проверка сайта 'training.appline.ru': авторизация, переход в раздел 'Все командировки', создание командировки, заполнение формы")
    public void firstTest() {
        //Шаг 1. Авторизация
        LoginPage loginPage = new LoginPage();
        loginPage.enterLoginAndPassword(
                properties.getProperty("LOGIN"),
                properties.getProperty("PASSWORD"));
        loginPage.submitClick();

        //Шаг 2. Открытие страницы Командировок
        LaunchPage launchPage = new LaunchPage();
        launchPage.openBusinessTrips();

        //Шаг 3. Создание командировки
        BusinessTripsPage businessTripsPage = new BusinessTripsPage();
        businessTripsPage.createBusinessTrip();

        //Шаг 4. Заполнение полей при создании командировки
        CreateBusinessTrip createBusinessTrip = new CreateBusinessTrip();
        createBusinessTrip.enterValues();

        //Шаг 5. Проверка заполненных полей
        createBusinessTrip.dataVerification();

        //Шаг 6. Проверка, что на странице появилось сообщение "Список командируемых сотрудников не может быть пустым"
        createBusinessTrip.popupMessage();
    }
}