import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

@QuarkusIntegrationTest
@QuarkusTestResource(PostgreSQLResource.class)
class FruitIT {

    @Test
    void getFruit() {
        // given
        given()
            .body("{\"id\": 1, \"name\": \"Apple\", \"description\": \"Red color\"}")
            .header("Content-Type", "application/json")
        .when().post("/fruits")
        .then().statusCode(200);

        // when
        when().get("/fruits")
        .then()
            .statusCode(200)
            .body("[0].id", is(1));
    }
}
