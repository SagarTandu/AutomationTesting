package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {

public WebDriver driver;
	
	By email = By.name("identifier");
	By Next = By.xpath("//span[text()='Next']");
	By password = By.name("password");
	
	public Loginpage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement email() {
		return driver.findElement(email);
	}
	
	public WebElement Next() {
		return driver.findElement(Next);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
}