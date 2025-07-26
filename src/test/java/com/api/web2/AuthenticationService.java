package com.api.web2; 
import com.api.models.request.LoginRequest;
import io.restassured.response.Response;

public class AuthenticationService extends  BaseService {
	
	private static final String BASE_PATH="/api/auth/";
	
	public Response login(LoginRequest payload) {
		
		return postRequest(payload,BASE_PATH+"login");
	}

}
