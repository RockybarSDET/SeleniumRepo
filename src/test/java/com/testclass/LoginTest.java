package com.testclass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Parameters;
import pages.LoginPage;



public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @Parameters({"browser"})
    @BeforeMethod
    
    public void setUp(String browser) {
    	
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\DriversChrome\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
        	System.setProperty("webdriver.gecko.driver", "C:\\DriversFirefox\\geckodriver.exe");        
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary("C:\\Users\\Acer\\AppData\\Local\\Mozilla Firefox\\firefox.exe"); // exact path
            options.setAcceptInsecureCerts(true);
            driver = new FirefoxDriver(options);
        	
        } else {
            throw new IllegalArgumentException("Invalid browser value: " + browser);
        }

        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/login");
        
        loginPage = new LoginPage(driver);
    }

    @Parameters({"username","password"})
    @Test
    public void validLoginTest(String username, String password) {
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.loginvalidation().contains("Logout"),"Error message mismatch");
        
    }

    @Parameters({"wusername","wpassword"})
    @Test
    public void invalidLoginTest(String wusername, String wpassword) {
        loginPage.login(wusername, wpassword);
        Assert.assertTrue(loginPage.loginfailed().contains("invalid"),"Error message mismatch");
    }

    @AfterMethod
	
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
