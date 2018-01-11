package fil.coo.model.handler;

import fil.coo.exception.InvalidAnswerException;
import fil.coo.model.impl.Answer;
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
            logger.debug("Failed to create " + getCreationClassName() + ", will try " + next.getClass()
                    .getSimpleName());
            return this.next.createAnswer(answerText);
        }
    }

    /**
     * @return the name of the class that this handler is trying to create
     */
    protected abstract String getCreationClassName();

    protected abstract Answer createSpecificAnswer(String answerText) throws InvalidAnswerException;

}
