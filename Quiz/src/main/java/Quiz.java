public class Quiz {
    String id;
    String question;
    String optionOne;
    String optionTwo;
    String optionThree;
    String optionFour;
    int correctOption;

    public Quiz(String id, String question, String optionOne, String optionTwo, String optionThree, String optionFour, int correctOption) {
        this.id = id;
        this.question = question;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.correctOption = correctOption;
    }

}
