package display;

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
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

import database.Employee;
import database.FullTimeEmployee;
import database.PartTimeEmployee;

import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.util.Objects;
import java.awt.event.ItemEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Record extends JFrame {

	private static final long serialVersionUID = 6107647818353986406L;
	private final int xLength = 500;
	private final int yLength = 370;

	private JPanel contentPane;
	private JTextField nameEntryField;
	private JTextField identEntryField;
	private JComboBox<String> sexEntryField;
	private JComboBox<String> workEntryField;
	private JRadioButton partTimeButton;
	private JRadioButton fullTimeButton;
	private JTextField fullDeductibleField;
	private JTextField fullSeniorityField;
	private JTextField fullSalaryField;
	private JTextField fullAnnualField;
	private JPanel fullContainer;
	private JPanel partContainer;
	private JTextField partDeductibleField;
	private JTextField partWorkField;
	private JTextField partWageField;
	private JTextField partHPWField;
	private JTextField partHPYField;
	private JTextField partWeeklyWageField;
	private JTextField partYearlyWageField;

	private boolean employeeType = true;
	private String firstName;
	private String lastName;
	private String ident;
	private String sex;
	private String workLocation;
	private String fullDeductible;
	private String partDeductible;
	private String workTerm;
	private String seniority;
	private String hourlyWage;
	private String hoursPerWeek;
	private String hoursPerYear;
	private String salary;
	private String annual;
	private String weeklyWage;
	private String yearlyWage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Record frame = new Record("Test GUI",
							new FullTimeEmployee(10, "test", "man", "yes", "place land", 0.25F, 0.25F, 1));
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
	public Record(String title, Employee subject) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, xLength, yLength);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		contentPane.setLayout(gbl_contentPane);

		if (subject != null) {
			firstName = subject.getFirst();
			lastName = subject.getLast();
			ident = Integer.toString(subject.getNum());
			sex = subject.getSex();
			workLocation = subject.getWorkLoc();
			if (subject.getClass() == database.FullTimeEmployee.class) {
				fullDeductible = Float.toString(((FullTimeEmployee) subject).getDeductible());
				salary = Float.toString(((FullTimeEmployee) subject).getSalary());
				seniority = Integer.toString(((FullTimeEmployee) subject).getSeniority());
				annual = Float.toString(((FullTimeEmployee) subject).calcAnnualSalary());
			} else if (subject.getClass() == database.PartTimeEmployee.class) {
				partDeductible = Float.toString(((PartTimeEmployee) subject).getDeductible());
				workTerm = Integer.toString(((PartTimeEmployee) subject).getWorkTerm());
				hourlyWage = Float.toString(((PartTimeEmployee) subject).getHourlyWage());
				hoursPerWeek = Float.toString(((PartTimeEmployee) subject).getHoursPerWeek());
				hoursPerYear = Float.toString(((PartTimeEmployee) subject).getHoursPerYear());
				weeklyWage = Float.toString(((PartTimeEmployee) subject).calcWeeklyWage());
				yearlyWage = Float.toString(((PartTimeEmployee) subject).calcYearlyWage());
			}
		} else {
			firstName = "";
			lastName = "";
			ident = "0";
			sex = "Other";
			workLocation = "N/A";
			fullDeductible = "0";
			salary = "0";
			seniority = "0";
			annual = "0";
			partDeductible = "0";
			workTerm = "0";
			hourlyWage = "0";
			hoursPerWeek = "0";
			hoursPerYear = "0";
			weeklyWage = "0";
			yearlyWage = "0";
		}

		JLabel nameField = new JLabel("Employee Name:");
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(5, 5, 5, 5);
		gbc_nameField.anchor = GridBagConstraints.EAST;
		gbc_nameField.gridx = 0;
		gbc_nameField.gridy = 0;
		contentPane.add(nameField, gbc_nameField);

		nameEntryField = new JTextField();
		nameEntryField.setText(firstName + " " + lastName);
		addChangeListener(nameEntryField, e -> {
			String[] split = nameEntryField.getText().split(" ");
			firstName = split[0];
			lastName = split[split.length - 1];
		});
		GridBagConstraints gbc_nameEntryField = new GridBagConstraints();
		gbc_nameEntryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameEntryField.gridwidth = 2;
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

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 1;
		gbc_horizontalStrut.gridy = 1;
		contentPane.add(horizontalStrut, gbc_horizontalStrut);

		identEntryField = new JTextField();
		identEntryField.setText(ident);
		addChangeListener(identEntryField, e -> ident = identEntryField.getText());
		GridBagConstraints gbc_identEntryField = new GridBagConstraints();
		gbc_identEntryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_identEntryField.gridwidth = 2;
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

		workEntryField = new JComboBox<String>();
		workEntryField.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Brampton", "Burlington", "Etobicoke", "Markham", "Milton", "Mississauga", "North York",
						"Oakville", "Richmond Hill", "Scarborough", "Toronto", "Vaughan" }));
		workEntryField.setEditable(true);
		workEntryField.setSelectedItem(workLocation);
		workEntryField.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				workLocation = (String) workEntryField.getSelectedItem();
			}
		});
		GridBagConstraints gbc_workEntryField = new GridBagConstraints();
		gbc_workEntryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_workEntryField.insets = new Insets(0, 0, 5, 0);
		gbc_workEntryField.gridwidth = 2;
		gbc_workEntryField.gridx = 2;
		gbc_workEntryField.gridy = 2;
		contentPane.add(workEntryField, gbc_workEntryField);

		JLabel sexField = new JLabel("Sex:");
		GridBagConstraints gbc_sexField = new GridBagConstraints();
		gbc_sexField.anchor = GridBagConstraints.EAST;
		gbc_sexField.insets = new Insets(0, 0, 5, 5);
		gbc_sexField.gridx = 0;
		gbc_sexField.gridy = 3;
		contentPane.add(sexField, gbc_sexField);

		sexEntryField = new JComboBox<String>();
		sexEntryField.setModel(new DefaultComboBoxModel<String>(new String[] { "Male", "Female", "Other" }));
		sexEntryField.setEditable(true);
		sexEntryField.setSelectedItem(sex);
		sexEntryField.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				sex = (String) sexEntryField.getSelectedItem();
			}
		});
		GridBagConstraints gbc_sexEntryField = new GridBagConstraints();
		gbc_sexEntryField.gridwidth = 2;
		gbc_sexEntryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_sexEntryField.insets = new Insets(0, 0, 5, 0);
		gbc_sexEntryField.gridx = 2;
		gbc_sexEntryField.gridy = 3;
		contentPane.add(sexEntryField, gbc_sexEntryField);

		JLabel typeField = new JLabel("Employee Type:");
		GridBagConstraints gbc_typeField = new GridBagConstraints();
		gbc_typeField.insets = new Insets(0, 0, 5, 5);
		gbc_typeField.gridx = 0;
		gbc_typeField.gridy = 4;
		contentPane.add(typeField, gbc_typeField);

		fullTimeButton = new JRadioButton("Full Time");
		fullTimeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeeType = true;
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
				employeeType = false;
				partTimeButton.setSelected(true);
				fullTimeButton.setSelected(false);
				partContainer.setVisible(true);
				fullContainer.setVisible(false);
			}
		});
		GridBagConstraints gbc_partTimeButton = new GridBagConstraints();
		gbc_partTimeButton.insets = new Insets(0, 0, 5, 0);
		gbc_partTimeButton.gridx = 3;
		gbc_partTimeButton.gridy = 4;
		contentPane.add(partTimeButton, gbc_partTimeButton);

		JPanel typeContainer = new JPanel();
		typeContainer.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_typeContainer = new GridBagConstraints();
		gbc_typeContainer.gridwidth = 4;
		gbc_typeContainer.insets = new Insets(0, 0, 5, 0);
		gbc_typeContainer.fill = GridBagConstraints.BOTH;
		gbc_typeContainer.gridx = 0;
		gbc_typeContainer.gridy = 5;
		contentPane.add(typeContainer, gbc_typeContainer);
		GridBagLayout gbl_typeContainer = new GridBagLayout();
		gbl_typeContainer.columnWeights = new double[] { 1.0 };
		gbl_typeContainer.rowWeights = new double[] { 1.0 };
		typeContainer.setLayout(gbl_typeContainer);

		fullContainer = new JPanel();
		fullContainer.setBorder(null);
		GridBagConstraints gbc_fullContainer = new GridBagConstraints();
		gbc_fullContainer.insets = new Insets(5, 5, 5, 5);
		gbc_fullContainer.fill = GridBagConstraints.BOTH;
		gbc_fullContainer.gridx = 0;
		gbc_fullContainer.gridy = 0;
		typeContainer.add(fullContainer, gbc_fullContainer);
		GridBagLayout gbl_fullContainer = new GridBagLayout();
		gbl_fullContainer.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_fullContainer.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_fullContainer.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0 };
		gbl_fullContainer.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		fullContainer.setLayout(gbl_fullContainer);

		JLabel fullDeductibleLabel = new JLabel("Deductible:");
		GridBagConstraints gbc_fullDeductibleLabel = new GridBagConstraints();
		gbc_fullDeductibleLabel.anchor = GridBagConstraints.EAST;
		gbc_fullDeductibleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fullDeductibleLabel.gridx = 0;
		gbc_fullDeductibleLabel.gridy = 0;
		fullContainer.add(fullDeductibleLabel, gbc_fullDeductibleLabel);

		fullDeductibleField = new JTextField();
		fullDeductibleField.setText(fullDeductible);
		addChangeListener(fullDeductibleField, e -> {
			if (isFloat(fullDeductibleField.getText())) {
				fullDeductible = fullDeductibleField.getText();
				annual = Float.toString(Float.parseFloat(salary) * (1 - Float.parseFloat(fullDeductible)));
				fullAnnualField.setText(annual);
			}
		});
		GridBagConstraints gbc_fullDeductibleField = new GridBagConstraints();
		gbc_fullDeductibleField.insets = new Insets(0, 0, 5, 5);
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
		fullSeniorityField.setText(seniority);
		addChangeListener(fullSeniorityField, e -> seniority = fullSeniorityField.getText());
		GridBagConstraints gbc_fullSeniorityField = new GridBagConstraints();
		gbc_fullSeniorityField.insets = new Insets(0, 0, 5, 5);
		gbc_fullSeniorityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fullSeniorityField.gridx = 1;
		gbc_fullSeniorityField.gridy = 1;
		fullContainer.add(fullSeniorityField, gbc_fullSeniorityField);
		fullSeniorityField.setColumns(10);

		JLabel fullSalaryLabel = new JLabel("Salary:");
		GridBagConstraints gbc_fullSalaryLabel = new GridBagConstraints();
		gbc_fullSalaryLabel.anchor = GridBagConstraints.EAST;
		gbc_fullSalaryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fullSalaryLabel.gridx = 2;
		gbc_fullSalaryLabel.gridy = 0;
		fullContainer.add(fullSalaryLabel, gbc_fullSalaryLabel);

		fullSalaryField = new JTextField();
		fullSalaryField.setText(salary);
		addChangeListener(fullSalaryField, e -> {
			if (isFloat(fullSalaryField.getText())) {
				salary = fullSalaryField.getText();
				annual = Float.toString(Float.parseFloat(salary) * (1 - Float.parseFloat(fullDeductible)));
				fullAnnualField.setText(annual);
			}
		});
		GridBagConstraints gbc_fullSalaryField = new GridBagConstraints();
		gbc_fullSalaryField.insets = new Insets(0, 0, 5, 0);
		gbc_fullSalaryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fullSalaryField.gridx = 3;
		gbc_fullSalaryField.gridy = 0;
		fullContainer.add(fullSalaryField, gbc_fullSalaryField);
		fullSalaryField.setColumns(10);

		JLabel fullAnnualLabel = new JLabel("Annual:");
		GridBagConstraints gbc_fullAnnualLabel = new GridBagConstraints();
		gbc_fullAnnualLabel.anchor = GridBagConstraints.EAST;
		gbc_fullAnnualLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fullAnnualLabel.gridx = 2;
		gbc_fullAnnualLabel.gridy = 1;
		fullContainer.add(fullAnnualLabel, gbc_fullAnnualLabel);

		fullAnnualField = new JTextField();
		fullAnnualField.setText(annual);
		fullAnnualField.setEditable(false);
		GridBagConstraints gbc_fullAnnualField = new GridBagConstraints();
		gbc_fullAnnualField.insets = new Insets(0, 0, 5, 0);
		gbc_fullAnnualField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fullAnnualField.gridx = 3;
		gbc_fullAnnualField.gridy = 1;
		fullContainer.add(fullAnnualField, gbc_fullAnnualField);
		fullAnnualField.setColumns(10);

		partContainer = new JPanel();
		partContainer.setVisible(false);
		partContainer.setBorder(null);
		GridBagConstraints gbc_partContainer = new GridBagConstraints();
		gbc_partContainer.insets = new Insets(5, 5, 5, 5);
		gbc_partContainer.fill = GridBagConstraints.BOTH;
		gbc_partContainer.gridx = 0;
		gbc_partContainer.gridy = 0;
		typeContainer.add(partContainer, gbc_partContainer);
		GridBagLayout gbl_partContainer = new GridBagLayout();
		gbl_partContainer.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_partContainer.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_partContainer.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_partContainer.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		partContainer.setLayout(gbl_partContainer);

		JLabel partDeductibleLabel = new JLabel("Deductible:");
		GridBagConstraints gbc_partDeductibleLabel = new GridBagConstraints();
		gbc_partDeductibleLabel.anchor = GridBagConstraints.EAST;
		gbc_partDeductibleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_partDeductibleLabel.gridx = 0;
		gbc_partDeductibleLabel.gridy = 0;
		partContainer.add(partDeductibleLabel, gbc_partDeductibleLabel);

		partDeductibleField = new JTextField();
		partDeductibleField.setText(partDeductible);
		addChangeListener(partDeductibleField, e -> {
			if (isFloat(partDeductibleField.getText())) {
				partDeductible = partDeductibleField.getText();
				weeklyWage = Float.toString((Float.parseFloat(hourlyWage) * Float.parseFloat(hoursPerWeek))
						* (1 - Float.parseFloat(partDeductible)));
				yearlyWage = Float.toString((Float.parseFloat(hourlyWage) * Float.parseFloat(hoursPerYear))
						* (1 - Float.parseFloat(partDeductible)));
				partWeeklyWageField.setText(weeklyWage);
				partYearlyWageField.setText(yearlyWage);
			}
		});
		GridBagConstraints gbc_partDeductibleField = new GridBagConstraints();
		gbc_partDeductibleField.insets = new Insets(0, 0, 5, 5);
		gbc_partDeductibleField.fill = GridBagConstraints.HORIZONTAL;
		gbc_partDeductibleField.gridx = 1;
		gbc_partDeductibleField.gridy = 0;
		partContainer.add(partDeductibleField, gbc_partDeductibleField);
		partDeductibleField.setColumns(10);

		JLabel partHPYLabel = new JLabel("Hours Per Year:");
		GridBagConstraints gbc_partHPYLabel = new GridBagConstraints();
		gbc_partHPYLabel.anchor = GridBagConstraints.EAST;
		gbc_partHPYLabel.insets = new Insets(0, 0, 5, 5);
		gbc_partHPYLabel.gridx = 2;
		gbc_partHPYLabel.gridy = 0;
		partContainer.add(partHPYLabel, gbc_partHPYLabel);

		partHPYField = new JTextField();
		addChangeListener(partHPYField, e -> {
			if (isFloat(partHPYField.getText())) {
				hoursPerYear = partHPYField.getText();
				yearlyWage = Float.toString((Float.parseFloat(hourlyWage) * Float.parseFloat(hoursPerYear))
						* (1 - Float.parseFloat(partDeductible)));
				partYearlyWageField.setText(yearlyWage);
			}
		});
		GridBagConstraints gbc_partHPYField = new GridBagConstraints();
		gbc_partHPYField.insets = new Insets(0, 0, 5, 0);
		gbc_partHPYField.fill = GridBagConstraints.HORIZONTAL;
		gbc_partHPYField.gridx = 3;
		gbc_partHPYField.gridy = 0;
		partContainer.add(partHPYField, gbc_partHPYField);
		partHPYField.setColumns(10);

		JLabel partWorkLabel = new JLabel("Work Term:");
		GridBagConstraints gbc_partWorkLabel = new GridBagConstraints();
		gbc_partWorkLabel.anchor = GridBagConstraints.EAST;
		gbc_partWorkLabel.insets = new Insets(0, 0, 5, 5);
		gbc_partWorkLabel.gridx = 0;
		gbc_partWorkLabel.gridy = 1;
		partContainer.add(partWorkLabel, gbc_partWorkLabel);

		partWorkField = new JTextField();
		partWorkField.setText(workTerm);
		addChangeListener(partWorkField, e -> workTerm = partWorkField.getText());
		partWorkField.setColumns(10);
		GridBagConstraints gbc_partWorkField = new GridBagConstraints();
		gbc_partWorkField.insets = new Insets(0, 0, 5, 5);
		gbc_partWorkField.fill = GridBagConstraints.HORIZONTAL;
		gbc_partWorkField.gridx = 1;
		gbc_partWorkField.gridy = 1;
		partContainer.add(partWorkField, gbc_partWorkField);

		JLabel partWeeklyWageLabel = new JLabel("Weekly Wage:");
		GridBagConstraints gbc_partWeeklyWageLabel = new GridBagConstraints();
		gbc_partWeeklyWageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_partWeeklyWageLabel.gridx = 2;
		gbc_partWeeklyWageLabel.gridy = 1;
		partContainer.add(partWeeklyWageLabel, gbc_partWeeklyWageLabel);

		partWeeklyWageField = new JTextField();
		partWeeklyWageField.setEditable(false);
		GridBagConstraints gbc_partWeeklyWageField = new GridBagConstraints();
		gbc_partWeeklyWageField.insets = new Insets(0, 0, 5, 0);
		gbc_partWeeklyWageField.fill = GridBagConstraints.HORIZONTAL;
		gbc_partWeeklyWageField.gridx = 3;
		gbc_partWeeklyWageField.gridy = 1;
		partContainer.add(partWeeklyWageField, gbc_partWeeklyWageField);
		partWeeklyWageField.setColumns(10);

		JLabel partWageLabel = new JLabel("Hourly Wage:");
		GridBagConstraints gbc_partWageLabel = new GridBagConstraints();
		gbc_partWageLabel.anchor = GridBagConstraints.EAST;
		gbc_partWageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_partWageLabel.gridx = 0;
		gbc_partWageLabel.gridy = 2;
		partContainer.add(partWageLabel, gbc_partWageLabel);

		partWageField = new JTextField();
		addChangeListener(partWageField, e -> {
			if (isFloat(partWageField.getText())) {
				hourlyWage = partWageField.getText();
				weeklyWage = Float.toString((Float.parseFloat(hourlyWage) * Float.parseFloat(hoursPerWeek))
						* (1 - Float.parseFloat(partDeductible)));
				yearlyWage = Float.toString((Float.parseFloat(hourlyWage) * Float.parseFloat(hoursPerYear))
						* (1 - Float.parseFloat(partDeductible)));
				partWeeklyWageField.setText(weeklyWage);
				partYearlyWageField.setText(yearlyWage);
			}
		});
		partWageField.setColumns(10);
		GridBagConstraints gbc_partWageField = new GridBagConstraints();
		gbc_partWageField.insets = new Insets(0, 0, 5, 5);
		gbc_partWageField.fill = GridBagConstraints.HORIZONTAL;
		gbc_partWageField.gridx = 1;
		gbc_partWageField.gridy = 2;
		partContainer.add(partWageField, gbc_partWageField);

		JLabel partYearlyWageLabel = new JLabel("Yearly Wage:");
		GridBagConstraints gbc_partYearlyWageLabel = new GridBagConstraints();
		gbc_partYearlyWageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_partYearlyWageLabel.gridx = 2;
		gbc_partYearlyWageLabel.gridy = 2;
		partContainer.add(partYearlyWageLabel, gbc_partYearlyWageLabel);

		partYearlyWageField = new JTextField();
		partYearlyWageField.setEditable(false);
		GridBagConstraints gbc_partYearlyWageField = new GridBagConstraints();
		gbc_partYearlyWageField.insets = new Insets(0, 0, 5, 0);
		gbc_partYearlyWageField.fill = GridBagConstraints.HORIZONTAL;
		gbc_partYearlyWageField.gridx = 3;
		gbc_partYearlyWageField.gridy = 2;
		partContainer.add(partYearlyWageField, gbc_partYearlyWageField);
		partYearlyWageField.setColumns(10);

		JLabel partHPWLabel = new JLabel("Hours Per Week:");
		GridBagConstraints gbc_partHPWLabel = new GridBagConstraints();
		gbc_partHPWLabel.anchor = GridBagConstraints.EAST;
		gbc_partHPWLabel.insets = new Insets(0, 0, 5, 5);
		gbc_partHPWLabel.gridx = 0;
		gbc_partHPWLabel.gridy = 3;
		partContainer.add(partHPWLabel, gbc_partHPWLabel);

		partHPWField = new JTextField();
		addChangeListener(partHPWField, e -> {
			if (isFloat(partHPWField.getText())) {
				hoursPerWeek = partHPWField.getText();
				weeklyWage = Float.toString((Float.parseFloat(hourlyWage) * Float.parseFloat(hoursPerWeek))
						* (1 - Float.parseFloat(partDeductible)));
				partWeeklyWageField.setText(weeklyWage);
			}
		});
		partHPWField.setColumns(10);
		GridBagConstraints gbc_partHPWField = new GridBagConstraints();
		gbc_partHPWField.insets = new Insets(0, 0, 5, 5);
		gbc_partHPWField.fill = GridBagConstraints.HORIZONTAL;
		gbc_partHPWField.gridx = 1;
		gbc_partHPWField.gridy = 3;
		partContainer.add(partHPWField, gbc_partHPWField);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit();
			}
		});

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.anchor = GridBagConstraints.WEST;
		gbc_cancelButton.insets = new Insets(0, 0, 0, 5);
		gbc_cancelButton.gridx = 0;
		gbc_cancelButton.gridy = 6;
		contentPane.add(cancelButton, gbc_cancelButton);
		GridBagConstraints gbc_okButton = new GridBagConstraints();
		gbc_okButton.anchor = GridBagConstraints.EAST;
		gbc_okButton.ipadx = 20;
		gbc_okButton.gridx = 3;
		gbc_okButton.gridy = 6;
		contentPane.add(okButton, gbc_okButton);
	}

	public void submit() {
		if (employeeType) {
			database.Database.submitEmployee(
					new FullTimeEmployee(Integer.parseInt(ident), firstName, lastName, sex, workLocation,
							Float.parseFloat(salary), Float.parseFloat(fullDeductible), Integer.parseInt(seniority)));
		} else {
			database.Database.submitEmployee(new PartTimeEmployee(Integer.parseInt(ident), firstName, lastName, sex,
					workLocation, Float.parseFloat(hourlyWage), Float.parseFloat(partDeductible),
					Float.parseFloat(hoursPerWeek), Float.parseFloat(hoursPerYear), Integer.parseInt(workTerm)));
		}
		cancel();
	}

	public void cancel() {
		setVisible(false);
		dispose();
	}

	public boolean isFloat(String str) {
		try {
			Float.parseFloat(str);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isInt(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Installs a listener to receive notification when the text of any
	 * {@code JTextComponent} is changed. Internally, it installs a
	 * {@link DocumentListener} on the text component's {@link Document}, and a
	 * {@link PropertyChangeListener} on the text component to detect if the
	 * {@code Document} itself is replaced.
	 * 
	 * @author Boann
	 * 
	 * @param text
	 *            any text component, such as a {@link JTextField} or
	 *            {@link JTextArea}
	 * @param changeListener
	 *            a listener to receive {@link ChangeEvent}s when the text is
	 *            changed; the source object for the events will be the text
	 *            component
	 * @throws NullPointerException
	 *             if either parameter is null
	 */
	public static void addChangeListener(JTextComponent text, ChangeListener changeListener) {
		Objects.requireNonNull(text);
		Objects.requireNonNull(changeListener);
		DocumentListener dl = new DocumentListener() {
			private int lastChange = 0, lastNotifiedChange = 0;

			@Override
			public void insertUpdate(DocumentEvent e) {
				changedUpdate(e);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				changedUpdate(e);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				lastChange++;
				SwingUtilities.invokeLater(() -> {
					if (lastNotifiedChange != lastChange) {
						lastNotifiedChange = lastChange;
						changeListener.stateChanged(new ChangeEvent(text));
					}
				});
			}
		};
		text.addPropertyChangeListener("document", (PropertyChangeEvent e) -> {
			Document d1 = (Document) e.getOldValue();
			Document d2 = (Document) e.getNewValue();
			if (d1 != null)
				d1.removeDocumentListener(dl);
			if (d2 != null)
				d2.addDocumentListener(dl);
			dl.changedUpdate(null);
		});
		Document d = text.getDocument();
		if (d != null)
			d.addDocumentListener(dl);
	}

}
