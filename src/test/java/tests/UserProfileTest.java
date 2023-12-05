package tests;

import config.EnvironmentConfig;
import static aquality.selenium.browser.AqualityServices.getBrowser;
import config.TestDataConfig;
import pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PasswordUtils;
import utils.RandomUtils;

public class UserProfileTest extends BaseTest {

    private static final int WORD_LENGTH = 10;
    private static final int NUMBER_OF_INTERESTS = 3;
    private HomePage homePage;
    private GamePage gamePage;
    private InterestCardPage interestCardPage;
    private LogInCardPage logInCardPage;
    private PersonalDetailsCardPage personalDetailsCardPage;

    @Test(enabled = false)
    public void testCardNavigation() {
        getBrowser().goTo(EnvironmentConfig.getUrl());
        homePage = new HomePage();
        Assert.assertTrue(homePage.state().isDisplayed(), "Home page is not displayed.");

        gamePage = new GamePage();
        homePage.clickNexButton();
        Assert.assertTrue(gamePage.state().isDisplayed(), "Game page is not displayed.");

        logInCardPage = new LogInCardPage();
        String email = RandomUtils.generateRandomString(WORD_LENGTH);
        String password = PasswordUtils.generateValidPassword(email, WORD_LENGTH);
        String domain = RandomUtils.generateRandomString(WORD_LENGTH);
        logInCardPage.fillDetailsAndProceed(email, password, domain);

        interestCardPage = new InterestCardPage();
        Assert.assertTrue(interestCardPage.state().isDisplayed(), "Interest Card on Game page is not displayed.");
        interestCardPage.chooseRandomInterests(NUMBER_OF_INTERESTS);

        String imagePath = TestDataConfig.getImagePath();
        interestCardPage.uploadImage(imagePath);
        interestCardPage.proceedToNextCard();

        personalDetailsCardPage = new PersonalDetailsCardPage();
        Assert.assertTrue(personalDetailsCardPage.state().isDisplayed()," Personal Details Card on Game page is not displayed.");
    }
}
