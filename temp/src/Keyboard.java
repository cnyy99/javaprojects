import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keyboard {
    static BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));

    public static int getInteger() {
        try {
            return Integer.valueOf(inputStream.readLine().trim());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getString() {
        try {
            return (inputStream.readLine());
        } catch (IOException e) {
            return "0";
        }
    }
}
