package notifications;

import base.BaseTest;
import login.LoginPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static utils.EnvConfig.PASSWORD;
import static utils.EnvConfig.USERNAME;

public class NotificationTest extends BaseTest {

    @Test
    public void notificationPageNotEmptyTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(USERNAME, PASSWORD);

        NotificationPage notificationPage = new NotificationPage(driver);
        List<String> notifications = notificationPage.getNotifications();

        Assert.assertFalse(notifications.isEmpty());
    }

    @Test
    public void browserHistoryNavigationWorksTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(USERNAME, PASSWORD);

        NotificationPage notificationPage = new NotificationPage(driver);

        String homeUrl = driver.getCurrentUrl();

        notificationPage.openNotificationPage();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("notifications")
        );

        driver.navigate().back();

        Assert.assertEquals(homeUrl, driver.getCurrentUrl());

        driver.navigate().forward();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("notifications")
        );
    }

}
