package temp;

public class StringEditorTester {
    public static void main(String args[])
    {
        String original = "Hello123,My name is Mark, 234I think you are my classmate?!!";
        System.out.println(StringEditor.removeNonLetters(original));
    }
}
