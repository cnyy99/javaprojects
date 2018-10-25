import java.util.HashSet;

public class ClassMemeberPriviledge {
    public static void main(String[] args) {
        if (!check(args)) {
            return;
        }
        System.out.println("您输入的类访问权限是:" + args[0] + "\n您输入的成员访问权限是:" + args[1] + "\n您输入的环境是:" + args[2]);
        String finall = getFinall(args);//计算类成员的综合访问权限
        System.out.println("类成员的综合访问权限是:" + finall);
        boolean read = getRead(args[2], finall);//计算最终访问权限
        System.out.println(read ? "您输入的环境中对您输入的类成员变量有访问权限" : "您输入的环境中对您输入的类成员变量没有访问权限");
    }

    private static boolean check(String[] args) {
        if ((args == null) || (args.length != 3)) {
            System.out.println("输入的参数数量不准确,退出");
            return false;
        }
        HashSet<String> hs = new HashSet<>();
        hs.add("default");
        hs.add("public");
        if (!hs.contains(args[0])) {
            System.out.println("错误! " + args[0] + " 不是类访问权限的2种情况中的一种：\"default\"和\"public\"");
            return false;
        }
        hs.add("private");
        hs.add("protected");
        if (!hs.contains(args[1])) {
            System.out.println("错误! " + args[1] + " 不是成员的访问权限4种情况中的一种：\"private\"、\"default\"、\"protected\"和\"public\"");
            return false;
        }
        if (!args[2].equalsIgnoreCase("SameClass") && !args[2].equalsIgnoreCase("SamePackageNotSameClass") && !args[2].equalsIgnoreCase("OtherPackageSubClass") && !args[2].equalsIgnoreCase("OtherPackageNotSubClass")) {
            System.out.println("错误! " + args[2] + " 不是以下4种情况中的一种：\"SameClass\"、\"SamePackageNotSameClass\"、\"OtherPackageSubClass\"、\"OtherPackageNotSubClass\"");
            return false;
        }
        return true;
    }

    private static String getFinall(String[] args) {
        if (args[1].equals("private")) {
            return "private";
        } else if (args[0].equals("public") && args[1].equals("protected")) {
            return "protected";
        } else if (args[0].equals("default") || args[1].equals("default")) {
            return "default";
        } else {
            return "public";
        }
    }

    private static boolean getRead(String str, String finall) {
        switch (str.toLowerCase()) {    //通过类成员的综合访问权限finall和环境综合计算类成员能否访问
            case "sameclass":
                return true;
            case "samepackagenotsameclass":
                return !finall.equals("private");
            case "otherpackagesubclass":
                return finall.equals("protected") || finall.equals("public");
            case "otherpackagenotsubclass":
                return finall.equals("public");
        }
        return true;
    }
}
