package fil.coo;

import fil.coo.answerHandler.*;
import fil.coo.answers.Answer;

public class AnswerFactory {

    private AnswerHandler c1;
    private AnswerFactory(){
        initAnswerHandler();
    }

    public static final AnswerFactory FACTORYANSWER = new AnswerFactory();

    public static AnswerFactory getInstance(){
        return FACTORYANSWER;
    }

    public Answer buildAnswer(String text){
        return this.c1.createAnswer(text);
    }

    public void initAnswerHandler(){
        this.c1 = new NumericalAnswerHandler();
        AnswerHandler c2 = new YesNoAnswerHandler();
        AnswerHandler c3 = new MultipleChoiceAnswerHandler();
        AnswerHandler c4 = new MultiAnswerHandler();
        AnswerHandler c5 = new TextAnswerHandler();

        c1.setNext(c2);
        c2.setNext(c3);
        c3.setNext(c4);
        c4.setNext(c5);
    }
}
