package sk.fmfi;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AdvancedGreetingResourceTest {

    @Test
    public void testGreetingEndpointWithoutQueryParam() {
        given()
                .when().get("/greeting")
                .then()
                .statusCode(200)
                .body(is("Hello, World"));
    }

    @Test
    public void testGreetingEndpointWithQueryParam() {
        given()
                .when().get("/greeting?subject=johny")
                .then()
                .statusCode(200)
                .body(is("Hello, johny"));
    }

}
