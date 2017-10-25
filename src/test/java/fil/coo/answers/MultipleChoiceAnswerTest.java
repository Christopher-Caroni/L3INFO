package fil.coo.answers;

public class MultipleChoiceAnswerTest extends SingleAnswerTest {


    private final static String EXPECTED_PROMPT = "( Robert Bourricot Bill Jolly Jumper )";
    private final static String AllChoice = "Robert Bourricot Bill Jolly Jumper";
    private final static int index = 2;
    private final static String answer = "Bill";


	@Override
	protected String getDefaultAnswer() {
		return AllChoice;
	}
	
	@Override
	protected String getCorrectAnswer() {
		return answer;
	}

	@Override
	protected SingleAnswer getSpecificSingleAnswer(String answer)
			throws NullPointerException, InvalidAnswerException {
		return new MultipleChoiceAnswer(answer, index);
	}

}
