package tests;

import config.EnvironmentConfig;
import static aquality.selenium.browser.AqualityServices.getBrowser;
import pages.GamePage;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SiteCookieTest extends BaseTest {

    private HomePage homePage;
    private GamePage gamePage;

    @Test(enabled = true)
    public void testAcceptCookies() {
        getBrowser().goTo(EnvironmentConfig.getUrl());
        homePage = new HomePage();
        Assert.assertTrue(homePage.state().isDisplayed(), "The welcome page is not open.");

        homePage.clickNexButton();
        gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().isDisplayed(), "Game page is not displayed.");
        Assert.assertTrue(gamePage.isCookieBannerDisplayed(), "Cookie banner is not displayed.");

        gamePage.acceptCookies();
        Assert.assertFalse(gamePage.isCookieBannerDisplayed(), "Cookie Banner is still displayed!");
    }
}
