package fil.coo.answers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultipleChoiceAnswer extends TextAnswer {

    public static final String REGEX_SPLIT = " | ";
    private List<String> choices;

    public MultipleChoiceAnswer(String answer) throws NullPointerException, InvalidAnswerException {
        saveChoices(answer);
        initAnswer(choices.get(0));
    }

    /**
     * Parses answer and saves the possible choices.
     * The choices are delimited by {@link #REGEX_SPLIT}
     *
     * @param answer the string containing the choices that user will select from.
     */
    private void saveChoices(String answer) {
        String[] tab = answer.split(REGEX_SPLIT);
        choices = Arrays.asList(tab);
    }

    @Override
    public String getPrompt() {
        StringBuilder prompt = new StringBuilder("(");
        Collections.shuffle(choices);
        for (String answer : choices) {
            prompt.append(" ").append(answer).append(" ");
        }
        prompt.append(")");
        return prompt.toString();
    }


    @Override
    protected boolean checkUserAnswerIsValid(String userAnswer) {
        return choices.contains(userAnswer);
    }
}
