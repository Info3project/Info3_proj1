package view;


import javax.swing.*;

import java.awt.*;

import utilities.*;
import command.*;

import java.util.Vector;

/**
 * @author Haid/Kopp
 *
 */
public class VerwaltungView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private Vector <String> prototypenString = new Vector <String>();
	
	
	private Zentralverwaltung zw;
	
	
	
	public VerwaltungView(Zentralverwaltung zw) {
		super("Verwaltung");
		this.zw = zw;
		JFrame total= new JFrame("GridBagLayout");
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill= GridBagConstraints.BOTH;
		total.setLayout(gb);

		//setLayout(new GridLayout(10, 10));
		//JButton b1 = new JButton(("add"));
		
		//********************* create JPanel left with Prototype List and add button
		JPanel left= new JPanel ();
		left.setLayout(new BorderLayout());
		left.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		//String vector mit prototypen namen fuellen
		for (Prototyp prototyp : zw.getPrototypes() ){
			prototypenString.addElement(prototyp.getNameCommand());
		} 
		
		left.add( new JScrollPane(new JList <String> (prototypenString)), BorderLayout.CENTER);
		left.add( new JButton("add"), BorderLayout.PAGE_END);
		
		
		left.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		//***************** create JPanel center with Programmablauf List and buttons remove, up, down start
		JPanel center= new JPanel (new BorderLayout());
		JPanel centerSouth = new JPanel(new GridLayout(1, 2));
		JPanel centerSouthLeft = new JPanel(new BorderLayout());
		JPanel centerSouthRight = new JPanel(new GridLayout(1, 3));
		//*****************  create JButtons
		JButton remove = new JButton("Remove");
		JButton up = new JButton("Up");
		JButton down = new JButton("Down");
		JButton start = new JButton("Start");
		//***************** set position of the buttons
		center.add (centerSouth, BorderLayout.SOUTH);
		centerSouth.add(centerSouthLeft);
		centerSouth.add(centerSouthRight);
		centerSouthLeft.add(remove, BorderLayout.WEST);
		centerSouthRight.add(up);
		centerSouthRight.add(down);
		centerSouthRight.add(start);
		center.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		//*************** create Jpanel right with config editor
		JPanel right= new JPanel();
		right.add(new JButton("save"));
		right.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		//************** create Jpanel bottom with text output
		JPanel bottom= new JPanel();
		bottom.add( new JTextArea("jlkjlkjlkj"));
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
		c.gridy=1;
		c.gridwidth=3;
		total.add(bottom,c);
		
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