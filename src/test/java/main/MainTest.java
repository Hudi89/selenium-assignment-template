package main;

import base.BaseTest;
import login.LoginPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static utils.EnvConfig.PASSWORD;
import static utils.EnvConfig.USERNAME;

public class MainTest extends BaseTest {

    @Test
    public void coursesNotEmptyTest() {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        loginPage.login(USERNAME, PASSWORD);

        List<String> courses = mainPage.getCourses();

        Assert.assertFalse(courses.isEmpty());
    }

    @Test
    public void userLogoutSuccessfullyTest() {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        loginPage.login(USERNAME, PASSWORD);

        mainPage.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

}
