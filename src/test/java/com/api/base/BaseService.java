package com.api.base;

import static io.restassured.RestAssured.given;

import com.api.filters.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService { //Wrapper for Rest Assured
	
//Base Uri
//Change the Request
//Handling the response
	
	private static final String BASE_URL="http://64.227.160.186:8080";
	private RequestSpecification requestspecificaion;
	
	static{
		RestAssured.filters(new LoggingFilter());//will execute only once
	}
	
	public BaseService() {
		
		requestspecificaion= given().baseUri(BASE_URL);
		
	}
	
	protected void setAuthToken(String token) {
		requestspecificaion.header("Authorization","Bearer "+token);
	}
	
	protected Response postRequest(Object payload, String endpoint){
		return requestspecificaion.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response getRequest( String endpoint){
		return requestspecificaion.get(endpoint);
	}
	
	protected Response postRequest(String baseUrl,Object payload, String endpoint){
		return requestspecificaion.baseUri(baseUrl).contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response putRequest(Object payload, String endpoint){
		return requestspecificaion.contentType(ContentType.JSON).body(payload).put(endpoint);
	}  
}
