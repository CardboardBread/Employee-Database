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
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AddRecord extends JFrame {

	private final String PART_TIME = "Part Time";
	private final String FULL_TIME = "Full Time";
	private JPanel contentPane;
	private JTextField nameEntryField;
	private JTextField identEntryField;
	private JTextField sexEntryField;
	private JTextField workEntryField;
	private String firstName;
	private String lastName;
	private String ident;
	private String sex;
	private String workLocation;
	private String employeeTypeLabel = FULL_TIME;
	private JRadioButton partTimeButton;
	private JRadioButton fullTimeButton;
	private JTextField fullDeductibleField;
	private JTextField fullSeniorityField;
	private JTextField fullSalaryField;
	private JTextField fullAnnualField;
	private JPanel fullContainer;
	private JPanel partContainer;
	private JTextField partDeductibleField;
	private JTextField partSeniorityField;
	private JTextField partSalaryField;
	private JTextField partAnnualField;

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
		setBounds(100, 100, 400, 320);
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
		
		fullTimeButton = new JRadioButton("Full Time");
		fullTimeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fullTimeButton.setSelected(true);
				partTimeButton.setSelected(false);
				fullContainer.setVisible(true);
				partContainer.setVisible(false);
			}
		});
		fullTimeButton.setSelected(true);
		GridBagConstraints gbc_fullTimeButton = new GridBagConstraints();
		gbc_fullTimeButton.insets = new Insets(0, 0, 5, 5);
		gbc_fullTimeButton.gridx = 2;
		gbc_fullTimeButton.gridy = 4;
		contentPane.add(fullTimeButton, gbc_fullTimeButton);
		
		partTimeButton = new JRadioButton("Part Time");
		partTimeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				partTimeButton.setSelected(true);
				fullTimeButton.setSelected(false);
				partContainer.setVisible(true);
				fullContainer.setVisible(false);
			}
		});
		GridBagConstraints gbc_partTimeButton = new GridBagConstraints();
		gbc_partTimeButton.insets = new Insets(0, 0, 5, 5);
		gbc_partTimeButton.gridx = 3;
		gbc_partTimeButton.gridy = 4;
		contentPane.add(partTimeButton, gbc_partTimeButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		
		JPanel typeContainer = new JPanel();
		GridBagConstraints gbc_typeContainer = new GridBagConstraints();
		gbc_typeContainer.gridwidth = 6;
		gbc_typeContainer.insets = new Insets(0, 0, 5, 5);
		gbc_typeContainer.fill = GridBagConstraints.BOTH;
		gbc_typeContainer.gridx = 0;
		gbc_typeContainer.gridy = 5;
		contentPane.add(typeContainer, gbc_typeContainer);
		GridBagLayout gbl_typeContainer = new GridBagLayout();
		gbl_typeContainer.columnWeights = new double[]{1.0};
		gbl_typeContainer.rowWeights = new double[]{1.0};
		typeContainer.setLayout(gbl_typeContainer);
		
		fullContainer = new JPanel();
		GridBagConstraints gbc_fullContainer = new GridBagConstraints();
		gbc_fullContainer.insets = new Insets(5, 5, 5, 5);
		gbc_fullContainer.fill = GridBagConstraints.BOTH;
		gbc_fullContainer.gridx = 0;
		gbc_fullContainer.gridy = 0;
		typeContainer.add(fullContainer, gbc_fullContainer);
		GridBagLayout gbl_fullContainer = new GridBagLayout();
		gbl_fullContainer.columnWidths = new int[]{0, 0, 0};
		gbl_fullContainer.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_fullContainer.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_fullContainer.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		fullContainer.setLayout(gbl_fullContainer);
		
		JLabel fullDeductibleLabel = new JLabel("Deductible:");
		GridBagConstraints gbc_fullDeductibleLabel = new GridBagConstraints();
		gbc_fullDeductibleLabel.anchor = GridBagConstraints.EAST;
		gbc_fullDeductibleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fullDeductibleLabel.gridx = 0;
		gbc_fullDeductibleLabel.gridy = 0;
		fullContainer.add(fullDeductibleLabel, gbc_fullDeductibleLabel);
		
		fullDeductibleField = new JTextField();
		GridBagConstraints gbc_fullDeductibleField = new GridBagConstraints();
		gbc_fullDeductibleField.insets = new Insets(0, 0, 5, 0);
		gbc_fullDeductibleField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fullDeductibleField.gridx = 1;
		gbc_fullDeductibleField.gridy = 0;
		fullContainer.add(fullDeductibleField, gbc_fullDeductibleField);
		fullDeductibleField.setColumns(10);
		
		JLabel fullSeniorityLabel = new JLabel("Seniority:");
		GridBagConstraints gbc_fullSeniorityLabel = new GridBagConstraints();
		gbc_fullSeniorityLabel.anchor = GridBagConstraints.EAST;
		gbc_fullSeniorityLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fullSeniorityLabel.gridx = 0;
		gbc_fullSeniorityLabel.gridy = 1;
		fullContainer.add(fullSeniorityLabel, gbc_fullSeniorityLabel);
		
		fullSeniorityField = new JTextField();
		GridBagConstraints gbc_fullSeniorityField = new GridBagConstraints();
		gbc_fullSeniorityField.insets = new Insets(0, 0, 5, 0);
		gbc_fullSeniorityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fullSeniorityField.gridx = 1;
		gbc_fullSeniorityField.gridy = 1;
		fullContainer.add(fullSeniorityField, gbc_fullSeniorityField);
		fullSeniorityField.setColumns(10);
		
		JLabel fullSalaryLabel = new JLabel("Salary:");
		GridBagConstraints gbc_fullSalaryLabel = new GridBagConstraints();
		gbc_fullSalaryLabel.anchor = GridBagConstraints.EAST;
		gbc_fullSalaryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fullSalaryLabel.gridx = 0;
		gbc_fullSalaryLabel.gridy = 2;
		fullContainer.add(fullSalaryLabel, gbc_fullSalaryLabel);
		
		fullSalaryField = new JTextField();
		GridBagConstraints gbc_fullSalaryField = new GridBagConstraints();
		gbc_fullSalaryField.insets = new Insets(0, 0, 5, 0);
		gbc_fullSalaryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fullSalaryField.gridx = 1;
		gbc_fullSalaryField.gridy = 2;
		fullContainer.add(fullSalaryField, gbc_fullSalaryField);
		fullSalaryField.setColumns(10);
		
		JLabel fullAnnualLabel = new JLabel("Annual:");
		GridBagConstraints gbc_fullAnnualLabel = new GridBagConstraints();
		gbc_fullAnnualLabel.anchor = GridBagConstraints.EAST;
		gbc_fullAnnualLabel.insets = new Insets(0, 0, 0, 5);
		gbc_fullAnnualLabel.gridx = 0;
		gbc_fullAnnualLabel.gridy = 3;
		fullContainer.add(fullAnnualLabel, gbc_fullAnnualLabel);
		
		fullAnnualField = new JTextField();
		fullAnnualField.setEditable(false);
		GridBagConstraints gbc_fullAnnualField = new GridBagConstraints();
		gbc_fullAnnualField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fullAnnualField.gridx = 1;
		gbc_fullAnnualField.gridy = 3;
		fullContainer.add(fullAnnualField, gbc_fullAnnualField);
		fullAnnualField.setColumns(10);
		
		partContainer = new JPanel();
		GridBagConstraints gbc_partContainer = new GridBagConstraints();
		gbc_partContainer.insets = new Insets(5, 5, 5, 5);
		gbc_partContainer.fill = GridBagConstraints.BOTH;
		gbc_partContainer.gridx = 0;
		gbc_partContainer.gridy = 0;
		typeContainer.add(partContainer, gbc_partContainer);
		GridBagLayout gbl_partContainer = new GridBagLayout();
		gbl_partContainer.columnWidths = new int[]{0, 0, 0};
		gbl_partContainer.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_partContainer.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_partContainer.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		partContainer.setLayout(gbl_partContainer);
		
		JLabel partDeductibleLabel = new JLabel("Deductible:");
		GridBagConstraints gbc_partDeductibleLabel = new GridBagConstraints();
		gbc_partDeductibleLabel.anchor = GridBagConstraints.EAST;
		gbc_partDeductibleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_partDeductibleLabel.gridx = 0;
		gbc_partDeductibleLabel.gridy = 0;
		partContainer.add(partDeductibleLabel, gbc_partDeductibleLabel);
		
		partDeductibleField = new JTextField();
		GridBagConstraints gbc_partDeductibleField = new GridBagConstraints();
		gbc_partDeductibleField.insets = new Insets(0, 0, 5, 0);
		gbc_partDeductibleField.fill = GridBagConstraints.HORIZONTAL;
		gbc_partDeductibleField.gridx = 1;
		gbc_partDeductibleField.gridy = 0;
		partContainer.add(partDeductibleField, gbc_partDeductibleField);
		partDeductibleField.setColumns(10);
		
		JLabel partSeniorityLabel = new JLabel("Work Term:");
		GridBagConstraints gbc_partSeniorityLabel = new GridBagConstraints();
		gbc_partSeniorityLabel.anchor = GridBagConstraints.EAST;
		gbc_partSeniorityLabel.insets = new Insets(0, 0, 5, 5);
		gbc_partSeniorityLabel.gridx = 0;
		gbc_partSeniorityLabel.gridy = 1;
		partContainer.add(partSeniorityLabel, gbc_partSeniorityLabel);
		
		partSeniorityField = new JTextField();
		partSeniorityField.setColumns(10);
		GridBagConstraints gbc_partSeniorityField = new GridBagConstraints();
		gbc_partSeniorityField.insets = new Insets(0, 0, 5, 0);
		gbc_partSeniorityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_partSeniorityField.gridx = 1;
		gbc_partSeniorityField.gridy = 1;
		partContainer.add(partSeniorityField, gbc_partSeniorityField);
		
		JLabel partSalaryLabel = new JLabel("Hourly Wage:");
		GridBagConstraints gbc_partSalaryLabel = new GridBagConstraints();
		gbc_partSalaryLabel.anchor = GridBagConstraints.EAST;
		gbc_partSalaryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_partSalaryLabel.gridx = 0;
		gbc_partSalaryLabel.gridy = 2;
		partContainer.add(partSalaryLabel, gbc_partSalaryLabel);
		
		partSalaryField = new JTextField();
		partSalaryField.setColumns(10);
		GridBagConstraints gbc_partSalaryField = new GridBagConstraints();
		gbc_partSalaryField.insets = new Insets(0, 0, 5, 0);
		gbc_partSalaryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_partSalaryField.gridx = 1;
		gbc_partSalaryField.gridy = 2;
		partContainer.add(partSalaryField, gbc_partSalaryField);
		
		JLabel partAnnualLabel = new JLabel("Weekly Wage:");
		GridBagConstraints gbc_partAnnualLabel = new GridBagConstraints();
		gbc_partAnnualLabel.anchor = GridBagConstraints.EAST;
		gbc_partAnnualLabel.insets = new Insets(0, 0, 0, 5);
		gbc_partAnnualLabel.gridx = 0;
		gbc_partAnnualLabel.gridy = 3;
		partContainer.add(partAnnualLabel, gbc_partAnnualLabel);
		
		partAnnualField = new JTextField();
		partAnnualField.setEditable(false);
		partAnnualField.setColumns(10);
		GridBagConstraints gbc_partAnnualField = new GridBagConstraints();
		gbc_partAnnualField.fill = GridBagConstraints.HORIZONTAL;
		gbc_partAnnualField.gridx = 1;
		gbc_partAnnualField.gridy = 3;
		partContainer.add(partAnnualField, gbc_partAnnualField);
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.insets = new Insets(0, 0, 0, 5);
		gbc_cancelButton.gridx = 2;
		gbc_cancelButton.gridy = 6;
		contentPane.add(cancelButton, gbc_cancelButton);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_okButton = new GridBagConstraints();
		gbc_okButton.insets = new Insets(0, 0, 0, 5);
		gbc_okButton.gridx = 3;
		gbc_okButton.gridy = 6;
		contentPane.add(okButton, gbc_okButton);
	}
	
	public void swapState(JRadioButton issuer, JRadioButton opposite) {
		issuer.setSelected(true);
		opposite.setSelected(false);
	}
	
	public void cancel() {
		setVisible(false);
		dispose();
	}

}
