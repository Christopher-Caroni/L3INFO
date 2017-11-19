package fil.coo.model.handler.impl;

import fil.coo.model.handler.AnswerHandler;
import fil.coo.model.impl.Answer;
import fil.coo.exception.InvalidAnswerException;
import fil.coo.model.impl.answers.MultipleChoiceAnswer;

public class MultipleChoiceAnswerHandler extends AnswerHandler {

    @Override
    protected String getCreationClassName() {
        return MultipleChoiceAnswer.class.getSimpleName();
    }

    @Override
    protected Answer createSpecificAnswer(String answerText) throws InvalidAnswerException {
        return new MultipleChoiceAnswer(answerText);
    }
}

