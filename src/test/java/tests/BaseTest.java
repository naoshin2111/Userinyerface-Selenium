package tests;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.AfterMethod;

public abstract class BaseTest {

    @AfterMethod
    public void tearDown() {
        if (AqualityServices.isBrowserStarted()) {
            getBrowser().quit();
        }
    }
}
