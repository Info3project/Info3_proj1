package command;

/**
 * Aufgabenblatt 1 Aufgabe 3 Bearbeitungsdauer k.A.
 * 
 * @author admin
 * @version 1.0
 *
 */

public abstract class Control extends Command
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Control(String name)
	{
		super(name);
	}

	public Control(String name, int id, int stepID)
	{
		super(name, id, stepID);
	}

}
