package command;

/**
 * Aufgabenblatt 1 Aufgabe 3 Bearbeitungsdauer k.A.
 * 
 * @author admin
 * @version 1.0
 *
 */

public class Direction extends Movement
{

	private int degree;

	public Direction()
	{
	}

	public Direction(int degree, int hwAdress, String name, int id, int stepID)
	{
		super(hwAdress, name, id, stepID);
		this.degree = degree;
	}

	public int getDegree()
	{
		return degree;
	}

	public void setDegree(int degree)
	{
		this.degree = degree;
	}

}
