package fil.coo.gui;

import javax.swing.*;
import java.awt.*;

public class QuestionPanel extends JPanel {


    private JPanel questionTextPanel;
    private JTextArea questionTextArea;

    private AnswerPanel answerPanel;

    public QuestionPanel(String questionText, AnswerPanel answerPanel) {
        initQuestion(questionText);
        initAnswer(answerPanel);

        setLayout(new GridLayout(1, 2));
        setBorder(BorderFactory.createLineBorder(Color.RED));
    }

    private void initQuestion(String questionText) {
        questionTextPanel = new JPanel();

        questionTextArea = new JTextArea(questionText);
        questionTextArea.setLineWrap(true);
        questionTextArea.setPreferredSize(new Dimension(300, 30));
        questionTextArea.setBackground(questionTextPanel.getBackground());
        questionTextArea.setWrapStyleWord(true);

        questionTextPanel.setLayout(new FlowLayout());
        questionTextPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        questionTextPanel.add(questionTextArea);
        add(questionTextPanel);
    }

    private void initAnswer(AnswerPanel answerPanel) {
        this.answerPanel = answerPanel;
        this.answerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(this.answerPanel);
    }
}
