package view;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComponent;

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
public class VerwaltungView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Zentralverwaltung zw;

	public VerwaltungView(Zentralverwaltung zw) {
		super("Verwaltung");
		this.zw = zw;
		JFrame total = new JFrame("Mega geiles Programm");
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		total.setLayout(gb);
		
		/**
		 * create menu
		 */
		//Create the menu bar.
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenu menuHelp = new JMenu("Help");
		
		JMenuItem menuFileLoad = new JMenuItem("Load File");
		JMenuItem menuFileSave = new JMenuItem("Save File");
		menuFile.add(menuFileLoad);
		menuFile.add(menuFileSave);
		
		JMenuItem menuHelpItem = new JMenuItem("Help text of Programmm...");
		menuHelp.add(menuHelpItem);
		
		menuBar.add(menuFile);
		menuBar.add(menuHelp);
		total.setJMenuBar(menuBar);
		
		
		
		
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
		JPanel rightCenter = new JPanel();
		
		//TODO: Create JPanels for all types of Commands 
		JPanel rightDirection = new JPanel(new GridLayout(1,1));
		rightDirection.add(new JLabel("Grad: "));
		JTextField grad = new JTextField();
		rightDirection.add(grad);
		
		JPanel rightGear = new JPanel(new GridLayout(2,1));
		rightGear.add(new JLabel("Speed: "));
		JTextField speed = new JTextField();
		rightGear.add(speed);
		rightGear.add(new JLabel("Duration: "));
		JTextField duration = new JTextField();
		rightGear.add(duration);
		
		JPanel rightGoto = new JPanel(new GridLayout(1,1));
		rightGoto.add(new JLabel("Jump Adress: "));
		JTextField jumpAdress = new JTextField();
		rightGoto.add(jumpAdress);
		
		JRadioButton ja = new JRadioButton("JA", false);
		JRadioButton nein = new JRadioButton("NEIN", true);
		/**
		 * GRoup the Radio Buttons
		 */
		ButtonGroup group = new ButtonGroup();
		group.add(ja);
		group.add(nein);
		JPanel rightIf = new JPanel(new GridLayout(2,1));
		rightIf.add(ja);
		rightIf.add(nein);
//		JTextField reference = new JTextField();
//		reference.setEditable(false);
//		rightIf.add(new JLabel("Reference: "));
//		rightIf.add(reference);
		
		JPanel rightAssignment = new JPanel(new GridLayout(1,1));
		rightAssignment.add(new JLabel("Operand: "));
		JTextField operand = new JTextField();
		rightAssignment.add(operand);
		
		
		
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
		//JButton save = new JButton("Save");
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
		leftNorth.add(new JLabel("Prototypes"));
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
		right.add(rightCenter, BorderLayout.CENTER);
		rightSouth.add(new JLabel("Bitte geben Sie die Daten ein und drücken Sie Enter"));
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
				zw.removeStep(table.getSelectedRow());
				table.updateUI();

			}
		});
		up.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i = table.getSelectedRow();
				zw.incOrder(i);
				table.updateUI();
				table.changeSelection(--i, 1, false, false);
			}
		});
		down.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i = table.getSelectedRow();
				zw.decOrder(i);
				table.updateUI();
				table.changeSelection(++i, 1, false, false);
			}
		});
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				output.append(zw.toString()+"\n");
			}
		});
		grad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Direction bla = (Direction) zw.getProgrammablauf().get(table.getSelectedRow());
					int degreeZahl = Integer.parseInt(e.getActionCommand());
					bla.setDegree(degreeZahl);
					table.updateUI();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
		});
		speed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Gear bla = (Gear)zw.getProgrammablauf().get(table.getSelectedRow());
					int speedZahl = Integer.parseInt(e.getActionCommand());
					bla.setSpeed(speedZahl);
					table.updateUI();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				
			}
		});
		duration.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Gear bla = (Gear)zw.getProgrammablauf().get(table.getSelectedRow());
					int durationZahl = Integer.parseInt(e.getActionCommand());
					bla.setDuration(durationZahl);
					table.updateUI();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
		});
		jumpAdress.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Goto bla = (Goto)zw.getProgrammablauf().get(table.getSelectedRow());
					int adressZahl = Integer.parseInt(e.getActionCommand());
					bla.setJumpAdress(adressZahl);
					table.updateUI();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
		});
		operand.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Assignment bla = (Assignment)zw.getProgrammablauf().get(table.getSelectedRow());
					bla.setOperand(e.getActionCommand());
					table.updateUI();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
		});
		/**
		 * ActionListener fuer ja/nein
		 */
		ja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				If bla = (If)zw.getProgrammablauf().get(table.getSelectedRow());
				bla.setReference(true);
				table.updateUI();
			}
		});
		nein.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				If bla = (If)zw.getProgrammablauf().get(table.getSelectedRow());
				bla.setReference(false);
				table.updateUI();
			}
		});
		menuFileLoad.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fC = new JFileChooser();
				fC.showOpenDialog(total);
				zw.laden(fC.getSelectedFile());
				table.updateUI();
				output.append("File loaded... \n");
				
				
			}
			
		});
		menuFileSave.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fC = new JFileChooser();
				fC.showSaveDialog(total);
				zw.speichern(null,fC.getSelectedFile());
				output.append("File saved... \n");
			}
			
		});
		
		
		table.getSelectionModel().addListSelectionListener( new ListSelectionListener() {
	        public void valueChanged(ListSelectionEvent event) {
	            if (event.getValueIsAdjusting()) {
	                return;
	            }
	            //TODO: Add Command-JPanels to switch statement
	            rightCenter.removeAll();
	            switch (zw.getProgrammablauf().get(table.getSelectedRow()).getName()){
	            case "Gear":
	            	rightCenter.add(rightGear);
	            	break;
	            case "Direction":
	            	rightCenter.add(rightDirection);
	            	break;
	            case "Goto":
	            	rightCenter.add(rightGoto);
	            	break;
	            case "If":
	            	rightCenter.add(rightIf);
	            	break;
	            case "Assignment":
	            	rightCenter.add(rightAssignment);
	            	break;
	            	
	            		
	            }
	            rightCenter.updateUI();
	            //System.out.println("new row selected!!");
	            
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