package automata;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import static automata.TestND.dotToFile;

/**
 * @author Bruno.Bogaert (at) univ-lille.fr
 */
public class AutomataUtils {

    /**
     * Extends automaton a, so that it accepts also this word.
     * Created states are prefixed by 'q_'
     *
     * @param word : word to be accepted
     * @param a    : target automaton
     */
    public static void addSingleton(String word, AutomatonBuilder a) {
        addSingleton(word, a, "q");
    }

    /**
     * Extends automaton a so that it accepts also this word.
     * Created states are prefixed by namePrefix followed by '_'
     *
     * @param word       : word to be accepted
     * @param a          : target automaton
     * @param namePrefix : prefix to use for state names.
     */
    public static void addSingleton(String word, AutomatonBuilder a, String namePrefix) {
        String currentStateName;

        a.addNewState(namePrefix + "_epsilon");
        a.setInitial(namePrefix + "_epsilon");

        for (int i = 0; i < word.length(); i++) {
            currentStateName = namePrefix + "_" + word.substring(0, i + 1);
            a.addNewState(currentStateName);

            if (i == 0) {
                a.addTransition(namePrefix + "_epsilon", word.charAt(i), currentStateName);
            } else {
                a.addTransition(namePrefix + "_" + word.substring(0, i), word.charAt(i), currentStateName);
            }
        }
        a.setAccepting(namePrefix + "_" + word);
    }

    /**
     * Extends automaton a so that it accepts also this finite language
     * created states are prefixed by namePrefix followed by '_'
     *
     * @param finiteLanguage : set of words to be accepted
     * @param a              : target automaton
     */
    public static void addFiniteSet(Iterable<String> finiteLanguage, AutomatonBuilder a) {
        for (String word : finiteLanguage) {
            addSingleton(word, a, "added_state");
        }
    }

    /**
     * Extends automaton a so that it accepts also language denoted by exp
     * created states are prefixed by namePrefix followed by '_'
     *
     * @param exp : flat regular expression (only letters and *)
     * @param a   : target automaton
     */
    public static void addFlatExp(String exp, AutomatonBuilder a) {
        addFlatExp(exp, a, "q");
    }

    /**
     * Extends automaton a so that it accepts also language denoted by exp
     * created states are prefixed by namePrefix followed by '_'
     *
     * @param exp        : flat regular expression (only letters and *)
     * @param a          : target automaton
     * @param namePrefix : prefix to use for state names.
     */
    public static void addFlatExp(String exp, AutomatonBuilder a, String namePrefix) {
        String prefix = namePrefix + "_";
        String firstName = prefix + "epsilon";
        String newName = null;
        String previousName = firstName;
        boolean nextIsMultiple = false;

        a.addNewState(firstName);
        a.setInitial(firstName);

        for (int i = 0; i < exp.length(); i++) {
            nextIsMultiple = (i + 1) < exp.length() && exp.charAt(i + 1) == '*';

            if (exp.charAt(i) == '*') {
                // do nothing
            } else if (!nextIsMultiple) {
                newName = prefix + exp.substring(0, i + 1); // exclude the '*'
                a.addNewState(newName);
                a.addTransition(previousName, exp.charAt(i), newName);
            }
            if (nextIsMultiple) {
                a.addTransition(newName, exp.charAt(i), newName);
            }
            previousName = newName;
        }

        a.setAccepting(prefix + exp);
    }

    /**
     * Transpose automaton
     * Note : mirror is cleared before the operation.
     *
     * @param original : automaton to be transposed
     * @param mirror   : receive the transposed automaton
     */

    public static void transpose(Automaton original, AutomatonBuilder mirror) {
        /*
            All accepting become initial
            All initial become accepting
         */
        mirror.clear();
        final String transposePrefix = "transpose_";
        Set<State> originalStates = original.getStates();
        Set<Character> alphabet = original.usedAlphabet();

        addTransposeStates(original, mirror, transposePrefix, originalStates);
        addReversedTransitions(original, mirror, transposePrefix, originalStates, alphabet);

    }

