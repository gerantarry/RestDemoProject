import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class MyHttpManager {
    String h, e, m;

    //конструкторы
    MyHttpManager(){};

MyHttpManager(String host,String endpoint, String httpMethod) throws IOException {
      h=host;
      e=endpoint;
      m=httpMethod.toLowerCase();



      switch (m) {
          case("get"):
              GetRequest(h,e);
              break;
          case("post"):
              PostRequest(h,e);
              break;
        /*  case("put"):
              PutRequest(h,e);

        */
      }
}

    public String GetRequest(String host, String endpoint) {

        Response response =
                given()
                        .when()
                        .get(host+endpoint)
                        .then()
                        .extract().response();
        String JsonAsString = response.asString();

        System.out.println("ПРОВЕРКА: \n"+ JsonAsString);

        return JsonAsString;
    }

    public String PostRequest(String host, String endpoint) throws java.io.IOException {
        HashMap postData = new HashMap();
        Scanner console = new Scanner(System.in);
        String key, value;
        char stop = 'y';

        // ввод данных для отправки
        //TODO обработать исключение java.io.IOException или отправлять готовый json
        System.out.println("enter the key,then enter the value");
        do{
                System.out.print("key");
                key=console.nextLine();
                System.out.print("\nvalue");
                value=console.nextLine();

                postData.put(key,value);
                System.out.println("continue? y/n");
                stop=(char)System.in.read();
                if(stop=='n')break;


        }while (stop!='n');

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


    return JsonAsString;
    }
}
