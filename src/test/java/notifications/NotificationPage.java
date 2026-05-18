package notifications;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class NotificationPage extends PageBase {

    By notificationLinkBy = By.xpath("//a[@href='/lms/mentor/notifications/']");
    By notificationListBy = By.xpath("//div[contains(@class, 'card mb-1')]");

    public NotificationPage(WebDriver driver) {
        super(driver);
    }

    public void openNotificationPage() {
        waitAndClick(notificationLinkBy);
    }

    public List<String> getNotifications() {
        openNotificationPage();

        List<WebElement> notifications = waitAndReturnElements(notificationListBy);
        return notifications.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
