package fil.coo.gui;

import javax.swing.*;
import java.awt.*;

public class QuizFrame extends JFrame {

    private Dimension frameDim;

    public QuizFrame() {

        setBasicProperties();


//        pack() must come before setLocationRelativeTo
        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }

    protected void setBasicProperties() {
        setTitle("Quiz");
        frameDim = new Dimension(600, 600);
        setPreferredSize(frameDim);
    }

    public void addQuestionPanel(QuestionPanel questionPanel) {
        add(questionPanel);
        repaint();
    }
}
