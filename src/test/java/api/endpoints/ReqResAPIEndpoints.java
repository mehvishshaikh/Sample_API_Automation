package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.ReqResPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReqResAPIEndpoints {
	public static Response getUser(int id){
		Response response = given()
				.pathParam("id",id)
			.when()
				.get(ReqResAPIRoutes.get_url);
		return response;
	}
	
	public static Response createUser(ReqResPayload payload){
		Response response = given()
				.headers("x-api-key","reqres-free-v1")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(ReqResAPIRoutes.post_url);
		return response;
	}
	
	public static Response updateUser(int id, ReqResPayload payload){
		Response response = given()
				.headers("x-api-key","reqres-free-v1")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("id",id)
			.when()
				.put(ReqResAPIRoutes.update_url);
		return response;
	}
	
	public static Response deleteUser(int id){
		Response response = given()
				.headers("x-api-key","reqres-free-v1")
				.pathParam("id",id)
			.when()
				.delete(ReqResAPIRoutes.delete_url);
		return response;
	}
}
