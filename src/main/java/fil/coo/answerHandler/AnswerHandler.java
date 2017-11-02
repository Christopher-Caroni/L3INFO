package fil.coo.answerHandler;

import fil.coo.answers.Answer;

public abstract class AnswerHandler {

    protected AnswerHandler next;

    public void setNext(AnswerHandler answerHandler){
        this.next = answerHandler;
    }

    public abstract Answer createAnswer(String answerText);
}
