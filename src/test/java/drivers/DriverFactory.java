package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	
    // ✅ Thread-safe WebDriver storage
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // ✅ Initialize driver based on browser type
    public static WebDriver initDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        // Optional: Maximize the window
        getDriver().manage().window().maximize();
        return getDriver();
    }

    // ✅ Retrieve the driver instance
    public static WebDriver getDriver() {
        return driver.get();
    }

    // ✅ Cleanup method to quit and remove the driver
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
