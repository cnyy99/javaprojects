import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyArrayList {
    private static ArrayList<Integer> list;

    public static void main(String[] args) {
        list = new ArrayList<>();
        final ArrayList<String> map = new ArrayList<>();
        init_map(map);
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String tmp = in.nextLine(); //读取一行
            String arr[] = tmp.split("\\s+");   //从一行中解析出命令和参数
            if (tmp.equals("")) {   //判断是否是空行
                continue;
            }
            //判断命令格式是否正确
            if ((arr.length > 3 || !map.contains(arr[0].toLowerCase())) || (map.indexOf(arr[0].toLowerCase()) < 6 && arr.length != 1) || (map.indexOf(arr[0].toLowerCase()) > 5 && map.indexOf(arr[0].toLowerCase()) < 10 && arr.length != 2) || (map.indexOf(arr[0].toLowerCase()) > 9 && arr.length != 3)) {
                Illegal();
                continue;
            }
            switch (arr[0].toLowerCase()) {     //解析命令
                case "help":
                    help();
                    break;
                case "finish":
                    finish();
                    break;
                case "clear":
                    clear();
                    break;
                case "isempty":
                    isEmpty();
                    break;
                case "size":
                    size();
                    break;
                case "iterator":
                    iterator();
                    break;
                case "add_last":
                    if (!checkNumber(arr[1])) {
                        continue;
                    }
                    add_last(Integer.valueOf(arr[1]));
                    break;
                case "contains":
                    if (!checkNumber(arr[1])) {
                        continue;
                    }
                    contains(Integer.valueOf(arr[1]));
                    break;
                case "get":
                    if (!checkNumber(arr[1]) || !check(Integer.valueOf(arr[1]), 1)) {
                        continue;
                    }
                    System.out.println("该位置的元素为: " + get(Integer.valueOf(arr[1])) + "\n");
                    break;
                case "remove":
                    if (!checkNumber(arr[1]) || !check(Integer.valueOf(arr[1]), 1)) {
                        continue;
                    }
                    remove(Integer.valueOf(arr[1]));
                    break;
                case "set":
                    if (!checkNumber(arr[1]) || !check(Integer.valueOf(arr[1]), 1) || !checkNumber(arr[2])) {
                        continue;
                    }
                    set(Integer.valueOf(arr[1]), Integer.valueOf(arr[2]));
                    break;
                case "add_any":
                    if (!checkNumber(arr[1]) || !check(Integer.valueOf(arr[1]), 0) || !checkNumber(arr[2])) {
                        continue;
                    }
                    add_any(Integer.valueOf(arr[1]), Integer.valueOf(arr[2]));
                    break;
            }
            System.out.println();
        }
    }

    //输出不合法提示
    static void Illegal() {
        System.out.println("输入的命令不符合规范\n");
    }

    //检查参数是否是数字
    static boolean isNumeric(String str) {//检查参数是否是数字
        Pattern pattern = Pattern.compile("-?[0-9]+");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    //检查参数是否是数字
    static boolean checkNumber(String str) {
        if (!isNumeric(str)) {
            System.out.println("输入的参数不是整数\n");
            return false;
        }
        return true;
    }

    //初始化命令map
    static void init_map(ArrayList<String> map) {
        map.add("help");
        map.add("finish");
        map.add("clear");
        map.add("isempty");
        map.add("size");
        map.add("iterator");
        map.add("add_last");
        map.add("contains");
        map.add("get");
        map.add("remove");
        map.add("set");
        map.add("add_any");
    }

    //显示帮助界面
    static void help() {
        System.out.println("（1）\thelp — 不带参数。打印出所有的命令。\n" +
                "（2）\tfinish — 不带参数。程序退出。\n" +
                "（3）\tclear — 不带参数。清空数据列表。\n" +
                "（4）\tisEmpty — 不带参数。返回数据列表是否为空的信息。\n" +
                "（5）\tsize — 不带参数。返回当前数据列表的元素数目。\n" +
                "（6）\titerator — 不带参数。遍历当前数据列表。\n" +
                "（7）\tadd_last — 带一个参数。把所带的参数追加到数据列表最后。\n" +
                "（8）\tcontains — 带一个参数。查看列表中是否含有所给的参数。\n" +
                "（9）\tget — 带一个参数。查看列表中的相应位置上的数据并返回。这个参数不能小于0，也不能大于或等于size。\n" +
                "（10）\tremove — 带一个参数。删除列表中相应位置上的信息。这个参数不能小于0，也不能大于或等于size。\n" +
                "（11）\tset — 带2个参数，第一个参数是位置，第二个参数是数据。把相应的位置上的数据置换成给定的第二个参数。\n" +
                "（12）\tadd_any — 带2个参数，在某个位置上插入一个新数据。\n");
    }

    //finish命令
    static void finish() {
        System.out.println("退出");
        System.exit(0);
    }

    //clear命令
    static void clear() {
        list.clear();
        System.out.println("列表已经清空");
    }

    //isEmpty命令
    static void isEmpty() {
        if (list.isEmpty()) {
            System.out.println("列表为空");
        } else {
            System.out.println("列表不为空");
        }
    }

    //size命令
    static void size() {
        System.out.println("列表数据元素共有  " + list.size() + "个");
    }

    //iterator命令
    static void iterator() {
        System.out.print("列表数据元素列表：");
        for (Integer t : list) {
            System.out.print(t + "\t");
        }
        System.out.println();
    }

    //add_last命令
    static void add_last(Integer num) {
        list.add(num);
        System.out.println("数据已经追加到列表末端");
    }

    //contains命令
    static void contains(Integer num) {
        if (list.contains(num)) {
            System.out.println("列表中有所给数据");
        } else {
            System.out.println("列表中没有所给数据");
        }
    }

    //get命令
    static Integer get(Integer n) {
        return list.get(n);
    }

    //remove命令
    static void remove(Integer n) {
        list.remove(n.intValue());
        System.out.println("给定位置的数据已从列表中删除");
    }

    //set命令
    static void set(Integer n, Integer number) {
        list.set(n, number);
        System.out.println("数据已经存储到了列表的指定位置");
    }

    //add_any命令
    static void add_any(Integer n, Integer number) {
        list.add(n, number);
        System.out.println("数据已经插入到了列表的指定位置");
    }

    //检查下标是否合法  add_any是合法范围为[0 - n],其他时候为[0 - (n-1)]
    static boolean check(Integer n, int type) {
        if ((type == 1 && (n < 0 || n >= list.size())) || (type == 0 && (n < 0 || n > list.size()))) {
            System.out.println("不在数据列表范围内\n");
            return false;
        } else {
            return true;
        }
    }
}
