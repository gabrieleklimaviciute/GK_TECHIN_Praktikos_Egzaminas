import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
//    @FindBy(xpath = "//a[@href='/rodyti?id=3']")
    @FindBy(css = "tr:nth-of-type(2) > td:nth-of-type(5) > a:nth-of-type(3)")
    private WebElement displayButton;
    @FindBy(xpath = "//body[@class='container']/div[@class='table-responsive']")
    private WebElement displayedOperationTable;
    @FindBy(css = "tr:nth-of-type(2) > td:nth-of-type(5) > a:nth-of-type(1)")
    private WebElement changeButton;
    @FindBy(xpath = "//input[@name='sk1']")
    private WebElement firstNumberInputField;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement changeConfirmationButton;
    @FindBy(css = "tr:nth-of-type(2) > td:nth-of-type(5) > a:nth-of-type(2)")
    private WebElement deletionButton;
// Assertions locators
    @FindBy(xpath = "//body[@class='container']/div[@class='table-responsive']/table[@class='table table-striped']/tbody/tr[2]/td[.='10']")
    private WebElement displayedChangedNumber;
     @FindBy(xpath = "//h1[.='Whitelabel Error Page']")
     private WebElement changedNumberErrorMessage;


    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public void clickDisplayButton(){
        displayButton.click();
    }
    public boolean isDisplayedOperationTable(){
        return displayedOperationTable.isDisplayed();
    }
    public void clickChangeButton(){
        changeButton.click();
    }
    public void clearFirstNumberField(){
        firstNumberInputField.clear();
    }
    public void sendKeysChangeFirstNumberInputField(String number){
        firstNumberInputField.sendKeys(number);
    }
    public void clickChangeConfirmationButton(){
        changeConfirmationButton.click();
    }
    public String getTextChangedNumber(){
        return displayedChangedNumber.getText();
    }
    public String getTextChangedNumberErrorMessage(){
        return changedNumberErrorMessage.getText();
    }
    public void clickDeletionButton(){
        deletionButton.click();
    }

}
