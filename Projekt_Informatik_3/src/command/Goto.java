package command;

/**
 * Aufgabenblatt 1 Aufgabe 3 Bearbeitungsdauer k.A.
 * 
 * @author admin
 * @version 1.0
 *
 */

public class Goto extends Control {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int jumpAdress;
	private int wdh;

	public Goto(String name) {
		super(name, 3);
	}

	public Goto(String name, int id, int stepID) {
		super(name, id, stepID);
		// TODO Auto-generated constructor stub
	}

	public int getJumpAdress() {
		return jumpAdress;
	}

	public void setJumpAdress(int jumpAdress) {
		this.jumpAdress = jumpAdress;
	}

	@Override
	public boolean equals(Object obj) {
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

	@Override
	public String toString() {
		return "Goto       [jumpAdress=" + jumpAdress + " " + super.toString() + "]";
	}
	public String getConfig(){
		Integer JumpAdress = this.getJumpAdress();
		Integer Wdh = this.getWdh();
		return "Jump Adress: "+JumpAdress.toString()+" "+"Anzahl Jumps: "+Wdh.toString();
	}

	public int getWdh() {
		return wdh;
	}

	public void setWdh(int wdh) {
		this.wdh = wdh;
	}

}
