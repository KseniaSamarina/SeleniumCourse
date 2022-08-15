package extension;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import project.DriverManager;

public class DriverExtension implements BeforeAllCallback, AfterAllCallback {
    private DriverManager DriverManager;

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        DriverManager.getWebDriver();
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        DriverManager.closeDriver();
    }
}

