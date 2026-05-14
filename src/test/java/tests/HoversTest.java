package tests;

import org.junit.jupiter.api.Test;
import pages.HoversPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoversTest extends BaseTest {

    @Test
    public void shouldRevealUserNameOnHover() {
        driver.get(baseUrl + "hovers");
        HoversPage hoversPage = new HoversPage(driver);

        hoversPage.hoverOverFirstUser();

        assertEquals("name: user1", hoversPage.firstUserName());
    }
}
