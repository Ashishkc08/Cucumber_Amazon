package PageObjectModel;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    
    
    private By passwordInput = By.id("ap_password");
	private By continueButton = By.id("continue");
    WebElement accountLists;
 
    private By emailInput = By.id("ap_email");
    private By signInBtn = By.xpath("//input[@id='signInSubmit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
	public void clickSigninLink() {
		accountLists = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Account & Lists')]")));
		accountLists.click();
	}
	
	public void enterEmail(String username) {
		WebElement emailInputField= wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        emailInputField.sendKeys(username);
    }
	
	public void enterPassword(String password) {
		WebElement passwordInputField= wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
		passwordInputField.sendKeys(password);
    }
	
	public void clickContinueButton() throws InterruptedException {
    	WebElement continueButtonElement= wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButtonElement.click();
        
    }
	
	public void clickSignInButton() {
    	WebElement signinButtonElement= wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
    	signinButtonElement.click();
        
    }
	
	public String getErrorMsg() {
		WebElement errorMsgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(.,'There was a problem')]")));
	    return errorMsgElement.getText();
        
    }
}
