public class ClassMemeberPriviledge {
    public static void main(String[] args) {
        if (!check(args)) {
            return;
        }
    }

    static boolean check(String[] args) {
        if ((args == null) || (args.length != 3)) {
            System.out.println("输入的参数数量不准确,退出");
            return false;
        }
        if (args[0] != "default" && args[0] != "public") {
            System.out.println("错误!" + args[0] + "不是类访问权限的2种情况中的一种：“default”和“public”");
            return false;
        }
        if (args[1] != "default" && args[1] != "public" && args[1] != "private" && args[1] != "protected") {
            System.out.println("错误!" + args[0] + "不是成员的访问权限4种情况中的一种：“private”、“default”、“protected”和“public”");
            return false;
        }
        if (args[2] != "SameClass" && args[2] != "SamePackageNotSameClass" && args[2] != "OtherPackageSubClass" && args[2] != "OtherPackageNotSubClass") {
            System.out.println("错误!" + args[0] + "不是以下4种情况中的一种：“SameClass”、“SamePackageNotSameClass”、“OtherPackageSubClass”、“OtherPackageNotSubClass”");
            return false;
        }
        return true;
    }
}