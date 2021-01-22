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

/*
        switch (m) {
            case ("get"):
                MyRestUtils.GetRequest(host, endpoint);
                break;
            case ("post"): {
                try {
                    MyRestUtils.PostRequest(host, endpoint);
                } catch (java.io.FileNotFoundException exc) {
                    System.out.println("file not found");
                }
                break;
            }

          case("put"):{
            try {

                MyRestUtils.PutRequest(host,endpoint,m);
            }catch (java.io.FileNotFoundException exc){
                System.out.println("file not found");
            }
            break;
          }
            case("delete"):
                MyRestUtils.DeleteRequest(host,endpoint,m);
                break;

            default:
                System.out.println("method not found");
        }
        */
    }
}
