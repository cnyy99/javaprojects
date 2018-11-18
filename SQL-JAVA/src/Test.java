import java.sql.*;

public class Test {
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    public static void main(String[] args) {
        try {
            conn = ConnectionSQL("EDUCATION", "student", "student");
            stmt = conn.createStatement();
            printAll();
            Student stu = new Student("1501109", "黄文雅", "女", "1997-03-02", "09999", "20");
//            Insert(stu);
            Update("delete from student where name='黄文雅'");
            printAll();
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static Connection ConnectionSQL(String dataBaseName, String user, String password) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=" + dataBaseName + ";user=" + user + ";password=" + password;
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void Insert(Student stu) {
        try {
            String sql = "INSERT INTO STUDENT(NO,NAME,SEX,BIRTH,CLASSNO,AGE) VALUES(" + "\'" + stu.getNo() + "\'," + "\'" + stu.getName() + "\'," + "\'" + stu.getSex() + "\'," + "\'" + stu.getBirth() + "\'," + "\'" + stu.getClassno() + "\'," + stu.getAge() + ")";
            System.out.println(sql);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean Update(String sql) {
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

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
            while (rs.next()) {
                System.out.println(rs.getString("no") + " " + rs.getString("name") + " " + rs.getString("sex") + " " + rs.getString("birth") + " " + rs.getString("classno") + " " + rs.getString("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
