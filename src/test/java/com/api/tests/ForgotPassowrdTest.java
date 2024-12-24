package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class ForgotPassowrdTest {
	
	@Test(description="Verify if forgot passowrd API is working....")
	public void forgotPasswordTest() {
		
		AuthService authService=  new AuthService();
		Response response=authService.forgotPassword("bccmanvidevgan123@gmail.com");
		System.out.println(response.asPrettyString());
		
		
		
	}

}
