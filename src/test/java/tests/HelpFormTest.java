package tests;

import config.EnvironmentConfig;
import static aquality.selenium.browser.AqualityServices.getBrowser;
import pages.GamePage;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelpFormTest extends BaseTest {

    private HomePage homePage;
    private GamePage gamePage;

    @Test(enabled = true)
    public void testHideHelpForm() {
        getBrowser().goTo(EnvironmentConfig.getUrl());
        homePage = new HomePage();
        Assert.assertTrue(homePage.state().isDisplayed(), "The welcome page is not open.");

        homePage.clickNexButton();
        gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().isDisplayed(), "Game page is not displayed.");

        gamePage.hideHelpForm();
        Assert.assertTrue(gamePage.isHelpFormHidden(), "The help form content is not hidden.");
    }
}
