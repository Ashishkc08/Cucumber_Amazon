package PageObjectModel;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage extends BasePage {
	public Homepage(WebDriver driver) {
        super(driver);
    }
	
	By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
	By searchButton = By.xpath("//input[@id='nav-search-submit-button']");
	By allLink = By.xpath("//i[contains(@class,'hm-icon nav-sprite')]");
	By bestSellerLink = By.xpath("//a[@href='/gp/bestsellers/?ref_=nav_em_cs_bestsellers_0_1_1_2']");
	public void enterProductName(String productName) {
		try {
			WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
			searchInput.clear();
			searchInput.sendKeys(productName);
			
		}
		catch (Exception e){
			System.out.println("Exception Occured "+e.getMessage());
		}

	}
	public void clickSearchBtn() {
		try {
			driver.findElement(searchButton).click();
		}
		catch (Exception e){
			System.out.println("Exception Occured "+e.getMessage());
		}

	}
	
	public void clickAllLink() {
		try {
			WebElement allLinkElement = wait.until(ExpectedConditions.elementToBeClickable(allLink));
			allLinkElement.click();
		}
		catch (Exception e){
			System.out.println("Exception Occured "+e.getMessage());
		}

	}
	public void clickBestSellerLink() {
		try {
			WebElement bestSellerLinkElement = wait.until(ExpectedConditions.elementToBeClickable(bestSellerLink));
			bestSellerLinkElement.click();
		}
		catch (Exception e){
			System.out.println("Exception Occured "+e.getMessage());
		}

	}
	public void clickLinkByText(String linkText) {
		System.out.println("Clicking dynamic link"+linkText);
        By dynamicLink = By.xpath("(//a[contains(text(),'" + linkText + "')])[2]");
     
        try {
            WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(dynamicLink));
            linkElement.click();
            System.out.println("Clicked dynamic link");
        } catch (Exception e) {
            System.out.println("Exception Occurred " + e.getMessage());
        }
    }
}
