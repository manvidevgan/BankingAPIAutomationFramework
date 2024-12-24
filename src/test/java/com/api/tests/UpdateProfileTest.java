package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagemnetService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test
	public void getUpdateProfileTest() {
		AuthService authService=new AuthService();
		Response response=authService.login(new LoginRequest("manvidevgan","test@123"));
		LoginResponse loginResponse =response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		
		System.out.println("--------------------------------------------------------");
		
		UserProfileManagemnetService userProfileManagemnetService=new UserProfileManagemnetService();
		response=userProfileManagemnetService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse=response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(), "manvidevgan");
		
		System.out.println("--------------------------------------------------------");
		
		ProfileRequest	profileRequest=new ProfileRequest.Builder()
				.firstName("Manvi")
				.lastName("Devgan")
				.email("bccmanvidevgan123@gmail.com")
				.mobileNumber("4444444445")
				.build();
		response=userProfileManagemnetService.updateProfile(loginResponse.getToken(), profileRequest);
		System.out.println(response.asPrettyString());
		
		
		
		
	}
	
	
	
	
}
