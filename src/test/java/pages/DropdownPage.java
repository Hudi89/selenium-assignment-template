package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    private final By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void selectOption(String visibleText) {
        Select select = new Select(find(dropdown));
        select.selectByVisibleText(visibleText);
    }

    public String selectedOption() {
        Select select = new Select(find(dropdown));
        return select.getFirstSelectedOption().getText();
    }
}
