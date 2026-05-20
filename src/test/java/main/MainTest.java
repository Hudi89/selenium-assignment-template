package main;

import base.BaseTest;
import login.LoginPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static utils.EnvConfig.PASSWORD;
import static utils.EnvConfig.USERNAME;

public class MainTest extends BaseTest {

    private static final List<String> pages = List.of(
            "https://academy.codifylab.com/lms/home/",
            "https://academy.codifylab.com/lms/mentor/notifications/",
            "https://academy.codifylab.com/lms/common/user/settings/"
    );

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

    @Test
    public void multiplePagesHaveCorrectTitlesTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(USERNAME, PASSWORD);


        for (String page : pages) {
            driver.get(page);
            Assert.assertFalse(driver.getTitle().isEmpty());
        }
    }

}
