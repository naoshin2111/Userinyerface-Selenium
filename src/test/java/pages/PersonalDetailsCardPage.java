package pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsCardPage extends Form {

    public PersonalDetailsCardPage() {
        super(By.xpath("//div[@class='personal-details__form']"), "Personal Details Page Indicator");
    }
}
