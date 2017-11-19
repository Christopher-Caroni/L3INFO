package fil.coo.model.handler.impl;

import fil.coo.model.handler.AnswerHandler;
import fil.coo.model.impl.Answer;
import fil.coo.exception.InvalidAnswerException;
import fil.coo.model.impl.answers.TextAnswer;

public class TextAnswerHandler extends AnswerHandler {

    @Override
    protected String getCreationClassName() {
        return TextAnswer.class.getSimpleName();
    }

    @Override
    protected Answer createSpecificAnswer(String answerText) throws InvalidAnswerException {
        return new TextAnswer(answerText, true);
    }
}
