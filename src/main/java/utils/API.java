package utils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API {

	
	public static void callAndVerifyResponse() {
        // Set the base URI for the API
        RestAssured.baseURI = "https://reqres.in";

        // Make an API request (e.g., GET request to /api/users)
        Response response = given()
                .when()
                .get("/api/users")
                .then()
                .extract()
                .response();

        // Verify the response status code
        assertEquals(200, response.getStatusCode());

        // Verify specific fields in the response body
        response.then()
                .body("page", equalTo(1))
                .body("per_page", equalTo(6))
                .body("total", equalTo(12))
                .body("total_pages", equalTo(2))
                .body("data", hasSize(6))
                .body("data[0].id", equalTo(1))
                .body("data[0].email", equalTo("george.bluth@reqres.in"))
                .body("data[0].first_name", equalTo("George"))
                .body("data[0].last_name", equalTo("Bluth"))
                .body("data[0].avatar", equalTo("https://reqres.in/img/faces/1-image.jpg"));

        // Additional assertions as needed
        assertNotNull(response.getBody());
	}
	
}
