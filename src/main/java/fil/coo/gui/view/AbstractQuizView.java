package fil.coo.gui.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the behaviour that our quiz views must implement
 */
public abstract class AbstractQuizView {

    private List<AbstractQuestionView> questionViews;

    public AbstractQuizView(int nbQuestions) {
    }


    /**
     * @return a list of the user's input
     */
    public List<String> getUserAnswerInput() {
        List<String> userAnswers = new ArrayList<>();
        for (AbstractQuestionView questionView : questionViews) {
            userAnswers.add(questionView.getUserInput());
        }
        return userAnswers;
    }

    /**
     * Adds a {@link AbstractQuestionView} to this instance
     *
     * @param questionView the view to add
     * @param refresh      if this instance should refresh right away
     */
    public abstract void addQuestionPanel(AbstractQuestionView questionView, boolean refresh);

    /**
     * @param visible if this instance should be visible or not
     */
    public abstract void setVisible(boolean visible);
}
