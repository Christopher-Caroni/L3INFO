package automata;

public class AhoCorasick {

    private static void completerAutomate(Automaton source) {

        for (State state : source.getStates()) {
            for (Character usedChar : source.usedAlphabet()) {
                if (source.getTransitionSet(state, usedChar) == null) {
                    if (state == racine) {
                        
                    } else {

                    }
                }
            }
        }

        /*
        for all état q do
            for all lettre do
                if δ(q, lettre) = null then
                    if q = racine then
                    δ(q, lettre) ← racine
                    else
                    δ(q, lettre) ← δ(repli[q], lettre)
                end if
            end if
            end for
        end for
         */
    }

}
