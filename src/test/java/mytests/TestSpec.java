package mytests;
import static io.restassured.RestAssured.*;
import static mytests.TestUtils.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestSpec {

    @Test(priority = 1)
    public static void PutRequestTest()throws java.io.FileNotFoundException{
        UriPathTest("https://jsonplaceholder.typicode.com", "/posts/2");
        String hmethod = "put";

        Response response =
                given()
                    .contentType(ContentType.JSON)
                .when()
                    .body(setup())
                    .request(hmethod)
                .then()
                    .assertThat()
                        .statusCode(200)
                        .header("Content-Type","application/json; charset=utf-8")
                    .extract().response();

            RespOutTest(response);
    }
    @Test(priority = 2)
    public static void GetRequestTest() throws java.io.FileNotFoundException {
        UriPathTest("https://jsonplaceholder.typicode.com", "/posts/2");
        String hmethod = "get";

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .body(setup())
                        .request(hmethod)
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .header("Content-Type","application/json; charset=utf-8")
                        .extract().response();

        RespOutTest(response);
    }
    @Test(priority = 3)
    public static void PostRequestTest() throws java.io.FileNotFoundException {
        UriPathTest("https://jsonplaceholder.typicode.com", "/posts");

        String hmethod = "post";

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .body(setup())
                        .request(hmethod)
                        .then()
                        .assertThat()
                        .statusCode(201)
                        .header("Content-Type","application/json; charset=utf-8")
                        .extract().response();

        RespOutTest(response);
    }
    @Test(priority = 4)
    public static void DeleteRequestTest() throws java.io.FileNotFoundException {
        UriPathTest("https://jsonplaceholder.typicode.com", "/posts/2");

        String hmethod = "delete";

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .body(setup())
                        .request(hmethod)
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .header("Content-Type","application/json; charset=utf-8")
                        .extract().response();

        RespOutTest(response);
    }
}
