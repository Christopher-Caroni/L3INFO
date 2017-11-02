package fil.coo.answerHandler;

import fil.coo.answers.Answer;
import fil.coo.answers.InvalidAnswerException;
import fil.coo.answers.TextAnswer;

public class TextAnswerHandler extends AnswerHandler {

    @Override
    public Answer createAnswer(String answerText) {
        try {
            return new TextAnswer(answerText);
        } catch (InvalidAnswerException e) {
            return this.next.createAnswer(answerText);
        }
    }
}
