import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = "/myservlet")
public class MyServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
//        super.init();
        System.out.println("From init method");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
        System.out.println("from service method");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("Hi From server!!!!");

    }

    @Override
    public void destroy() {
//        super.destroy();
        System.out.println("From destroy method");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("Hi From server!!!!");
    }
}
