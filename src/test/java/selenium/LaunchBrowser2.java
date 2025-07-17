package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchBrowser2 {
@Test
    public void openGoogleInChrome() {
        // Set the path to chromedriver (optional if chromedriver is in system PATH)
        System.setProperty("webdriver.chrome.driver", "C:\\DriversChrome\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open Google
        driver.get("https://www.flipkart.com");

        // Optional: Maximize the browser window
        driver.manage().window().maximize();

        // Optional: Print page title
        System.out.println("Page Title is: " + driver.getTitle());

        // Optional: Close the browser after few seconds
        try {
            Thread.sleep(3000); // wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(driver.getTitle(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");

        driver.quit();
    }
}
