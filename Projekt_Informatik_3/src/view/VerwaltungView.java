package view;

import javax.swing.*;

import java.awt.*;

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

	private Zentralverwaltung zw;
	
	
	public VerwaltungView(Zentralverwaltung zw) {
		super("Verwaltung");
		this.zw = zw;
		JFrame total= new JFrame("GridBagLayout");
		JPanel left= new JPanel ();
		JPanel center= new JPanel ();
		JPanel right= new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill= GridBagConstraints.BOTH;
		
		//setLayout(new GridLayout(10, 10));
		total.setLayout(gb);

		//JButton b1 = new JButton(("add"));
		left.add( new JButton("add"), BorderLayout.SOUTH);
		left.add( new JList ( zw.getPrototypes()), BorderLayout.CENTER);
		left.setBorder(BorderFactory.createLineBorder(Color.black));
		center.add (new JButton("remove"));
		center.setBorder(BorderFactory.createLineBorder(Color.black));
		right.add(new JButton("save"));
		right.setBorder(BorderFactory.createLineBorder(Color.black));
		//JButton b2 = new JButton(("remove"));
		//JButton b3 = new JButton(("save"));
//		b1.addActionListener(null);
//		b2.addActionListener(null);
//		b3.addActionListener(null);
//		add(b1);
//		add(b2);
//		add(b3);
		c.weighty=80;
		c.weightx=20;
		total.add(left,c);
		c.weightx=60;
		total.add(center,c);
		c.weightx=20;
		total.add(right,c);
		
		total.setSize(800,300);
		total.setVisible(true);
	}

	public static void main(String[] args) {
		Zentralverwaltung zw= Zentralverwaltung.getInstance();
		VerwaltungView vv = new VerwaltungView(zw);
		//vv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//vv.pack();
		//vv.setVisible(true);

	}
}