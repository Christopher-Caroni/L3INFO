package fil.coo.gui.factory;

import fil.coo.answers.impl.*;
import fil.coo.gui.panels.AnswerPanel;

import javax.swing.*;
import java.awt.*;

public class AnswerPanelFactory {


    private static final AnswerPanelFactory INSTANCE = new AnswerPanelFactory();

    private AnswerPanelFactory() {
    }

    public static AnswerPanelFactory getInstance() {
        return INSTANCE;
    }

    private AnswerPanel createTextJPanel() {
        AnswerPanel panel = new AnswerPanel();

        TextArea textArea = new TextArea();
        textArea.setPreferredSize(new Dimension(200, 40));

        panel.add(textArea);
        return panel;
    }

    public JPanel createAnswerPanel(TextAnswer answer) {
        return createTextJPanel();
    }

    public AnswerPanel createAnswerPanel(YesNoAnswer answer) {
        AnswerPanel panel = new AnswerPanel();

        JRadioButton yesButton = new JRadioButton("yes");
        JRadioButton noButton = new JRadioButton("no");

        panel.add(yesButton);
        panel.add(noButton);

        return panel;
    }

    public JPanel createAnswerPanel(NumericalAnswer answer) {
        AnswerPanel panel = new AnswerPanel();

        JSpinner spinner = new JSpinner();
        spinner.setPreferredSize(new Dimension(100, 40));

        panel.add(spinner);

        return panel;
    }

    public AnswerPanel createAnswerPanel(MultipleChoiceAnswer answer) {
        // TODO
        return createTextJPanel();
    }

    public AnswerPanel createAnswerPanel(MultiAnswer answer) {
        // TODO
        return createTextJPanel();
    }
}
