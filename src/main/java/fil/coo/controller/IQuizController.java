package fil.coo.controller;

import fil.coo.gui.AbstractQuizView;
import fil.coo.model.QuizModel;

import java.util.Iterator;
import java.util.List;

public abstract class IQuizController {

    protected final QuizModel quizModel;
    protected final AbstractQuizView quizView;

    public IQuizController(QuizModel quizModel, AbstractQuizView quizView) {
        this.quizModel = quizModel;
        this.quizView = quizView;
    }

    /**
     * When the submit button is clicked: validates all user input
     */
    protected void onSubmit() {

        List<String> userAnswers = quizView.getUserAnswerInput();
        Iterator<String> userAnswerIterator = userAnswers.iterator();

        boolean validInput = true;
        int i = 0;
        while (userAnswerIterator.hasNext() && validInput) {
            validInput = quizModel.validateAnswerType(i, userAnswerIterator.next());
            i++;
        }
        if (!validInput) {
            // TODO error
            return;
        }
        onQuizCompleted();
    }

    /**
     * Displays the wrong answers and number of points won.
     */
    protected abstract void onQuizCompleted();
}
