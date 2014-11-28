package utilities;

import java.util.Vector;
import java.util.Iterator;

import command.*;

/**
 * 
 * @author Kopp / Haid
 *
 */

public abstract class Zentralverwaltung {
	private Vector<Prototyp> prototypen = new Vector<Prototyp>();
	private Vector<Command> programmablauf = new Vector<Command>();

	/**
	 * Befaellt den ersten Vector mit allen Prototypobjekten
	 *
	 */
	public void createPrototypen() {
		prototypen.addElement(new Prototyp("Direction"));
		prototypen.addElement(new Prototyp("Gear"));
		prototypen.addElement(new Prototyp("Goto"));
		prototypen.addElement(new Prototyp("If"));
		prototypen.addElement(new Prototyp("Assignment"));

	}

	/**
	 * Fuegt einen Schritt in den Programmablauf Vector ein und erstellt diesen
	 * aus dem entsprechenden Prototypen
	 * 
	 * @param prototyp
	 */
	public void addStep(Prototyp prototyp) {
		programmablauf.addElement(prototyp.createInstance());
	}

	/**
	 * entfernt den entsprechenden Befehl aus dem Programmablauf
	 * 
	 * @param iD
	 */
	public void removeStep(int iD) {
		Iterator<Command> it = programmablauf.iterator();
		while (it.hasNext()) {
			if (it.next().getId() == iD) {
				it.remove();
			}
		}
	}

	/**
	 * schiebt den Befehl im Programmablauf einen Schritt nach vorne
	 * 
	 * @param iD
	 */
	public boolean incOrder(int iD) {
		Iterator<Command> it = programmablauf.iterator();
		int index = 0;
		if (it.next().getId() == iD) {
			return false;
		}
		while (it.hasNext()) {
			if (it.next().getId() == iD) {
				Command temp = programmablauf.get(index - 1);
				programmablauf.set(index - 1, programmablauf.get(index));
				programmablauf.set(index, temp);
			}

			index++;
		}
		return true;

	}

	/**
	 * schiebt den Befehl im Programmablauf einen Schritt nach hinten
	 * 
	 * @param iD
	 */
	public boolean decOrder(int iD) {
		Iterator<Command> it = programmablauf.iterator();
		int index = 0;
		while (it.hasNext()) {
			if (it.next().getId() == iD) {
				Command temp = programmablauf.get(index + 1);
				programmablauf.set(index + 1, programmablauf.get(index));
				programmablauf.set(index, temp);
			}

			index++;
			if((it.hasNext() != true) && (it.next().getId() == iD)){
				return false;
			}
		}
		return true;

	}

}
