package steps;

import io.cucumber.java.ru.И;
import project.PageManager;

public class BusinessTripsPageSteps {

    PageManager pageManager = PageManager.getInstance();

    @И("Нажать кнопку {string}")
    public void нажать_кнопку(String string) {
        pageManager.getBusinessTripsPage().createBusinessTrip();
    }
}

