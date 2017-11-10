package fil.coo.handler.impl;

import fil.coo.handler.AnswerHandler;
import fil.coo.answers.Answer;
import fil.coo.answers.InvalidAnswerException;
import fil.coo.answers.impl.TextAnswer;

public class TextAnswerHandler extends AnswerHandler {

    @Override
    protected Answer createSpecificAnswer(String answerText) throws InvalidAnswerException {
        return new TextAnswer(answerText, true);
    }
}
