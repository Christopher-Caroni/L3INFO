package fil.coo.answerHandler;

import fil.coo.answers.Answer;
import fil.coo.answers.InvalidAnswerException;
import fil.coo.answers.MultipleChoiceAnswer;

public class MultipleChoiceAnswerHandler extends AnswerHandler {

    @Override
    public Answer createAnswer(String answerText) {
        MultipleChoiceAnswer answer = null;
        try {
            answer = new MultipleChoiceAnswer(answerText);
        } catch (InvalidAnswerException e) {
            this.next.createAnswer(answerText);
        }
        return answer;
    }
}

