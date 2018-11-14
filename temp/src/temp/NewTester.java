package temp;

public class NewTester {
    public static void main(String args[]) {
        ShowType st = new ShowType();
        GeneralType<Integer> i = new GeneralType<>(2);
        GeneralType<String> s = new GeneralType<>("hello");
        st.showType(i);
        st.showType(s);
        GeneralType d = new GeneralType<>(0.33);
        System.out.println("i.object=" + i.getObj());
        System.out.println("i.object=" + d.getObj());
    }
}
