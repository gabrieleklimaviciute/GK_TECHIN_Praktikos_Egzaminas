import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest extends BaseTest{
    @Test
    @Tag("logoutTest")
    void userLogout(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsernameIntoField("user123");
        loginPage.enterPasswordIntoField("user123");
        loginPage.clickLoginButton();

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.clickLogoutButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Boolean expectedOutput = loginPage.isDisplayedLogoutMessage();
        assertTrue(expectedOutput,"User is not logged out");
    }
}
