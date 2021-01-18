import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class DemoPostRequest {
HashMap map = new HashMap();

    @BeforeClass
    public void postData(){
        map.put("userId", MyRestUtils.getUserId());
        map.put("title",MyRestUtils.getTitle());
        map.put("body",MyRestUtils.getBody());

        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        RestAssured.basePath="/posts";

    }
    @Test
    public void myPostRequest(){
        given()
                .contentType("application/json; charset=utf-8")
                .body(map)
        .when()
            .post()
        .then()
            .statusCode(201)
                .and()
            .body("userId",equalTo(map.get("userId")))
                .and()
            .body("title",equalTo(map.get("title")))
                .and()
            .body("body",equalTo(map.get("body")))
                .log().body();
    }

}
