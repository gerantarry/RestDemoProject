public class StartHttpManager {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        String host=args[0], endpoint=args[1],method = args[2];
/*
        MyHttpManager ob1 = new MyHttpManager("https://jsonplaceholder.typicode.com",
                "/posts/2","delete");
*/

        try {
            MyHttpManager ob1 = new MyHttpManager(host,endpoint,method);
        }catch (ArrayIndexOutOfBoundsException exc){
            System.out.println(exc);
        }


    }
}
