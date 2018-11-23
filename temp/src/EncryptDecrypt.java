import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EncryptDecrypt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入(finish表示结束):加/解密  源文件  目的文件  密钥列表:");
        while (in.hasNextLine()) {
            try {
                String tmp = in.nextLine(); //读取一行
                String arr[] = tmp.split("\\s+");   //从一行中解析出命令和参数
                if (tmp.equals("")) {   //判断是否是空行
                    continue;
                }
                if (tmp.toLowerCase().equals("finish")) {
                    System.exit(0);
                }
                if (arr[0].equals("加密")) {
                    String srcPath = arr[1].replace("\\", "/");
                    String tarPath = arr[2].replace("\\", "/");
                    ArrayList<Integer> code = new ArrayList<>();
                    for (int i = 3; i < arr.length; i++) {
                        code.add(Integer.valueOf(arr[i]));
                    }
                    ArrayList<String> str = readfile(srcPath);
                    if (str == null) {
                        System.out.println("请输入(finish表示结束):加/解密  源文件  目的文件  密钥列表:");
                        continue;
                    }
                    writefile(tarPath, encrypt(code, str));
                } else if (arr[0].equals("解密")) {
                    String srcPath = arr[1].replace("\\", "/");
                    String tarPath = arr[2].replace("\\", "/");
                    ArrayList<Integer> code = new ArrayList<>();
                    for (int i = 3; i < arr.length; i++) {
                        code.add(Integer.valueOf(arr[i]));
                    }
                    ArrayList<String> str = readfile(srcPath);
                    if (str == null) {
                        System.out.println("请输入(finish表示结束):加/解密  源文件  目的文件  密钥列表:");
                        continue;
                    }
                    writefile(tarPath, decrypt(code, str));
                } else {
                    System.out.println("命令错误,请重新输入\n");
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

    public static ArrayList<String> encrypt(ArrayList<Integer> code, ArrayList<String> str) {
        for (int j = 0; j < str.size(); j++) {
            StringBuilder[] strmap = new StringBuilder[code.size()];
            Integer[] iter = new Integer[code.size()];
            for (int i = 0; i < strmap.length; i++) {
                strmap[i] = new StringBuilder();
                iter[i] = 0;
            }
            StringBuilder strBuilder = new StringBuilder();
            for (int i = 0; i < str.get(j).length(); i++) {
                strmap[str.get(j).codePointAt(i) % code.size()].append(str.get(j).charAt(i));
            }
            for (int i = 0; i < strmap.length; i++) {
                strmap[i] = moveToRight(strmap[i].toString(), code.get(i));
            }
            for (int i = 0; i < str.get(j).length(); i++) {
                Integer key = str.get(j).codePointAt(i) % code.size();
                strBuilder.append(strmap[key].charAt(iter[key]++));
            }
            str.set(j, strBuilder.toString());

//            System.out.println(strBuilder.toString());
        }
        System.out.println("文件已经成功加密");
        //todo
        return str;
    }

    public static void help()
    {
        System.out.println("请输入(finish表示结束):加/解密  源文件  目的文件  密钥列表:");
    }
    public static ArrayList<String> decrypt(ArrayList<Integer> code, ArrayList<String> str) {
        for (int j = 0; j < str.size(); j++) {
            StringBuilder[] strmap = new StringBuilder[code.size()];
            Integer[] iter = new Integer[code.size()];
            for (int i = 0; i < strmap.length; i++) {
                strmap[i] = new StringBuilder();
                iter[i] = 0;
            }
            StringBuilder strBuilder = new StringBuilder();
            for (int i = 0; i < str.get(j).length(); i++) {
                strmap[str.get(j).codePointAt(i) % code.size()].append(str.get(j).charAt(i));
            }
            for (int i = 0; i < strmap.length; i++) {
                strmap[i] = moveToLeft(strmap[i].toString(), code.get(i));
            }
            for (int i = 0; i < str.get(j).length(); i++) {
                Integer key = str.get(j).codePointAt(i) % code.size();
                strBuilder.append(strmap[key].charAt(iter[key]++));
            }
            str.set(j, strBuilder.toString());

//            System.out.println(strBuilder.toString());
        }
        //todo
        System.out.println("文件已经成功解密");
        return str;
    }

    public static ArrayList<String> readfile(String path) {
        FileReader fileReader = null;
        BufferedReader reader = null;
        ArrayList<String> stringArrayList = new ArrayList<>();
        try {
            fileReader = new FileReader(path);
            reader = new BufferedReader(fileReader);
            String tempString = null;
            // 一次读入一行，直到读入 null 为文件结束
            System.out.println("原文件内容为:");
            while ((tempString = reader.readLine()) != null) {
                stringArrayList.add(tempString);
                System.out.println(tempString + "\n");
            }
        } catch (IOException e) {
            System.out.println("读取文件错误\n");
            stringArrayList = null;
        } finally {
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
        //todo
        return stringArrayList;
    }


    public static void writefile(String path, ArrayList<String> str) {
        StringBuilder temp = new StringBuilder();
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            for (String s : str) {
                temp.append(s).append("\n");
                fileWriter.write(s + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("写入文件错误\n");
        } finally {
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

    public static StringBuilder moveToRight(String from, int index) {
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

    public static StringBuilder moveToLeft(String from, int index) {
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

    public static String reChange(String from) {
        char[] froms = from.toCharArray();
        for (int i = 0; i < from.length() / 2; i++) {
            char temp = froms[i];
            froms[i] = froms[froms.length - 1 - i];
            froms[froms.length - 1 - i] = temp;
        }
        return String.valueOf(froms);
    }
}
