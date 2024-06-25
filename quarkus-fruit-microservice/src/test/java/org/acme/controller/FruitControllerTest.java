package org.acme.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class FruitControllerTest {

    @Test
    void getFruits() {
        given()
            .when().get("/fruits")
            .then().statusCode(200);
    }
}
