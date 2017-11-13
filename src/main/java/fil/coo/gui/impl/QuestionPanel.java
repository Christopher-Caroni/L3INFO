package fil.coo.gui.views.impl;

import fil.coo.gui.views.AbstractAnswerView;
import fil.coo.gui.views.AbstractQuestionView;

import javax.swing.*;
import java.awt.*;

public class QuestionPanel extends AbstractQuestionView {

    private JPanel rootPanel;

    private JPanel questionTextPanel;


    public QuestionPanel(String questionText, AbstractAnswerView answerView) {
        super(questionText, answerView);

        initRootPanel();
        initQuestionView(questionText);
        initAnswerView();
    }

    /**
     * Initialises the root views: here {@link #rootPanel}
     */
    private void initRootPanel() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayout(1, 2));
        rootPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
    }

    /**
     * Initialises the panel holding the question and then adds it to {@link #rootPanel}
     *
     * @param questionText the text of the question
     */
    private void initQuestionView(String questionText) {
        initQuestionPanel();
        initQuestionText(questionText);

        rootPanel.add(questionTextPanel);
    }

    /**
     * Initialises the panel that holds the real question as in {@link #initQuestionText(String)}
     */
    private void initQuestionPanel() {
        questionTextPanel = new JPanel();
        questionTextPanel.setLayout(new FlowLayout());
        questionTextPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    /**
     * Initialises what <b>directly</b> represents the question: {@link JTextArea}
     * and adds it to {@link #questionTextPanel}
     *
     * @param questionText the text of the question
     */
    private void initQuestionText(String questionText) {
        JTextArea questionTextArea = new JTextArea(questionText);
        questionTextArea.setLineWrap(true);
        questionTextArea.setPreferredSize(new Dimension(300, 50));
        questionTextArea.setBackground(questionTextPanel.getBackground());
        questionTextArea.setWrapStyleWord(true);
        questionTextArea.setFocusable(false);

        questionTextPanel.add(questionTextArea);
    }

    /**
     * Sets up additional treatment of the {@link #answerView} and then adds it to {@link #rootPanel}
     */
    private void initAnswerView() {
        this.answerView.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rootPanel.add(this.answerView.getView());
    }

    @Override
    public Component getView() {
        return rootPanel;
    }
}
