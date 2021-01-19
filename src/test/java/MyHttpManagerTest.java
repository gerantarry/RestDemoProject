import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class MyHttpManagerTest {
    HashMap postData = new HashMap();

    @Test
    public void GetRequest() {

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
    public void PostRequest()  {
        baseURI="https://jsonplaceholder.typicode.com";
        basePath="/comments";

        postData.put("userId",1956);



        //формирование запроса
        Response response =
        given()
                .contentType("application/json; charset=utf-8")
                .body(postData)
                .when()
                    .post()
                .then()
                    .extract().response();

        String JsonAsString = response.asString();

        System.out.println("ПРОВЕРКА:\n " + JsonAsString);



    }
}
