import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class MyHttpManagerTest {
    HashMap postData = new HashMap();

    @Test
    public void GetRequestTest() {

        Response response =
                given()
                        .when()
                        .get("https://jsonplaceholder.typicode.com/comments")
                        .then()
                        .extract().response();
        String JsonAsString = response.asString();

        System.out.println("ПРОВЕРКА: \n"+ JsonAsString);


    }

    @Test
    public void PostRequestTest() throws java.io.FileNotFoundException {
        baseURI="https://jsonplaceholder.typicode.com";
        basePath="/comments";

        FileInputStream fData = new FileInputStream("src/main/resources/postData.json");

        //формирование запроса
        Response response =
        given()
                .contentType("application/json; charset=utf-8")
                .body(fData)
                .when()
                    .post()
                .then()
                    .statusCode(201)
                    .extract().response();

        String JsonAsString = response.asString();

        System.out.println("ПРОВЕРКА:\n " + JsonAsString);



    }

    @Test
    public void PutRequestTest() throws java.io.FileNotFoundException{
        baseURI="https://jsonplaceholder.typicode.com";
        basePath="/posts/2";

        FileInputStream fData = new FileInputStream("src/main/resources/putData.json");

        Response response = given()
                .contentType("application/json; charset=utf-8")
                .body(fData)
                .when()
                .put()
                .then()
                .extract().response();
        String JsonAsString = response.asString();

        System.out.println(JsonAsString);

    }
}
