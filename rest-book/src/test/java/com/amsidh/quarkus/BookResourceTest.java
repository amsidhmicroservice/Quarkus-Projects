package com.amsidh.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.vertx.core.json.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;

@QuarkusTest
@Slf4j
public class BookResourceTest {

    @Test
    public void shouldCreateBook() {
        JsonObject bookRequest = new JsonObject()
                .put("title","Building Microservice with Quarkus")
                .put("author","Amsidh")
                .put("year_of_publication",2020)
                .put("genre","Technology");

        given()
                .contentType(ContentType.JSON)
                .body(bookRequest.encode())
                .when()
                .post("/api/books")
                .then()
                .statusCode(201)
                .body("isbn_13", startsWith("13-"))
                .body("title", startsWith("Building Microservice "))
                .body("author", startsWith("Amsidh"))
                .body("year_of_publication", is(2020))
                .body("genre", is("Technology"))
                .body("creation_date", startsWith("20"));
    }

}