package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

import database.Database;
import database.Employee;
import database.FullTimeEmployee;
import database.PartTimeEmployee;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1899909472206190456L;
	private static final int maxPageLength = 18;

	private JPanel contentPane;
	private JTextField searchField;
	private JList<String> employeeList;
	private JTextField identField;
	private JTextField nameField;
	private JTextField workLocationField;
	private JTextField sexField;
	private JTextField fullSalaryField;
	private JTextField fullDeductibleField;
	private JTextField fullSeniorityField;
	private JTextField partWageField;
	private JTextField partDeductibleField;
	private JTextField partHPWField;
	private JTextField partHPYField;
	private JTextField partWorkField;
	private JPanel panelFullTimeInfo;
	private JPanel panelPartTimeInfo;

	private String selected;
	private ArrayList<Employee[]> employees;
	private int pageSelected;

	/**
	 * Test the application.
	 */
	public static void test() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu("Title goes here...");
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
	public MainMenu(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0 };
		contentPane.setLayout(gbl_contentPane);

		JPanel GlobalContainer = new JPanel();
		GlobalContainer.setBackground(Color.WHITE);
		GlobalContainer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_GlobalContainer = new GridBagConstraints();
		gbc_GlobalContainer.insets = new Insets(5, 5, 5, 5);
		gbc_GlobalContainer.fill = GridBagConstraints.BOTH;
		gbc_GlobalContainer.gridx = 0;
		gbc_GlobalContainer.gridy = 0;
		contentPane.add(GlobalContainer, gbc_GlobalContainer);
		GridBagLayout gbl_GlobalContainer = new GridBagLayout();
		gbl_GlobalContainer.columnWidths = new int[] { 53, 57, 0, 55 };
		gbl_GlobalContainer.rowHeights = new int[] { 10, 10 };
		gbl_GlobalContainer.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0 };
		gbl_GlobalContainer.rowWeights = new double[] { 0.0, 0.0 };
		GlobalContainer.setLayout(gbl_GlobalContainer);

		JButton newButton = new JButton("New");
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				database.Database.newDatabase();
			}
		});
		GridBagConstraints gbc_newButton = new GridBagConstraints();
		gbc_newButton.fill = GridBagConstraints.BOTH;
		gbc_newButton.insets = new Insets(0, 0, 0, 5);
		gbc_newButton.gridx = 0;
		gbc_newButton.gridy = 1;
		GlobalContainer.add(newButton, gbc_newButton);

		JButton saveDatabaseButton = new JButton("Save");
		saveDatabaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				database.Database.saveDatabase();
			}
		});
		GridBagConstraints gbc_saveDatabaseButton = new GridBagConstraints();
		gbc_saveDatabaseButton.fill = GridBagConstraints.BOTH;
		gbc_saveDatabaseButton.insets = new Insets(0, 3, 0, 5);
		gbc_saveDatabaseButton.gridx = 1;
		gbc_saveDatabaseButton.gridy = 1;
		GlobalContainer.add(saveDatabaseButton, gbc_saveDatabaseButton);

		JButton saveAsButton = new JButton("Save As...");
		saveAsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				database.Database.saveDatabaseAs();
			}
		});
		GridBagConstraints gbc_saveAsButton = new GridBagConstraints();
		gbc_saveAsButton.insets = new Insets(0, 0, 0, 5);
		gbc_saveAsButton.gridx = 2;
		gbc_saveAsButton.gridy = 1;
		GlobalContainer.add(saveAsButton, gbc_saveAsButton);

		JButton loadDatabaseButton = new JButton("Load");
		loadDatabaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				database.Database.loadDatabase();
			}
		});
		GridBagConstraints gbc_loadDatabaseButton = new GridBagConstraints();
		gbc_loadDatabaseButton.fill = GridBagConstraints.BOTH;
		gbc_loadDatabaseButton.insets = new Insets(0, 3, 0, 0);
		gbc_loadDatabaseButton.gridx = 3;
		gbc_loadDatabaseButton.gridy = 1;
		GlobalContainer.add(loadDatabaseButton, gbc_loadDatabaseButton);

		JLabel globalControlLabel = new JLabel("Database Controls");
		globalControlLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_globalControlLabel = new GridBagConstraints();
		gbc_globalControlLabel.insets = new Insets(0, 0, 5, 0);
		gbc_globalControlLabel.gridwidth = 4;
		gbc_globalControlLabel.gridx = 0;
		gbc_globalControlLabel.gridy = 0;
		GlobalContainer.add(globalControlLabel, gbc_globalControlLabel);

		JPanel ActionContainer = new JPanel();
		ActionContainer.setBackground(Color.WHITE);
		ActionContainer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_ActionContainer = new GridBagConstraints();
		gbc_ActionContainer.insets = new Insets(5, 0, 5, 5);
		gbc_ActionContainer.fill = GridBagConstraints.BOTH;
		gbc_ActionContainer.gridx = 1;
		gbc_ActionContainer.gridy = 0;
		contentPane.add(ActionContainer, gbc_ActionContainer);
		GridBagLayout gbl_ActionContainer = new GridBagLayout();
		gbl_ActionContainer.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_ActionContainer.rowHeights = new int[] { 10, 10 };
		gbl_ActionContainer.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_ActionContainer.rowWeights = new double[] { 0.0, 0.0 };
		ActionContainer.setLayout(gbl_ActionContainer);

		JLabel employeeControlLabel = new JLabel("Employee Controls");
		employeeControlLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_employeeControlLabel = new GridBagConstraints();
		gbc_employeeControlLabel.insets = new Insets(0, 0, 5, 0);
		gbc_employeeControlLabel.gridwidth = 7;
		gbc_employeeControlLabel.gridx = 0;
		gbc_employeeControlLabel.gridy = 0;
		ActionContainer.add(employeeControlLabel, gbc_employeeControlLabel);

		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				database.Database.newEmployee();
			}
		});
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.insets = new Insets(0, 0, 0, 5);
		gbc_addButton.fill = GridBagConstraints.BOTH;
		gbc_addButton.gridx = 0;
		gbc_addButton.gridy = 1;
		ActionContainer.add(addButton, gbc_addButton);

		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selected != null) {
					try {
						int ident = Integer.parseInt(selected.split(" ")[0]);
						Database.deleteEmployee(ident);
					} catch (NumberFormatException nfe) {
						nfe.printStackTrace();
					}
				}
			}
		});
		GridBagConstraints gbc_deleteButton = new GridBagConstraints();
		gbc_deleteButton.fill = GridBagConstraints.BOTH;
		gbc_deleteButton.insets = new Insets(0, 3, 0, 5);
		gbc_deleteButton.gridx = 1;
		gbc_deleteButton.gridy = 1;
		ActionContainer.add(deleteButton, gbc_deleteButton);

		JButton editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.editEmployee(listToNum(selected));
			}
		});
		GridBagConstraints gbc_editButton = new GridBagConstraints();
		gbc_editButton.fill = GridBagConstraints.BOTH;
		gbc_editButton.insets = new Insets(0, 3, 0, 5);
		gbc_editButton.gridx = 2;
		gbc_editButton.gridy = 1;
		ActionContainer.add(editButton, gbc_editButton);

		JButton replaceButton = new JButton("Replace");
		replaceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database.editEmployee(listToNum(selected));
			}
		});
		GridBagConstraints gbc_replaceButton = new GridBagConstraints();
		gbc_replaceButton.fill = GridBagConstraints.BOTH;
		gbc_replaceButton.insets = new Insets(0, 3, 0, 5);
		gbc_replaceButton.gridx = 3;
		gbc_replaceButton.gridy = 1;
		ActionContainer.add(replaceButton, gbc_replaceButton);

		JLabel searchLabel = new JLabel("Search");
		GridBagConstraints gbc_searchLabel = new GridBagConstraints();
		gbc_searchLabel.fill = GridBagConstraints.BOTH;
		gbc_searchLabel.insets = new Insets(0, 3, 0, 5);
		gbc_searchLabel.gridx = 5;
		gbc_searchLabel.gridy = 1;
		ActionContainer.add(searchLabel, gbc_searchLabel);

		searchField = new JTextField();
		Record.addChangeListener(searchField, e -> {
			if (isInt(searchField.getText())) {
				search(Integer.parseInt(searchField.getText()));
			} else {
				populate(Database.table.toList());
			}
		});
		GridBagConstraints gbc_searchField = new GridBagConstraints();
		gbc_searchField.ipadx = 60;
		gbc_searchField.insets = new Insets(0, 3, 0, 0);
		gbc_searchField.fill = GridBagConstraints.BOTH;
		gbc_searchField.gridx = 6;
		gbc_searchField.gridy = 1;
		ActionContainer.add(searchField, gbc_searchField);
		searchField.setColumns(10);

		JPanel ViewContainer = new JPanel();
		ViewContainer.setBackground(Color.WHITE);
		ViewContainer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_ViewContainer = new GridBagConstraints();
		gbc_ViewContainer.insets = new Insets(0, 5, 5, 5);
		gbc_ViewContainer.fill = GridBagConstraints.BOTH;
		gbc_ViewContainer.gridx = 0;
		gbc_ViewContainer.gridy = 1;
		contentPane.add(ViewContainer, gbc_ViewContainer);
		GridBagLayout gbl_ViewContainer = new GridBagLayout();
		gbl_ViewContainer.columnWidths = new int[] { 0, 0, 0 };
		gbl_ViewContainer.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_ViewContainer.columnWeights = new double[] { 1.0, 1.0, 1.0 };
		gbl_ViewContainer.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		ViewContainer.setLayout(gbl_ViewContainer);

		JLabel identLabel = new JLabel("Employee ID:");
		identLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_identLabel = new GridBagConstraints();
		gbc_identLabel.anchor = GridBagConstraints.WEST;
		gbc_identLabel.insets = new Insets(0, 0, 5, 5);
		gbc_identLabel.gridx = 0;
		gbc_identLabel.gridy = 0;
		ViewContainer.add(identLabel, gbc_identLabel);

		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.anchor = GridBagConstraints.WEST;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 1;
		gbc_nameLabel.gridy = 0;
		ViewContainer.add(nameLabel, gbc_nameLabel);

		identField = new JTextField();
		identField.setEditable(false);
		GridBagConstraints gbc_identField = new GridBagConstraints();
		gbc_identField.insets = new Insets(0, 0, 5, 5);
		gbc_identField.fill = GridBagConstraints.HORIZONTAL;
		gbc_identField.gridx = 0;
		gbc_identField.gridy = 1;
		ViewContainer.add(identField, gbc_identField);
		identField.setColumns(10);

		nameField = new JTextField();
		nameField.setEditable(false);
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(0, 0, 5, 0);
		gbc_nameField.gridwidth = 2;
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 1;
		ViewContainer.add(nameField, gbc_nameField);
		nameField.setColumns(10);

		JLabel workLocationLabel = new JLabel("Work Location:");
		workLocationLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_workLocationLabel = new GridBagConstraints();
		gbc_workLocationLabel.anchor = GridBagConstraints.WEST;
		gbc_workLocationLabel.insets = new Insets(0, 0, 5, 5);
		gbc_workLocationLabel.gridx = 0;
		gbc_workLocationLabel.gridy = 2;
		ViewContainer.add(workLocationLabel, gbc_workLocationLabel);

		JLabel sexLabel = new JLabel("Sex:");
		sexLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_sexLabel = new GridBagConstraints();
		gbc_sexLabel.insets = new Insets(0, 0, 5, 5);
		gbc_sexLabel.anchor = GridBagConstraints.WEST;
		gbc_sexLabel.gridx = 2;
		gbc_sexLabel.gridy = 2;
		ViewContainer.add(sexLabel, gbc_sexLabel);

		workLocationField = new JTextField();
		workLocationField.setEditable(false);
		GridBagConstraints gbc_workLocationField = new GridBagConstraints();
		gbc_workLocationField.gridwidth = 2;
		gbc_workLocationField.insets = new Insets(0, 0, 5, 5);
		gbc_workLocationField.fill = GridBagConstraints.HORIZONTAL;
		gbc_workLocationField.gridx = 0;
		gbc_workLocationField.gridy = 3;
		ViewContainer.add(workLocationField, gbc_workLocationField);
		workLocationField.setColumns(10);

		sexField = new JTextField();
		sexField.setEditable(false);
		GridBagConstraints gbc_sexField = new GridBagConstraints();
		gbc_sexField.insets = new Insets(0, 0, 5, 0);
		gbc_sexField.fill = GridBagConstraints.HORIZONTAL;
		gbc_sexField.gridx = 2;
		gbc_sexField.gridy = 3;
		ViewContainer.add(sexField, gbc_sexField);
		sexField.setColumns(10);

		JPanel panelExtendedEmployeeInfo = new JPanel();
		panelExtendedEmployeeInfo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panelExtendedEmployeeInfo = new GridBagConstraints();
		gbc_panelExtendedEmployeeInfo.gridheight = 3;
		gbc_panelExtendedEmployeeInfo.gridwidth = 3;
		gbc_panelExtendedEmployeeInfo.fill = GridBagConstraints.BOTH;
		gbc_panelExtendedEmployeeInfo.gridx = 0;
		gbc_panelExtendedEmployeeInfo.gridy = 4;
		ViewContainer.add(panelExtendedEmployeeInfo, gbc_panelExtendedEmployeeInfo);
		panelExtendedEmployeeInfo.setLayout(new CardLayout(0, 0));

		panelFullTimeInfo = new JPanel();
		panelExtendedEmployeeInfo.add(panelFullTimeInfo, "name_3892476439700159");
		GridBagLayout gbl_panelFullTimeInfo = new GridBagLayout();
		gbl_panelFullTimeInfo.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelFullTimeInfo.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelFullTimeInfo.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panelFullTimeInfo.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelFullTimeInfo.setLayout(gbl_panelFullTimeInfo);

		JLabel lblFullTimeEmployee = new JLabel("Full Time Employee");
		lblFullTimeEmployee.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblFullTimeEmployee = new GridBagConstraints();
		gbc_lblFullTimeEmployee.gridwidth = 3;
		gbc_lblFullTimeEmployee.insets = new Insets(0, 0, 5, 5);
		gbc_lblFullTimeEmployee.gridx = 0;
		gbc_lblFullTimeEmployee.gridy = 0;
		panelFullTimeInfo.add(lblFullTimeEmployee, gbc_lblFullTimeEmployee);

		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblSalary = new GridBagConstraints();
		gbc_lblSalary.anchor = GridBagConstraints.WEST;
		gbc_lblSalary.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalary.gridx = 0;
		gbc_lblSalary.gridy = 1;
		panelFullTimeInfo.add(lblSalary, gbc_lblSalary);

		fullSalaryField = new JTextField();
		fullSalaryField.setEditable(false);
		GridBagConstraints gbc_fullSalaryField = new GridBagConstraints();
		gbc_fullSalaryField.gridwidth = 3;
		gbc_fullSalaryField.insets = new Insets(0, 0, 5, 5);
		gbc_fullSalaryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fullSalaryField.gridx = 0;
		gbc_fullSalaryField.gridy = 2;
		panelFullTimeInfo.add(fullSalaryField, gbc_fullSalaryField);
		fullSalaryField.setColumns(10);

		JLabel lblDeductable = new JLabel("Deductable:");
		lblDeductable.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblDeductable = new GridBagConstraints();
		gbc_lblDeductable.anchor = GridBagConstraints.WEST;
		gbc_lblDeductable.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeductable.gridx = 0;
		gbc_lblDeductable.gridy = 3;
		panelFullTimeInfo.add(lblDeductable, gbc_lblDeductable);

		fullDeductibleField = new JTextField();
		fullDeductibleField.setEditable(false);
		GridBagConstraints gbc_fullDeductibleField = new GridBagConstraints();
		gbc_fullDeductibleField.gridwidth = 3;
		gbc_fullDeductibleField.insets = new Insets(0, 0, 5, 5);
		gbc_fullDeductibleField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fullDeductibleField.gridx = 0;
		gbc_fullDeductibleField.gridy = 4;
		panelFullTimeInfo.add(fullDeductibleField, gbc_fullDeductibleField);
		fullDeductibleField.setColumns(10);

		JLabel lblSeniority = new JLabel("Seniority:");
		lblSeniority.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblSeniority = new GridBagConstraints();
		gbc_lblSeniority.anchor = GridBagConstraints.WEST;
		gbc_lblSeniority.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeniority.gridx = 0;
		gbc_lblSeniority.gridy = 5;
		panelFullTimeInfo.add(lblSeniority, gbc_lblSeniority);

		fullSeniorityField = new JTextField();
		fullSeniorityField.setEditable(false);
		GridBagConstraints gbc_fullSeniorityField = new GridBagConstraints();
		gbc_fullSeniorityField.gridwidth = 3;
		gbc_fullSeniorityField.insets = new Insets(0, 0, 0, 5);
		gbc_fullSeniorityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fullSeniorityField.gridx = 0;
		gbc_fullSeniorityField.gridy = 6;
		panelFullTimeInfo.add(fullSeniorityField, gbc_fullSeniorityField);
		fullSeniorityField.setColumns(10);

		panelPartTimeInfo = new JPanel();
		panelExtendedEmployeeInfo.add(panelPartTimeInfo, "name_3892498524926794");

		JPanel panel = new JPanel();
		panelPartTimeInfo.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel PartTimeEmployeeLabel = new JLabel("Part Time Employee");
		PartTimeEmployeeLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_PartTimeEmployeeLabel = new GridBagConstraints();
		gbc_PartTimeEmployeeLabel.gridwidth = 3;
		gbc_PartTimeEmployeeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PartTimeEmployeeLabel.gridx = 0;
		gbc_PartTimeEmployeeLabel.gridy = 0;
		panel.add(PartTimeEmployeeLabel, gbc_PartTimeEmployeeLabel);

		JLabel partWageLabel = new JLabel("Hourly Wage");
		partWageLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_partWageLabel = new GridBagConstraints();
		gbc_partWageLabel.anchor = GridBagConstraints.WEST;
		gbc_partWageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_partWageLabel.gridx = 0;
		gbc_partWageLabel.gridy = 1;
		panel.add(partWageLabel, gbc_partWageLabel);

		partWageField = new JTextField();
		partWageField.setEditable(false);
		partWageField.setColumns(10);
		GridBagConstraints gbc_partWageField = new GridBagConstraints();
		gbc_partWageField.fill = GridBagConstraints.HORIZONTAL;
		gbc_partWageField.gridwidth = 3;
		gbc_partWageField.insets = new Insets(0, 0, 5, 5);
		gbc_partWageField.gridx = 0;
		gbc_partWageField.gridy = 2;
		panel.add(partWageField, gbc_partWageField);

		JLabel partDeductibleLabel = new JLabel("Deductible");
		partDeductibleLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_partDeductibleLabel = new GridBagConstraints();
		gbc_partDeductibleLabel.anchor = GridBagConstraints.WEST;
		gbc_partDeductibleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_partDeductibleLabel.gridx = 0;
		gbc_partDeductibleLabel.gridy = 3;
		panel.add(partDeductibleLabel, gbc_partDeductibleLabel);

		partDeductibleField = new JTextField();
		partDeductibleField.setEditable(false);
		partDeductibleField.setColumns(10);
		GridBagConstraints gbc_partDeductibleField = new GridBagConstraints();
		gbc_partDeductibleField.fill = GridBagConstraints.HORIZONTAL;
		gbc_partDeductibleField.gridwidth = 3;
		gbc_partDeductibleField.insets = new Insets(0, 0, 5, 5);
		gbc_partDeductibleField.gridx = 0;
		gbc_partDeductibleField.gridy = 4;
		panel.add(partDeductibleField, gbc_partDeductibleField);

		JLabel partHPWLabel = new JLabel("Hours Per Week");
		partHPWLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_partHPWLabel = new GridBagConstraints();
		gbc_partHPWLabel.anchor = GridBagConstraints.WEST;
		gbc_partHPWLabel.insets = new Insets(0, 0, 5, 5);
		gbc_partHPWLabel.gridx = 0;
		gbc_partHPWLabel.gridy = 5;
		panel.add(partHPWLabel, gbc_partHPWLabel);

		partHPWField = new JTextField();
		partHPWField.setEditable(false);
		partHPWField.setColumns(10);
		GridBagConstraints gbc_partHPWField = new GridBagConstraints();
		gbc_partHPWField.fill = GridBagConstraints.HORIZONTAL;
		gbc_partHPWField.gridwidth = 3;
		gbc_partHPWField.insets = new Insets(0, 0, 5, 5);
		gbc_partHPWField.gridx = 0;
		gbc_partHPWField.gridy = 6;
		panel.add(partHPWField, gbc_partHPWField);

		JLabel partHPYLabel = new JLabel("Hours Per Year");
		partHPYLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_partHPYLabel = new GridBagConstraints();
		gbc_partHPYLabel.insets = new Insets(0, 0, 5, 5);
		gbc_partHPYLabel.gridx = 0;
		gbc_partHPYLabel.gridy = 7;
		panel.add(partHPYLabel, gbc_partHPYLabel);

		partHPYField = new JTextField();
		partHPYField.setEditable(false);
		GridBagConstraints gbc_partHPYField = new GridBagConstraints();
		gbc_partHPYField.gridwidth = 3;
		gbc_partHPYField.insets = new Insets(0, 0, 5, 5);
		gbc_partHPYField.fill = GridBagConstraints.HORIZONTAL;
		gbc_partHPYField.gridx = 0;
		gbc_partHPYField.gridy = 8;
		panel.add(partHPYField, gbc_partHPYField);
		partHPYField.setColumns(10);

		JLabel partWorkLabel = new JLabel("Work Term");
		partWorkLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_partWorkLabel = new GridBagConstraints();
		gbc_partWorkLabel.insets = new Insets(0, 0, 5, 5);
		gbc_partWorkLabel.gridx = 0;
		gbc_partWorkLabel.gridy = 9;
		panel.add(partWorkLabel, gbc_partWorkLabel);

		partWorkField = new JTextField();
		partWorkField.setEditable(false);
		GridBagConstraints gbc_partWorkField = new GridBagConstraints();
		gbc_partWorkField.gridwidth = 3;
		gbc_partWorkField.insets = new Insets(0, 0, 0, 5);
		gbc_partWorkField.fill = GridBagConstraints.HORIZONTAL;
		gbc_partWorkField.gridx = 0;
		gbc_partWorkField.gridy = 10;
		panel.add(partWorkField, gbc_partWorkField);
		partWorkField.setColumns(10);

		JPanel ListContainer = new JPanel();
		ListContainer.setBackground(Color.WHITE);
		ListContainer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_ListContainer = new GridBagConstraints();
		gbc_ListContainer.insets = new Insets(0, 0, 5, 5);
		gbc_ListContainer.fill = GridBagConstraints.BOTH;
		gbc_ListContainer.gridx = 1;
		gbc_ListContainer.gridy = 1;
		contentPane.add(ListContainer, gbc_ListContainer);
		GridBagLayout gbl_ListContainer = new GridBagLayout();
		gbl_ListContainer.columnWidths = new int[] { 0 };
		gbl_ListContainer.rowHeights = new int[] {0, 0};
		gbl_ListContainer.columnWeights = new double[] { 1.0, 0.0 };
		gbl_ListContainer.rowWeights = new double[] { 1.0, 0.0 };
		ListContainer.setLayout(gbl_ListContainer);

		JButton previousPageButton = new JButton("Previous");
		previousPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousPage();
			}
		});
		GridBagConstraints gbc_previousPageButton = new GridBagConstraints();
		gbc_previousPageButton.insets = new Insets(0, 0, 5, 5);
		gbc_previousPageButton.anchor = GridBagConstraints.SOUTHWEST;
		gbc_previousPageButton.gridx = 0;
		gbc_previousPageButton.gridy = 1;
		ListContainer.add(previousPageButton, gbc_previousPageButton);

		JButton nextPageButton = new JButton("Next");
		nextPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextPage();
			}
		});
		GridBagConstraints gbc_nextPageButton = new GridBagConstraints();
		gbc_nextPageButton.insets = new Insets(0, 0, 5, 0);
		gbc_nextPageButton.anchor = GridBagConstraints.SOUTHEAST;
		gbc_nextPageButton.gridx = 1;
		gbc_nextPageButton.gridy = 1;
		ListContainer.add(nextPageButton, gbc_nextPageButton);

		JPanel ListHolder = new JPanel();
		GridBagConstraints gbc_ListHolder = new GridBagConstraints();
		gbc_ListHolder.gridwidth = 2;
		gbc_ListHolder.insets = new Insets(5, 5, 5, 0);
		gbc_ListHolder.fill = GridBagConstraints.BOTH;
		gbc_ListHolder.gridx = 0;
		gbc_ListHolder.gridy = 0;
		ListContainer.add(ListHolder, gbc_ListHolder);

		employeeList = new JList<String>();
		employeeList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				selected = employeeList.getSelectedValue();
				expandInfo(Database.table.searchEmployee(listToNum(selected)));
			}
		});
		employeeList.setVisibleRowCount(21);
		employeeList.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = -433516457112582L;
			String[] values = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
					"nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
					"eighteen", "nineteen", "twenty", "twenty one" };

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});
		ListHolder.add(employeeList);
	}

	private boolean isInt(String str) {
		if (str.isEmpty()) return false;
		return str.matches("[+-]?\\d*(\\.\\d+)?");
	}

	private void search(int search) {
		ArrayList<Employee> formatted = new ArrayList<Employee>();
		Employee result = Database.table.searchEmployee(search);
		if (result != null) {
			formatted.add(result);
			populate(formatted);
		}
	}

	public void populate(ArrayList<Employee> in) {
		employees = new ArrayList<Employee[]>();
		if (!in.isEmpty()) {
			int step = 0;
			float size = in.size();
			float length = maxPageLength;
			int pages = (int) Math.ceil(size / length);
			while (in.size() < pages * maxPageLength) {
				in.add(null);
			}
			for (int i = 0; i < pages; i++) {
				Employee[] page = new Employee[maxPageLength];
				for (int k = 0; k < page.length; k++) {
					page[k] = in.get(step);
					step++;
				}
				employees.add(page);
			}
			pageSelected = 0;
			displayPage(pageSelected);
		}
	}

	private void displayPage(int pageNum) {
		String[] data = new String[maxPageLength];
		Employee[] emplist = employees.get(pageNum);
		for (int i = 0; i < maxPageLength; i++) {
			try {
				data[i] = emplist[i].toString();
			} catch (NullPointerException npe) {
				data[i] = "";
			}
			
		}
		employeeList.setListData(data);
	}

	private int listToNum(String listItem) {
		if (listItem != null && !listItem.isEmpty()) {
			String[] split = listItem.split(" ");
			try {
				return Integer.parseInt(split[0]);
			} catch (NumberFormatException e) {
				System.out.println("Failed to parse " + split[0] + " as an employee number.");
				return -1;
			}
		} else {
			return -1;
		}
	}

	private void expandInfo(Employee view) {
		if (view != null) {
			identField.setText(Integer.toString(view.getNum()));
			nameField.setText(view.getFirst() + " " + view.getLast());
			workLocationField.setText(view.getWorkLoc());
			sexField.setText(view.getSex());
			if (view.getClass() == FullTimeEmployee.class) {
				fullDeductibleField.setText(Float.toString(((FullTimeEmployee) view).getDeductible()));
				fullSalaryField.setText(Float.toString(((FullTimeEmployee) view).getSalary()));
				fullSeniorityField.setText(Integer.toString(((FullTimeEmployee) view).getSeniority()));
				panelPartTimeInfo.setVisible(false);
				panelFullTimeInfo.setVisible(true);
			} else if (view.getClass() == PartTimeEmployee.class) {
				partDeductibleField.setText(Float.toString(((PartTimeEmployee) view).getDeductible()));
				partWorkField.setText(Integer.toString(((PartTimeEmployee) view).getWorkTerm()));
				partWageField.setText(Float.toString(((PartTimeEmployee) view).getHourlyWage()));
				partHPWField.setText(Float.toString(((PartTimeEmployee) view).getHoursPerWeek()));
				partHPYField.setText(Float.toString(((PartTimeEmployee) view).getHoursPerYear()));
				panelPartTimeInfo.setVisible(true);
				panelFullTimeInfo.setVisible(false);
			}
		}
	}

	private void nextPage() {
		if (pageSelected + 1 < employees.size()) {
			pageSelected++;
			displayPage(pageSelected);
		}
	}

	private void previousPage() {
		if (pageSelected > 0) {
			pageSelected--;
			displayPage(pageSelected);
		}
	}
	
	public void clearPage() {
		String[] data = new String[maxPageLength];
		employeeList.setListData(data);
	}
}
