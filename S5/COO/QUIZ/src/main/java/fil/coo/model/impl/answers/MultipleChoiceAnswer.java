package fil.coo.model.impl.answers;

import fil.coo.exception.InvalidAnswerException;
import fil.coo.gui.AbstractAnswerView;
import fil.coo.gui.factory.AnswerPanelFactory;
import fil.coo.model.impl.ChoiceAnswer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User has to choose one correct answer out of several propositions
 */
public class MultipleChoiceAnswer extends TextAnswer implements ChoiceAnswer {

    private static final String REGEX_SPLIT = " \\| ";

    private List<TextAnswer> choices;

    /**
     * Takes in multiple {@link TextAnswer} inputs separated by a "|". The correct answer then overwritten from the super
     * constructor with the first {@link TextAnswer}
     *
     * @param choices the possible choices
     * @throws InvalidAnswerException if the input does not correspond to this type of answer
     */
    public MultipleChoiceAnswer(String choices) throws InvalidAnswerException {
        super(choices);
        saveChoices();
        saveCorrectAnswer(this.choices.get(0).getCorrectAnswer());
    }

    /**
     * Parses answer and saves the possible choices in {@link #choices}.
     * The choices are delimited by {@link #REGEX_SPLIT}
     *
     * @throws InvalidAnswerException if one or more of the possible answers is not a {@link TextAnswer} according to {@link TextAnswer#isValid(String)}
     */
    private void saveChoices() throws InvalidAnswerException {
        choices = new ArrayList<>();
        String[] possibleChoices = correctAnswer.split(REGEX_SPLIT);
        for (String oneChoice : possibleChoices) {
            choices.add(new TextAnswer(oneChoice));
        }
    }

    /**
     * @return all the available choices, shuffled.
     */
    @Override
    public String getPrompt() {
        StringBuilder prompt = new StringBuilder("(");
        Collections.shuffle(choices);
        for (int i = 0; i < choices.size(); i++) {
            if (i < choices.size() - 1) {
                prompt.append(choices.get(i).getCorrectAnswer())
                        .append(" | ");
            } else {
                prompt.append(choices.get(i).getCorrectAnswer());
            }

        }
        prompt.append(")");
        return prompt.toString();
    }


    /**
     * Any {@link TextAnswer} input is considered valid
     *
     * @param userAnswer the user's answer
     * @return if the input would be accepted by {@link TextAnswer}
     */
    @Override
    protected boolean checkUserAnswerIsValid(String userAnswer) {
        try {
            return new TextAnswer(userAnswer).isValid(userAnswer);
        } catch (InvalidAnswerException e) {
            return false;
        }
    }

    @Override
    protected boolean isQuizTextValid(String quizText) {
        return quizText.contains("|");
    }

    public List<TextAnswer> getChoices() {
        return choices;
    }

    @Override
    public AbstractAnswerView createAnswerPanel(AnswerPanelFactory answerPanelFactory) {
        return answerPanelFactory.createAnswerPanel(this);
    }

    @Override
    public List<String> getPossibleAnswers() {
        List<String> possibleAnswers = new ArrayList<>();
        for (TextAnswer textAnswer : getChoices()) {
            possibleAnswers.add(textAnswer.getCorrectAnswer());
        }
        return possibleAnswers;
    }
}
