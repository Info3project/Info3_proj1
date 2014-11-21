package command;

/**
 * Aufgabenblatt 1 Aufgabe 3 Bearbeitungsdauer k.A.
 * 
 * @author admin
 * @version 1.0
 *
 */

public class Gear extends Movement
{
	private int speed;
	private int duration;

	public Gear()
	{
	}

	public Gear(int speed, int duration, int hwAdress, String name, int id,
			int stepID)
	{
		super(hwAdress, name, id, stepID);
		this.speed = speed;
		this.duration = duration;
	}

	public int getSpeed()
	{
		return speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	public int getDuration()
	{
		return duration;
	}

	public void setDuration(int duration)
	{
		this.duration = duration;
	}

}
