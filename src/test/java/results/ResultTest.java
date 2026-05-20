package results;

import base.BaseTest;
import login.LoginPage;
import org.junit.Assert;
import org.junit.Test;

import static utils.EnvConfig.PASSWORD;
import static utils.EnvConfig.USERNAME;

public class ResultTest extends BaseTest {

    @Test
    public void selectCodeDropdownTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(USERNAME, PASSWORD);

        driver.get("https://academy.codifylab.com/lms/mentor/personality-test/results/");

        ResultPage page = new ResultPage(driver);

        String expected = "R";

        page.selectDominantCode(expected);

        String result = page.getCodeSelectValue();

        Assert.assertEquals(expected, result);
    }

}
