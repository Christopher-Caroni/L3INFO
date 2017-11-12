package fil.coo.model;

import java.util.List;

public abstract class QuizModel {

    public abstract boolean validateAnswerType(int questionIndex, String userAnswer);

    public abstract boolean checkCorrectAnswer(int questionIndex, String userAnswer);

    public abstract List<QuestionModel> getQuestions();

    public abstract int getNbQuestions();
}
