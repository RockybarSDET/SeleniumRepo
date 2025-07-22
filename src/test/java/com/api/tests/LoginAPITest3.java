package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthenticationService;


import io.restassured.response.Response;


public class LoginAPITest3 {
	
	@Test(description = "Verify if Login API is working...")
	public void loginTest() {
		AuthenticationService authService=new AuthenticationService();
		Response response = authService.login("{\"username\": \"rocky1234\",\"password\": \"rocky1234\"}");
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(),200);
	}

}
