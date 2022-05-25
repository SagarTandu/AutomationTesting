package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
public WebDriver driver;
public Properties prop;
public WebDriverWait w;
public Actions act;
	
public WebDriver initializeBrowser() throws IOException {
	FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Incubyte\\Incubyte\\src\\main\\java\\resources\\data.properties");
	prop = new Properties();
	prop.load(fis);
	
	String browserName = prop.getProperty("browser");
	prop.getProperty("URL");
	
	if(browserName.equals("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	
	if(browserName.equals("Edge"))
	{
		System.setProperty("webdriver.edge.driver", "C:\\Users\\HP\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		 driver =  new EdgeDriver();
	}
	

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	w = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.manage().window().maximize();
	
	act = new Actions(driver);
	
	
	
	
	return driver;
	
}
	
	
	
}
