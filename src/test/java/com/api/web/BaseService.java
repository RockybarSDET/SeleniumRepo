package com.api.web;

import com.api.models.request.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService { //WRAPPER for RestAssured

	//Handling BASE URI
	//CREATING THE REQUEST
	//HANDLING THE RESPONSE
	
	private static final String BASE_URL="https://swift.techwithjatin.com/";
	private RequestSpecification requestspecification;
	
	public BaseService() {
		requestspecification = RestAssured.given().baseUri(BASE_URL);
	}
	
	protected Response postRequest(Object payload,String endpoint) {
		return requestspecification.contentType(ContentType.JSON).body(payload).post(endpoint);
		
	}
}
