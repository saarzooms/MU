import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//@WebServlet("/validate")
public class ValidateUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        to set contenttype
//        resp.setContentType("text/html");
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        PrintWriter out = resp.getWriter();
        if(uname.equals(upwd)){
            out.print("<b>Welcome,"+uname+"</b>");
        }else{
            out.print("<p style='color:red'>Invalid credentials</p>");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req,resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
