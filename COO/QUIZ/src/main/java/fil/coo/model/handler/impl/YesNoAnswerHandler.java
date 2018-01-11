package fil.coo.model.handler.impl;

import fil.coo.model.handler.AnswerHandler;
import fil.coo.model.impl.Answer;
import fil.coo.exception.InvalidAnswerException;
import fil.coo.model.impl.answers.YesNoAnswer;

public class YesNoAnswerHandler extends AnswerHandler {

    @Override
    protected String getCreationClassName() {
        return YesNoAnswer.class.getSimpleName();
    }

    @Override
    protected Answer createSpecificAnswer(String answerText) throws InvalidAnswerException {
        return new YesNoAnswer(answerText);
    }
}
