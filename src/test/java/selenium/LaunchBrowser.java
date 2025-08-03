package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchBrowser {

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
    public void openGoogleInChrome() throws InterruptedException {
        driver.get("https://www.google.com/");
        // Clear and enter search term
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).clear();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Selenium WebDriver");
        Thread.sleep(3000);
        // Hit ENTER instead of clicking the button (more reliable)
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        String title = driver.getTitle();
        // Wait for page to load and title to change
        Thread.sleep(5000);
        System.out.println("Page Title: " + title);
        Assert.assertTrue(title.contains("Selenium"), "Title does not contain expected text.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
