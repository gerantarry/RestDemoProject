import io.restassured.response.Response;
import java.io.FileInputStream;
import static io.restassured.RestAssured.*;

public class MyRestUtils {
    public static String GetRequest(String host, String endpoint) {
        baseURI = host;
        basePath = endpoint;
        Response response =
                given()
                        .when()
                        .get(host + endpoint)
                        .then()
                        .extract().response();
        String JsonAsString = response.asString();

        System.out.println("ПРОВЕРКА: \n" + JsonAsString);

        return JsonAsString;
    }

    public static String PostRequest(String host, String endpoint) throws java.io.FileNotFoundException {

        baseURI = host;
        basePath = endpoint;

        FileInputStream fData = new FileInputStream("src/main/resources/postData.json");

        //формирование запроса
        Response response =
                given()
                        .contentType("application/json; charset=utf-8")
                        .body(fData)
                        .when()
                        .post()
                        .then()
                        .extract().response();

        String JsonAsString = response.asString();

        System.out.println("ПРОВЕРКА:\n " + JsonAsString);


        return JsonAsString;
    }

    public static String PutRequest (String host, String endpoint) throws java.io.FileNotFoundException{
        baseURI=host;
        basePath=endpoint;

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

        return JsonAsString;
    }

}
