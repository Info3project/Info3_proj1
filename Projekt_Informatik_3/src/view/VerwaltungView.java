package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	private Zentralverwaltung zw;

	public VerwaltungView(Zentralverwaltung zw) {
		super("Verwaltung");
		this.zw = zw;
		JFrame total = new JFrame("GridBagLayout");
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		total.setLayout(gb);

		/**
		 * create JPanel left
		 */
		JPanel left = new JPanel(new BorderLayout());
		JPanel leftNorth = new JPanel();
		JPanel leftSouth = new JPanel(new BorderLayout());
		/**
		 * create JPanel right
		 */
		JPanel right = new JPanel(new BorderLayout());
		JPanel rightSouth = new JPanel(new BorderLayout());
		
		/**
		 * create JPanel bottom
		 */
		JPanel bottom = new JPanel();
		
		/**
		 * create JPanel center
		 */
		JPanel center = new JPanel(new BorderLayout());
		JPanel centerCenter = new JPanel(new BorderLayout());
		JPanel centerSouth = new JPanel(new GridLayout(1, 2));
		JPanel centerSouthLeft = new JPanel(new BorderLayout());
		JPanel centerSouthRight = new JPanel(new GridLayout(1, 3));
		
		/**
		 * create JButtons
		 */
		JButton remove = new JButton("Remove");
		JButton up = new JButton("Up");
		JButton down = new JButton("Down");
		JButton start = new JButton("Start");
		JButton save = new JButton("Save");
		JButton add = new JButton("add");
		
		/**
		 * create JList left
		 */
		JList<Prototyp> prototypList = new JList<Prototyp>(zw.getPrototypes());
		
		/**
		 * create List mid
		 */
		DefaultListModel commands = new DefaultListModel<Command>();
		JList commandList = new JList(commands);
		JScrollPane scrollPane1 = new JScrollPane(commandList);
		
		
		/**
		 * add Buttons, JPanels and set Layout left side
		 */
		left.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		left.add(new JScrollPane(prototypList), BorderLayout.CENTER);
		left.add(leftSouth, BorderLayout.PAGE_END);
		left.add(leftNorth, BorderLayout.PAGE_START);
		leftNorth.add(new JTextArea("Prototypes"));
		leftSouth.add(add, BorderLayout.EAST);
		left.setBorder(BorderFactory.createLineBorder(Color.black));
		
		/**
		 * add Buttons, JPanels and set Layout of the center buttons
		 */
		center.add(centerSouth, BorderLayout.SOUTH);
		centerSouth.add(centerSouthLeft);
		centerSouth.add(centerSouthRight);
		centerSouthLeft.add(remove, BorderLayout.WEST);
		centerSouthRight.add(up);
		centerSouthRight.add(down);
		centerSouthRight.add(start);
		centerCenter.add(scrollPane1, BorderLayout.CENTER);
		center.setBorder(BorderFactory.createLineBorder(Color.black));
		
		/**
		 * add Buttons, JPanels and set Layout right side
		 */
		right.add(rightSouth, BorderLayout.SOUTH);
		rightSouth.add(save, BorderLayout.EAST);
		right.setBorder(BorderFactory.createLineBorder(Color.black));
		
		/**
		 * set Layout of JFrame
		 */
		c.weightx = 80;
		c.weighty = 80;
		total.add(left, c);
		c.weightx = 60;
		total.add(center, c);
		c.weightx = 200;
		total.add(right, c);
		c.gridy = 1;
		c.gridwidth = 3;
		total.add(bottom, c);

		total.setSize(1000, 500);
		total.setVisible(true);
		
		/**
		 *  ActionListener, creates the selected Prototyp
		 */
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				zw.addStep((Prototyp) prototypList.getSelectedValue());
				// TODO Auto-generated method stub

			}
		});
		
		/**
		 * add Actionlisteners
		 */
		remove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		up.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		down.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bottom.add(new JTextArea(zw.toString()));
			}
		});
				
	}

	public static void main(String[] args) {
		Zentralverwaltung zw = Zentralverwaltung.getInstance();
		VerwaltungView vv = new VerwaltungView(zw);
		// vv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// vv.pack();
		// vv.setVisible(true);

	}
}