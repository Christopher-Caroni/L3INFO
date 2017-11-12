package fil.coo.gui.factory;

import fil.coo.model.impl.answers.*;
import fil.coo.gui.views.impl.AnswerPanel;
import fil.coo.gui.views.impl.ChoiceAnswerPanel;
import fil.coo.gui.views.impl.NumericalAnswerPanel;
import fil.coo.gui.views.impl.TextAnswerPanel;

public class AnswerPanelFactory {


    private static final AnswerPanelFactory INSTANCE = new AnswerPanelFactory();

    private AnswerPanelFactory() {
    }

    public static AnswerPanelFactory getInstance() {
        return INSTANCE;
    }

    public AnswerPanel createAnswerPanel(TextAnswer answer) {
        // TODO give it a controller
        return new TextAnswerPanel(null);
    }

    public AnswerPanel createAnswerPanel(YesNoAnswer answer) {
        // TODO give it a controller
        return new ChoiceAnswerPanel(null);
    }

    public AnswerPanel createAnswerPanel(NumericalAnswer answer) {
        // TODO give it a controller
        return new NumericalAnswerPanel(null);
    }

    public AnswerPanel createAnswerPanel(MultipleChoiceAnswer answer) {
        // TODO give it a controller
        return new TextAnswerPanel(null);
    }

    public AnswerPanel createAnswerPanel(MultiAnswer answer) {
        // TODO give it a controller
        return new ChoiceAnswerPanel(null);
    }
}
