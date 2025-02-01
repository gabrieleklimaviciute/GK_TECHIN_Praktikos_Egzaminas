import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {
    @FindBy(id = "username")
    private WebElement usernameInputField;
    @FindBy(id = "password")
    private WebElement passwordInputField;
    @FindBy(id = "passwordConfirm")
    private WebElement passwordConfirmationInputField;
    @FindBy(xpath = "//form[@id='userForm']/button[@type='submit']")
    private WebElement signupFormConfirmationButton;

    @FindBy(id = "username.errors")
    private WebElement usernameErrorMessage;
    @FindBy(xpath = "/html//span[@id='password.errors']")
    private WebElement passwordErrorMessage;
    @FindBy(xpath = "/html//span[@id='passwordConfirm.errors']")
    private WebElement confirmationPasswordError;

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public void sendKeysUsernameField(String username) {
        usernameInputField.sendKeys(username);
    }

    public void sendKeysPasswordField(String password) {
        passwordInputField.sendKeys(password);
    }

    public void sendKeysPasswordConfirmationField(String passwdConfirmation) {
        passwordConfirmationInputField.sendKeys(passwdConfirmation);
    }

    public void clickSignupConfirmationButton() {
        signupFormConfirmationButton.click();
    }

    public boolean successfulSignupAssert(String username) {
        WebElement loggedUsername = driver.findElement(By.xpath("//a[text()='Logout, " + username + "']"));
        return loggedUsername.isDisplayed();
    }

    public String getTextFromUsernameError() {
        return usernameErrorMessage.getText();

    }

    public String getTextPasswordError() {
        return passwordErrorMessage.getText();

    }

    public String getTextPasswordConfirmationError() {
        return confirmationPasswordError.getText();
    }
}


