package command;

/**
 * Aufgabenblatt 1 Aufgabe 3 Bearbeitungsdauer k.A.
 * 
 * @author admin
 * @version 1.0
 *
 */

public class Goto extends Control
{
	private int jumpAdress;

	public Goto()
	{
	}

	public Goto(String name, int id, int stepID)
	{
		super(name, id, stepID);
		// TODO Auto-generated constructor stub
	}

	public int getJumpAdress()
	{
		return jumpAdress;
	}

	public void setJumpAdress(int jumpAdress)
	{
		this.jumpAdress = jumpAdress;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goto other = (Goto) obj;
		if (jumpAdress != other.jumpAdress)
			return false;
		return true;
	}

}
