package com.api.base;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUserInfo {
	
@Test (description="Get User Information...")
public void getUserInfo() {
	Response response= RestAssured.given().baseUri("http://64.227.160.186:8080").header("Authorization","Bearer "+"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyb2NreTEyMzQiLCJpYXQiOjE3NTQ2MDk2MjcsImV4cCI6MTc1NDYxMzIyN30.q5cyqkFFqY6nU-oOCNmnV4e-A3Dkq8eSbpMG3RhiixI").get("/api/users/profile");
	System.out.println(response.asPrettyString());
}
}
