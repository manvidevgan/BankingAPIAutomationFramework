package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;
@Listeners(com.api.listner.TestListener.class)
public class LoginAPITest3 {
		
	@Test(description="Verify if login API is working....")
	public void LoginTest()
	{
		//serializw
		LoginRequest loginRequest =new LoginRequest("manvidevgan","test@123");
		AuthService authService=new AuthService();
		Response response=authService.login(loginRequest);
		//Deserialize
		LoginResponse loginResponse=response.as(LoginResponse.class);
		
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getId());
		
		Assert.assertTrue(loginResponse.getToken() !=null);
		Assert.assertEquals(loginResponse.getEmail(), "bccmanvidevgan123@gmail.com");
		Assert.assertEquals(loginResponse.getId(), 412);

		
		
		
		
	}
	
}
