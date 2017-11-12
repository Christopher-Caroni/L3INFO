package fil.coo.gui.views;

/**
 * Defines the behaviour that our question views must implement
 */
public abstract class AbstractQuestionView implements IView {

    protected AbstractAnswerView answerView;

    /**
     * @param questionText the model from which to create this question
     * @param answerView   the specific {@link AbstractAnswerView} that this views should hold
     */
    public AbstractQuestionView(String questionText, AbstractAnswerView answerView) {
        this.answerView = answerView;
    }

    /**
     * @return the user's input for this question's answer
     */
    public final String getUserInput() {
        return answerView.getUserInput();
    }

}
