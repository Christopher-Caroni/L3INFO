package fil.coo.answerHandler;

import fil.coo.answers.Answer;
import fil.coo.answers.InvalidAnswerException;
import fil.coo.answers.MultiAnswer;

public class MultiAnswerHandler extends AnswerHandler {

    @Override
    public Answer createAnswer(String answerText) {
        MultiAnswer answer = null;
        try {
            answer = new MultiAnswer(answerText);
        } catch (InvalidAnswerException e) {
            this.next.createAnswer(answerText);
        }
        return answer;
    }
}