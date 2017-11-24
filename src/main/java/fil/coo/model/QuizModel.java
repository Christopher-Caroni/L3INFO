package fil.coo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class QuizModel<Q extends QuestionModel> {

    protected List<Q> questions;

    public QuizModel() {
        questions = new ArrayList<>();
    }

    /**
     * @param questionIndex the index of the question
     * @param userAnswer    the user's input
     * @return whether the userAnswer is valid for the answer at questionIndex
     */
    public boolean validateAnswerType(int questionIndex, String userAnswer) {
        return getAnswer(questionIndex).isValid(userAnswer);
    }

    /**
     * @param questionIndex the index of the question
     * @param userAnswer    the user's input
     * @return whether the userAnswer is the correct answer for the question at questionIndex
     */
    public boolean checkCorrectAnswer(int questionIndex, String userAnswer) {
        return getAnswer(questionIndex).isCorrect(userAnswer);
    }


    protected AnswerModel getAnswer(int questionIndex) {
        return questions.get(questionIndex).getAnswer();
    }

    /**
     * @return all the questions of the quiz
     */
    public final List<Q> getQuestions() {
        return questions;
    }

    /**
     * @return the number of questions of the quiz
     */
    public final int getNbQuestions() {
        return questions.size();
    }

    /**
     *
     * @return a list of the points of the questions of the same indices in {@link #questions}
     */
    public List<Integer> getPoints() {
        return questions.stream()
                .map(QuestionModel::getNbPts)
                .collect(Collectors.toList());
    }


    public QuestionModel getQuestion(int i) {
        return questions.get(i);
    }


    /**
     * Adds a question to this quiz
     *
     * @param question the question to add
     */
    public void addQuestion(Q question) {
        this.questions.add(question);
    }
}
