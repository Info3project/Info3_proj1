package utilities;

import command.*;

/**
 * Aufgabenblatt 2
 * 
 * @author Kopp / Haid
 *
 */
public class Prototyp {

	private String nameCommand = null;

	public Prototyp() {
	}

	public Prototyp(String nameCommand) {
		this.setNameCommand(nameCommand);
	}

	public String getNameCommand() {
		return nameCommand;
	}

	private void setNameCommand(String nameCommand) {
		this.nameCommand = nameCommand;
	}

	public Command createInstance(String name) {
		Command temp = null;
		if (name.equals("Direction")) {
			temp = new Direction();
		}
		if (name.equals("Gear")) {
			temp = new Gear();
		}
		if (name.equals("Goto")) {
			temp = new Goto("Goto");
		}
		if (name.equals("If")) {
			temp = new If();
		}
		if (name.equals("Assignment")) {
			temp = new Assignment();
		}
		return temp;
	}

	public Command createInstance() {
		if (nameCommand == null)
			return null;
		else {
			Command temp = null;
			if (nameCommand.equals("Direction")) {
				temp = new Direction();
			}
			if (nameCommand.equals("Gear")) {
				temp = new Gear();
			}
			if (nameCommand.equals("Goto")) {
				temp = new Goto("Goto");
			}
			if (nameCommand.equals("If")) {
				temp = new If();
			}
			if (nameCommand.equals("Assignment")) {
				temp = new Assignment();
			}
			return temp;
		}
	}

	@Override
	public String toString() {
		return "Prototyp [nameCommand=" + nameCommand + "]";
	}

}