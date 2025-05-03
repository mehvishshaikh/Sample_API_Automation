package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.ReqResAPIEndpoints;
import api.payload.ReqResPayload;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ReqResAPITests {
	@Test(priority = 1)
	public void getUserTest() {
		Response response = ReqResAPIEndpoints.getUser(2);
		response.then().log().all();
		ResponseBody body = response.getBody();
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("Response body is: " +body.asString());
	}
	
	@Test(priority = 2)
	public void postUserTest() {
		ReqResPayload reqPayload = new ReqResPayload();
		
		reqPayload.setJob("Senior Vice President");
		reqPayload.setName("Katherine Adams");
		
		Response response = ReqResAPIEndpoints.createUser(reqPayload);
		response.then().log().all();
		ResponseBody body = response.getBody();
		Assert.assertEquals(response.statusCode(), 201);
		System.out.println("Response body is: " +body.asString());
	}
	
	@Test(priority = 3)
	public void putUserTest() {
		ReqResPayload reqPayload = new ReqResPayload();
		
		reqPayload.setJob("Senior Vice President");
		reqPayload.setName("Katherine Adams");
		
		Response response = ReqResAPIEndpoints.updateUser(2, reqPayload);
		response.then().log().all();
		ResponseBody body = response.getBody();
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("Response body is: " +body.asString());
	}
	
	@Test(priority = 4)
	public void deleteUserTest() {
		Response response = ReqResAPIEndpoints.deleteUser(3);
		response.then().log().all();
		ResponseBody body = response.getBody();
		Assert.assertEquals(response.statusCode(), 204);
		System.out.println("Response body is: " +body.asString());
	}
}
