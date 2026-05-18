package main;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends PageBase {

    private final By courseLinkBy = By.xpath("//div[@class='course clickable link']");
    private final By profileDropdownBy = By.xpath("//a[@class='nav-link dropdown-toggle dropdown-user-link']");
    private final By logoutLinkBy = By.xpath("//a[@href='/accounts/logout/']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        waitAndClick(profileDropdownBy);
        waitAndClick(logoutLinkBy);
    }

    public List<String> getCourses() {
        List<WebElement> elements = waitAndReturnElements(courseLinkBy);
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
