public class StartHttpManager {
    //метод для запуска в консоли
  /*  public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        String host = args[0], endpoint = args[1], httpMethod = args[2];

        try {
            MyHttpManager ob1 = new MyHttpManager(host, endpoint, httpMethod);
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println(exc);
        }
    }
*/


// метод для запуска в IDEA
    public static void main(String[] args) {
        MyHttpManager ob1 = new MyHttpManager("https://jsonplaceholder.typicode.com",
                "/posts/2","get");
    }

    }