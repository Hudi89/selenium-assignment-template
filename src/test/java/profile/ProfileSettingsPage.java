package profile;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileSettingsPage extends PageBase {

    private final By profileDropdownBy = By.xpath("//a[@class='nav-link dropdown-toggle dropdown-user-link']");
    private final By settingsLinkBy = By.xpath("//a[@href='/lms/common/user/settings/']");
    private final By personalDataHeading = By.xpath("//h1[@class='card-title' and text()='Personal data']");


    public ProfileSettingsPage(WebDriver driver) {
        super(driver);
    }

    public String getPersonalDataHeading() {
        waitAndClick(profileDropdownBy);
        waitAndClick(settingsLinkBy);

        return waitAndGetText(personalDataHeading);
    }

}
