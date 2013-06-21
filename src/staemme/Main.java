package staemme;


import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import entities.Unit;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;

public class Main {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final JTextField woodCapacy = new JTextField();
	private JTextField ironCapacy;
	private JTextField clayCapacy;
	private ArrayList<Unit> units;
	private JTable table_1;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		units = initializeUnits();
	}	
	
	private ArrayList<Unit> initializeUnits()
	{
		ArrayList<Unit> units = new ArrayList<Unit>();
		units.add(new Unit(50,30,10, "/units/unit_spear.png"));
		units.add(new Unit(30, 30, 70,"/units/unit_sword.png"));

		
		return units;
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Units bauen", null, panel_1, null);
		panel_1.setLayout(null);
		woodCapacy.setBounds(59, 11, 86, 20);
		panel_1.add(woodCapacy);
		woodCapacy.setColumns(10);
		
		JLabel lblWood = new JLabel("");
		lblWood.setVerticalAlignment(SwingConstants.TOP);
		lblWood.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblWood.setIcon(new ImageIcon(Main.class.getResource("/ress/holz.png")));
		lblWood.setBounds(25, 17, 27, 14);
		panel_1.add(lblWood);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Main.class.getResource("/ress/lehm.png")));
		lblNewLabel_1.setBounds(173, 17, 27, 14);
		panel_1.add(lblNewLabel_1);
		
		clayCapacy = new JTextField();
		clayCapacy.setColumns(10);
		clayCapacy.setBounds(205, 11, 86, 20);
		panel_1.add(clayCapacy);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/ress/eisen.png")));
		label.setBounds(332, 17, 27, 14);
		panel_1.add(label);
		
		ironCapacy = new JTextField();
		ironCapacy.setColumns(10);
		ironCapacy.setBounds(362, 11, 86, 20);
		panel_1.add(ironCapacy);
		
		JButton calculate = new JButton("berechne");
		calculate.setBounds(480, 10, 89, 23);
		panel_1.add(calculate);
		
		table = new JTable();
		JLabel testLabel = new JLabel("asfd");
		table.setRowSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		Object[][] data = new Object[][] {
//				{null, null, null},
//				{null, null, null},
//			};
//		String[] columnNames = new String[] {
//				"New column", "New column", "New column"
//			};
		Vector rowA = new Vector();
		rowA.add(testLabel);
		Vector data = new Vector();
		data.add(rowA);
		Vector columnNames = new Vector();
		columnNames.add("bla");
		table.setModel(new DefaultTableModel(data,columnNames));
		table.setBounds(10, 76, 559, 247);
		
		panel_1.add(table);
		
		
		
		
		
		JPanel troopStrengh = new JPanel();
		tabbedPane.addTab("Truppen St\u00E4rke", null, troopStrengh, null);
	}
}
