public class java99table {
    public static void main(String args[]){
        int N = 9;
        for(int i = 0;i <= N;i++)
        {
            for(int j = 1;j <= i;j++)
            {
                System.out.print(j + " * " + i + " = "+ i * j + "   ");
            }
            System.out.println();
        }
    }
}
