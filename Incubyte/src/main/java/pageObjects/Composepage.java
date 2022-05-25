package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Composepage {
public WebDriver driver;

	By compose = By.xpath("//div[text()='Compose']");
	By recipient = By.className("vO");
	By subject = By.className("aoT");
	By body = By.className("Am");	
	By send = By.xpath("//div[text()='Send']");
	By sent = By.linkText("Sent");
	By message = By.xpath("//span[text()='Message sent']");
	By account  = By.cssSelector(".gb_Ba.gbii");
	By signout  = By.xpath("//*[text()='Sign out']");

	public Composepage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement compose() {
		return driver.findElement(compose);
	}
	
	public WebElement recipient() {
		return driver.findElement(recipient);
	}
	
	public WebElement subject() {
		return driver.findElement(subject);
	}
	public WebElement body() {
		return driver.findElement(body);
	}
	public WebElement send() {
		return driver.findElement(send);
	}
	public WebElement sent() {
		return driver.findElement(sent);
	}
	public WebElement message() {
		return driver.findElement(message);
	}
	public WebElement account() {
		return driver.findElement(account);
	}
	
	public WebElement signout() {
		return driver.findElement(signout);
	}
	
}
