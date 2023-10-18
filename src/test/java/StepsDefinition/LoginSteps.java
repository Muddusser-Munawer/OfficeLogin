package StepsDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    WebDriver driver = null;
    WebDriverWait wait = null;

    @Given("user open a browser")
    public void user_open_a_browser() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/DAX/eclipse-workspace/OfficeLogin/src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10); // Initialize WebDriverWait with a timeout of 10 seconds.
    }

    @Given("user is on saucedemo page")
    public void user_is_on_saucedemo_page() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @When("user enter username and password field")
    public void user_enter_username_and_password_field() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
    }

    @And("Hit Login Button")
    public void Hit_Login_Button() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("User navigate to Homepage")
    public void user_navigate_to_Homepage() {
        // Wait until the "Products" text is visible on the page.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Products')]")));
    }

    @Then("Select Filters Options")
    public void Select_Filters_Options() {
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        Select selectObject = new Select(dropdown);
        selectObject.selectByVisibleText("Price (high to low)");
        
        
    }
    @Then("add products to the cart")
    public void add_products_to_the_cart() throws InterruptedException {
    	WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
      Thread.sleep(5000); 
        
      js.executeScript("window.scrollBy(0, 500);");
    }

    @And("remove products to the cart")
    public void remove_products_to_the_cart() throws InterruptedException {
    	WebElement removeFromCartButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeFromCartButton.click();
        
        Thread.sleep(5000); 
    }

    
}
