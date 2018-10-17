public class ClassTest {
    public static void main(String args[])
    {
        BankAcconut anAccount= new BankAcconut();
        Class aClass = anAccount.getClass();
        System.out.println(aClass);
        System.out.println(aClass.getName());
    }
}
