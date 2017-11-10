package fil.coo.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import fil.coo.answers.Answer;

public class Quiz {

	private List<Question> questions;
	private int totalPoints;
	final static Logger logger = Logger.getLogger(Quiz.class.getSimpleName());

	public Quiz() {
		questions = new ArrayList<>();
		totalPoints = 0;
	}
	
	/**
	 * Method to get all the point from the quiz
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
	 * Method to ask a question and wait a answer
	 * @param question Question
	 */
	public void ask(Question question) {
		logger.info(question.getQuestionText());
		answerOfUser(question);
	}

	/**
	 * Method to get the answer of the user and see if is correct
	 * @param question Question
	 */
	public void answerOfUser(Question question) {
		Answer answer = question.getAnswer();
		Scanner scanner = new Scanner(System.in);
		String userAnswer = "";
		
		do {
			logger.info(answer.getPrompt());
			userAnswer = scanner.nextLine();
		} while (answer.isValid(userAnswer));

		verifyAnswerOfUser(question, answer, userAnswer);
		scanner.close();
	}

	private void verifyAnswerOfUser(Question question, Answer answer, String userAnswer) {
		if (answer.isCorrect(userAnswer)) {
			logger.info("correct (" + question.getNbPts() + " pts)");
			totalPoints += question.getNbPts();
		} else {
			logger.info("wrong, the right answer was : "+answer.getCorrectAnswer());
		}
	}

	/**
	 * Method to ask all the question present in the list
	 */
	public void askAll() {
		for (Question question : questions) {
			this.ask(question);
		}
		logger.info("You get "+getTotalPoints()+" points");
	}

    public int getNbQuestions() {
        return questions.size();
    }

    public Question getQuestion(int i) {
        return questions.get(i);
    }

    public List<Question> getQuestions() {
		return questions;
    }
}
