package utilities;

import command.*;

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
		if(name.equals("Direction")){
			temp = new Direction();
		}
		if(name.equals("Gear")){
			temp = new Gear();
		}
		if(name.equals("Goto")){
			temp = new Goto();
		}
		if(name.equals("If")){
			temp = new If();
		}
		if(name.equals("Assignment")){
			temp = new Assignment();
		}
		return temp;
	}
}