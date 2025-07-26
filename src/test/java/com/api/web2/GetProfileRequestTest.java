package com.api.web2;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {
	@Test
	public void getProfileInfoTest() {
		
		LoginRequest loginRequest=new LoginRequest("rocky1234","rocky1234");
		AuthenticationService authService=new AuthenticationService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse=response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		Assert.assertEquals(loginResponse.getEmail(),"rockyrahaman13.rr@gmail.com");
		Assert.assertEquals(response.getStatusCode(),200);
				
		UserProfileManagementService userProfileManagementService=new UserProfileManagementService();
		response=userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		
		UserProfileResponse userProfileResponse=response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getFirstName());
		Assert.assertEquals(userProfileResponse.getFirstName(),"Rockybar");
		
	}

}
