package com.api.web;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class LoginAPITest3 {
	
	@Test(description = "Verify if Login API is working...")
	public void loginTest() {
		LoginRequest loginRequest=new LoginRequest("rocky1234","rocky1234");
		AuthenticationService authService=new AuthenticationService();
		Response response = authService.login(loginRequest);
		
		LoginResponse loginResponse=response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		Assert.assertEquals(response.getStatusCode(),200);
	}

}
