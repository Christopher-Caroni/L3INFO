package fil.coo.gui.view;

import fil.coo.gui.view.impl.QuestionPanel;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractQuizView {

    private List<AbstractQuestionView> questionViews;

    public abstract void addQuestion(AbstractQuestionView questionView);

    public AbstractQuizView(int nbQuestions) {
    }

    public List<String> getUserAnswers() {
        List<String> userAnswers = new ArrayList<>();
        for (AbstractQuestionView questionView : questionViews) {
            userAnswers.add(questionView.getUserInput());
        }
        return userAnswers;
    }

    public abstract void addQuestionPanel(QuestionPanel questionPanel, boolean refresh);

    public abstract void setVisible(boolean visible);
}
