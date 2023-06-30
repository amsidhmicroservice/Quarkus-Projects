package com.amsidh.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.collection.IsMapContaining.hasKey;

@QuarkusTest
public class NumberResourceTest {

    @Test
    public void testIsbnOkEndpoint() {
        given()
                .when().get("/api/numbers")
                .then()
                .statusCode(200)
                .body("isbn_13", startsWith("13-"))
                .body("isbn_10", startsWith("10-"))
                .body(not(hasKey("createdDate")));
    }

    @Test
    public void testUrlNotFoundEndpoint() {
        ValidatableResponse response = given()
                .when().get("/api/numbersx")
                .then()
                .statusCode(404)
                .log().all();
        Assertions.assertEquals("", response.extract().body().asString());
    }
}