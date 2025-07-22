package selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchBrowser {
@Test
    public void openGoogleInChrome() {
        
        System.setProperty("webdriver.chrome.driver", "C:\\DriversChrome\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://signup.ebay.com/pa/crte");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='gh-ac']")).clear();
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Box");
//        String str=driver.getTitle();
//        System.out.println("Page Title is: " + str);

        // Optional: Close the browser after few seconds
        try {
            Thread.sleep(5000); // wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // Assert.assertEquals(driver.getTitle(), "Google");

        driver.quit();
    }
}
