package fil.coo.answers;

import java.util.Arrays;
import java.util.List;

public class MultipleChoiceAnswer extends SingleAnswer {
    
	static List<String> multiplechoice;
	
	public MultipleChoiceAnswer(String answer, int goodAnswer) throws NullPointerException, InvalidAnswerException {
		super(collectTheGoodAnswer(answer, goodAnswer));
		
	}

	private static String collectTheGoodAnswer(String answer, int goodAnswer) {
		initializeList(answer);
		return multiplechoice.get(goodAnswer);
	}



	private static void initializeList(String answer) {
		String tab[] = answer.split(" | ");
		multiplechoice = Arrays.asList(tab);
	}

	@Override
	public String getPrompt() {
		String allAnswer = "";
		for (String answer : multiplechoice) {
			allAnswer+= " "+answer+" ";
		}
		return "("+allAnswer+")";
	}



	@Override
	protected boolean checkUserAnswerIsValid(String userAnswer) {
		for (String answer : multiplechoice) {
			if(answer.equals(userAnswer))
				return true;
		}
		return false;
	}
}
