package fil.coo.model.impl;

import fil.coo.answers.Answer;
import fil.coo.model.AnswerModel;
import fil.coo.model.QuestionModel;

public class Question extends QuestionModel {

    private int nbPoints;
    private String questionText;
    private AnswerModel answer;

    /**
     * Constructor to create a question
     * @param text the question text
     * @param answer the answer
     * @param nbPoints the number of points
     */
    public Question(String text, AnswerModel answer, int nbPoints) {
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

	public AnswerModel getAnswer() {
		return answer;
	} 

}
