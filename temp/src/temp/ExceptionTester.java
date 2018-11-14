package temp;

import java.security.Key;

public class ExceptionTester {
    public static void main(String args[]) {
        System.out.println("Enter the first number");
        int number1 = Keyboard.getInteger();
        System.out.println("Enter the second number");
        int number2 = Keyboard.getInteger();
        System.out.println(number1 + "/" + number2 + "=");
        int result = number1 / number2;
        System.out.println(result);
    }
}
