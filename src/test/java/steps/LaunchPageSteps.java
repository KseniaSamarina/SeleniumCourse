package steps;

import io.cucumber.java.ru.И;
import project.PageManager;

public class LaunchPageSteps {

    PageManager pageManager = PageManager.getInstance();

    @И("Открытие раздела {string}")
    public void открытие_раздела(String string) {
        pageManager.getLaunchPage().openBusinessTrips();
    }
}
