package fil.coo.answers.impl;

import fil.coo.answers.Answer;
import fil.coo.answers.InvalidAnswerException;

public abstract class SingleAnswer extends Answer {

    protected String answer;


    public SingleAnswer(String answer, boolean save) throws NullPointerException, InvalidAnswerException {
        super(answer);
        if (save) {
            initAnswer(answer);
        }
    }

    /**
     * @param answer the answer read from the quiz file, that this instance will represent
     * @throws NullPointerException   if answer is null
     * @throws InvalidAnswerException if the answer does not correspond to this type of {@link SingleAnswer}. See {@link #isValid(String)}
     */
    protected void initAnswer(String answer) throws NullPointerException, InvalidAnswerException {
        if (answer == null) {
            throw new NullPointerException();
        }
        if (this.isValid(answer)) {
            setAnswer(answer);
        } else {
            throw new InvalidAnswerException();
        }
    }

    @Override
    protected boolean checkUserAnswerIsCorrect(String userAnswer) {
        return answer.equals(userAnswer);
    }

    public String getCorrectAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
