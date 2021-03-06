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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int degree;

	public Direction()
	{
		super("Direction", 1);
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

	@Override
	public String toString() {
		return "Direction  [degree=" + degree + " " + super.toString() + "]";
	}
	public String getConfig(){
		Integer Degree = this.getDegree();
		return "Degree: "+Degree.toString();
	}
}
