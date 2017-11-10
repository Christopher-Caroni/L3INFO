package fil.coo.handler.impl;

import fil.coo.handler.AnswerHandler;
import fil.coo.answers.Answer;
import fil.coo.answers.InvalidAnswerException;
import fil.coo.answers.MultipleChoiceAnswer;

public class MultipleChoiceAnswerHandler extends AnswerHandler {

    @Override
    protected Answer createSpecificAnswer(String answerText) throws InvalidAnswerException {
        return new MultipleChoiceAnswer(answerText);
    }
}

