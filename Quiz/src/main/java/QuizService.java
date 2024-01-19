import java.util.ArrayList;
import java.util.Date;

public class QuizService {
    ArrayList<Quiz> list;
    QuizService(){
        list= new ArrayList();
    }
    public void addQuestion(String ques, String optO, String optT, String optTh, String optF, int curOpt){
        list.add(new Quiz(new Date().toString(),ques, optO, optT, optTh, optF, curOpt ));
    }
    public ArrayList getAllQuestion(){
        return list;
    }

}
