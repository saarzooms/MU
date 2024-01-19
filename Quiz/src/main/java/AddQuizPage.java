import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addquiz")
public class AddQuizPage extends HttpServlet {
    QuizService qs;

    @Override
    public void init() throws ServletException {
        qs = new QuizService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("add_quiz.html");
        rd.include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String btn = req.getParameter("add");
if(btn!=null && btn.equals("add")){
    String question = req.getParameter("question");
    String opt1 = req.getParameter("optionFst");
    String opt2 = req.getParameter("optionSec");
    String opt3 = req.getParameter("optionThr");
    String opt4 = req.getParameter("optionFth");
    int curOpt = Integer.parseInt(req.getParameter("correct_answer"));
    qs.addQuestion(question,opt1, opt2,opt3, opt4, curOpt);
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    RequestDispatcher rd = req.getRequestDispatcher("add_quiz.html");
    rd.include(req,resp);
    out.print("<table>");
    out.print("<tr><th>id</th><th>Question</th><th>Option 1</th><th>option 2</th><th>Option 3</th><th>option 4</th><th>Correct option </th></tr>");
    for (Object quiz : qs.getAllQuestion()) {
        Quiz q = (Quiz)quiz;
        out.print("<tr><td>"+q.id+"</td><td>"+q.question+"</td><td>"+q.optionOne+"</td><td>"+q.optionTwo+"</td><td>Option 3</td><td>option 4</td><td>Correct option </td></tr>");
    }
    out.print("<table>");

}

    }
}
