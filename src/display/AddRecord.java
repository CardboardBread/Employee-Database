package display;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

public class AddRecord extends JFrame {

	private JPanel contentPane;
	private JTextField nameEntryField;
	private JTextField identEntryField;
	private JTextField sexEntryField;
	private JTextField workEntryField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRecord frame = new AddRecord();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddRecord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel nameField = new JLabel("Employee Name:");
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(5, 5, 5, 5);
		gbc_nameField.anchor = GridBagConstraints.EAST;
		gbc_nameField.gridx = 0;
		gbc_nameField.gridy = 0;
		contentPane.add(nameField, gbc_nameField);
		
		Component nameStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_nameStrut = new GridBagConstraints();
		gbc_nameStrut.anchor = GridBagConstraints.WEST;
		gbc_nameStrut.insets = new Insets(0, 0, 5, 5);
		gbc_nameStrut.gridx = 1;
		gbc_nameStrut.gridy = 0;
		contentPane.add(nameStrut, gbc_nameStrut);
		
		nameEntryField = new JTextField();
		GridBagConstraints gbc_nameEntryField = new GridBagConstraints();
		gbc_nameEntryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameEntryField.gridwidth = 3;
		gbc_nameEntryField.insets = new Insets(5, 0, 5, 0);
		gbc_nameEntryField.gridx = 2;
		gbc_nameEntryField.gridy = 0;
		contentPane.add(nameEntryField, gbc_nameEntryField);
		nameEntryField.setColumns(10);
		
		JLabel identField = new JLabel("Employee ID:");
		GridBagConstraints gbc_identField = new GridBagConstraints();
		gbc_identField.anchor = GridBagConstraints.EAST;
		gbc_identField.insets = new Insets(0, 0, 5, 5);
		gbc_identField.gridx = 0;
		gbc_identField.gridy = 1;
		contentPane.add(identField, gbc_identField);
		
		Component identStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_identStrut = new GridBagConstraints();
		gbc_identStrut.insets = new Insets(0, 0, 5, 5);
		gbc_identStrut.gridx = 1;
		gbc_identStrut.gridy = 1;
		contentPane.add(identStrut, gbc_identStrut);
		
		identEntryField = new JTextField();
		GridBagConstraints gbc_identEntryField = new GridBagConstraints();
		gbc_identEntryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_identEntryField.gridwidth = 3;
		gbc_identEntryField.insets = new Insets(0, 0, 5, 0);
		gbc_identEntryField.gridx = 2;
		gbc_identEntryField.gridy = 1;
		contentPane.add(identEntryField, gbc_identEntryField);
		identEntryField.setColumns(10);
		
		JLabel workField = new JLabel("Work Location:");
		GridBagConstraints gbc_workField = new GridBagConstraints();
		gbc_workField.anchor = GridBagConstraints.EAST;
		gbc_workField.insets = new Insets(0, 0, 5, 5);
		gbc_workField.gridx = 0;
		gbc_workField.gridy = 2;
		contentPane.add(workField, gbc_workField);
		
		Component workStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_workStrut = new GridBagConstraints();
		gbc_workStrut.insets = new Insets(0, 0, 5, 5);
		gbc_workStrut.gridx = 1;
		gbc_workStrut.gridy = 2;
		contentPane.add(workStrut, gbc_workStrut);
		
		workEntryField = new JTextField();
		GridBagConstraints gbc_workEntryField = new GridBagConstraints();
		gbc_workEntryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_workEntryField.insets = new Insets(0, 0, 5, 0);
		gbc_workEntryField.gridwidth = 3;
		gbc_workEntryField.gridx = 2;
		gbc_workEntryField.gridy = 2;
		contentPane.add(workEntryField, gbc_workEntryField);
		workEntryField.setColumns(10);
		
		JLabel sexField = new JLabel("Sex:");
		GridBagConstraints gbc_sexField = new GridBagConstraints();
		gbc_sexField.anchor = GridBagConstraints.EAST;
		gbc_sexField.insets = new Insets(0, 0, 5, 5);
		gbc_sexField.gridx = 0;
		gbc_sexField.gridy = 3;
		contentPane.add(sexField, gbc_sexField);
		
