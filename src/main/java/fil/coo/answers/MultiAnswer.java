package fil.coo.answers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Has several answers that are correct
 */
public class MultiAnswer extends Answer {

    List<TextAnswer> answers;

    public MultiAnswer(String allAnswers) throws InvalidAnswerException {
        answers = new ArrayList<TextAnswer>();
        for (String oneAnswer : allAnswers.split(" ; ")) {
            if (!("".equals(oneAnswer))) {
                answers.add(new TextAnswer(oneAnswer));
            }
        }
        if (answers.size() == 0) {
            throw new InvalidAnswerException();
        }
    }

    public String getPrompt() {
        return "(" + answers.size() + " possible answers)";
    }

    protected boolean checkUserAnswerIsValid(String userAnswer) {
        return answers.get(0).isValid(userAnswer);
    }

    protected boolean checkUserAnswerIsCorrect(String userAnswer) {
        boolean found = false;
        Iterator<TextAnswer> textAnswerIterator = answers.iterator();
        while (textAnswerIterator.hasNext() && !found) {
            found = textAnswerIterator.next().isCorrect(userAnswer);
        }
        return found;
    }

}
