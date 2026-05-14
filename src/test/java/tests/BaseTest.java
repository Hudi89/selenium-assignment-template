package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ScreenshotOnFailureExtension;

@ExtendWith(ScreenshotOnFailureExtension.class)
public class BaseTest {

    protected WebDriver driver;
    protected final String baseUrl = "https://the-internet.herokuapp.com/";

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get(baseUrl);
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
