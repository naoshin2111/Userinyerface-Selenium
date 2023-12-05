package tests;

import config.EnvironmentConfig;
import static aquality.selenium.browser.AqualityServices.getBrowser;
import pages.GamePage;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimerValidationTest extends BaseTest {

    private static final String TIMER_START_VALUE = "00:00:00";
    private HomePage homePage;
    private GamePage gamePage;

    @Test(enabled = true)
    public void testTimerValidation() {
        getBrowser().goTo(EnvironmentConfig.getUrl());
        homePage = new HomePage();
        Assert.assertTrue(homePage.state().isDisplayed(), "The welcome page is not open.");

        homePage.clickNexButton();
        gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().isDisplayed(), "Game page is not displayed.");
        Assert.assertEquals(gamePage.getTimerText(), TIMER_START_VALUE, String.format("The timer does not start from %s", TIMER_START_VALUE));
    }
}
