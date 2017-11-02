package fil.coo.answerHandler;

import fil.coo.answers.Answer;
import fil.coo.answers.InvalidAnswerException;
import fil.coo.answers.NumericalAnswer;

public class NumericalAnswerHandler extends AnswerHandler {

    @Override
    public Answer createAnswer(String answerText) {
        try {
            return new NumericalAnswer(answerText);
        } catch (InvalidAnswerException e) {
            return this.next.createAnswer(answerText);
        }
    }
}
