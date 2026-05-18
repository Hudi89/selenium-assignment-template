package login;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import utils.RandomDataGenerator;

import static utils.EnvConfig.PASSWORD;
import static utils.EnvConfig.USERNAME;

public class LoginTest extends BaseTest {

    @Test
    public void userLoginWithValidCredentialsTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(USERNAME, PASSWORD);

        Assert.assertTrue(driver.getCurrentUrl().contains("home"));
    }

    @Test
    public void userCannotLoginWithInvalidUsernameTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(RandomDataGenerator.randomUsername(), PASSWORD);

        Assert.assertFalse(loginPage.getErrorMessage().isEmpty());
    }

    @Test
    public void userCannotLoginWithInvalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(USERNAME, RandomDataGenerator.randomPassword());

        Assert.assertFalse(loginPage.getErrorMessage().isEmpty());
    }

}
