package tests;

import org.junit.jupiter.api.Test;
import pages.InputPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest extends BaseTest {

    @Test
    public void shouldFillNumberInput() {
        driver.get(baseUrl + "inputs");
        InputPage inputPage = new InputPage(driver);
        int number = 321;

        inputPage.enterNumber(number);

        assertEquals(String.valueOf(number), inputPage.enteredNumber());
    }
}
