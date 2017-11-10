package fil.coo.handler.impl;

import fil.coo.handler.AnswerHandler;
import fil.coo.answers.Answer;
import fil.coo.answers.InvalidAnswerException;
import fil.coo.answers.impl.NumericalAnswer;

public class NumericalAnswerHandler extends AnswerHandler {

    @Override
    protected Answer createSpecificAnswer(String answerText) throws InvalidAnswerException {
        return new NumericalAnswer(answerText);
    }
}
