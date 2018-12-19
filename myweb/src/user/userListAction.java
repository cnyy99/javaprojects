package user;

import domain.User;
import utilurl.dataUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "userListAction")
public class userListAction extends HttpServlet {
    private static final long serialVersionUID = 1L;
    String url =dataUrl.url;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            System.out.println("userListAction.doGet()");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String query="select * from t_user";
            ResultSet rs=stmt.executeQuery(query);
            List<User> userlist=new ArrayList<User>();
            while(rs.next()){
                User user=new User();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                userlist.add(user);
            }
            request.setAttribute("list", userlist);
            rs.close();
            stmt.close();
            conn.close();
            request.getRequestDispatcher("/user/list.jsp").forward(request,response);
        }		catch (Exception e) {
            e.printStackTrace();
        }
        // TODO Auto-generated method stub

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("userListAction.doPost()");
        String  queryValue=request.getParameter("queryValue");
        request.setAttribute("queryValue", queryValue);
        System.out.println("queryValue="+queryValue);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String query = "select * from t_user where username like '%"+queryValue+"%'";
            ResultSet rs = stmt.executeQuery(query);
            List<User> userList = new ArrayList<User>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                userList.add(user);
            }
            request.setAttribute("list", userList);
            rs.close();
            stmt.close();
            conn.close();
            request.getRequestDispatcher("/user/list.jsp").forward(request, response);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
