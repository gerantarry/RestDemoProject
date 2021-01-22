package mytests;

import io.restassured.response.Response;
import org.testng.annotations.Ignore;

import java.io.FileInputStream;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class TestUtils {
    @Ignore
    public static FileInputStream setup() throws java.io.FileNotFoundException{
        FileInputStream fData = new FileInputStream("src/main/resources/putData.json");
        return fData;
    }
    @Ignore
    public static void UriPathTest(String host, String endpoint) {
        baseURI = host;
        basePath = endpoint;

    }
    @Ignore
    public static void RespOutTest(Response response) {
        if (response!=null){
            String JsonAsString = response.asString();
            System.out.println("ПРОВЕРКА: \n" + JsonAsString);}
        else System.out.println("ПРОВЕРКА: пустое поле ответа");
    }
}
