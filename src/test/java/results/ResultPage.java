package results;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ResultPage extends PageBase {

    private final By codeDropdownBy = By.xpath("//select[@name='code']");

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public void selectDominantCode(String value) {
        Select select = new Select(waitAndReturnElement(codeDropdownBy));
        select.selectByValue(value);
    }

    public String getCodeSelectValue() {
        return driver.findElement(By.name("code")).getAttribute("value");
    }

}
