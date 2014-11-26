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

	public Command createInstance(VerketteteListe list, String name) {
		return list.getElement(name);
	}
}