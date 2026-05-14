package tests;

import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void shouldLoginSuccessfully() {

        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.openLoginPage();

        login.login("tomsmith", "SuperSecretPassword!");

        assertTrue(login.isLoginSuccess());
    }
}
