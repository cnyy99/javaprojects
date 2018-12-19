package conn;

import java.sql.Connection;
import java.sql.*;

public class TestConnection {

    private   String driver;
    private  String url;
    private  String dbName;
    private  String password;
    Connection conn;
    Statement  sta;
    PreparedStatement prepare;

    public TestConnection()
    {
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/sudu";
        this.dbName = "root";
        this.password = "yy0302";
    }

    public Connection getConnection()throws Exception
    {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, dbName, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
        //   System.out.println("success");
    }

    public void closeConn()
    {
        try {
            if(this.conn!=null)
            {
                this.conn.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}