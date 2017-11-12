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

    private JPanel answerPanel;


    public QuestionPanel(QuestionModel questionModel, AbstractAnswerView answerView) {
        super(questionModel, answerView);

        questionPanel = new JPanel();
        answerPanel = new JPanel();

        initQuestion(questionModel.getQuestionText());
        initAnswer(answerPanel);

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

    private void initAnswer(JPanel answerPanel) {
        this.answerPanel = answerPanel;
        this.answerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        questionPanel.add(this.answerPanel);
    }

    @Override
    public Component getView() {
        return questionPanel;
    }
}
