package login;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.RandomDataGenerator;

import static utils.EnvConfig.PASSWORD;
import static utils.EnvConfig.USERNAME;

public class LoginTest extends BaseTest {

    @Test
    public void sanityCheck() {
        driver.get(BASE_URL);
        System.out.println("Page title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        // Check if username field exists
        boolean usernamePresent = driver.findElements(By.id("id_username")).size() > 0;
        System.out.println("Username field present: " + usernamePresent);
    }

    @Test
    public void userLoginWithValidCredentialsTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(USERNAME, PASSWORD);

        Assert.assertTrue(driver.getCurrentUrl().contains("home"));
    }

    @Test
    public void userLoginWithInvalidUsernameTest() {
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
