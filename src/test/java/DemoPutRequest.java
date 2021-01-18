import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DemoPutRequest {
  public static   HashMap map = new HashMap();
  int id = 2;


    @BeforeClass
    public void putData(){
    map.put("body", MyRestUtils.getBody());
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        RestAssured.basePath="/posts/"+id;
    }
    @Test
    public void myPutRequest(){
        given()
            .contentType("application/json; charset=utf-8")
            .body(map)
        .when()
            .put()
        .then()
            .statusCode(200)
            .log().body();
             //   .and()
           // .body("body", equalTo(map.get("body")));

    }

}
