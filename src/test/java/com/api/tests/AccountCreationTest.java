package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description="Verify if login API is working....")
	public void createAccountTest() {
		SignUpRequest signUpRequest=new SignUpRequest.Builder().userName("DishaBhatt")
		.email("disha@bhatt.com")
		.firstName("Disha")
		.password("test123")
		.lastName("Bhatt")
		.mobileNumber("4753689412")
		.build();
		AuthService authService=  new AuthService();
		Response response=authService.signUp(signUpRequest);
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		
		
		
		
		
	}
	
}
