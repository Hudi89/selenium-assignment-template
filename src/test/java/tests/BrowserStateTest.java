package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowserStateTest extends BaseTest {

    @Test
    public void shouldNavigateBackAndForwardInBrowserHistory() {
        driver.get(baseUrl + "login");
        driver.get(baseUrl + "checkboxes");

        driver.navigate().back();
        assertTrue(driver.getCurrentUrl().contains("/login"));

        driver.navigate().forward();
        assertTrue(driver.getCurrentUrl().contains("/checkboxes"));
    }
}
