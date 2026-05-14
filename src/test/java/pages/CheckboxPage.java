package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxPage extends BasePage {

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    private By checkbox = By.cssSelector("input[type='checkbox']");

    public void toggleCheckbox() {
        click(checkbox);
    }

    public boolean isChecked() {
        return find(checkbox).isSelected();
    }
}
