package fil.coo.gui;

import javax.swing.*;

public class QuestionPanel extends JPanel {

    private AnswerPanel answerPanel;

    public QuestionPanel() {

        answerPanel = new AnswerPanel();
        add(answerPanel);
    }

    public void setAnswerPanel(AnswerPanel answerPanel) {
        if (answerPanel != null) {
            this.remove(answerPanel);
        }
        this.answerPanel = answerPanel;
        add(answerPanel);
    }
}
