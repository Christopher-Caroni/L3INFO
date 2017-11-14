package fil.coo.gui;

import fil.coo.controller.IQuizController;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the behaviour that our quiz views must implement
 */
public abstract class AbstractQuizView implements IView {

    private List<AbstractQuestionView> questionViews;
    protected IQuizController quizController;

    public AbstractQuizView(IQuizController quizController) {
        this.quizController = quizController;
        questionViews = new ArrayList<>();
    }


    /**
     * @return a list of the user's input for each of the {@link AbstractQuestionView} in {@link #questionViews}
     */
    public List<String> getUserAnswerInput() {
        List<String> userAnswers = new ArrayList<>();
        for (AbstractQuestionView questionView : questionViews) {
            userAnswers.add(questionView.getUserInput());
        }
        return userAnswers;
    }

    /**
     * Adds a {@link AbstractQuestionView} to this instance and saves it in {@link #questionViews}
     *
     * @param questionView the views to add
     * @param refresh      if this instance should refresh right away
     */
    public abstract void addQuestionPanel(AbstractQuestionView questionView, boolean refresh);

    /**
     * @param visible if this instance should be visible or not
     */
    public abstract void setVisible(boolean visible);

    /**
     * Shows the user the answers that have invalid inputs
     *
     * @param invalidInputIndexes the indexes of the answers with invalid inputs
     */
    public abstract void showInvalidInputs(List<Integer> invalidInputIndexes);

    /**
     * Displays the number of points won
     * TODO maybe refuse additional input, display incorrect answers...
     *
     * @param pointsWon the number of points the user won with his inputs
     */
    public abstract void onSubmissionFinished(int pointsWon);
}
