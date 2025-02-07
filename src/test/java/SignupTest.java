import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignupTest extends BaseTest {
    Random random = new Random();


    @Test
    @Tag("signUp")
    @Tag("signupPositiveTest")
    void signUpWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openSignupForm();
        String username = "user" + random.nextInt(1000);

        SignupPage signupPage = new SignupPage(driver);
        signupPage.sendKeysUsernameField(username);
        signupPage.sendKeysPasswordField("user123");
        signupPage.sendKeysPasswordConfirmationField("user123");
        signupPage.clickSignupConfirmationButton();
        //Assertion
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        assertTrue(signupPage.successfulSignupAssert(username), "User not logged in");
    }

    @Test
    @Tag("signUp")
    @Tag("signupNegativeTest")
    void usernameTooShort() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openSignupForm();

        SignupPage signupPage = new SignupPage(driver);
        signupPage.sendKeysUsernameField("aa");
        signupPage.sendKeysPasswordField("user123");
        signupPage.sendKeysPasswordConfirmationField("user123");
        signupPage.clickSignupConfirmationButton();
        //Assertion
        String expectedOutput = "Privaloma įvesti nuo 3 iki 32 simbolių";
        String actualOutput = signupPage.getTextFromUsernameError();
        Assertions.assertEquals(expectedOutput, actualOutput, "Invalid username format");
    }

    @Test
    @Tag("signUp")
    @Tag("signupNegativeTest")
    void usernameTooLong() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openSignupForm();

        SignupPage signupPage = new SignupPage(driver);
        signupPage.sendKeysUsernameField("VeryLongUsernameForCalculatorTask");
        signupPage.sendKeysPasswordField("user123");
        signupPage.sendKeysPasswordConfirmationField("user123");
        signupPage.clickSignupConfirmationButton();
        //Assertion
        String expectedOutput = "Privaloma įvesti nuo 3 iki 32 simbolių";
        String actualOutput = signupPage.getTextFromUsernameError();
        Assertions.assertEquals(expectedOutput, actualOutput, "Invalid username format");
    }

    @Test
    @Tag("signUp")
    @Tag("signupNegativeTest")
    void emptyUsernameField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openSignupForm();

        SignupPage signupPage = new SignupPage(driver);
        signupPage.sendKeysUsernameField("");
        signupPage.sendKeysPasswordField("user123");
        signupPage.sendKeysPasswordConfirmationField("user123");
        signupPage.clickSignupConfirmationButton();
        //Assertion
        String expectedOutput = "Šį laukelį būtina užpildyti\n" +
                "Privaloma įvesti nuo 3 iki 32 simbolių";
        String actualOutput = signupPage.getTextFromUsernameError();
        Assertions.assertEquals(expectedOutput, actualOutput, "Invalid username format");
    }

    @Test
    @Tag("signUp")
    @Tag("signupNegativeTest")
    void passwordTooShort() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openSignupForm();
        String username = "user" + random.nextInt(1000);

        SignupPage signupPage = new SignupPage(driver);
        signupPage.sendKeysUsernameField(username);
        signupPage.sendKeysPasswordField("aa");
        signupPage.sendKeysPasswordConfirmationField("aa");
        signupPage.clickSignupConfirmationButton();
        //Assertion
        String expectedOutput = "Privaloma įvesti bent 3 simbolius";
        String actualOutput = signupPage.getTextPasswordError();
        Assertions.assertEquals(expectedOutput, actualOutput, "Invalid password format");

    }

    @Test
    @Tag("signUp")
    @Tag("signupNegativeTest")
    void passwordFieldEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openSignupForm();
        String username = "user" + random.nextInt(1000);

        SignupPage signupPage = new SignupPage(driver);
        signupPage.sendKeysUsernameField(username);
        signupPage.sendKeysPasswordField("");
        signupPage.sendKeysPasswordConfirmationField("");
        signupPage.clickSignupConfirmationButton();
        //Assertion
        String expectedOutput = "Šį laukelį būtina užpildyti\n" +
                "Privaloma įvesti bent 3 simbolius";

        String actualOutput = signupPage.getTextPasswordError();
        Assertions.assertEquals(expectedOutput, actualOutput, "Invalid password format");
    }

    @Test
    @Tag("signUp")
    @Tag("signupNegativeTest")
    void passwordMismatch() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openSignupForm();
        String username = "user" + random.nextInt(1000);

        SignupPage signupPage = new SignupPage(driver);
        signupPage.sendKeysUsernameField(username);
        signupPage.sendKeysPasswordField("user123");
        signupPage.sendKeysPasswordConfirmationField("user12");
        signupPage.clickSignupConfirmationButton();
        //Assertion
        String expectedOutput = "Įvesti slaptažodžiai nesutampa";
        String actualOutput = signupPage.getTextPasswordConfirmationError();
        Assertions.assertEquals(expectedOutput, actualOutput, "Password should match.");
    }
}
