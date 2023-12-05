package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.FileUploaderUtils;
import utils.RandomUtils;
import java.util.List;

public class InterestCardPage extends Form {

    private final IButton uploadImageButton = AqualityServices.getElementFactory().getButton(By.xpath("//a[normalize-space()='upload']"), "Image Upload");
    private final IButton nextButton = AqualityServices.getElementFactory().getButton(By.xpath("//button[normalize-space()='Next']"), "Next Button");
    private static final By INTEREST_CHECKBOX_LOCATOR = By.xpath("//div[contains(@class,'interests-list')]//label");
    private final ICheckBox unselectAllCheckbox = AqualityServices.getElementFactory().getCheckBox(By.xpath("(//div[contains(@class,'interests-list')]//label)[21]"), "Unselect All Checkbox");
    private final ICheckBox selectAllCheckbox = AqualityServices.getElementFactory().getCheckBox(By.xpath("(//div[contains(@class,'interests-list')]//label)[18]"), "Select All Checkbox");
    private static final String LABEL = "for";

    public InterestCardPage() {
        super(By.xpath("(//div[@class='page-indicator'])[1]"), "Interest Card Page Indicator");
    }

    public void chooseRandomInterests(int numberOfInterestsToSelect) {
        if (!unselectAllCheckbox.isChecked()){
            unselectAllCheckbox.click();
        }

        List<ICheckBox> interestCheckboxes = AqualityServices.getElementFactory().findElements(INTEREST_CHECKBOX_LOCATOR, ICheckBox.class);

        String selectAllForValue = selectAllCheckbox.getElement().getAttribute(LABEL);
        String unselectAllForValue = unselectAllCheckbox.getElement().getAttribute(LABEL);

        interestCheckboxes.removeIf(checkbox ->
                checkbox.getElement().getAttribute(LABEL).equals(selectAllForValue) ||
                        checkbox.getElement().getAttribute(LABEL).equals(unselectAllForValue)
        );

        int interestsSelected = 0;
        while (interestsSelected < numberOfInterestsToSelect) {
            int randomIndex = RandomUtils.generateRandomNumber(interestCheckboxes.size());
            ICheckBox checkbox = interestCheckboxes.get(randomIndex);
            if (!checkbox.isChecked()) {
                checkbox.click();
                interestsSelected++;
            }
            interestCheckboxes.remove(randomIndex);
        }
    }

    public void uploadImage(String imagePath) {
        uploadImageButton.click();
        FileUploaderUtils.uploadImage(imagePath);
    }

    public void proceedToNextCard() {
        nextButton.click();
    }
}
