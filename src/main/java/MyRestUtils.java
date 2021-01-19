import org.apache.commons.lang3.RandomStringUtils;

public class MyRestUtils {
    public static int getUserId() {
        int generatedInt = (int) (Math.random() * 100);
        return (generatedInt + 10);
    }


    public static String getTitle() {
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        return ("Holla " + generatedString);

    }


    public static String getBody() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return ("It is random text:" + generatedString + "; its work");
    }



}
