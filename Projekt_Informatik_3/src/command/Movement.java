package command;

/**
 * Aufgabenblatt 1 Aufgabe 3 Bearbeitungsdauer k.A.
 * 
 * @author admin
 * @version 1.0
 *
 */

public abstract class Movement extends Command
{

	private int hwAdress;

	public Movement()
	{
	}

	public Movement(int hwAdress, String name, int id, int stepID)
	{
		super(name, id, stepID);
		this.hwAdress = hwAdress;
	}

	public int getHwAdress()
	{
		return hwAdress;
	}

	public void setHwAdress(int hwAdress)
	{
		this.hwAdress = hwAdress;
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
		Movement other = (Movement) obj;
		if (hwAdress != other.hwAdress)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Movement [hwAdress=" + hwAdress + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
