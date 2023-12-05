package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import constants.CommonConstants;
import org.openqa.selenium.By;
import java.time.Duration;

public class GamePage extends Form {

    private final IButton hideHelpFormButton = AqualityServices.getElementFactory().getButton(By.xpath("//span[@class='highlight']"), "Hide Help Form Button");
    private final IButton acceptCookiesButton = AqualityServices.getElementFactory().getButton(By.xpath("//button[normalize-space()='Not really, no']"), "Accept Cookies Button");
    private final IElement cookieBanner = AqualityServices.getElementFactory().getLabel(By.xpath("//div[@class='cookies']"), "Cookie Banner");
    private final ILabel timer = AqualityServices.getElementFactory().getLabel(By.xpath("//div[@class='timer timer--white timer--center']"), "Timer Label");

    public GamePage() {
        super(By.xpath("(//div[@class='game view'])"), "Game Page Indicator");
    }

    public void hideHelpForm() {
        hideHelpFormButton.click();
    }

    public boolean isHelpFormHidden() {
        return hideHelpFormButton.state().waitForNotDisplayed(Duration.ofSeconds(CommonConstants.COMMON_WAIT_TIME));
    }

    public void acceptCookies() {
        acceptCookiesButton.click();
    }

    public boolean isCookieBannerDisplayed() {
        return cookieBanner.state().waitForDisplayed(Duration.ofSeconds(CommonConstants.COMMON_WAIT_TIME));
    }

    public String getTimerText() {
        return timer.getText();
    }
}
