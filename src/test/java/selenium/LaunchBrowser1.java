package selenium;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LaunchBrowser1 {

    WebDriver driver;
    String searchKeyword;

    @Parameters({"chromeDriverPath", "searchTerm"})
    @BeforeMethod
    public void setUp(String chromeDriverPath, String searchTerm) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        //searchKeyword = searchTerm;
        searchKeyword=searchTerm;

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @Parameters({"url"})
    public void openGoogleInChrome(String url) throws InterruptedException {
        driver.get(url);

        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).clear();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(searchKeyword);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertTrue(title.contains("Selenium"), title);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
