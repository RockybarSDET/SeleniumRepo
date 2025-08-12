package com.api.base;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest2 {
	
	@Test(description = "Verify if Login API is working...")
	public void loginTest() {
		
		Response response = RestAssured.given().baseUri("http://64.227.160.186:8080").header("Content-Type","application/json").body("{\"username\":\"rocky1234\",\"password\": \"rocky1234\"}").post("/api/auth/login");
		Response response2= RestAssured.given().baseUri("http://64.227.160.186:8080").contentType(ContentType.URLENC)
				.formParam("username", "rocky1234")
			    .formParam("password", "rocky1234").post("/api/auth/login");
				
		System.out.println(response.asPrettyString());
		System.out.println(response2.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
