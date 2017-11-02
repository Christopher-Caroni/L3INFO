package fil.coo.answerHandler;

import fil.coo.answers.Answer;
import fil.coo.answers.InvalidAnswerException;
import fil.coo.answers.YesNoAnswer;

public class YesNoAnswerHandler extends AnswerHandler {

    @Override
    public Answer createAnswer(String answerText) {
        YesNoAnswer answer = null;
        try {
            answer = new YesNoAnswer(answerText);
        } catch (InvalidAnswerException e) {
            this.next.createAnswer(answerText);
        }
        return answer;
    }
}
