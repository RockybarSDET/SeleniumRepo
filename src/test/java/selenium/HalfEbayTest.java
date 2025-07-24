package selenium;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.test.utility.TestUtil;

public class HalfEbayTest {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
			System.setProperty("webdriver.chrome.driver", "C:\\DriversChrome\\chromedriver.exe");
			driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        //driver.manage().deleteAllCookies();
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	        driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F");
	        try {
	            Thread.sleep(5000); // wait for 5 seconds
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

}
	@DataProvider
	
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testdata = TestUtil.getDataFromExcel();
		return testdata.iterator();
	}
	@Test(dataProvider="getTestData")
	public void halfEbayRegTest(String firstname, String lastname, String email,String password) throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@id='personalaccount-radio']")).click();
		
		driver.findElement(By.xpath("//input[@id='firstname']")).clear();
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstname);
		
		driver.findElement(By.xpath("//input[@id='lastname']")).clear();
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastname);
		
		driver.findElement(By.xpath("//input[@id='Email']")).clear();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		
		Thread.sleep(9000);
		
		driver.findElement(By.xpath("//*[@id='EMAIL_REG_FORM_SUBMIT']")).click();
				
	}
 @AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}