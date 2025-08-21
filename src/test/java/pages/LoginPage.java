package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

   private WebDriver driver;
   
// Constructor to initialize WebDriver and elements
   public LoginPage(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(driver, this);
   }


    // Locators using PageFactory
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']")
    private WebElement loginButton;
    
    @FindBy(xpath = "//i[@class='icon-2x icon-signout']")
    private WebElement loginvalidation;

    @FindBy(xpath = "//div[@id='flash']")
    private WebElement loginfailed;
    
    
    // Actions
    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }
    
    public String loginvalidation() {
 	   return loginvalidation.getText();
    }

   public String loginfailed() {
	   return loginfailed.getText();
   }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
