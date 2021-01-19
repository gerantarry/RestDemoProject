import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class MyRestUtilsTest {
    @Test
    public static int getUserId() {
        int generatedInt = (int) (Math.random() * 100);
        return (generatedInt + 10);
    }

    @Test
    public static String getTitle() {
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        return ("Holla " + generatedString);

    }

    @Test
    public static String getBody() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return ("It is random text:" + generatedString + "; its work");
    }
}
