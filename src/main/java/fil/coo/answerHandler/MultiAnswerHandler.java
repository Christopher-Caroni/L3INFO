package fil.coo.answerHandler;

import fil.coo.answers.Answer;
import fil.coo.answers.InvalidAnswerException;
import fil.coo.answers.MultiAnswer;

public class MultiAnswerHandler extends AnswerHandler {

    @Override
    public Answer createAnswer(String answerText) {
        try {
            return new MultiAnswer(answerText);
        } catch (InvalidAnswerException e) {
            return this.next.createAnswer(answerText);
        }
    }
}