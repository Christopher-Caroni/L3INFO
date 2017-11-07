package fil.coo;

import fil.coo.answerHandler.*;
import fil.coo.answers.Answer;
import org.apache.log4j.Logger;

public class AnswerFactory {

    public static final AnswerFactory FACTORYANSWER = new AnswerFactory();

    private AnswerHandler c1;
    private static final Logger logger = Logger.getLogger(AnswerFactory.class.getSimpleName());

    private AnswerFactory(){
        initAnswerHandler();
    }


    public static AnswerFactory getInstance(){
        return FACTORYANSWER;
    }

    public Answer buildAnswer(String text){
        logger.debug("creating answer for \"" + text + "\"");

        Answer answer = this.c1.createAnswer(text);

        logger.debug("did create " + answer.getClass().getSimpleName());
        return answer;
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
