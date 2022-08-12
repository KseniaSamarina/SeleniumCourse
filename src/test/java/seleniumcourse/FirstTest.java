package seleniumcourse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import seleniumcourse.extension.DriverExtension;
import seleniumcourse.pages.BusinessTripsPage;
import seleniumcourse.pages.CreateBusinessTrip;
import seleniumcourse.pages.LaunchPage;
import seleniumcourse.pages.LoginPage;

@ExtendWith(DriverExtension.class)
class FirstTest {

    //private final WebDriver driver = DriverManager.getWebDriver();

    @Test
    void firstTest() {
        //Шаг 1. Авторизация
        LoginPage loginPage = new LoginPage();
        loginPage.enterLoginAndPassword();
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