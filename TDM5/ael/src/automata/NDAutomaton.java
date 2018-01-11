package automata;

import java.util.Set;

public class NDAutomaton extends AbstractNDAutomaton implements Recognizer, AutomatonBuilder {

    @Override
    public boolean accept(String word) throws StateException {
        Set<State> wordState = new PrintSet<>();
        wordState.addAll(getInitialStates());
        for(int i=0;i<word.length();i++) {
            wordState = getTransitionSet(wordState, word.charAt(i));
        }
        Set<State> acceptingStates = getAcceptingStates();
        return acceptingStates.stream().anyMatch(wordState::contains);
    }

    /**
     * Calcul de l’ensemble des états pouvant être obtenus depuis un ensemble d’états
     * @param fromSet : ensemble d’états
     * @param letter : lettre de l’alphabet
     * @return ensemble d’états pouvant être obtenus en lisant letter,
     * en partant de n’importe lequel des états de l’ensemble fromSet
     */
    @Override
    public Set<State> getTransitionSet(Set<State> fromSet, char letter) {
        Set<State> resultStates = new PrintSet<>();
        for (State singleState : fromSet) {
            Set<State> transitionSet = singleState.getAutomaton().getTransitionSet(singleState, letter);
            resultStates.addAll(transitionSet);

        }
        return resultStates;
    }
}
