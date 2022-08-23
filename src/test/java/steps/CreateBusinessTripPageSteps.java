package steps;

import io.cucumber.java.ru.И;
import project.PageManager;

public class CreateBusinessTripPageSteps {

    PageManager pageManager = PageManager.getInstance();

    @И("Заполнение полей на форме создание командировки")
    public void заполнение_полей_на_форме_создание_командировки() {
        pageManager.getCreateBusinessTrip().enterValues();
    }

    @И("Проверка, что поля на форме заполнены корректно")
    public void проверка_что_поля_на_форме_заполнены_корректно() {
        pageManager.getCreateBusinessTrip().dataVerification();
    }

    @И("Проверка появления сообщения об ошибке {string}")
    public void проверка_появления_сообщения_об_ошибке(String string) {
        pageManager.getCreateBusinessTrip().popupMessage();
    }
}
