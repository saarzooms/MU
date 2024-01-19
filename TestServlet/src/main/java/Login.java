import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        RequestDispatcher rd = req.getRequestDispatcher("menu.html");
        rd.include(req,resp);
        RequestDispatcher rdLogin = req.getRequestDispatcher("login.html");
        rdLogin.include(req,resp);
        out.print("Hi from Login Page");
    }
}

