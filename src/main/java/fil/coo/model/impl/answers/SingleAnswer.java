package fil.coo.model.impl.answers;

import fil.coo.exception.InvalidAnswerException;
import fil.coo.model.impl.Answer;

/**
 * This type of answer has one single correct answer. This correct answer is given as the input in the constructor
 */
public abstract class SingleAnswer extends Answer {

    protected String correctAnswer;


    /**
     * Calls super constructor and then saves input to {@link #correctAnswer}
     *
     * @param input the correct answer
     * @throws InvalidAnswerException if the input does not correspond to this type of answer
     */
    public SingleAnswer(String input) throws InvalidAnswerException {
        super(input);
        saveCorrectAnswer(input);
    }

    /**
     * @param answer the answer read from the model file, that this instance will represent
     * @throws NullPointerException   if answer is null
     * @throws InvalidAnswerException if the answer does not correspond to this type of {@link SingleAnswer}. See {@link #isValid(String)}
     */
    protected void saveCorrectAnswer(String answer) throws NullPointerException, InvalidAnswerException {
        verifyUserInputNotNull(answer);
        if (this.isValid(answer)) {
            setCorrectAnswer(answer);
        } else {
            throw new InvalidAnswerException();
        }
    }

    @Override
    protected boolean checkUserAnswerIsCorrect(String userAnswer) {
        return correctAnswer.equals(userAnswer);
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
