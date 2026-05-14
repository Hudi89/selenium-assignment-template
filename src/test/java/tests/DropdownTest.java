package tests;

import org.junit.jupiter.api.Test;
import pages.DropdownPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTest extends BaseTest {

    @Test
    public void shouldSelectDropdownOption() {
        driver.get(baseUrl + "dropdown");
        DropdownPage dropdownPage = new DropdownPage(driver);

        dropdownPage.selectOption("Option 2");

        assertEquals("Option 2", dropdownPage.selectedOption());
    }
}