		Component sexStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_sexStrut = new GridBagConstraints();
		gbc_sexStrut.insets = new Insets(0, 0, 5, 5);
		gbc_sexStrut.gridx = 1;
		gbc_sexStrut.gridy = 3;
		contentPane.add(sexStrut, gbc_sexStrut);
		
		sexEntryField = new JTextField();
		GridBagConstraints gbc_sexEntryField = new GridBagConstraints();
		gbc_sexEntryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_sexEntryField.gridwidth = 3;
		gbc_sexEntryField.insets = new Insets(0, 0, 5, 0);
		gbc_sexEntryField.gridx = 2;
		gbc_sexEntryField.gridy = 3;
		contentPane.add(sexEntryField, gbc_sexEntryField);
		sexEntryField.setColumns(10);
		
		JLabel typeField = new JLabel("Employee Type:");
		GridBagConstraints gbc_typeField = new GridBagConstraints();
		gbc_typeField.insets = new Insets(0, 0, 5, 5);
		gbc_typeField.gridx = 0;
		gbc_typeField.gridy = 4;
		contentPane.add(typeField, gbc_typeField);
		
		Component typeStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_typeStrut = new GridBagConstraints();
		gbc_typeStrut.anchor = GridBagConstraints.WEST;
		gbc_typeStrut.insets = new Insets(0, 0, 5, 5);
		gbc_typeStrut.gridx = 1;
		gbc_typeStrut.gridy = 4;
		contentPane.add(typeStrut, gbc_typeStrut);
		
		JRadioButton defaultEmployeeButton = new JRadioButton("Standard");
		GridBagConstraints gbc_defaultEmployeeButton = new GridBagConstraints();
		gbc_defaultEmployeeButton.anchor = GridBagConstraints.WEST;
		gbc_defaultEmployeeButton.insets = new Insets(0, 0, 5, 5);
		gbc_defaultEmployeeButton.gridx = 2;
		gbc_defaultEmployeeButton.gridy = 4;
		contentPane.add(defaultEmployeeButton, gbc_defaultEmployeeButton);
		
		JRadioButton fullEmployeeButton = new JRadioButton("Full Time Employee");
		GridBagConstraints gbc_fullEmployeeButton = new GridBagConstraints();
		gbc_fullEmployeeButton.anchor = GridBagConstraints.WEST;
		gbc_fullEmployeeButton.insets = new Insets(0, 0, 5, 5);
		gbc_fullEmployeeButton.gridx = 3;
		gbc_fullEmployeeButton.gridy = 4;
		contentPane.add(fullEmployeeButton, gbc_fullEmployeeButton);
		
		JRadioButton partEmployeeButton = new JRadioButton("Part Time Employee");
		GridBagConstraints gbc_partEmployeeButton = new GridBagConstraints();
		gbc_partEmployeeButton.anchor = GridBagConstraints.WEST;
		gbc_partEmployeeButton.insets = new Insets(0, 0, 5, 0);
		gbc_partEmployeeButton.gridx = 4;
		gbc_partEmployeeButton.gridy = 4;
		contentPane.add(partEmployeeButton, gbc_partEmployeeButton);
		
		JTabbedPane employeeTimeField = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_employeeTimeField = new GridBagConstraints();
		gbc_employeeTimeField.gridwidth = 5;
		gbc_employeeTimeField.insets = new Insets(0, 5, 5, 0);
		gbc_employeeTimeField.fill = GridBagConstraints.BOTH;
		gbc_employeeTimeField.gridx = 0;
		gbc_employeeTimeField.gridy = 5;
		contentPane.add(employeeTimeField, gbc_employeeTimeField);
		
		JButton cancelButton = new JButton("Cancel");
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.insets = new Insets(0, 0, 0, 5);
		gbc_cancelButton.gridx = 2;
		gbc_cancelButton.gridy = 6;
		contentPane.add(cancelButton, gbc_cancelButton);
		
		JButton okButton = new JButton("OK");
		GridBagConstraints gbc_okButton = new GridBagConstraints();
		gbc_okButton.insets = new Insets(0, 0, 0, 5);
		gbc_okButton.gridx = 3;
		gbc_okButton.gridy = 6;
		contentPane.add(okButton, gbc_okButton);
	}

}
