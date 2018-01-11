package fil.coo.model;


import org.apache.log4j.Logger;

/**
 * Specifies what a bare question is made of: a question, an answer a a number of points
 */
public abstract class QuestionModel {

    private static final Logger logger = org.apache.log4j.Logger.getLogger(QuestionModel.class.getSimpleName());

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
     * @param userAnswer the user's answer
     * @return if the user's answer is correct
     */
    protected boolean verifyCorrectAnswer(String userAnswer) {
        boolean correct = answer.isCorrect(userAnswer);
        if (correct) {
            logger.info("correct (" + getNbPts() + " pts)");
        } else {
            logger.info("wrong, the right answer was : " + answer.getCorrectAnswer());
        }
        return correct;
    }
}
