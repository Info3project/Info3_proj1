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
	public Control()
	{
	}

	public Control(String name, int id, int stepID)
	{
		super(name, id, stepID);
	}

}
