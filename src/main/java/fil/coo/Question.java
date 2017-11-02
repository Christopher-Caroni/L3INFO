package fil.coo;

import fil.coo.answers.Answer;

public class Question {

    private int nbPoints;
    private String questionText;
    private Answer answer;

    public Question(String text, Answer answer, int nbPoints) {
        this.questionText = text;
        this.answer = answer;
        this.nbPoints = nbPoints;
    }


    public int getNbPts() {
        return nbPoints;
    }

    public String getQuestionText() {
        return questionText;
    }
}
