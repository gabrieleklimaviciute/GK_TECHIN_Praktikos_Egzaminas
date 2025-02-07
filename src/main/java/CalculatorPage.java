import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends BasePage {
    @FindBy(id = "sk1")
    private WebElement firstNumberInputField;
    @FindBy(id = "sk2")
    private WebElement secondNumberInputField;
    @FindBy(xpath = "//select[@name='zenklas']")
    private WebElement operatorSigns;
    @FindBy(xpath = "//form[@id='number']/input[@value='skaičiuoti']")
    private WebElement calculationButton;

    @FindBy(xpath = "//h4[contains(text(), '= 10')]")
    private WebElement sumResult;
    @FindBy(xpath = "//h4[contains(text(), '= 4')]")
    private WebElement subtractionResult;
    @FindBy(xpath = "//h4[contains(text(), '= 25')]")
    private WebElement multiplicationResult;
    @FindBy(xpath = "//h4[contains(text(), '= 0')]")
    private WebElement multiplicationResultWhenZero;
    @FindBy(xpath = "//h4[contains(text(), '= 3')]")
    private WebElement divisionResult;
    @FindBy(xpath = "//h4[contains(text(), '= 0')]")
    private WebElement divisionResultWhenZero;
    //Locator for "done operations" opening
    @FindBy(xpath = "//a[@href='/skaiciai']")
    private WebElement doneOperationsSearchButton;

    //Logout locators
    @FindBy (css = "a[onclick]")
    private WebElement logoutButton;




    @FindBy(id = "sk1.errors")
    private WebElement firstNumberErrorMessage;
    @FindBy(id = "sk2.errors")
    private WebElement secondNumberErrorMessage;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    //Sum operations
    public void sendKeysToFirstNumberField(String num1) {
        firstNumberInputField.clear();
        firstNumberInputField.sendKeys(num1);
    }

    public void sendKeysToSecondNumberField(String num2) {
        secondNumberInputField.clear();
        secondNumberInputField.sendKeys(num2);
    }

    public void setSumOperatorSign(String operator) {
        operatorSigns.click();
        operatorSigns.sendKeys(operator);
    }

    public void clickCalculationButton() {
        calculationButton.click();
    }

    public String getTextFromSumResult() {
        return sumResult.getText();
    }

    public boolean firstNumberErrorMessageIsDisplayed() {
        return firstNumberErrorMessage.isDisplayed();
    }
    //Subtraction Operations

    public void setSubtractionOperator(String operator) {
        operatorSigns.click();
        operatorSigns.sendKeys(operator);
    }

    public String getTextFromSubtractionResult() {
        return subtractionResult.getText();
    }

    public boolean secondNumberErrorMessageIsDisplayed() {
        return secondNumberErrorMessage.isDisplayed();
    }
    //Multiplication Operations

    public void setMultiplicationOperator(String operator) {
        operatorSigns.click();
        operatorSigns.sendKeys(operator);
    }

    public String getTextFromMultiplicationResult() {
        return multiplicationResult.getText();
    }
    public String getTextMultiplicationWithZero(){
        return multiplicationResultWhenZero.getText();
    }

    // Division Operations
    public void setDivisionOperator(String operator){
        operatorSigns.click();
        operatorSigns.sendKeys(operator);
    }
    public String getTextFromDivisionResult(){
        return divisionResult.getText();
    }
     public String getTextDivisionWithZero(){
        return divisionResultWhenZero.getText();
     }
     public void clickLogoutButton(){
        logoutButton.click();
     }
     public void clickDoneOperationsButton(){
        doneOperationsSearchButton.click();
     }
}
