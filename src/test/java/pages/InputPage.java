package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputPage extends BasePage {

    private final By numberInput = By.cssSelector("input[type='number']");

    public InputPage(WebDriver driver) {
        super(driver);
    }

    public void enterNumber(int number) {
        type(numberInput, String.valueOf(number));
    }

    public String enteredNumber() {
        return find(numberInput).getAttribute("value");
    }
}
