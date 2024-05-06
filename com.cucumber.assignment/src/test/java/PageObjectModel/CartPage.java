package PageObjectModel;

import java.time.Duration;
//import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
        super(driver);
    }
	
	private By productLink = By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-medium a-color-base a-text-normal']");
	private By addToCartButton = By.xpath("//input[@id='add-to-cart-button' and not(contains(@class, 'attach-dss-atc')) and @type='submit']"); 
	private By addToCartSideSheetClose = By.id("attach-close_sideSheet-link");
	
	//private By deleteButton = By.xpath("//input[@aria-label='Delete Apple iPhone 15 (128 GB) - Blue']");
	private By deleteButton = By.xpath("//input[contains(@aria-label, 'Delete')]");

	public void clickAddToCart() {
		System.out.println("Clicking on Add to Cart button...");
		WebElement addToCartElement = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
		addToCartElement.click();
		System.out.println("Clicked on Add to Cart button.");
	}
	
	public void clickProductLink() {
		System.out.println("Clicking on Add to Cart button...");
		WebElement productLinkElement = wait.until(ExpectedConditions.elementToBeClickable(productLink));
		productLinkElement.click();
		String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
	}

	public void closeSideSheet() {
		System.out.println("Closing side sheet...");
		wait.until(ExpectedConditions.elementToBeClickable(addToCartSideSheetClose)).click();
		System.out.println("Side sheet closed.");
	}

	public void goToCart() {
	    System.out.println("Navigating to the cart...");  
	    try {
	    	WebElement cartLink = driver.findElement(By.xpath("//a[@id='nav-cart']"));
	        
	        JavascriptExecutor executor = (JavascriptExecutor) driver;
	        executor.executeScript("arguments[0].click();", cartLink);
	        
	        System.out.println("Navigated to the cart.");
	    } catch (Exception e) {
	        System.out.println("Failed to navigate to the cart within the timeout.");
	    }
	}

	public void clickDeleteButton() {
		try {
			System.out.println("Inside Cart page Product deletion in progess");
			WebElement deleteLink = driver.findElement(deleteButton);


			wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
			System.out.println("Product Deleted");
			Thread.sleep(3000);
		}
		catch(Exception e) {
			System.out.println("Exception Occured "+e.getMessage());
		}
	}

	public String verifyRemovalMessage() {
		try {
			WebElement removalMessageElement = driver.findElement(By.cssSelector("div.a-padding-medium[data-action='delete']"));
			String removalMessageText = removalMessageElement.findElement(By.cssSelector("span.a-size-base")).getText();
			System.out.println(removalMessageText);
			return removalMessageText;
		} catch (Exception e) {
			System.out.println("Exception occurred while verifying removal message: " + e.getMessage());
			return null;
		}
	}
}
