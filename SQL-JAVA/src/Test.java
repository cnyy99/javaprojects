import java.sql.*;

public class Test {
    static Connection conn = null;      //数据库连接
    static Statement stmt = null;       //数据库的Statement
    static ResultSet rs = null;         //枚举查询结果

    public static void main(String[] args) {
        String sql = "select student.no,name\n" + //测试Search方法的sql语句
                "from student\n" +
                "where no in(select no \n" +
                "from score \n" +
                "group by no \n" +
                "having count(*)>=2)\n";
        DBCPTestSearch(sql);        //DBCP连接池  测试Search方法
        C3P0TestSearch(sql);        //C3P0连接池  测试Search方法
        DBCPTestUpdate();           //DBCP连接池  测试Update方法
        try {
            Thread.sleep(5000);     //睡眠5s  ,有时间在SQL Server management stdio 中截图
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        C3P0TestUpdate();           //C3P0连接池  测试Update方法
    }


    public static boolean C3P0TestUpdate() {
        boolean t = false;
        try {
            System.out.println("******C3P0******\n测试Update方法\n删除'李军'同学的学生信息前数据库数据如下所示");
            conn = C3P0JdbcUtil.getConnection();    //从C3P0连接池中得到数据库连接
            stmt = conn.createStatement();          //创建Statement
            String sql = "delete from student where name='李军'"; //sql语句
            printAll();
            t = Update(sql);                        //执行SQL语句
            System.out.println("测试Update方法\n删除'李军'同学的学生信息后数据库数据如下所示");
            printAll();
            System.out.println("\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0JdbcUtil.release(conn, stmt, rs);    //释放数据库连接相关
        }
        return t;
    }

    public static boolean DBCPTestUpdate() {
        boolean t = false;
        try {
            System.out.println("******DBCP******\n测试Update方法\n删除'王芳'同学的学生信息前数据库数据如下所示");
            conn = DbcpJdbcUtil.getConnection();    //从DBCP连接池中得到数据库连接
            stmt = conn.createStatement();          //创建Statement
            String sql = "delete from student where name='王芳'"; //sql语句
            printAll();
            t = Update(sql);                        //执行SQL语句
            System.out.println("测试Update方法\n删除'王芳'同学的学生信息后数据库数据如下所示");
            printAll();
            System.out.println("\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbcpJdbcUtil.release(conn, stmt, rs);   //释放数据库连接相关
        }
        return t;
    }

    public static boolean C3P0TestSearch(String sql) {
        try {
            System.out.println("******C3P0******\n测试Search方法\n查询至少选修两门课程的学生学号和姓名的结果如下");
            conn = C3P0JdbcUtil.getConnection();    //从C3P0连接池中得到数据库连接
            stmt = conn.createStatement();          //创建Statement
            System.out.println("no  name");
            rs = Search(sql);                       //执行SQL语句
            while (rs.next()) {                     //打印结果
                System.out.println(rs.getString("no") + " " + rs.getString("name"));
            }
            System.out.println("\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0JdbcUtil.release(conn, stmt, rs);   //释放数据库连接相关
        }
        return rs != null;
    }

    public static boolean DBCPTestSearch(String sql) {
        try {
            System.out.println("******DBCP******\n测试Search方法\n查询至少选修两门课程的学生学号和姓名的结果如下");
            conn = DbcpJdbcUtil.getConnection();    //从DBCP连接池中得到数据库连接
            stmt = conn.createStatement();          //创建Statement
            System.out.println("no  name");
            rs = Search(sql);                       //执行SQL语句
            while (rs.next()) {                     //打印结果
                System.out.println(rs.getString("no") + " " + rs.getString("name"));
            }
            System.out.println("\n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbcpJdbcUtil.release(conn, stmt, rs);   //释放数据库连接相关
        }
        return rs != null;
    }

    public static ResultSet Search(String sql) {
        try {
            return stmt.executeQuery(sql); //返回查找的枚举对象
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
