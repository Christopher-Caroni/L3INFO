package fil.coo.answerHandler;

import fil.coo.answers.Answer;
import fil.coo.answers.InvalidAnswerException;
import fil.coo.answers.YesNoAnswer;

public class YesNoAnswerHandler extends AnswerHandler {

    @Override
    public Answer createAnswer(String answerText) {
        try {
            return new YesNoAnswer(answerText);
        } catch (InvalidAnswerException e) {
            return this.next.createAnswer(answerText);
        }
    }
}
