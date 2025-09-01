package drivers1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	 	WebDriver driver;
	    
	    @BeforeMethod
	    @Parameters({"browser"})
	    public void setUp(String browser) {
	    	
	        if (browser.equalsIgnoreCase("chrome")) {
	           // System.setProperty("webdriver.chrome.driver", "C:\\DriversChrome\\chromedriver.exe");
	        	WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("firefox")) {
//	        	System.setProperty("webdriver.gecko.driver", "C:\\DriversFirefox\\geckodriver.exe");        
//	            FirefoxOptions options = new FirefoxOptions();
//	            options.setBinary("C:\\Users\\Acer\\AppData\\Local\\Mozilla Firefox\\firefox.exe"); // exact path
//	            options.setAcceptInsecureCerts(true);
	        	WebDriverManager.firefoxdriver().setup();
	           // driver = new FirefoxDriver(options);
	        	driver = new FirefoxDriver();
	        	
	        } else {
	            throw new IllegalArgumentException("Invalid browser value: " + browser);
	        }

	        driver.manage().window().maximize();
	    }
	    @AfterMethod
		
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}


