public class LongestPiece {
    public static void main(String args[]) {
        if (args == null || args.length == 0) {
            System.out.println("No data has been input.");
            return;
        }
        for (String num : args) {
            int n = Integer.valueOf(num);
            String b = Integer.toBinaryString(n);
            System.out.println("The binary sequence of " + num + " is " + b);
            int count0 = 0, count1 = 0, max0 = 0, max1 = 0;
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == '0') {
                    count0++;
                    count1 = 0;
                } else {
                    count1++;
                    count0 = 0;
                }
                max0 = max0 > count0 ? max0 : count0;
                max1 = max1 > count1 ? max1 : count1;
            }
            System.out.println("The maximum length of consecutive '0' strings in the binary sequence is " + max0);
            System.out.println("The maximum length of consecutive '1' strings in the binary sequence is " + max1);
            System.out.print("\n");
        }
    }
}
