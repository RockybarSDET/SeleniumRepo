package com.testclass;
import java.time.Duration;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class AmazonTest {
		    WebDriver driver;
	    @BeforeMethod
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "C:\\DriversChrome\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }

	    @Test
	   	    public void openAmazonInChrome() throws InterruptedException {
	    	 Thread.sleep(5000);
	        driver.get("https://www.amazon.in/");
	       

	        Actions action=new Actions(driver);
	        action.moveToElement(driver.findElement(By.xpath("//span[@aria-label='India']"))).build().perform();
	        driver.findElement(By.xpath("//div[@id='nav-flyout-icp']//li[8]//a[1]//span[1]//i[1]")).click();

	        Thread.sleep(5000);

	        
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}



