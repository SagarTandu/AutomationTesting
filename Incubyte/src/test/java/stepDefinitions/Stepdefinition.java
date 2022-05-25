package stepDefinitions;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.Composepage;
import pageObjects.Loginpage;
import resources.Base;



@RunWith(Cucumber.class)

public class Stepdefinition extends Base{
public WebDriver driver;
public Composepage cp;
public Loginpage lp;


     @Given("User visits Gmail login page")
     public void user_visits_gmail_login_page() throws IOException {
    	 driver= initializeBrowser();
    	 driver.get(prop.getProperty("URL"));
    }
     

     @And("User will login with email \"([^\"]*)\" and password \"([^\"]*)\"$")
     public void user_will_login_with_email_something_and_password_something(String strArg1, String strArg2) throws Throwable {
    	 
    	lp = new Loginpage(driver);
     	lp.email().sendKeys("kselenium.java@gmail.com");
     	lp.Next().click();
     	lp.password().sendKeys("Selenium@123");
     	//w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Next')]")));
     	WebElement nextButton = lp.Next();
     	w.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(nextButton)));
     	lp.Next().click();
     }
   
      	
     @When("User will compose email to the recipient {string}")
     public void user_will_compose_email_to_the_recipient(String string) {
    	
    	cp = new Composepage(driver);
    	cp.compose().click();
    	cp.recipient().click();
     	cp.recipient().sendKeys("kselenium.java@gmail.com");
     	act.sendKeys(Keys.ENTER).build().perform();
     }
     

     @And("With body of the email {string} and subject {string}")
     public void with_body_of_the_email_and_subject(String string, String string2) {
    	
    	cp.subject().click();
      	cp.subject().sendKeys("Incubyte");
      	cp.body().click();
      	cp.body().sendKeys("Automation QA test for Incubyte"); 	
    	
    }
     
     @Then("Send email")
     public void send_email() {
    	 
    	 cp.send().click();
     }
     
     @And("Verify the successfull message")
     public void verify_the_successfull_message() throws Throwable {
         
    	 String msg = cp.message().getText();
         Assert.assertEquals(msg, "Message sent");
         System.out.println(msg);
     }
     
     @And("Verify the email sent in the sent items")
     public void verify_the_email_sent_in_the_sent_items() throws Throwable {
         
    	 cp.sent().click();
     }
     
     
     


}