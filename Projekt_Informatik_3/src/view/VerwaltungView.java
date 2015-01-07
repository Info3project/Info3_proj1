package view;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

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
		//DefaultListModel commands = new DefaultListModel<Command>();
		//JList commandList = new JList(commands);
		//JScrollPane scrollPane1 = new JScrollPane(commandList);
		class MyTableModel extends AbstractTableModel{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] columnNames ={"No.","Command","Config"};
			public int getColumnCount() {
				return columnNames.length;
			}
			public int getRowCount(){
				return zw.getProgrammablauf().size();
			}
			public String getColumnName(int col) {
	            return columnNames[col];
	        }
			public Object getValueAt(int row, int col){
				if (col==0) return (Object) zw.getProgrammablauf().get(row).getStepID();
				else if (col==1) return (Object) zw.getProgrammablauf().get(row).getName();
				else /*(col==2)*/ return (Object) zw.getProgrammablauf().get(row).getConfig();
			}
		}
		JTable table = new JTable(new MyTableModel());
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		//table.setRowSelectionAllowed(true);
		//table.setColumnSelectionAllowed(false);
		//table.setCellSelectionEnabled(false);
		
		table.setFillsViewportHeight(true);
		
		
		
		
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
		center.add(centerCenter, BorderLayout.CENTER);
		centerSouth.add(centerSouthLeft);
		centerSouth.add(centerSouthRight);
		centerSouthLeft.add(remove, BorderLayout.WEST);
		centerSouthRight.add(up);
		centerSouthRight.add(down);
		centerSouthRight.add(start);
		centerCenter.add(new JScrollPane(table), BorderLayout.CENTER);
		center.setBorder(BorderFactory.createLineBorder(Color.black));
		
		/**
		 * add Buttons, JPanels and set Layout right side
		 */
		right.add(rightSouth, BorderLayout.SOUTH);
		rightSouth.add(save, BorderLayout.EAST);
		right.setBorder(BorderFactory.createLineBorder(Color.black));
		
		/**
		 * set Layout bottom side
		 */
		JTextArea output = new JTextArea("Welcome to our wonderfully charming program ;) \n",8,70);
		output.setEditable(false);
		bottom.add( new JScrollPane(output), BorderLayout.CENTER);
		
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
				if (prototypList.isSelectionEmpty()){
					output.append("you need to select a prototype to be added to Commands list \n");
				}else{
					output.append("added "+prototypList.getSelectedValue()+" to Commands list \n");
					table.updateUI();
					zw.addStep((Prototyp) prototypList.getSelectedValue());
				}

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
				output.append(zw.toString()+"\n");
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