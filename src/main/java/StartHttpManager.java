import java.io.IOException;

public class StartHttpManager {
    public static void main(String[] args) throws IOException {
        MyHttpManager ob1 = new MyHttpManager("https://jsonplaceholder.typicode.com",
                "/comments","post");


    }
}
