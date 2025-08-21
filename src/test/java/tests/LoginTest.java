package tests;

import base.BaseTest;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	
	

	@Parameters({"username","password"})
    @Test
    public void validLoginTest(String username, String password) {
		driver.get("https://the-internet.herokuapp.com/login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
        Assert.assertTrue(loginpage.loginvalidation().contains("Logout"),"Error message mismatch");
        
    }

    @Parameters({"wusername","wpassword"})
    @Test
    public void invalidLoginTest(String wusername, String wpassword) {
    	driver.get("https://the-internet.herokuapp.com/login");
		LoginPage loginpage=new LoginPage(driver);
        loginpage.login(wusername, wpassword);
        Assert.assertTrue(loginpage.loginfailed().contains("invalid"),"Error message mismatch");
    }
        
    
}
