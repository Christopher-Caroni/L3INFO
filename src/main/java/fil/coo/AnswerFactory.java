package fil.coo;

import fil.coo.answers.Answer;

public class AnswerFactory {

    private AnswerFactory(){}

    public static final AnswerFactory FACTORYANSWER = new AnswerFactory();

    public static AnswerFactory getInstance(){
        return FACTORYANSWER;
    }

    public Answer buildAnswer(String text){
        return null;
    }
}
