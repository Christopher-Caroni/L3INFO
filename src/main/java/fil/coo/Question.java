package fil.coo;

import fil.coo.answers.Answer;

public class Question {

    private int nbPoints;
    private String text;
    private Answer answer;

    public Question(String text, Answer answer, int nbPoints) {
        this.text = text;
        this.answer = answer;
        this.nbPoints = nbPoints;
    }


    public int getNbPts() {
        return nbPoints;
    }

    public String getText() {
        return text;
    }
}
