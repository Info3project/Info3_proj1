package utilities;

import java.util.Properties;
import java.util.Vector;
import java.util.Iterator;

import command.*;

/**
 * 
 * @author Kopp / Haid
 *
 */

public class Zentralverwaltung implements Interface {
	private static Zentralverwaltung instance = null;
	private Vector<Prototyp> prototypen = new Vector<Prototyp>();
	private Vector<Command> programmablauf = new Vector<Command>();

	/**
	 * Befuellt den ersten Vector mit allen Prototypobjekten
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
	 * Konstruktor der nicht aufgerufen werden darf, daher private
	 */
	private Zentralverwaltung() {
	}

	public static Zentralverwaltung getInstance() {
		if (instance == null) {
			instance = new Zentralverwaltung();
		}
		return instance;
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
		int index = 1;
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
				index++;
				return true;
			}

			index++;
			if ((it.hasNext() != true) && (it.next().getId() == iD)) {
				return false;
			}
		}
		return false;

	}

	@SuppressWarnings("unchecked")
	public Properties laden(String verzeichnis) {
		Properties daten = new Properties();
		Serialisieren ser = new Serialisieren();
		daten = ser.laden(verzeichnis);
		//prototypen = (Vector<Prototyp>) daten.get("prototypen");
		programmablauf = (Vector<Command>) daten.get("commands");

		return null;
	}

	public void speichern(Properties daten, String verzeichnis) {
		daten = new Properties();
		//daten.put("prototypen", prototypen);
		daten.put("commands", programmablauf);
		Serialisieren ser = new Serialisieren();
		ser.speichern(daten, verzeichnis);
	}

	@Override
	public String toString() {
		String result = "Zentralverwaltung: \nPrototypen: \n";
		for (Prototyp prototyp : prototypen) {
			result = result + "   " + prototyp + "\n";
		}
		result = result + "Programmablauf: \n";
		for (Command command : programmablauf) {
			result = result + "   " + command + "\n";
		}
		return result;
	}

}
