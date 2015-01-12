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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int speed;
	private int duration;

	public Gear()
	{
		super("Gear", 2);
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

	@Override
	public String toString() {
		return "Gear       [speed=" + speed + ", duration=" + duration + " " + super.toString() +  "]";
	}
	public String getConfig(){
		Integer Speed = this.getSpeed();
		Integer Duration = this.getDuration();
		return "Speed: "+Speed.toString()+" Duration: "+Duration.toString();
	}

}
