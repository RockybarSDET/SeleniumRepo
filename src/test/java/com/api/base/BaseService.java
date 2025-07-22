package com.api.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService { //WRAPPER for RestAssured

	//Handling BASE URI
	//CREATING THE REQUEST
	//HANDLING THE RESPONSE
	
	private static final String BASE_URL="http://64.227.160.186:8080";
	private RequestSpecification requestspecification;
	
	public BaseService() {
		requestspecification = RestAssured.given().baseUri(BASE_URL);
	}
	
	protected Response postRequest(String payload,String endpoint) {
		return requestspecification.contentType(ContentType.JSON).body(payload).post(endpoint);
		
	}
}
