package fil.coo.handler;

import fil.coo.answers.Answer;
import fil.coo.answers.InvalidAnswerException;
import org.apache.log4j.Logger;

public abstract class AnswerHandler {

    private static final Logger logger = Logger.getLogger(AnswerHandler.class.getSimpleName());

    private AnswerHandler next;

    public final void setNext(AnswerHandler answerHandler) {
        this.next = answerHandler;
    }

    public final Answer createAnswer(String answerText) {
        try {
            return createSpecificAnswer(answerText);
        } catch (InvalidAnswerException e) {
            logger.debug("Failed to create " + this.getClass().getSimpleName() + ", will try " + next.getClass()
                    .getSimpleName());
            return this.next.createAnswer(answerText);
        }
    }

    protected abstract Answer createSpecificAnswer(String answerText) throws InvalidAnswerException;

}
