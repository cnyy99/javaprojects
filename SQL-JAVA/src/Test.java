import java.sql.*;

public class Test {
    static Connection conn = null;      //数据库了解
    static Statement stmt = null;       //数据库的Statement
    static ResultSet rs = null;         //枚举查询结果

    public static void main(String[] args) {
        try {
            conn = ConnectionSQL("EDUCATION", "student", "student");//连接数据库
            stmt = conn.createStatement();              //建立statement
//            printAll();                 //打印student表                                 //打印student表
            TestInsert();//测试Insert方法
            TestInsertP();//测试InsertP方法
            TestSearch("select student.no,name\n" + //测试Search方法
                    "from student\n" +
                    "where no in(select no \n" +
                    "from score \n" +
                    "group by no \n" +
                    "having count(*)>=2)\n");
            TestUpdate();  //测试Update方法


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {     //关闭数据库相关
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static boolean TestInsert() {
        //构建student实例
        Student stu = new Student("117", "陈楠", "男", "1997-07-07", "00161", 20);
        System.out.println("测试Insert方法\n插入前数据库数据如下所示");
        printAll();                 //打印student表
        boolean t = Insert(stu);    //插入数据
        System.out.println("插入后数据库数据如下所示");
        printAll();                 //打印student表
        return t;
    }

    public static boolean TestInsertP() {
        //构建student实例
        Student stuP = new Student("17P", "陈楠", "男", "1997-07-07", "00161", 20);
        System.out.println("测试InsertP方法\n插入前数据库数据如下所示");
        printAll();                 //打印student表
        boolean t = InsertP(stuP);  //插入数据
        System.out.println("插入后数据库数据如下所示");
        printAll();                 //打印student表
        return t;
    }

    public static boolean TestUpdate() {
        String sql="delete from student where name='陈楠'";
        System.out.println("测试Update方法\n删除上述建立的学生信息前数据库数据如下所示");
        printAll();
        boolean t= Update(sql);
        System.out.println("测试Update方法\n删除上述建立的学生信息后数据库数据如下所示");
        printAll();
        return t;
    }

    public static boolean TestSearch(String sql) {
        try {
            rs = Search(sql);
            System.out.println("测试Search方法\n查询至少选修两门课程的学生学号和姓名的结果如下");
            System.out.println("no  name");
            while (rs.next()) {
                System.out.println(rs.getString("no") + " " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs != null;
    }


    public static Connection ConnectionSQL(String dataBaseName, String user, String password) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //加载包
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=" + dataBaseName + ";user=" + user + ";password=" + password;
            return DriverManager.getConnection(url); //返回连接对象
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet Search(String sql) {
        try {
            return stmt.executeQuery(sql); //返回查找的枚举对象
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean Insert(Student stu) {
        try {
            //插入数据库的sql语句
            String sql = "INSERT INTO STUDENT(NO,NAME,SEX,BIRTH,CLASSNO,AGE) VALUES(" + "\'" + stu.getNo() + "\',\'" + stu.getName() + "\',\'" + stu.getSex() + "\',\'" + stu.getBirth() + "\',\'" + stu.getClassno() + "\'," + stu.getAge() + ")";
            stmt.executeUpdate(sql);    //执行sql语句
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean InsertP(Student stu) {
        try {
            //构建PreparedStatement
            PreparedStatement preStatement = conn.prepareStatement("INSERT INTO STUDENT(NO,NAME,SEX,BIRTH,CLASSNO,AGE) VALUES(?,?,?,?,?,?)");
            preStatement.setString(1, stu.getNo());
            preStatement.setString(2, stu.getName());
            preStatement.setString(3, stu.getSex());
            preStatement.setString(4, stu.getBirth());
            preStatement.setString(5, stu.getClassno());
            preStatement.setInt(6, stu.getAge());
            preStatement.executeUpdate();//执行sql语句
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean Update(String sql) {
        try {
            stmt.executeUpdate(sql);//执行sql数据
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //打印student表
    public static void printAll() {
        try {
            String sql = "SELECT TOP 1000 " +
                    "       [NO]\n" +
                    "      ,[NAME]\n" +
                    "      ,[SEX]\n" +
                    "      ,[BIRTH]\n" +
                    "      ,[CLASSNO]\n" +
                    "      ,[AGE]\n" +
                    "  FROM [EDUCATION].[dbo].[student]";
            rs = stmt.executeQuery(sql);
            System.out.println("no\t\tname\tsex\tbirth\t\tclassno\tage");
            while (rs.next()) {
                System.out.println(rs.getString("no") + "\t\t" + rs.getString("name") + "\t\t" + rs.getString("sex") + "\t" + rs.getString("birth") + "\t" + rs.getString("classno") + "\t" + rs.getString("age"));
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
