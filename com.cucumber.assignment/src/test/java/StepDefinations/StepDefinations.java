package StepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjectModel.CartPage;
import PageObjectModel.Homepage;
import PageObjectModel.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

public class StepDefinations {

	private WebDriver driver;
    private LoginPage loginPage;
    private Homepage homepage;
    private CartPage cartPage;
    
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {

    }

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		loginPage = new LoginPage(driver);
		homepage = new Homepage(driver);
		cartPage = new CartPage(driver);
	}


	    @When("Click signin Link")
	    public void click_signin_link() {
	      
	        loginPage.clickSigninLink();
	    }

	    @When("User enters Email as {string}")
	    public void user_enters_email_as(String email) {
	    
	        loginPage.enterEmail(email);
	    }

	    @When("Click continue")
	    public void click_continue() throws InterruptedException {
	       
	        loginPage.clickContinueButton();
	    }

	    @When("Enter Password as {string}")
	    public void enter_password_as(String password) {
	 
	        loginPage.enterPassword(password);
	    }

	    @Then("Page Title should be {string}")
	    public void page_title_should_be(String expectedTitle) throws InterruptedException {
	    
	    	Thread.sleep(1000);
	    	String actualTitle = driver.getTitle();
	    	Assert.assertEquals(expectedTitle, actualTitle);
	    }
	    
	    @When("Click SignIn")
	    public void click_sign_in() {
	    
	        loginPage.clickSignInButton();
	    }

	    @Then("User should see an error message {string}")
	    public void user_should_see_an_error_message(String expectedMsg) {
	 
	    	String actualErrorMsg = loginPage.getErrorMsg();
	        Assert.assertEquals(expectedMsg, actualErrorMsg);
	    }

	    @Then("close browser")
	    public void close_browser() {

	    }
	    
	    @When("User enters item name as {string}")
	    public void user_enters_item_name_as(String productName) {
	 
	        homepage.enterProductName(productName);
	    }

	    @When("Click search")
	    public void click_search() {
	      
	        homepage.clickSearchBtn();
	    }
	    
	    @When("User clicks all link")
	    public void user_clicks_all_link() {
	        
	        homepage.clickAllLink();
	    }

	    @When("Best Seller")
	    public void best_seller() {
	   
	        homepage.clickBestSellerLink();
	    }

	    @Then("User clicks category as {string}")
	    public void user_clicks_category_as(String category) {
	   
	        homepage.clickLinkByText(category);
	    }
	    @Then("Expected title should be {string}")
	    public void expected_title_should_be(String expectedTitle) {
	       
	    	String actualErrorMsg = driver.getTitle();
	        Assert.assertEquals(expectedTitle, actualErrorMsg);
	    }
	    
	    @Then("User clicks on the first search result")
	    public void user_clicks_on_the_first_search_result() {
	     
	        cartPage.clickProductLink();
	    }

	    @Then("User adds the item to the cart")
	    public void user_adds_the_item_to_the_cart() {
	    
	        cartPage.clickAddToCart();
	        cartPage.closeSideSheet();
	    }

	    @Then("User views the cart")
	    public void user_views_the_cart() {
	      
	        cartPage.goToCart();
	    }

	    @Then("User removes the item from the cart")
	    public void user_removes_the_item_from_the_cart() {
	     
	        cartPage.clickDeleteButton();
	        String actualText = cartPage.verifyRemovalMessage();
	        System.out.println(actualText);
	        String expectedMessage = "was removed from Shopping Cart.";
	        Assert.assertTrue("Actual text does not contain the expected message.", actualText.contains(expectedMessage));
	    }


	}


