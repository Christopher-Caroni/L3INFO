package fil.coo.answers;

public abstract class SingleAnswer extends Answer {

    protected String answer;

    /**
     * Default constructor to use for subclasses that need to treat the answer in {@link #SingleAnswer(String)} before calling {@link #initAnswer(String)}
     */
    protected SingleAnswer() {
        super();
    }

    public SingleAnswer(String answer) throws NullPointerException, InvalidAnswerException {
        this();
        initAnswer(answer);
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
