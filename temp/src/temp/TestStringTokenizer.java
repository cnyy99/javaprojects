package temp;

import java.util.StringTokenizer;

public class TestStringTokenizer {
    public static void main(String args[]) {
        StringTokenizer anaB = new StringTokenizer("You-, and I are- students", " -,");
        int number = anaB.countTokens();
        int count = number;
        while (anaB.hasMoreTokens()) {
            String str = anaB.nextToken();
            System.out.println(str);
            System.out.println("剩余" + --count + "个词");
        }
        System.out.println("\n共有" + number + "个词");
    }
}
