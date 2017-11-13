package fil.coo.model;

import java.util.ArrayList;
import java.util.List;

public abstract class QuizModel {

    protected List<QuestionModel> questions;

    public QuizModel() {
        questions = new ArrayList<>();
    }

    /**
     * @param questionIndex the index of the question
     * @param userAnswer    the user's input
     * @return whether the userAnswer is valid for the answer at questionIndex
     */
    public abstract boolean validateAnswerType(int questionIndex, String userAnswer);

    /**
     * @param questionIndex the index of the question
     * @param userAnswer    the user's input
     * @return whether the userAnswer is the correct answer for the question at questionIndex
     */
    public abstract boolean checkCorrectAnswer(int questionIndex, String userAnswer);

    /**
     * @return all the questions of the quiz
     */
    public final List<QuestionModel> getQuestions() {
        return questions;
    }

    /**
     * @return the number of questions of the quiz
     */
    public final int getNbQuestions() {
        return questions.size();
    }
}
