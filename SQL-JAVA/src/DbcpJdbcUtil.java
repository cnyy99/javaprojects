import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbcpJdbcUtil {
    private static DataSource ds = null;

    static {
        try {
            InputStream in = JdbcPool.class.getClassLoader().getResourceAsStream("dbcp.properties");    //读取配置文件
            Properties prop = new Properties();
            prop.load(in);
            ds = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();      //返回数据库连接
    }

    public static void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {           //释放数据库相关
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
