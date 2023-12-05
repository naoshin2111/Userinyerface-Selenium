package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HomePage extends Form {

    private final IButton nextPageButton = AqualityServices.getElementFactory().getButton(By.xpath("//a[normalize-space()='HERE']"), "Next Page");

    public HomePage() {
        super(By.className("start__paragraph"), "Home Page Indicator");
    }

    public void clickNexButton() {
        nextPageButton.click();
    }
}
