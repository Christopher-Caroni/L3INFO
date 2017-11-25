package fil.coo.model.impl;

import fil.coo.model.AnswerModel;
import fil.coo.model.QuestionModel;
import org.apache.log4j.Logger;

/**
 * A concrete implementation of {@link QuestionModel}. Does not add any features
 */
public class SimpleQuestion extends QuestionModel {

    private static final Logger logger = Logger.getLogger(SimpleQuestion.class.getSimpleName());

    public SimpleQuestion(String text, AnswerModel answer, int nbPoints) {
        super(text, answer, nbPoints);
    }

}
