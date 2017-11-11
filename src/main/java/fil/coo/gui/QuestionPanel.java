package fil.coo.gui;

import javax.swing.*;
import java.awt.*;

public class QuestionPanel extends JPanel {


    private JLabel questionLabel;
    private AnswerPanel answerPanel;

    public QuestionPanel() {
        questionLabel = new JLabel();
        answerPanel = new AnswerPanel();

        add(questionLabel);
        add(answerPanel);

        setLayout(new GridLayout(1, 2));
    }

    public void setAnswerPanel(AnswerPanel answerPanel) {
        if (answerPanel != null) {
            this.remove(answerPanel);
        }
        this.answerPanel = answerPanel;
        add(answerPanel);
    }

    public void setQuestion(String questionText, boolean refresh) {
        questionLabel.setText(questionText);
        if (refresh) {
            repaint();
        }
    }
}
