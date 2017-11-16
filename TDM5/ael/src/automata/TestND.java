package automata;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestND {

	/*
	 * Écriture de la représentation graphviz de l'automate dans un fichier
	 * 
	 */
	private static void dotToFile(Automaton a, String fileName) {
		File f = new File(fileName);
		try {
			PrintWriter sortieDot = new PrintWriter(f);
			sortieDot.println(a.toGraphviz());
			sortieDot.close();
		} catch (IOException e) {
			System.out.println("création du fichier " + fileName + " impossible");
		}
	}

	/*
	 * Test de la méthode accept()
	 */
	private static void testAccept(Automaton a) {
		if (a.accept(""))
			System.out.println("Le mot vide est accepté. ");
		else
			System.out.println("Le mot vide n'est pas accepté. ");

		Scanner in = new Scanner(System.in);
		System.out.println("Mot non vide à tester ? (mot vide pour terminer)");
		String word = in.nextLine();
		while (word.length() != 0) {
			System.out.print("> " + word);
			if (a.accept(word))
				System.out.print(" est accepté. ");
			else
				System.out.print(" n'est pas accepté.");
			System.out.println("Mot non vide à tester ? (mot vide pour terminer)");
			word = in.nextLine();
		}

	}

	public static void main(String[] args) throws StateException {

		/* Fabrication de l'automate */

		AutomatonBuilder a = Constantes.buildTransposeOriginal();
		AutomatonBuilder b = new NDAutomaton();


//		AutomataUtils.addFlatExp("10*1", a, "exp");
		AutomataUtils.transpose(a, b);
//		AutomataUtils.determinize(a, b);
//		AutomataUtils.minimalise(a, b);

		/*
		 * Dessin de l'automate (fabrication d'un fichier Graphviz)
		 */
        dotToFile(a, "automate-test-original.dot");
		dotToFile(b, "automate-test-result.dot");

		/*
		 * Affichage de l'automate, en mode texte
		 */
//        System.out.println("\nPrinting the two automatons");
		System.out.println(a + "*** END PRINT AUTOMATE ***\n");
		System.out.println(b + "*** END PRINT AUTOMATE ***\n");

		/*
		 * Test de la méthode accept() à réactiver quand vous aurez développé une classe
		 * avec une vraie méthode accept()
		 */

//		 testAccept(a);

		System.out.println("That's all folks");

	}
}
