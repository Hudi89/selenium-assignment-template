package tests;

import org.junit.jupiter.api.Test;
import pages.CheckboxPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckboxTest extends BaseTest {

    @Test
    public void shouldToggleCheckbox() {

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        CheckboxPage checkbox = new CheckboxPage(driver);

        checkbox.toggleCheckbox();

        assertTrue(checkbox.isChecked());
    }
}