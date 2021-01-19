/*
given()
    set cookies, add auth, add param, set headers info etc...
when()
    get, post, put, delete...
then()
    validate status code, extract response, extract headers cookies & response body..

 */
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class GetRequestTest {

    @Test
    public void Demo1_GET_Request(){
            given()
            .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
            .then()
                .statusCode(200)
               // .statusLine("HTTP/1.1 200 OK")
                .assertThat().body("userId", equalTo(1))
                .header("Content-Type","application/json; charset=utf-8")
                .log().body();

    }

}
