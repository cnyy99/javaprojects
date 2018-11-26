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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EncryptDecrypt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //从控制台输入
        help();
        while (in.hasNextLine()) {          //有输入则进行
            try {
                String tmp = in.nextLine(); //读取一行
                String arr[] = tmp.split("\\s+");   //从一行中解析出命令和参数
                if (tmp.equals("")) {   //判断是否是空行
                    continue;
                }
                if (tmp.toLowerCase().equals("finish")) { //如果输入的是finish 则直接结束
                    System.exit(0);  //退出
                }
                String srcPath = arr[1].replace("\\", "/"); //将路径中的'\'替换成'/'
                String tarPath = arr[2].replace("\\", "/"); //将路径中的'\'替换成'/'
                ArrayList<Integer> code = new ArrayList<>();        //密钥列表
                for (int i = 3; i < arr.length; i++) {      //从用户输入中提取出所有密钥
                    code.add(Integer.valueOf(arr[i]));      //加入密钥列表中
                }
                ArrayList<String> str = readfile(srcPath);  //读取文件,返回每一行组成的ArrayList
                if (str == null) {      //读取文件错误,输出提示,继续
                    help();
                    continue;
                }
                switch (arr[0]) {
                    case "加密": //命令为加密
                        writefile(tarPath, en_deCrypt(code, str, true));     //写入目标文件加密后的内容

                        break;
                    case "解密": //命令为加密
                        writefile(tarPath, en_deCrypt(code, str, false));     //写入目标文件解密后的内容

                        break;
                    default:
                        System.out.println("命令错误,请重新输入\n");
                        break;
                }
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("数字格式错误,请重新输入\n");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("参数个数错误\n");
            }
            help();
        }
    }
    public static ArrayList<String> en_deCrypt(ArrayList<Integer> code, ArrayList<String> str,boolean en) {
        for (int j = 0; j < str.size(); j++) {      //遍历每一行
            StringBuilder[] strmap = new StringBuilder[code.size()];        //建立跟密钥个数相同的StringBulider
            Integer[] iter = new Integer[code.size()];                      //建立跟密钥个数相同的Integer,作为每一组的指针1a's'z
            for (int i = 0; i < strmap.length; i++) {       //初始化strmap和iter指针
                strmap[i] = new StringBuilder();
                iter[i] = 0;
            }
            for (int i = 0; i < str.get(j).length(); i++) {//对每一个字符,填入相应的strmap中
                strmap[str.get(j).codePointAt(i) % code.size()].append(str.get(j).charAt(i));
            }
            for (int i = 0; i < strmap.length; i++) {   //对每一组进行向左或向右移动
                if(en)
                {
                    strmap[i] = moveToRight(strmap[i].toString(), code.get(i)); //加密 向右移动
                }
                else
                {
                    strmap[i] = moveToLeft(strmap[i].toString(), code.get(i));  //解密 向左移动
                }
            }
            StringBuilder strBuilder = new StringBuilder();
            for (int i = 0; i < str.get(j).length(); i++) {//将每一组回填到相应位置
                Integer key = str.get(j).codePointAt(i) % code.size();//计算为哪一组
                strBuilder.append(strmap[key].charAt(iter[key]++));   //回填
            }
            str.set(j, strBuilder.toString());              //更改str
        }
        System.out.println(en?"文件已经成功加密":"文件已经成功解密");
        return str;
    }
    //输入提示
    public static void help() {
        System.out.println("请输入(finish表示结束):加/解密  源文件  目的文件  密钥列表:");
    }

    public static ArrayList<String> readfile(String path) {
        FileReader fileReader = null;
        BufferedReader reader = null;
        ArrayList<String> stringArrayList = new ArrayList<>();  //初始化arraylist
        try {
            fileReader = new FileReader(path);          //实例化fileReader
            reader = new BufferedReader(fileReader);    //实例化reader
            String tempString = null;                   //初始化tempString
            // 一次读入一行，直到读入 null 为文件结束
            System.out.println("原文件内容为:");
            while ((tempString = reader.readLine()) != null) {      //一行一行读入文件
                stringArrayList.add(tempString);                //加入stringSringList中
                System.out.println(tempString);                 //输出读到的内容
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("读取文件错误\n");
            stringArrayList = null;     //出错时将stringArrayList置为null
        } finally {         //关闭读文件相关
            try {
                if (reader != null) {
                    reader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return stringArrayList;
    }


    public static void writefile(String path, ArrayList<String> str) {
        StringBuilder temp = new StringBuilder();       //实例化stringbuilder
        FileWriter fileWriter = null;                   //初始化fileWrite
        try {
            fileWriter = new FileWriter(path);          //实例化fileWrite
            for (String s : str) {                      //对str中的每一行
                temp.append(s).append("\n");            //temp加上每一行再加上换行符
                fileWriter.write(s + "\n");         //写入每一行外加一个换行符
            }
        } catch (IOException e) {
            System.out.println("写入文件错误\n");
        } finally {                                     //关闭fileWriter
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("目的文件的内容是:\n" + temp);
    }

    public static StringBuilder moveToRight(String from, int index) {   //向右循环移动,先反转两部分,合起来之后再反转整体
        Integer length = from.length();
        while (length < index) {
            length *= 2;
        }
        String first = reChange(from.substring(0, (length - index) % from.length()));
        String second = reChange(from.substring((length - index) % from.length()));
        from = first + second;
        from = reChange(from);
//        System.out.println(from);
        return new StringBuilder(from);
    }

    public static StringBuilder moveToLeft(String from, int index) {    //向左循环移动,先反转整体,合起来之后再反转两部分
        Integer length = from.length();
        while (length < index) {
            length *= 2;
        }
        from = reChange(from);
        String first = reChange(from.substring(0, (length - index) % from.length()));
        String second = reChange(from.substring((length - index) % from.length()));
        from = first + second;
//        System.out.println(from);
        return new StringBuilder(from);
    }

    public static String reChange(String from) {    //反转字符串
        char[] froms = from.toCharArray();
        for (int i = 0; i < from.length() / 2; i++) {
            char temp = froms[i];
            froms[i] = froms[froms.length - 1 - i];
            froms[froms.length - 1 - i] = temp;
        }
        return String.valueOf(froms);
    }
}
