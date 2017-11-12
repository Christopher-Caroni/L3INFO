package fil.coo.model.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fil.coo.model.AnswerModel;
import fil.coo.model.QuestionModel;
import fil.coo.model.QuizModel;
import org.apache.log4j.Logger;

public class Quiz extends QuizModel {

	private List<QuestionModel> questions;
	private int totalPoints;
	final static Logger logger = Logger.getLogger(Quiz.class.getSimpleName());

	public Quiz() {
		questions = new ArrayList<>();
		totalPoints = 0;
	}
	
	/**
	 * Method to get all the point from the model
	 * @return int the total points
	 */
	public int getTotalPoints(){
		return totalPoints;
	}

	/**
	 * Method to add a question into the List of questions
	 * 
	 * @param question
	 *            Question
	 */
	public void addQuestion(Question question) {
		this.questions.add(question);
	}

	/**
	 * Method to askSingleQuestion a question and wait a answer
	 * @param question Question
	 */
	public void askSingleQuestion(QuestionModel question) {
		logger.info(question.getQuestionText());
		answerOfUser(question);
	}

	/**
	 * Method to get the answer of the user and see if is correct
	 * @param question Question
	 */
	public void answerOfUser(QuestionModel question) {
		AnswerModel answer = question.getAnswer();
		Scanner scanner = new Scanner(System.in);
		String userAnswer = "";
		
		do {
			logger.info(answer.getPrompt());
			userAnswer = scanner.nextLine();
		} while (answer.isValid(userAnswer));

		verifyAnswerOfUser(question, answer, userAnswer);
		scanner.close();
	}

	private void verifyAnswerOfUser(QuestionModel question, AnswerModel answer, String userAnswer) {
		if (answer.isCorrect(userAnswer)) {
			logger.info("correct (" + question.getNbPts() + " pts)");
			totalPoints += question.getNbPts();
		} else {
			logger.info("wrong, the right answer was : "+answer.getCorrectAnswer());
		}
	}

	/**
	 * Method to askSingleQuestion all the question present in the list
	 */
	public void askAll() {
		for (QuestionModel question : questions) {
			this.askSingleQuestion(question);
		}
		logger.info("You get "+getTotalPoints()+" points");
	}

    public int getNbQuestions() {
        return questions.size();
    }

    public QuestionModel getQuestion(int i) {
        return questions.get(i);
    }

    @Override
    public boolean validateAnswerType(int questionIndex, String userAnswer) {
	    // TODO
        return false;
    }

    @Override
    public boolean checkCorrectAnswer(int questionIndex, String userAnswer) {
	    // TODO
        return false;
    }

    public List<QuestionModel> getQuestions() {
		return questions;
    }
}
