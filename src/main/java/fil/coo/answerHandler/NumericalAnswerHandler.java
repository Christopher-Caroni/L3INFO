package fil.coo.answerHandler;

import fil.coo.answers.Answer;
import fil.coo.answers.InvalidAnswerException;
import fil.coo.answers.NumericalAnswer;

public class NumericalAnswerHandler extends AnswerHandler {

    @Override
    public Answer createAnswer(String answerText) {
        NumericalAnswer answer = null;
        try {
            answer = new NumericalAnswer(answerText);
        } catch (InvalidAnswerException e) {
            this.next.createAnswer(answerText);
        }
        return answer;
    }
}
