package temp;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoubleSort {
    static boolean isNumeric(String str)
    {
        Pattern pattern = Pattern.compile("(-?[0-9]+\\.?[0-9]+)||(-?[0-9])");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("No data has been input");
            return;
        }
        double[] arr = new double[args.length];
        for (int i = 0; i < args.length; i++) {
            if(!isNumeric(args[i]))
            {
                System.out.println("Illegal digital format: "+args[i]);
                return;
            }
            arr[i] = Double.valueOf(args[i]);
        }
        System.out.println("You has inputed " + args.length + " numbers. They are ");
        for (Double n : arr) {
            System.out.print(n + "\t");
        }
        System.out.println("\n");
        System.out.println("After sort:");
        Arrays.sort(arr);
        for (Double n : arr) {
            System.out.print(n + "\t");
        }
    }
}
