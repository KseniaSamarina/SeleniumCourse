package project;

import pages.BusinessTripsPage;
import pages.CreateBusinessTrip;
import pages.LaunchPage;
import pages.LoginPage;

public class PageManager {
    private static PageManager instance = null;

    private LoginPage loginPage;
    private LaunchPage launchPage;
    private BusinessTripsPage businessTripsPage;
    private CreateBusinessTrip createBusinessTrip;

    private PageManager() {
    }

    public static PageManager getInstance() {
        if (instance == null) {
            instance = new PageManager();
        }
        return instance;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public LaunchPage getLaunchPage() {
        if (launchPage == null) {
            launchPage = new LaunchPage();
        }
        return launchPage;
    }

    public BusinessTripsPage getBusinessTripsPage() {
        if (businessTripsPage == null) {
            businessTripsPage = new BusinessTripsPage();
        }
        return businessTripsPage;
    }

    public CreateBusinessTrip getCreateBusinessTrip() {
        if (createBusinessTrip == null) {
            createBusinessTrip = new CreateBusinessTrip();
        }
        return createBusinessTrip;
    }

}
