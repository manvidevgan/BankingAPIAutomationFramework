package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagemnetService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {

	@Test
	public void getProfileInfoTest() {
		AuthService authService=new AuthService();
		Response response=authService.login(new LoginRequest("manvidevgan","test@123"));
		LoginResponse loginResponse =response.as(LoginResponse.class);
		//System.out.println(loginResponse.getToken());
		
		UserProfileManagemnetService userProfileManagemnetService=new UserProfileManagemnetService();
		response=userProfileManagemnetService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		
		UserProfileResponse userProfileResponse=response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
		
		
	}
}
