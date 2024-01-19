import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/redirect-test")
public class RedirectTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        to send redirect page code
        resp.setContentType("text/html");
        resp.getWriter().print("Hi from redirect test");
//        resp.sendRedirect("login.html");
        RequestDispatcher rd = req.getRequestDispatcher("login.html");
        rd.include(req,resp);
    }
}
