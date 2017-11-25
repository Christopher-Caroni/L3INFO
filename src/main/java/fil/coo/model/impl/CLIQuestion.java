package fil.coo.model.impl;

import fil.coo.model.AnswerModel;
import fil.coo.model.QuestionModel;
import fil.coo.util.Prompter;
import org.apache.log4j.Logger;

/**
 * Adds the possibility to ask this question and get the user's answer in the CLI via {@link Prompter}
 */
public class CLIQuestion extends QuestionModel {

    private static final Logger logger = org.apache.log4j.Logger.getLogger(CLIQuestion.class.getSimpleName());

    /**
     * @param text     the question text
     * @param answer   the answer
     * @param nbPoints the number of points
     */
    public CLIQuestion(String text, AnswerModel answer, int nbPoints) {
        super(text, answer, nbPoints);
    }

    public CLIQuestion(SimpleQuestion question) {
        super(question.getQuestionText(), question.getAnswer(), question.getNbPts());
    }

    /**
     * Displays the question prompt and gets the user's answer.
     * Will loop on this question while the user input is not a valid type of answer
     * according to {@link AnswerModel#isValid(String)}
     *
     * @return the number of points won according to correctness
     */
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
}
