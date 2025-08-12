package com.testclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class DriverTestFirefox {
	@Test
	
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\DriversFirefox\\geckodriver.exe");        
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Users\\Acer\\AppData\\Local\\Mozilla Firefox\\firefox.exe"); // exact path
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new FirefoxDriver(options);
        //WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}