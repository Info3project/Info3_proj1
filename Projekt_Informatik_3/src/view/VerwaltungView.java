package view;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import utilities.*;
import command.*;

/**
 * @author Haid/Kopp
 *
 */
public class VerwaltungView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VerwaltungView() {
		super("Verwaltung");
		setLayout(new GridLayout(10,10));
	}
}
