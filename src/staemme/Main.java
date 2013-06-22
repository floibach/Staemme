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
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Main {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final JTextField woodCapacy = new JTextField();
	private JTextField ironCapacy;
	private JTextField clayCapacy;
	private JCheckBox isPike;
	private JCheckBox isSword;
	private JTextField testField;
	private JPanel unitsBuilding;
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
	}	
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		unitsBuilding = new JPanel();
		tabbedPane.addTab("Units bauen", null, unitsBuilding, null);
		unitsBuilding.setLayout(null);
		woodCapacy.setBounds(59, 11, 86, 20);
		unitsBuilding.add(woodCapacy);
		woodCapacy.setColumns(10);
		
		JLabel lblWood = new JLabel("");
		lblWood.setLabelFor(woodCapacy);
		lblWood.setVerticalAlignment(SwingConstants.TOP);
		lblWood.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblWood.setIcon(new ImageIcon(Main.class.getResource("/ress/holz.png")));
		lblWood.setBounds(25, 17, 27, 14);
		unitsBuilding.add(lblWood);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Main.class.getResource("/ress/lehm.png")));
		lblNewLabel_1.setBounds(173, 17, 27, 14);
		unitsBuilding.add(lblNewLabel_1);
		
		clayCapacy = new JTextField();
		lblNewLabel_1.setLabelFor(clayCapacy);
		clayCapacy.setColumns(10);
		clayCapacy.setBounds(205, 11, 86, 20);
		unitsBuilding.add(clayCapacy);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/ress/eisen.png")));
		label.setBounds(332, 17, 27, 14);
		unitsBuilding.add(label);
		
		ironCapacy = new JTextField();
		label.setLabelFor(ironCapacy);
		ironCapacy.setColumns(10);
		ironCapacy.setBounds(362, 11, 86, 20);
		unitsBuilding.add(ironCapacy);
		
		JButton calculate = new JButton("berechne");
		calculate.addActionListener(
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent arg0) 
					{
						start();
					}
				});
		calculate.setBounds(480, 10, 89, 23);
		unitsBuilding.add(calculate);
		
		
		isPike = new JCheckBox();
		isPike.setBounds(25, 42, 27, 23);
		unitsBuilding.add(isPike);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/units/unit_spear.png")));
		lblNewLabel.setLabelFor(isPike);
		lblNewLabel.setBounds(53, 42, 27, 23);
		unitsBuilding.add(lblNewLabel);
		
		isSword = new JCheckBox("");
		isSword.setBounds(122, 42, 27, 23);
		unitsBuilding.add(isSword);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Main.class.getResource("/units/unit_sword.png")));
		lblNewLabel_2.setLabelFor(isSword);
		lblNewLabel_2.setBounds(155, 42, 27, 23);
		unitsBuilding.add(lblNewLabel_2);
		
		

		
		JPanel troopStrengh = new JPanel();
		tabbedPane.addTab("Truppen St\u00E4rke", null, troopStrengh, null);
	}
	
	private void start()
	{
		ArrayList<Unit> selectedUnits = new ArrayList<Unit>();
		if(isPike.isSelected())
		{
			selectedUnits.add(new Unit(50,30,10, "/units/unit_spear.png"));		
		}
		if(isSword.isSelected())
		{
			selectedUnits.add(new Unit(30, 30, 70,"/units/unit_sword.png"));		
			
		}
		
		Calculator.calculate(selectedUnits);
		
		for(int i=0;i<selectedUnits.size();i++)
		{
			JLabel lblNewLabel_3 = new JLabel("New label");
			lblNewLabel_3.setBounds(25, 100+14*i+5, 60, 14);
			unitsBuilding.add(lblNewLabel_3);		
		}	
				
		unitsBuilding.repaint();
	}
}
