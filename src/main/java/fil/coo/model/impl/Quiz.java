package fil.coo.model.impl;

import org.apache.log4j.Logger;

import fil.coo.model.AnswerModel;
import fil.coo.model.QuestionModel;
import fil.coo.model.QuizModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz extends QuizModel {

    private static final Logger logger = Logger.getLogger(Quiz.class.getSimpleName());

    private int totalPoints;

    public Quiz() {
        totalPoints = 0;
    }

    /**
     * @return the amount of points the user won
     */
    public int getPointsWon() {
        return totalPoints;
    }

    /**
     * Adds a question to this quiz
     *
     * @param question the question to add
     */
    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    /**
     * Asks all the questions in this quiz
     */
    public void askAll() {
        for (QuestionModel question : questions) {
            totalPoints += question.ask();
        }
        logger.info("Quiz finished and you won " + getPointsWon() + " points");
    }

    public QuestionModel getQuestion(int i) {
        return questions.get(i);
    }

    @Override
    public boolean validateAnswerType(int questionIndex, String userAnswer) {
        return getAnswer(questionIndex).isValid(userAnswer);
    }

	
    @Override
    public boolean checkCorrectAnswer(int questionIndex, String userAnswer) {
        return getAnswer(questionIndex).isCorrect(userAnswer);
    }

    @Override
    public List<Integer> getPoints() {
        return questions.stream()
                .map(QuestionModel::getNbPts)
                .collect(Collectors.toList());
    }

    private AnswerModel getAnswer(int questionIndex) {
		return questions.get(questionIndex).getAnswer();
	}
    
}
