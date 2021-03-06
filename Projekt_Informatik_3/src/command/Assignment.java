package command;

/**
 * Aufgabenblatt 1 Aufgabe 3 Bearbeitungsdauer k.A.
 * 
 * @author admin
 * @version 1.0
 *
 */

public class Assignment extends Control
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String operand;

	public Assignment()
	{
		super("Assignment", 4);
	}

	public Assignment(String name, int id, int stepID)
	{
		super(name, id, stepID);
		// TODO Auto-generated constructor stub
	}

	public String getOperand()
	{
		return operand;
	}

	public void setOperand(String operand)
	{
		this.operand = operand;
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
		Assignment other = (Assignment) obj;
		if (operand == null)
		{
			if (other.operand != null)
				return false;
		} else if (!operand.equals(other.operand))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Assignment [operand=" + operand + " " + super.toString() + "]";
	}
	public String getConfig(){
		return "Operand: "+ this.getOperand();
	}

	
}
