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
		 * create JPanel left with Prototype List and add button
		 */
		JPanel left = new JPanel(new BorderLayout());
		JPanel leftNorth = new JPanel();
		JPanel leftSouth = new JPanel(new BorderLayout());
		JButton add = new JButton("add");
		JList<Prototyp> prototypList = new JList<Prototyp>(zw.getPrototypes());
		left.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);

		left.add(new JScrollPane(prototypList), BorderLayout.CENTER);
		left.add(leftSouth, BorderLayout.PAGE_END);
		left.add(leftNorth, BorderLayout.PAGE_START);
		leftNorth.add(new JTextArea("Prototypes"));
		leftSouth.add(add, BorderLayout.EAST);
		/**
		 * **************** ActionListener, creates the selected Prototyp
		 */
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				zw.addStep((Prototyp) prototypList.getSelectedValuesList());
				// TODO Auto-generated method stub

			}
		});
		left.setBorder(BorderFactory.createLineBorder(Color.black));

		/**
		 * create JPanel center with Programmablauf List and buttons remove, up,
		 * down start
		 */
		JPanel center = new JPanel(new BorderLayout());
		JPanel centerCenter = new JPanel(new BorderLayout());
		JPanel centerSouth = new JPanel(new GridLayout(1, 2));
		JPanel centerSouthLeft = new JPanel(new BorderLayout());
		JPanel centerSouthRight = new JPanel(new GridLayout(1, 3));

		/**
		 * create List mid
		 */
		final DefaultListModel commands = new DefaultListModel<Command>();
		JList commandList = new JList(commands);
		JScrollPane scrollPane1 = new JScrollPane(commandList);

		/**
		 * create JButtons
		 */
		JButton remove = new JButton("Remove");
		JButton up = new JButton("Up");
		JButton down = new JButton("Down");
		JButton start = new JButton("Start");

		/**
		 *  add Actionlisteners
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

		/**
		 * set position of the buttons
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
		 *  create Jpanel right with config editor
		 */
		JPanel right = new JPanel(new BorderLayout());
		JPanel rightSouth = new JPanel(new BorderLayout());
		JButton save = new JButton("Save");
		right.add(rightSouth, BorderLayout.SOUTH);
		rightSouth.add(save, BorderLayout.EAST);
		right.setBorder(BorderFactory.createLineBorder(Color.black));

		/**
		 *  create Jpanel bottom with text output
		 */
		JPanel bottom = new JPanel();
		bottom.add(new JTextArea("jlkjlkjlkj"));
		right.setBorder(BorderFactory.createLineBorder(Color.black));
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
	}

	public static void main(String[] args) {
		Zentralverwaltung zw = Zentralverwaltung.getInstance();
		VerwaltungView vv = new VerwaltungView(zw);
		// vv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// vv.pack();
		// vv.setVisible(true);

	}
}