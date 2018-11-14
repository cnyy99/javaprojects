package temp;

public class Tester {
    public static void main(String atgs[]) {
        BankAcconut a = new BankAcconut("Bob", 123456, 100.00f);
        BankAcconut b = new BankAcconut("Bob", 123456, 100.00f);
        BankAcconut c = a;
        if (a == b) {
            System.out.println("a==b    YES");
        } else {
            System.out.println("a==b    NO");
        }
        if (c == a) {
            System.out.println("a==c    YES");
        } else {
            System.out.println("a==c    NO");
        }

        if (a.equals(b)) {
            System.out.println("a.equals(b)    YES");
        } else {
            System.out.println("a.equals(b)    NO");
        }
        if (c.equals(a)) {
            System.out.println("a.equals(c)    YES");
        } else {
            System.out.println("a.equals(c)    NO");
        }
    }
}
