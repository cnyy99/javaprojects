package temp;

public class AppleTester {
    public static void main(String args[]) {
        Apple a = new Apple("red", true);
        Apple b = new Apple("red", true);
        System.out.println(a + "is equal to " + b + ":" + a.equals(b));
        System.out.println("a is identical to b:" + (a == b));
        Apple c = a;
        System.out.println(a + "is equal to " + c + ":" + a.equals(c));
        System.out.println("a is identical to c:" + (a == c));

    }
}