    private static void addReversedTransitions(Automaton original, AutomatonBuilder mirror, String transposePrefix, Set<State> originalStates, Set<Character> alphabet) {
        for (State previousState : originalStates) {
            for (Character usedChar : alphabet) {
                Set<State> transitionSet = original.getTransitionSet(previousState, usedChar);
                for (State nextState : transitionSet) {
                    String prevNameInTr = getTransposeName(transposePrefix, previousState);
                    String nextNameInTr = getTransposeName(transposePrefix, nextState);
                    mirror.addTransition(nextNameInTr, usedChar, prevNameInTr);
                }
            }
        }
    }

    private static void addTransposeStates(Automaton original, AutomatonBuilder mirror, String transposePrefix, Set<State> originalStates) {
        for (State state : originalStates) {
            String newName = getTransposeName(transposePrefix, state);

            mirror.addNewState(newName);
            if (original.isAccepting(state) && original.isInitial(state)) {
                mirror.setInitial(newName);
                mirror.setAccepting(newName);
            } else if (original.isAccepting(state)) {
                mirror.setInitial(newName);
            } else if (original.isInitial(state)) {
                mirror.setAccepting(newName);
            }
        }
    }

    private static String getTransposeName(String transposePrefix, State state) {
        return transposePrefix + state.getName();
    }

    /**
     * Determinization of nfa automaton.
     * Note : dfa is cleared before the operation.
     *
     * @param nfa : non deterministic automaton (to be determinize)
     * @param dfa : receive determinization result
     */

    public static void determinize(Automaton nfa, AutomatonBuilder dfa) {
        // For each computed state set from nfa, a corresponding state has to be created in dfa
        // map represents relationship  between nfa state set (key) and created dfa state (value)
        Map<Set<State>, State> map = new HashMap<Set<State>, State>();

        // stack todo contains state sets whose transitions have not yet been computed
        Stack<Set<State>> todo = new Stack<Set<State>>();

        dfa.clear();

        Set<State> startSet = nfa.getInitialStates();

        // create matching state in DFA
        State start = dfa.addNewState(startSet.toString()); // state creation
        map.put(startSet, start);  // record relationship in map

        dfa.setInitial(start); // start is the unique initial state of dfa

        todo.push(startSet); // put it in todo list.

        while (!todo.isEmpty()) {
            Set<State> fromSet = todo.pop(); // pick a state from todo list
            /*
             * for each letter of alphabet :
			 * 		compute transitionSet from fromSet
			 * 		if computed set is a new one :
			 * 			create corresponding state in dfa
			 * 			record relationship in map
			 * 			add it to the todo list
			 * 		end if
			 * 		create corresponding transition in dfa
			 */

            Set<Character> alphabet = nfa.usedAlphabet();
            for (Character usedChar : alphabet) {
                Set<State> transitionSet = nfa.getTransitionSet(fromSet, usedChar);
                if (map.get(transitionSet) == null) {
                    State state = dfa.addNewState(transitionSet.toString());// state creation
                    map.put(transitionSet, state);  // record relationship in map
                    todo.push(transitionSet);
                }
                dfa.addTransition(fromSet.toString(), usedChar, transitionSet.toString());
            }
        }
        for (Set<State> qSet : map.keySet()) {    // foreach computed state set

            /*
             * if qset contains accepting state (from nfa)
			 * 	 	in dfa, set corresponding state as accepting state
			 */
            boolean containsAccepting = false;
            for (State state : qSet) {
                if (nfa.isAccepting(state)) {
                    containsAccepting = true;
                }
            }
            if (containsAccepting) {
                dfa.setAccepting(qSet.toString());
            }
        }
    }

    public static void minimalise(Automaton a, AutomatonBuilder dest) {
        AutomatonBuilder result = new NDAutomaton();

        transpose(a, result);
        determinize(result, dest);

        transpose(dest, result);
        determinize(result, dest);
    }

}
