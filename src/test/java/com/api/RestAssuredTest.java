package com.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.Test;

public class RestAssuredTest {
    
    @Test
    public void testCreatePost() {

        // Define the payload data
        JSONObject payload = new JSONObject();
        payload.put("title", "foo");
        payload.put("body", "bar");
        payload.put("userId", 1);

        // Send POST request with payload and verify response
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payload.toString())
                .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(201) // Verify created (201) status code
                .log().body(); // Log the response body
    }

    @Test
    public void testGetAllPosts() {

        // Send GET request to retrieve all posts
        RestAssured.given()
                .accept(ContentType.JSON) // Specify expected response content type
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(200) // Verify successful response (200 OK)
                .log().body(); // Log the response body for debugging
    }
}