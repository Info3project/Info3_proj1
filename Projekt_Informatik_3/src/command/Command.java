package command;


import java.io.Serializable;

/**
 * Aufgabenblatt 1 Aufgabe 3 Bearbeitungsdauer k.A.
 * 
 * @author admin
 * @version 1.0
 *
 */

public abstract class Command implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int id;
	private int stepID;

	public Command(String name, int id)
	{
		this(name, id,-1);
	}
	
	public Command(String name, int id, int stepID)
	{
		this.setName(name);
		this.setId(id);
		this.setStepID(stepID);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getConfig()
	{
		return "";
	}

	public int getId()
	{
		return id;
	}

	protected void setId(int id)
	{
		this.id = id;
	}

	public int getStepID()
	{
		return stepID;
	}

	public void setStepID(int stepID)
	{
		this.stepID = stepID;
	}

	@Override
	public String toString()
	{
		return "Command [name=" + name + ", id=" + id + ", stepID=" + stepID
				+ "]";
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Command other = (Command) obj;
		if (id != other.id)
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stepID != other.stepID)
			return false;
		return true;
	}

}
