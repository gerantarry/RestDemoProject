import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class MyRestUtils {

    public static FileInputStream openJson() {
        FileInputStream fData = null;
        try {
            fData = new FileInputStream("src/main/resources/putData.json");
        } catch (FileNotFoundException exc) {
            System.out.println(exc);
        }
        return fData;
    }

    public static void UriPath(String host, String endpoint) {
        baseURI = host;
        basePath = endpoint;

    }

    public static void RespOut(Response response) {

        if (response!=null){
            String JsonAsString = response.asString();
        System.out.println("ПРОВЕРКА: \n" + JsonAsString);}
        else System.out.println("ПРОВЕРКА: пустое поле ответа");
    }
}
