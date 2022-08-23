package steps;

import io.cucumber.java.ru.И;
import project.PageManager;

import java.util.Properties;

public class LoginPageSteps {
    PageManager pageManager = PageManager.getInstance();
    private final Properties properties = new Properties();

    @И("Ввод {string} и {string} на форме авторизации")
    public void ввод_и_на_форме_авторизации(String login, String password) {
        pageManager.getLoginPage().enterLoginAndPassword(login, password);
    }

    @И("Нажатие кнопки {string}")
    public void нажатие_кнопки(String string) {
        pageManager.getLoginPage().submitClick();
    }

}
