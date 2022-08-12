package seleniumcourse.extension;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import seleniumcourse.DriverManager;

public class DriverExtension implements BeforeAllCallback, AfterAllCallback {
    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        DriverManager.getWebDriver();
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        DriverManager.closeDriver();
    }
}
