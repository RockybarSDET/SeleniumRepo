package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest2 {
	
	@Test(description = "Verify if Login API is working...")
	public void loginTest() {
		//RestAssured.baseURI="http://64.227.160.186:8080";
		Response response = RestAssured.given().baseUri("http://64.227.160.186:8080").header("Content-Type","application/json").body("{\"username\":\"rocky1234\",\"password\": \"rocky1234\"}").post("/api/auth/login");
	//	Response response1= RestAssured.given().baseUri("http://64.227.160.186:8080").header("Authorization","Bearer ","eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyb2NreTEyMzQiLCJpYXQiOjE3NTM1NDk2NzgsImV4cCI6MTc1MzU1MzI3OH0.rTgAUitjZdBu7g3RcbjybZqUCcu8dhr4CE6r_yIBleY").get("/api/users/profile");
		System.out.println(response.asPrettyString());
//		System.out.println(response1.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
