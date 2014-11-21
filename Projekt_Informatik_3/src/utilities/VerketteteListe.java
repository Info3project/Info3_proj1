package utilities;

import command.*;

/**
 * @author Benjamin Haid
 *
 */
public class VerketteteListe {
	private Command inhalt = null;
	private VerketteteListe next = null;
	private VerketteteListe pre = null;
	private VerketteteListe help;

	public VerketteteListe() {
	}

	/**
	 * @param com
	 */
	public VerketteteListe(Command com) {
		super();
		setInhalt(com);
	}

	/**
	 * 
	 * @return Vorheriges Element
	 */
	private VerketteteListe getPre() {
		return pre;
	}

	/**
	 * 
	 * @param pre
	 */
	private void setPre(VerketteteListe pre) {
		this.pre = pre;
	}

	/**
	 * @return the Inhalt
	 */
	public Command getInhalt() {
		return inhalt;
	}

	/**
	 * @param com
	 *            the com to set
	 */
	public void setInhalt(Command com) {
		this.inhalt = com;
	}

	/**
	 * @return the next
	 */
	private VerketteteListe getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	private void setNext(VerketteteListe next) {
		this.next = next;
	}

	public VerketteteListe getHelp() {
		return help;
	}

	public void setHelp(VerketteteListe help) {
		this.help = help;
	}

	@Override
	public String toString() {
		return "VerketteteListe [inhalt=" + inhalt + "]";
	}

	/**
	 * 
	 * @param list
	 * @param com
	 * @return Liste
	 */
	public VerketteteListe addElement(VerketteteListe list, Command com) {
		if (list.getInhalt() == null) {
			list.setInhalt(com);
			return list;
		} else if (list.getNext() == null) {
			VerketteteListe temp = new VerketteteListe(com);
			list.setNext(temp);
			temp.setPre(list);
		} else {
			help = list;
			while (help.getNext() != null) {
				help = help.getNext();
			}
			VerketteteListe temp = help;
			help = new VerketteteListe(com);
			temp.setNext(help);
			help.setPre(temp);
		}
		return list;
	}

	/**
	 * 
	 * @param list
	 * @param com
	 * @return Die Liste
	 */
	public VerketteteListe removeElement(VerketteteListe list, Command com) {
		help = list;
		while (help.getNext() != null) {
			if (help.getInhalt().getId() == com.getId()) {
				if (list.getPre() == null) {
					list.getNext().setPre(null);
					list = list.getNext();
					return list;
				}
				help.getNext().setPre(help.getPre());
				help.getPre().setNext(help.getNext());
				return list;
			}
			help = help.getNext();
		}
		return list;

	}

	/**
	 * 
	 * @param list
	 * @param com
	 * @return ein Element der Liste
	 */
	public Command getElement(String name) {
		help = this;
		// durch die Liste gehen
		while (help.getNext() != null) {
			// Namen überprüfen
			if (help.getInhalt().getName() == name) {
				return help.getInhalt();
			}
			help = help.getNext();
		}
		return null;
	}

	/**
	 * Liste wird ausgegeben
	 */
	public String listeAusgeben() {
		String ausgabe = new String();
		help = this;
		int count = 1;
		while (help != null) {
			ausgabe += count + ". Element: " + help.toString() + "\n";
			// System.out.println("" + count + ". Element: " + help.toString());
			help = help.getNext();
			count++;
		}
		return ausgabe;
	}

	/**
	 * 
	 * @param list
	 * @param com
	 * @return Die ver�nderte Liste
	 */
	public VerketteteListe moveUpElement(VerketteteListe list, Command com) {
		help = list;
		while (help != null) {
			// schauen ob ID �bereinstimmt
			if (help.getInhalt().getId() == com.getId()) {
				// wenn erstes Element der Liste -> Fehlermeldung
				if (help.getPre() == null) {
					System.out.println("Das Element ist schon ganz vorne");
					return list;
				}
				// wenn zweites Element der liste
				if (help.getPre().getPre() == null) {
					list.setNext(help.getNext());
					help.getNext().setPre(list);
					help.setNext(list);
					help.setPre(null);
					list.setPre(help);
					list = help;
					return list;
				}
				// wenn letztes Element der Liste
				if (help.getNext() == null) {
					VerketteteListe temp = help.getPre();
					temp.setNext(null);
					temp.getPre().setNext(help);
					help.setPre(temp.getPre());
					temp.setPre(help);
					help.setNext(temp);

				}
				// alle anderen F�lle
				else {
					VerketteteListe temp = help.getPre();
					temp.setNext(help.getNext());
					help.getNext().setPre(temp);
					help.setNext(temp);
					help.setPre(temp.getPre());
					temp.getPre().setNext(help);
					temp.setPre(help);
				}
			}
			help = help.getNext();
		}
		return list;
	}

	/**
	 * 
	 * @param list
	 * @param com
	 * @return Die ver�nderte Liste
	 */
	public VerketteteListe moveDownElement(VerketteteListe list, Command com) {
		help = list;
		// Durchlaufen
		while (help != null) {
			// �berpr�fen ob ID stimmt
			if (help.getInhalt().getId() == com.getId()) {
				// wenn letztes Element -> Fehlermeldung
				if (help.getNext() == null) {
					System.out.println("Das Element ist an letzter Stelle");
					return list;
				}
				{
					// Das n�chste Element mit moveUp aufrufen
					list = list.moveUpElement(list, help.getNext().getInhalt());
					return list;
				}
			}
			help = help.getNext();
		}
		return list;
	}
}
