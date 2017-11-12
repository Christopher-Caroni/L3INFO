package fil.coo.model.impl;

import fil.coo.model.AnswerModel;
import fil.coo.util.Prompter;
import fil.coo.model.QuestionModel;
import org.apache.log4j.Logger;

public class Question implements QuestionModel {

    private static final Logger logger = Logger.getLogger(Question.class.getSimpleName());

    private int nbPoints;
    private String questionText;
    private AnswerModel answer;

    /**
     * Constructor to create a question
     *
     * @param text     the question text
     * @param answer   the answer
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

    @Override
    public int ask() {
        logger.info(getQuestionText());

        String userAnswer = promptUserForAnswer();
        boolean correct = verifyCorrectAnswer(userAnswer);

        return correct ? getNbPts() : 0;
    }

    /**
     * @return the user's answer to this question
     */
    private String promptUserForAnswer() {
        String userAnswer;
        do {
            logger.info(answer.getPrompt());
            userAnswer = Prompter.getInstance().nextLine();
        } while (!answer.isValid(userAnswer));
        return userAnswer;
    }

    /**
     * @param userAnswer the user's answer
     * @return if the user's answer is correct
     */
    private boolean verifyCorrectAnswer(String userAnswer) {
        boolean correct = answer.isCorrect(userAnswer);
        if (correct) {
            logger.info("correct (" + getNbPts() + " pts)");
        } else {
            logger.info("wrong, the right answer was : " + answer.getCorrectAnswer());
        }
        return correct;
    }

    public String getQuestionText() {
        return questionText;
    }

    public AnswerModel getAnswer() {
        return answer;
    }

}
