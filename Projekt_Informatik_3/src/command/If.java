package command;

/**
 * Aufgabenblatt 1 Aufgabe 3 Bearbeitungsdauer k.A.
 * 
 * @author admin
 * @version 1.0
 *
 */

public class If extends Goto
{
	private Assignment treshold;
	private boolean reference;
	public If()
	{
	}
	public If(Assignment treshold, boolean reference, String name, int id, int stepID)
	{
		super(name, id, stepID);
		// TODO Auto-generated constructor stub
		this.treshold = treshold;
		this.reference = reference;
	}
	public Assignment getTreshold()
	{
		return treshold;
	}
	public void setTreshold(Assignment treshold)
	{
		this.treshold = treshold;
	}
	public boolean isReference()
	{
		return reference;
	}
	public void setReference(boolean reference)
	{
		this.reference = reference;
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
		If other = (If) obj;
		if (reference != other.reference)
			return false;
		if (treshold == null)
		{
			if (other.treshold != null)
				return false;
		} else if (!treshold.equals(other.treshold))
			return false;
		return true;
	}
	
	
}
