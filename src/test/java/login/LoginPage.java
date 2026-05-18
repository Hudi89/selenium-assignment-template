package login;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    private final By usernameInput = By.xpath("//input[@id='id_username']");
    private final By passwordInput = By.xpath("//input[@id='id_password']");
    private final By loginButton = By.xpath("//button[@id='login-submit']");
    private final By loginError = By.xpath("//div[contains(@class,'alert') or contains(@class,'error')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        waitAndType(usernameInput, username);
    }

    public void enterPassword(String password) {
        waitAndType(passwordInput, password);
    }

    public void clickLogin() {
        waitAndClick(loginButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        return waitAndGetText(loginError);
    }

}
