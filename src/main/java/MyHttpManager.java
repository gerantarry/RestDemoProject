import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class MyHttpManager {

    //конструктор
    MyHttpManager(String host, String endpoint, String httpMethod) {

        MyRestUtils.UriPath(host,endpoint);

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .when()
                            .body(MyRestUtils.openJson())
                            .request(httpMethod.toLowerCase())
                        .then()
                            .extract().response();

        MyRestUtils.RespOut(response);


    }
}
