package utilities;

import java.util.Vector;
import command.*;

public abstract class Zentralverwaltung {
	private Vector <Prototyp> prototypen = new Vector<Prototyp>();
	private Vector <Command> programmablauf= new Vector <Command>();

	/**
	 * Befaellt den ersten Vector mit allen Prototypobjekten
	 *
	 */
	public void createPrototypen(){
		prototypen.addElement(new Prototyp("Direction"));
		prototypen.addElement(new Prototyp("Gear"));
		prototypen.addElement(new Prototyp("Goto"));
		prototypen.addElement(new Prototyp("If"));
		prototypen.addElement(new Prototyp("Assignment"));
		
	}
	/**
	 * Fuegt einen Schritt in den Programmablauf Vector ein
	 * und erstellt diesen aus dem entsprechenden Prototypen
	 * @param prototyp
	 */
	public void addStep(Prototyp prototyp){
		
	}
	
	/**
	 * entfernt den entsprechenden Befehl aus dem Programmablauf
	 * @param iD
	 */
	public void removeStep(int iD){
		
	}
	
	/**
	 * schiebt den Befehl im Programmablauf einen Schritt nach vorne
	 * @param iD
	 */
	public void incOrder(int iD){
		
	}
	
	/**
	 * schiebt den Befehl im Programmablauf einen Schritt nach hinten
	 * @param iD
	 */
	public void decOrder (int iD){
		
	}

}



