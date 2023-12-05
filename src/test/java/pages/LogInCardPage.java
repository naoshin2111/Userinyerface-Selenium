package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.RandomUtils;
import java.util.List;

public class LogInCardPage extends Form {

    private final ITextBox passwordField = AqualityServices.getElementFactory().getTextBox(By.cssSelector("input[placeholder='Choose Password']"), "Password Field");
    private final ITextBox usernameField = AqualityServices.getElementFactory().getTextBox(By.cssSelector("input[placeholder='Your email']"), "Email Field");
    private final ITextBox domainField = AqualityServices.getElementFactory().getTextBox(By.cssSelector("input[placeholder='Domain']"), "Domain Field");
    private final ICheckBox termsButton = AqualityServices.getElementFactory().getCheckBox(By.className("checkbox"), "Terms of Use");
    private final IButton nextButton = AqualityServices.getElementFactory().getButton(By.cssSelector("a[class='button--secondary']"), "Next Button");
    private final ILabel domainOption = AqualityServices.getElementFactory().getLabel(By.xpath("//span[@class='icon icon-chevron-down']"), "Domain Option");
    private static final By DOMAIN_OPTIONS_LOCATOR = By.xpath("//div[contains(@class, 'dropdown__list-item')]");

    public LogInCardPage() {
        super(By.xpath("//a[@class='login-form__terms-conditions']"), "LogIn Page indicator");
    }

    public void fillDetailsAndProceed(String email, String password, String domain) {
        usernameField.clearAndType(email);
        domainField.clearAndType(domain);
        passwordField.clearAndType(password);
        domainOption.click();
        selectRandomDomain();
        termsButton.check();
        nextButton.click();
    }

    private void selectRandomDomain() {
        List<ILabel> domainOptions = AqualityServices.getElementFactory().findElements(DOMAIN_OPTIONS_LOCATOR, ILabel.class);
        int randomIndex = RandomUtils.generateRandomNumber(domainOptions.size());
        domainOptions.get(randomIndex).click();
    }
}
