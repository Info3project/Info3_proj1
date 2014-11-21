package utilities;

import command.*;

/**
 * 
 * @author admin
 */

public class Test
{

	public static void main(String[] args)
	{
		VerketteteListe liste1 = new VerketteteListe();

		Goto g1 = new Goto("Befehl 1", 1, 234);
		Goto g2 = new Goto("Befehl 2", 2, 956);
		Goto g3 = new Goto("Befehl 3", 3, 123);
		Goto g4 = new Goto("Befehl 4", 4, 412);

		liste1 = liste1.addElement(liste1, g1);
		liste1 = liste1.addElement(liste1, g2);
		liste1 = liste1.addElement(liste1, g3);
		liste1 = liste1.addElement(liste1, g4);
		System.out.println(liste1.listeAusgeben());
		System.out.println("\nMove down\n");
		liste1 = liste1.moveDownElement(liste1, g1);

		// System.out.println("\nMove el 3 up\n");
		// liste1 = liste1.moveUpElement(liste1, g1);
		System.out.println(liste1.listeAusgeben());

		// liste1 = liste1.removeElement(liste1, g1);
		// System.out.println("\nErstes Element gel�scht:\n");
		// liste1.listeAusgeben();
	}
}
