package profile;

import base.BaseTest;
import login.LoginPage;
import org.junit.Assert;
import org.junit.Test;

import static utils.EnvConfig.PASSWORD;
import static utils.EnvConfig.USERNAME;

public class ProfileSettingsTest extends BaseTest {

    @Test
    public void profileSettingsReturnPersonalDataTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(USERNAME, PASSWORD);

        ProfileSettingsPage profileSettingsPage = new ProfileSettingsPage(driver);
        String personalDataHeading = profileSettingsPage.getPersonalDataHeading();

        Assert.assertTrue(personalDataHeading.contains("Personal data"));
    }

}
