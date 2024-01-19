import javax.print.event.PrintEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/calc")
public class MyCalc extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
//        for create input fields
        out.print("<form method='get'>");
        out.print("<input type='text' palceholder='enter first number' name='fno'>");
        out.print("<input type='text' palceholder='enter second number' name='sno'>");
        out.print("<input type='submit'  name='operation' value='+'>");
        out.print("<input type='submit'  name='operation' value='-'>");
        out.print("<input type='submit'  name='operation' value='/'>");
        out.print("<input type='submit'  name='operation' value='*'>");
        out.print("<input type='submit'  name='operation' value='%'>");
        out.print("</form>");

//        to fetch parameters
        String operation = req.getParameter("operation");
        if(operation!=null){
            int fno = Integer.parseInt(req.getParameter("fno"));
            int sno = Integer.parseInt(req.getParameter("sno"));
            int res = 0;

            switch (operation){
                case "+": res = fno +sno;break;
                case "-": res = fno -sno;break;
                case "*": res = fno *sno;break;
                case "/": res = fno /sno;break;
                case "%": res = fno %sno;break;
            }
            out.print("<p>"+fno+operation+sno+"="+res+"</p>");
        }


    }
}
