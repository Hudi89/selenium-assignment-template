package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By formAuthLink = By.linkText("Form Authentication");

    public void openLoginPage() {
        click(formAuthLink);
    }
}