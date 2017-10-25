package fil.coo.answers;

public class YesNoAnswerTest extends SingleAnswerTest{

	protected String getDefaultAnswer() {
		return null;
	}

	@Override
	protected SingleAnswer getSpecificSingleAnswer(String anwser) {
		return new YesNoAnswer(anwser);
	}
}
