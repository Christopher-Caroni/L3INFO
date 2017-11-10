package fil.coo.answers.handler.impl;

import fil.coo.answers.handler.AnswerHandler;
import fil.coo.answers.Answer;
import fil.coo.answers.InvalidAnswerException;
import fil.coo.answers.impl.MultipleChoiceAnswer;

public class MultipleChoiceAnswerHandler extends AnswerHandler {

    @Override
    protected Answer createSpecificAnswer(String answerText) throws InvalidAnswerException {
        return new MultipleChoiceAnswer(answerText);
    }
}

