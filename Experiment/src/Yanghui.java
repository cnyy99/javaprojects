/*
代码运行环境:
1.Java version
    java version "9.0.4"
    Java(TM) SE Runtime Environment (build 9.0.4+11)
    Java HotSpot(TM) 64-Bit Server VM (build 9.0.4+11, mixed mode)

2.开发工具及系统环境:
    IntelliJ IDEA 2018.1.7 (Ultimate Edition)
    Build #IU-181.5540.23, built on November 12, 2018
    Licensed to 陈 楠
    Subscription is active until October 13, 2019
    For educational use only.
    JRE: 1.8.0_152-release-1136-b43 amd64
    JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
    Windows 10 10.0

 */

import java.util.Scanner;

public class Yanghui {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //包装输入输出
        String line;
        boolean t = false;
        if (args.length != 0) {
            t = true;
        }
        while (true) {
            try {
                int n = 0;
                if (!t) {
                    System.out.println("请输入杨辉三角的行数(q:退出):");//输出提示
                    do {
                        line = in.nextLine();                   //读取一行
                    } while (line.equals(""));                  //如果是空行则继续读取
                    if (line.equalsIgnoreCase("q"))        //如果输入的是'q'或'Q'则退出
                        System.exit(0);

                    n = Integer.parseInt(line);             //转换为int
                } else {
                    if (args.length != 1) {
                        System.out.println("参数个数错误!");          //输出提示
                        System.exit(0);
                    }
                    n = Integer.parseInt(args[0]);
                }
                int[][] map = new int[n][];                 //初始化二维数组
                for (int i = 0; i < n; i++)                 //初始化二维数组的每一行
                {
                    map[i] = new int[i + 1];
                    map[i][0] = map[i][i] = 1;              //每一行的开头和末尾置1
                }
                for (int i = 2; i < n; i++)                 //从第三行开始
                {
                    for (int j = 1; j < i; j++)             //对于这一行中的第二个到倒数第二个数
                    {
                        map[i][j] = (map[i - 1][j] + map[i - 1][j - 1]) % 10;   //每一个数位上一行上一列于这一列的和模10
                    }
                }
                printYangHui(map);                          //打印出杨辉三角

            } catch (NumberFormatException e)               //如果数字格式错误
            {
                System.out.println("数字格式错误!");          //输出提示

            } finally {
                if (t) {
                    System.exit(0);
                }
            }

        }
    }

    static void printYangHui(int[][] map)                   //打印杨辉三角
    {
        for (int i = 0; i < map.length; i++) {              //对于每一行
            for (int k = 0; k < map.length - i - 1; k++)    //打印map.length-i-1个空格
            {
                System.out.print(" ");                      //打印空格
            }
            for (int j = 0; j < i + 1; j++) {               //对于每个数
                System.out.print(map[i][j] % 10 + " ");     //输入这个数模10的结果并输出空格
            }
            System.out.println();                           //每一行输出结束后,换行
        }
    }
}
