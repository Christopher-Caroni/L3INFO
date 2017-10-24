package fil.coo.answers;

public class YesNoAnswerTest extends SingleAnswerTest{

	@Override
	protected SingleAnswer getSpecificSingleAnswer(String anwser) {
		return new YesNoAnswer(anwser);
	}
}
