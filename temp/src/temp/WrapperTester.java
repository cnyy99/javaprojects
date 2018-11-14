package temp;

public class WrapperTester {
    public static void sortNum(Comparable[] c) {
        Comparable temp;
        for (int i = c.length - 1; i >= 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (c[j].compareTo(c[j + 1]) > 0) {
                    temp = c[j];
                    c[j] = c[j + 1];
                    c[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String args[]) {
        int[] a = {3, 2, 5};
        Integer[] aa = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            aa[i] = new Integer(a[i]);
        }
        sortNum(aa);
        for (Integer anAa : aa) {
            System.out.println(anAa.toString() + " ");
        }
    }
}
