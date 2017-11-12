package fil.coo.model;

import java.util.List;

public interface QuizModel {

    /**
     * @param questionIndex the index of the question
     * @param userAnswer    the user's input
     * @return whether the userAnswer is valid for the answer at questionIndex
     */
    boolean validateAnswerType(int questionIndex, String userAnswer);

    /**
     * @param questionIndex the index of the question
     * @param userAnswer    the user's input
     * @return whether the userAnswer is the correct answer for the question at questionIndex
     */
    boolean checkCorrectAnswer(int questionIndex, String userAnswer);

    /**
     * @return all the questions of the quiz
     */
    List<QuestionModel> getQuestions();

    /**
     * @return the number of questions of the quiz
     */
    int getNbQuestions();
}
