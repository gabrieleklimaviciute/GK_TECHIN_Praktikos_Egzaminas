import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'Sukurti naują paskyrą')]")
    private WebElement createNewAccountButton;
//        @FindBy(id = "number2")
//    private WebElement secondNumberField;
//    @FindBy(id = "calculate")
//    private WebElement calculationButton;
    @FindBy(css = "input[name='username']")
    private WebElement usernameInputField;
    @FindBy(css = "input[name='password']")
    private WebElement passwordInputField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//form[@action='/prisijungti']/div/span[2]")
    private WebElement loginErrorMessage;

    //Logout locators
     @FindBy(xpath = "/html//form[@action='/prisijungti']//span[.='Sėkmingai atsijungėte']")
     private WebElement logoutMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openSignupForm() {
        createNewAccountButton.click();
    }

    public void enterUsernameIntoField(String username) {
        usernameInputField.sendKeys(username);
    }

    public void enterPasswordIntoField(String password) {
        passwordInputField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean successfulLoginAssert(String username) {
        WebElement loggedUsername = driver.findElement(By.xpath("//a[text()='Logout, " + username + "']"));
        return loggedUsername.isDisplayed();
    }
    public String getTextLoginErrorMessage(){
       return loginErrorMessage.getText();
    }
    public String getTextLogoutMessage(){
       return logoutMessage.getText();
    }
}
