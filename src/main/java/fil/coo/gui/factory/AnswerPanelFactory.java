package fil.coo.gui.factory;

import fil.coo.gui.AbstractAnswerView;
import fil.coo.gui.impl.AnswerPanel;
import fil.coo.gui.impl.answers.MultiChoiceAnswerPanel;
import fil.coo.gui.impl.answers.NumericalAnswerPanel;
import fil.coo.gui.impl.answers.TextAnswerPanel;
import fil.coo.gui.impl.answers.YesNoAnswerPanel;
import fil.coo.model.AnswerModel;
import fil.coo.model.impl.answers.MultiAnswer;
import fil.coo.model.impl.answers.MultipleChoiceAnswer;
import fil.coo.model.impl.answers.NumericalAnswer;
import fil.coo.model.impl.answers.TextAnswer;
import fil.coo.model.impl.answers.YesNoAnswer;

import java.util.Collections;
import java.util.List;

public class AnswerPanelFactory {


    private static final AnswerPanelFactory INSTANCE = new AnswerPanelFactory();

    private AnswerPanelFactory() {
    }

    public static AnswerPanelFactory getInstance() {
        return INSTANCE;
    }

    /**
     * Uses double dispatch to create a specific {@link AnswerPanel} according
     * to the type of answer
     *
     * @param answer the model wrapper for the answer
     * @return the specific {@link AnswerPanel} that corresponds to the type of the answer
     */
    public AbstractAnswerView createAnswerPanel(AnswerModel answer) {
        return answer.createAnswerPanel(this);
    }

    public AbstractAnswerView createAnswerPanel(TextAnswer answer) {
        // TODO give it a controller
        return new TextAnswerPanel(null);
    }

    public AbstractAnswerView createAnswerPanel(MultipleChoiceAnswer answer) {
        // TODO give it a controller

        List<String> possibleAnswers = answer.getPossibleAnswers();
        Collections.shuffle(possibleAnswers);

        return new MultiChoiceAnswerPanel(null, possibleAnswers);
    }
    
    public AbstractAnswerView createAnswerPanel(YesNoAnswer answer) {
        // TODO give it a controller
        return new YesNoAnswerPanel(null);
    }

    public AbstractAnswerView createAnswerPanel(NumericalAnswer answer) {
        // TODO give it a controller
        return new NumericalAnswerPanel(null);
    }

    public AbstractAnswerView createAnswerPanel(MultiAnswer answer) {
        // TODO give it a controller
        return new TextAnswerPanel(null);
    }
}
