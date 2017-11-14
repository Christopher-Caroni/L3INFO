package fil.coo.gui.impl;

import fil.coo.gui.AbstractQuestionView;
import fil.coo.gui.AbstractQuizView;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class QuizFrame extends AbstractQuizView {

	private static final Logger logger = Logger.getLogger(QuizFrame.class.getSimpleName());

	private JFrame rootFrame;

	private Dimension frameDim;
	private JPanel questionsPanel;
	private JPanel mainPanel;
	private JButton validateButton;

	public QuizFrame(int nbQuestions) {
		super();

		rootFrame = new JFrame();

		setBasicProperties();
		setupRootPanel(nbQuestions);
		doFinalPrep();
	}

	/**
	 * Sets properties such as title, layout, dimension...
	 */
	private void setBasicProperties() {
		rootFrame.setTitle("Quiz");
		frameDim = new Dimension(800, 800);
		rootFrame.setPreferredSize(frameDim);
		rootFrame.setLayout(new BorderLayout());

		rootFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	/**
	 * Sets up the whole panel hierarchy
	 *
	 * @param nbQuestions
	 *            the number of questions that the questions panel will hold
	 */
	private void setupRootPanel(int nbQuestions) {
		setupScrollPane(nbQuestions);
		setupValidatePanel();
	}

	/**
	 * Packs the frame and sets its location to the middle of the screen. This
	 * should be called once all the adding of components is finished
	 */
	private void doFinalPrep() {
		// pack() must come before setLocationRelativeTo
		rootFrame.pack();
		rootFrame.setLocationRelativeTo(null);
	}

	/**
	 * Sets up the bottom panel that has the validate button
	 */
	private void setupValidatePanel() {
		JPanel validatePanel = new JPanel();
		validateButton = new JButton("Validate");
		validatePanel.add(validateButton);

		rootFrame.add(validatePanel, BorderLayout.SOUTH);
	}

	/**
	 * Sets up the scroll pane with the actual model
	 *
	 * @param nbQuestions
	 *            the number of questions in the model
	 */
	private void setupScrollPane(int nbQuestions) {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		JScrollPane scrollPane = new JScrollPane(mainPanel);
		rootFrame.add(scrollPane, BorderLayout.CENTER);

		setupQuestionsPanel(nbQuestions);
		setupMainPanel();
	}

	/**
	 * Sets up the panel containing the rows of {@link JPanel}s of questions
	 *
	 * @param nbQuestions
	 *            the number of questions in the model
	 */
	private void setupQuestionsPanel(int nbQuestions) {
		questionsPanel = new JPanel();
		questionsPanel.setLayout(new GridLayout(nbQuestions, 1));
	}

	/**
	 * Sets up the mainPanel that contains the questionsPanel with glue on the
	 * sides.
	 */
	private void setupMainPanel() {
		mainPanel.add(Box.createHorizontalGlue(), BorderLayout.LINE_START);
		mainPanel.add(questionsPanel, BorderLayout.CENTER);
		mainPanel.add(Box.createHorizontalGlue(), BorderLayout.LINE_END);
	}

	/**
	 * Adds a {@link QuestionPanel} to this frame
	 *
	 * @param questionView
	 *            the panel to add
	 * @param refresh
	 *            if this frame should repaint right away
	 */
	public void addQuestionPanel(AbstractQuestionView questionView, boolean refresh) {
		logger.debug("Added question panel");
		questionsPanel.add(questionView.getView());

		if (refresh) {
			rootFrame.pack();
			rootFrame.repaint();
		}
	}

	@Override
	public void setVisible(boolean visible) {
		rootFrame.setVisible(visible);
	}

	@Override
	public void showInvalidInputs(List<Integer> invalidInputIndexes) {
		String msg = "";
		for (Integer integer : invalidInputIndexes) {
			msg += "[question " + questionViews.get(integer) + " fail]";
		}
		JOptionPane.showMessageDialog(this.getView(), msg);
	}

	@Override
	public void onSubmissionFinished(int pointsWon) {
		JOptionPane.showMessageDialog(this.getView(), "You won " + pointsWon + " points !");
	}

	@Override
	public Component getView() {
		return rootFrame;
	}
}
