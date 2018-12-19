package action.login;
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

@WebServlet(name = "loginAction")
public class loginAction extends HttpServlet {
    private static final long serialVersionUID = 1L;
    String url =dataUrl.url;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("loginAction.dopost()");
        String username=(String)request.getParameter("username");
        String password=(String)request.getParameter("password");
        System.out.println("username=" + username + " -- password=" + password);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url);
            System.out.println("success");
            Statement stmt=conn.createStatement();
            String query="select * from t_user where username = '"+username+"' and password='"+password+"' ";
            ResultSet rs=stmt.executeQuery(query);
            if(rs.next()){
                String id=rs.getString("id");
                System.out.println("id==" + id);
                response.sendRedirect("../user/list");
                //response.sendRedirect("../user/list");
            }else{
                request.setAttribute("message", "”√ªß√˚√‹¬Î¥ÌŒÛ");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void doGet1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginAction.doGet()");
    }
}
