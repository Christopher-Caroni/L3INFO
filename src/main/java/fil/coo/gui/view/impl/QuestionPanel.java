package fil.coo.gui.view.impl;

import fil.coo.gui.view.AbstractQuestionView;
import fil.coo.gui.view.AbstractAnswerView;
import fil.coo.model.QuestionModel;

import javax.swing.*;
import java.awt.*;

public class QuestionPanel extends AbstractQuestionView {

    private JPanel questionPanel;

    private JPanel questionTextPanel;
    private JTextArea questionTextArea;


    public QuestionPanel(QuestionModel questionModel, AbstractAnswerView answerView) {
        super(questionModel, answerView);

        questionPanel = new JPanel();

        initQuestion(questionModel.getQuestionText());
        initAnswerView();

        questionPanel.setLayout(new GridLayout(1, 2));
        questionPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
    }

    private void initQuestion(String questionText) {
        questionTextPanel = new JPanel();

        questionTextArea = new JTextArea(questionText);
        questionTextArea.setLineWrap(true);
        questionTextArea.setPreferredSize(new Dimension(300, 50));
        questionTextArea.setBackground(questionTextPanel.getBackground());
        questionTextArea.setWrapStyleWord(true);
        questionTextArea.setFocusable(false);

        questionTextPanel.setLayout(new FlowLayout());
        questionTextPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        questionTextPanel.add(questionTextArea);
        questionPanel.add(questionTextPanel);
    }

    private void initAnswerView() {
        this.answerView.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        questionPanel.add(this.answerView.getView());
    }

    @Override
    public Component getView() {
        return questionPanel;
    }
}
