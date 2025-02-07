import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SearchPageTest extends BaseTest {

    @Test
    @Tag("displayOperationsTest")
    @Tag("positiveDisplayTest")
    void positiveDisplayOfDoneOperations() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsernameIntoField("user123");
        loginPage.enterPasswordIntoField("user123");
        loginPage.clickLoginButton();

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.clickDoneOperationsButton();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickDisplayButton();
        //Assertion
        boolean expectedOutput = searchPage.isDisplayedOperationTable();
        Assertions.assertTrue(expectedOutput, "Table do not exist");
    }

    @Test
    @Tag("changeCredentialsTest")
    @Tag("positiveChangeTest")
    void changingFirstNumber() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsernameIntoField("user123");
        loginPage.enterPasswordIntoField("user123");
        loginPage.clickLoginButton();

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.clickDoneOperationsButton();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickChangeButton();
        searchPage.clearFirstNumberField();
        searchPage.sendKeysChangeFirstNumberInputField("10");
        searchPage.clickChangeConfirmationButton();
        //Assertion
        String expectedOutput = "10";
        String actualOutput = searchPage.getTextChangedNumber();
        Assertions.assertEquals(expectedOutput, actualOutput, "Given changed number do not match");
    }

    @Test
    @Tag("changeCredentialsTest")
    @Tag("negativeChangeTest")
    void changingFirstNumberIntoNegative() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsernameIntoField("user123");
        loginPage.enterPasswordIntoField("user123");
        loginPage.clickLoginButton();

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.clickDoneOperationsButton();
        // 10 changing to -1
        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickChangeButton();
        searchPage.clearFirstNumberField();
        searchPage.sendKeysChangeFirstNumberInputField("-1");
        searchPage.clickChangeConfirmationButton();
        //Assertion
        String expectedOutput = "Whitelabel Error Page";
        String actualOutput = searchPage.getTextChangedNumberErrorMessage();
        Assertions.assertEquals(expectedOutput,actualOutput, "Changed number can not be negative");

    }

    @Test
    @Tag("deletionTest")
    void deletingOperation(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsernameIntoField("user123");
        loginPage.enterPasswordIntoField("user123");
        loginPage.clickLoginButton();

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.clickDoneOperationsButton();

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickDeletionButton();

        //No Assertion
    }

}
