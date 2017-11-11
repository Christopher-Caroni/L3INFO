package fil.coo.gui.factory;

import fil.coo.answers.impl.*;
import fil.coo.gui.AnswerPanel;

import javax.swing.*;
import java.awt.*;

public class AnswerPanelFactory {


    private static final AnswerPanelFactory INSTANCE = new AnswerPanelFactory();

    private AnswerPanelFactory() {
    }

    public static AnswerPanelFactory getInstance() {
        return INSTANCE;
    }

    private AnswerPanel createTextAnswerPanel() {
        AnswerPanel answerPanel = new AnswerPanel();

        TextArea textArea = new TextArea();
        textArea.setPreferredSize(new Dimension(200, 40));

        answerPanel.add(textArea);
        return answerPanel;
    }

    public AnswerPanel createAnswerPanel(TextAnswer answer) {
        return createTextAnswerPanel();
    }

    public AnswerPanel createAnswerPanel(YesNoAnswer answer) {
        AnswerPanel answerPanel = new AnswerPanel();

        JRadioButton yesButton = new JRadioButton("yes");
        JRadioButton noButton = new JRadioButton("no");

        answerPanel.add(yesButton);
        answerPanel.add(noButton);

        return answerPanel;
    }

    public AnswerPanel createAnswerPanel(NumericalAnswer answer) {
        AnswerPanel answerPanel = new AnswerPanel();

        JSpinner spinner = new JSpinner();
        spinner.setPreferredSize(new Dimension(100, 40));

        answerPanel.add(spinner);

        return answerPanel;
    }

    public AnswerPanel createAnswerPanel(MultipleChoiceAnswer answer) {
        // TODO
        return createTextAnswerPanel();
    }

    public AnswerPanel createAnswerPanel(MultiAnswer answer) {
        // TODO
        return createTextAnswerPanel();
    }
}
