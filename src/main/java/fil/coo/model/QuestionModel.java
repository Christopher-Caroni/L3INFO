package fil.coo.model;

public abstract class QuestionModel {

    protected AnswerModel answer;
    protected int nbPoints;
    protected String questionText;


    /**
     * @param text     the question text
     * @param answer   the answer
     * @param nbPoints the number of points
     */
    public QuestionModel(String text, AnswerModel answer, int nbPoints) {
        this.questionText = text;
        this.answer = answer;
        this.nbPoints = nbPoints;
    }

    /**
     * @return this instance's {@link AnswerModel}
     */
    public final AnswerModel getAnswer() {
        return answer;
    }

    /**
     * @return the question in {@link String} format
     */
    public final String getQuestionText() {
        return questionText;
    }

    /**
     * @return the number of points this question represents if answered correctly
     */
    public final int getNbPts() {
        return nbPoints;
    }

    /**
     * Asks this question
     */
    public abstract int ask();
}
