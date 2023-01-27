package sk.fmfi.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class FeeResourceIT {

    @Test
    public void testCreateAndFetchFee() {
        // UC1 create a fee
        Response postRequest = given().when()
                .header("Content-Type", "application/json")
                .body("{}")
                .post("/fee");

        assertThat(postRequest.statusCode(), is(200));
        // UC2 get all fees
        Response getRequest = given().when()
                .get("/fee");

        assertThat(getRequest.statusCode(), is(200));
        ResponseBody body = getRequest.body();
        String responseBody = body.prettyPrint();

        assertNotNull(responseBody);
    }

}
