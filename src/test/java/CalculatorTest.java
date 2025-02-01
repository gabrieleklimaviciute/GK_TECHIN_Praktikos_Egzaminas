import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CalculatorTest extends BaseTest {
    //SUM TESTS
    @Test
    @Tag("sumPositiveTest")
    void sumOfTwoNumbers() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsernameIntoField("user123");
        loginPage.enterPasswordIntoField("user123");
        loginPage.clickLoginButton();

        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.sendKeysToFirstNumberField("7");
        calculatorPage.sendKeysToSecondNumberField("3");
        calculatorPage.setSumOperatorSign("Sudėtis");
        calculatorPage.clickCalculationButton();

        String expectedOutput = "7 + 3 = 10";
        String actualOutput = calculatorPage.getTextFromSumResult();
        Assertions.assertEquals(expectedOutput, actualOutput, "Calculation unsuccessful");

    }

    @Test
    @Tag("sumNegativeTest")
    void sumWhenOneOfTwoNumbersNegative() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsernameIntoField("user123");
        loginPage.enterPasswordIntoField("user123");
        loginPage.clickLoginButton();

        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.sendKeysToFirstNumberField("-7");
        calculatorPage.sendKeysToSecondNumberField("3");
        calculatorPage.setSumOperatorSign("Sudėtis");
        calculatorPage.clickCalculationButton();

        boolean expectedOutput = calculatorPage.firstNumberErrorMessageIsDisplayed();
        Assertions.assertTrue(expectedOutput, "Numbers can not be negative");
    }
    //SUBTRACTION TESTS
    @Test
    @Tag("subtractionPositiveTest")
    void subtractTwoPositiveNumbers(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsernameIntoField("user123");
        loginPage.enterPasswordIntoField("user123");
        loginPage.clickLoginButton();

        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.sendKeysToFirstNumberField("7");
        calculatorPage.sendKeysToSecondNumberField("3");
        calculatorPage.setSubtractionOperator("Atimtis");
        calculatorPage.clickCalculationButton();

        String expectedOutput = "7 - 3 = 4";
        String actualOutput = calculatorPage.getTextFromSubtractionResult();
        Assertions.assertEquals(expectedOutput, actualOutput, "Calculation unsuccessful");
    }
    @Test
    @Tag("subtractionNegativeTest")
    void subtractionWithEmptyNumberFields(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsernameIntoField("user123");
        loginPage.enterPasswordIntoField("user123");
        loginPage.clickLoginButton();

        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.sendKeysToFirstNumberField("");
        calculatorPage.sendKeysToSecondNumberField("");
        calculatorPage.setSubtractionOperator("Atimtis");
        calculatorPage.clickCalculationButton();

        boolean expectedOutput = calculatorPage.firstNumberErrorMessageIsDisplayed();
        Assertions.assertTrue(expectedOutput, "Field can not be empty");

        boolean expectedOutput2 = calculatorPage.secondNumberErrorMessageIsDisplayed();
        Assertions.assertTrue(expectedOutput2,"Field can not be empty");
    }
    //MULTIPLICATION TESTS
     @Test
     @Tag("multiplicationPositiveTest")
    void multiplicationOfTwoPositiveNumbers(){
         LoginPage loginPage = new LoginPage(driver);
         loginPage.enterUsernameIntoField("user123");
         loginPage.enterPasswordIntoField("user123");
         loginPage.clickLoginButton();

         CalculatorPage calculatorPage = new CalculatorPage(driver);

         calculatorPage.sendKeysToFirstNumberField("5");
         calculatorPage.sendKeysToSecondNumberField("5");
         calculatorPage.setMultiplicationOperator("Daugyba");
         calculatorPage.clickCalculationButton();

         String expectedOutput = "5 * 5 = 25";
         String actualOutput = calculatorPage.getTextFromMultiplicationResult();
         Assertions.assertEquals(expectedOutput,actualOutput, "Unsuccessful calculation");
     }
     @Test
     @Tag("multiplicationPositiveTest")
    void multiplicationWhenOneNumberIsZero(){
         LoginPage loginPage = new LoginPage(driver);
         loginPage.enterUsernameIntoField("user123");
         loginPage.enterPasswordIntoField("user123");
         loginPage.clickLoginButton();

         CalculatorPage calculatorPage = new CalculatorPage(driver);

         calculatorPage.sendKeysToFirstNumberField("5");
         calculatorPage.sendKeysToSecondNumberField("0");
         calculatorPage.setMultiplicationOperator("Daugyba");
         calculatorPage.clickCalculationButton();

         String expectedOutput = "5 * 0 = 0";
         String actualOutput = calculatorPage.getTextMultiplicationWithZero();
         Assertions.assertEquals(expectedOutput,actualOutput, "Unsuccessful calculation");
     }
     //DIVISION TESTS
    @Test
    @Tag("divisionPositiveTest")
    void divisionWithPositiveNumbers(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsernameIntoField("user123");
        loginPage.enterPasswordIntoField("user123");
        loginPage.clickLoginButton();

        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.sendKeysToFirstNumberField("12");
        calculatorPage.sendKeysToSecondNumberField("4");
        calculatorPage.setDivisionOperator("Dalyba");
        calculatorPage.clickCalculationButton();

        String expectedOutput = "12 / 4 = 3";
        String actualOutput = calculatorPage.getTextFromDivisionResult();
        Assertions.assertEquals(expectedOutput,actualOutput,"Unsuccessful calculation");
    }
    @Test
    @Tag("divisionPositiveTest")
    void divisionWhenOneNumberIsZero(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsernameIntoField("user123");
        loginPage.enterPasswordIntoField("user123");
        loginPage.clickLoginButton();

        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.sendKeysToFirstNumberField("0");
        calculatorPage.sendKeysToSecondNumberField("9");
        calculatorPage.setDivisionOperator("Dalyba");
        calculatorPage.clickCalculationButton();

        String expectedOutput = "0 / 9 = 0";
        String actualOutput = calculatorPage.getTextDivisionWithZero();
        Assertions.assertEquals(expectedOutput,actualOutput, "Unsuccessful calculation");
    }
}
