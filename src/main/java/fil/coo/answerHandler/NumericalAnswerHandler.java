package fil.coo.answerHandler;

import fil.coo.answers.Answer;
import fil.coo.answers.InvalidAnswerException;
import fil.coo.answers.NumericalAnswer;
import org.apache.log4j.Logger;

public class NumericalAnswerHandler extends AnswerHandler {

    private static final Logger logger = Logger.getLogger(YesNoAnswerHandler.class.getSimpleName());

    @Override
    public Answer createAnswer(String answerText) {
        try {
            return new NumericalAnswer(answerText);
        } catch (InvalidAnswerException e) {
            logger.debug("Failed to create " + this.getClass().getSimpleName() + ", will try " + next.getClass()
                    .getSimpleName());
            return this.next.createAnswer(answerText);
        }
    }
}
