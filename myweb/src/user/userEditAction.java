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

@WebServlet(name = "userEditAction")
public class userEditAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String url = dataUrl.url;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("userEditAction");
        String id=(String) request.getParameter("id");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url);
            Statement stmt=conn.createStatement();
            String sql="select * from t_user where id='"+id+"'";
            ResultSet rs=stmt.executeQuery(sql);
            User user=new User();
            while(rs.next()){
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            request.setAttribute("user", user);
            rs.close();
            stmt.close();
            conn.close();
            request.getRequestDispatcher("/user/edit。jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }




    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
}
