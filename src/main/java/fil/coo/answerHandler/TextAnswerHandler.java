package fil.coo.answerHandler;

import fil.coo.answers.Answer;
import fil.coo.answers.InvalidAnswerException;
import fil.coo.answers.NumericalAnswer;
import fil.coo.answers.TextAnswer;

public class TextAnswerHandler extends AnswerHandler {

    @Override
    public Answer createAnswer(String answerText) {
        TextAnswer answer = null;
        try {
            answer = new TextAnswer(answerText);
        } catch (InvalidAnswerException e) {
            this.next.createAnswer(answerText);
        }
        return answer;
    }
}
