package fil.coo.answers.impl;

import fil.coo.answers.InvalidAnswerException;
import fil.coo.gui.factory.AnswerPanelFactory;
import fil.coo.gui.panels.AnswerPanel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * User has to choose one correct answer out of several propositions
 */
public class MultipleChoiceAnswer extends TextAnswer {

    private static final String REGEX_SPLIT = " \\| ";

    private List<TextAnswer> choices;

    public MultipleChoiceAnswer(String answer) throws NullPointerException, InvalidAnswerException {
        super(answer, false);
        saveChoices(answer);
        initAnswer(choices.get(0).getCorrectAnswer());
    }


    /**
     * Parses answer and saves the possible choices in {@link #choices}.
     * The choices are delimited by {@link #REGEX_SPLIT}
     *
     * @param answer the string containing the choices that user will select from.
     * @throws InvalidAnswerException if one or more of the possible answers is not a {@link TextAnswer} according to {@link TextAnswer#isValid(String)}
     */
    private void saveChoices(String answer) throws InvalidAnswerException {
        choices = new ArrayList<>();
        String[] possibleChoices = answer.split(REGEX_SPLIT);
        for (String oneChoice : possibleChoices) {
            choices.add(new TextAnswer(oneChoice, true));
        }
    }

    /**
     * @return all the available choices, shuffled.
     */
    @Override
    public String getPrompt() {
        StringBuilder prompt = new StringBuilder("(");
        Collections.shuffle(choices);
        for (TextAnswer answer : choices) {
            prompt.append(" ").append(answer.getCorrectAnswer()).append(" ");
        }
        prompt.append(")");
        return prompt.toString();
    }


    @Override
    protected boolean checkUserAnswerIsValid(String userAnswer) {
        boolean found = false;
        Iterator<TextAnswer> textAnswerIterator = choices.iterator();
        while (textAnswerIterator.hasNext() && !found) {
            found = textAnswerIterator.next().isCorrect(userAnswer);
        }
        return found;
    }

    @Override
    protected boolean isQuizTextValid(String quizText) {
        return quizText.contains("|");
    }

    public List<TextAnswer> getChoices() {
        return choices;
    }

    @Override
    public AnswerPanel createAnswerPanel(AnswerPanelFactory answerPanelFactory) {
        return answerPanelFactory.createAnswerPanel(this);
    }
}
