package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HoversPage extends BasePage {

    private final By firstFigure = By.cssSelector(".figure:first-of-type");
    private final By firstFigureCaption = By.cssSelector(".figure:first-of-type .figcaption h5");

    public HoversPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOverFirstUser() {
        new Actions(driver).moveToElement(find(firstFigure)).perform();
    }

    public String firstUserName() {
        return textOf(firstFigureCaption);
    }
}
