package fil.coo.gui.factory;

import fil.coo.answers.impl.*;

import javax.swing.*;
import java.awt.*;

public class AnswerPanelFactory {


    private static final AnswerPanelFactory INSTANCE = new AnswerPanelFactory();

    private AnswerPanelFactory() {
    }

    public static AnswerPanelFactory getInstance() {
        return INSTANCE;
    }

    private JPanel createTextJPanel() {
        JPanel panel = new JPanel();

        TextArea textArea = new TextArea();
        textArea.setPreferredSize(new Dimension(200, 40));

        panel.add(textArea);
        return panel;
    }

    public JPanel createAnswerPanel(TextAnswer answer) {
        return createTextJPanel();
    }

    public JPanel createAnswerPanel(YesNoAnswer answer) {
        JPanel panel = new JPanel();

        JRadioButton yesButton = new JRadioButton("yes");
        JRadioButton noButton = new JRadioButton("no");

        panel.add(yesButton);
        panel.add(noButton);

        return panel;
    }

    public JPanel createAnswerPanel(NumericalAnswer answer) {
        JPanel panel = new JPanel();

        JSpinner spinner = new JSpinner();
        spinner.setPreferredSize(new Dimension(100, 40));

        panel.add(spinner);

        return panel;
    }

    public JPanel createAnswerPanel(MultipleChoiceAnswer answer) {
        // TODO
        return createTextJPanel();
    }

    public JPanel createAnswerPanel(MultiAnswer answer) {
        // TODO
        return createTextJPanel();
    }
}
