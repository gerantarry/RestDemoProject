import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class MyHttpManager {
    String h, e, m;

    //конструктор
    MyHttpManager(String host, String endpoint, String httpMethod) {
        h = host;
        e = endpoint;
        m = httpMethod.toLowerCase();

        switch (m) {
            case ("get"):
                MyRestUtils.GetRequest(h, e);
                break;
            case ("post"): {
                try {
                    MyRestUtils.PostRequest(h, e);
                } catch (java.io.FileNotFoundException exc) {
                    System.out.println("file not found");
                }
                break;
            }

          case("put"):{
            try {

                MyRestUtils.PutRequest(h,e);
            }catch (java.io.FileNotFoundException exc){
                System.out.println("file not found");
            }
            break;
          }

        }
    }
}
