package automata;

public class Constantes {

    public static AutomatonBuilder buildMinimaliseOriginal() {
        AutomatonBuilder a = new NDAutomaton();


        a.addNewState("q0");
        a.addNewState("q1");
        a.addNewState("q2");
        a.addNewState("q3");
        a.addNewState("q4");

		/*
		 * Définition des états initiaux et des états acceptants Le paramètre est
		 * indifféremment le numéro ou le nom d'un état
		 */
        a.setAccepting("q2");
        a.setAccepting("q3");

		/*
		 * Définition des transitions
		 */
        a.addTransition("q0", 'a', "q1");
        a.addTransition("q1", 'b', "q1");
        a.addTransition("q1", 'a', "q2");
        a.addTransition("q2", 'a', "q1");
        a.addTransition("q2", 'b', "q2");
        a.addTransition("q0", 'b', "q3");
        a.addTransition("q3", 'b', "q3");
        a.addTransition("q3", 'a', "q4");
        a.addTransition("q4", 'a', "q3");
        a.addTransition("q4", 'b', "q4");

        return a;
    }

    public static AutomatonBuilder buildTransposeOriginal() {
        AutomatonBuilder a = new NDAutomaton();


        a.addNewState("epsilon");
        a.addNewState("a");
        a.addNewState("ab");
        a.addNewState("abc");

		/*
		 * Définition des états initiaux et des états acceptants Le paramètre est
		 * indifféremment le numéro ou le nom d'un état
		 */
        a.setAccepting("abc");

		/*
		 * Définition des transitions
		 */
        a.addTransition("epsilon", 'a', "a");
        a.addTransition("a", 'b', "ab");
        a.addTransition("ab", 'c', "abc");

        return a;

    }

}
