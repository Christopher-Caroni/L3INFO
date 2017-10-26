package fil.coo.answers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultipleChoiceAnswer extends TextAnswer {
    
	static List<String> multiplechoice;
	
	public MultipleChoiceAnswer(String answer) throws NullPointerException, InvalidAnswerException {
		super(collectTheGoodAnswer(answer));
		
	}

	private static String collectTheGoodAnswer(String answer) {
		initializeList(answer);
		return multiplechoice.get(0);
	}



	private static void initializeList(String answer) {
		String tab[] = answer.split(" | ");
		multiplechoice = Arrays.asList(tab);
	}

	@Override
	public String getPrompt() {
		String allAnswer = "";
		Collections.shuffle(multiplechoice);
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
