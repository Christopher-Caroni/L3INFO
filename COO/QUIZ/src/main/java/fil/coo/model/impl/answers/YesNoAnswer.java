package fil.coo.model.impl.answers;

import fil.coo.exception.InvalidAnswerException;
import fil.coo.gui.AbstractAnswerView;
import fil.coo.gui.factory.AnswerPanelFactory;
import fil.coo.model.impl.ChoiceAnswer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YesNoAnswer extends SingleAnswer implements ChoiceAnswer {

    private static final List<String> possibleQuizInput = new ArrayList<>(Arrays.asList("yes", "no", "true", "false", "oui", "non", "vrai", "faux"));
    private List<String> possibleAnswers;

    public YesNoAnswer(String answer) throws InvalidAnswerException {
        super(answer);
        initPossibleAnswers();
    }

    /**
     * @param quizText the string read from the .quiz file
     * @return if the quiz input is any of the expected from a Yes/No answer in English/French in true/false or yes/no format
     */
    @Override
    protected boolean isQuizTextValid(String quizText) {
        for (String possibleAnswer : possibleQuizInput) {
            if (possibleAnswer.equalsIgnoreCase(quizText)) {
                return true;
            }
        }
        return false;
    }

    public String getPrompt() {
        return "(vrai/faux) ";
    }

    /**
     * @param userAnswer the user's answer
     * @return if the user's answer is one of the two possible answers in the correct language and wording expected
     */
    protected boolean checkUserAnswerIsValid(String userAnswer) {
        if (possibleAnswers == null) {
            return isQuizTextValid(userAnswer);
        }
        for (String possibleAnswer : possibleAnswers) {
            if (possibleAnswer.equalsIgnoreCase(userAnswer)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public AbstractAnswerView createAnswerPanel(AnswerPanelFactory answerPanelFactory) {
        return answerPanelFactory.createAnswerPanel(this);
    }


    private void initPossibleAnswers() {
        possibleAnswers = new ArrayList<>();
        switch (correctAnswer) {
            case "yes":
            case "no":
                possibleAnswers.add("yes");
                possibleAnswers.add("no");
                break;
            case "true":
            case "false":
                possibleAnswers.add("true");
                possibleAnswers.add("false");
                break;
            case "oui":
            case "non":
                possibleAnswers.add("oui");
                possibleAnswers.add("non");
                break;
            case "vrai":
            case "faux":
                possibleAnswers.add("vrai");
                possibleAnswers.add("faux");
                break;
            default:
                break;
        }
    }

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }
}
