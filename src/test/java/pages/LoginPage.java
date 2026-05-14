package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.cssSelector("button[type='submit']");
    private By successMsg = By.cssSelector(".flash.success");
    private By logoutBtn = By.xpath("//a[@href='/logout' and contains(@class,'button')]");

    public void login(String user, String pass) {
        type(username, user);
        type(password, pass);
        click(loginBtn);
    }

    public boolean isLoginSuccess() {
        return find(successMsg).isDisplayed();
    }

    public void logout() {
        WebElement logoutLink = find(logoutBtn);
        String logoutUrl = logoutLink.getAttribute("href");
        logoutLink.click();

        try {
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlContains("/login"));
        } catch (TimeoutException exception) {
            driver.get(logoutUrl);
        }

        wait.until(ExpectedConditions.urlContains("/login"));
    }

    public boolean isLoginPageOpen() {
        return find(username).isDisplayed();
    }
}
