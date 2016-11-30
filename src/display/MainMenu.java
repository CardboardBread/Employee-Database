package display;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

import database.Database;
import database.Employee;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1899909472206190456L;
	private static final int maxPageLength = 18;

	private JPanel contentPane;
	private JTextField searchField;
	private JList<String> employeeList;
	private String selected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0 };
		contentPane.setLayout(gbl_contentPane);

		JPanel GlobalContainer = new JPanel();
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
		GridBagConstraints gbc_globalControlLabel = new GridBagConstraints();
		gbc_globalControlLabel.insets = new Insets(0, 0, 5, 0);
		gbc_globalControlLabel.gridwidth = 4;
		gbc_globalControlLabel.gridx = 0;
		gbc_globalControlLabel.gridy = 0;
		GlobalContainer.add(globalControlLabel, gbc_globalControlLabel);

		JPanel ActionContainer = new JPanel();
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
		GridBagConstraints gbc_ViewContainer = new GridBagConstraints();
		gbc_ViewContainer.insets = new Insets(0, 5, 5, 5);
		gbc_ViewContainer.fill = GridBagConstraints.BOTH;
		gbc_ViewContainer.gridx = 0;
		gbc_ViewContainer.gridy = 1;
		contentPane.add(ViewContainer, gbc_ViewContainer);
		ViewContainer.setLayout(new BorderLayout(0, 0));

		JPanel ListContainer = new JPanel();
		ListContainer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_ListContainer = new GridBagConstraints();
		gbc_ListContainer.insets = new Insets(0, 0, 5, 5);
		gbc_ListContainer.fill = GridBagConstraints.BOTH;
		gbc_ListContainer.gridx = 1;
		gbc_ListContainer.gridy = 1;
		contentPane.add(ListContainer, gbc_ListContainer);
		GridBagLayout gbl_ListContainer = new GridBagLayout();
		gbl_ListContainer.columnWidths = new int[] { 0 };
		gbl_ListContainer.rowHeights = new int[] { 0 };
		gbl_ListContainer.columnWeights = new double[] { 1.0, 0.0 };
		gbl_ListContainer.rowWeights = new double[] { 1.0, 0.0 };
		ListContainer.setLayout(gbl_ListContainer);

		JButton previousPageButton = new JButton("Previous");
		previousPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_previousPageButton = new GridBagConstraints();
		gbc_previousPageButton.anchor = GridBagConstraints.SOUTHWEST;
		gbc_previousPageButton.gridx = 0;
		gbc_previousPageButton.gridy = 1;
		ListContainer.add(previousPageButton, gbc_previousPageButton);

		JButton nextPageButton = new JButton("Next");
		nextPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_nextPageButton = new GridBagConstraints();
		gbc_nextPageButton.anchor = GridBagConstraints.SOUTHEAST;
		gbc_nextPageButton.gridx = 1;
		gbc_nextPageButton.gridy = 1;
		ListContainer.add(nextPageButton, gbc_nextPageButton);

		JPanel ListHolder = new JPanel();
		GridBagConstraints gbc_ListHolder = new GridBagConstraints();
		gbc_ListHolder.gridwidth = 2;
		gbc_ListHolder.insets = new Insets(5, 5, 5, 5);
		gbc_ListHolder.fill = GridBagConstraints.BOTH;
		gbc_ListHolder.gridx = 0;
		gbc_ListHolder.gridy = 0;
		ListContainer.add(ListHolder, gbc_ListHolder);

		employeeList = new JList<String>();
		employeeList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				selected = employeeList.getSelectedValue();
			}
		});
		employeeList.setVisibleRowCount(21);
		employeeList.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = -7298468375848165951L;
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

	public boolean isInt(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			return false;
		}
		return true;
	}

	public void search(int search) {
		ArrayList<Employee> formatted = new ArrayList<Employee>();
		formatted.add(database.Database.table.searchEmployee(search));
		int distance = 1;
		while (formatted.size() < maxPageLength) {
			Employee above = database.Database.table.searchEmployee(search + distance);
			Employee below = database.Database.table.searchEmployee(search - distance);
			if (above != null) {
				formatted.add(above);
			}
			if (below != null) {
				formatted.add(below);
			}
			distance++;
		}
	}

	public void populate(ArrayList<Employee> in) {
		ArrayList<String> data = new ArrayList<String>();
		for (Employee emp : in) {
			data.add(emp.toString());
		}
		while (data.size() < maxPageLength) {
			data.add("");
		}
		while (data.size() > maxPageLength) {
			data.remove(data.size() - 1);
		}
		employeeList.setListData(data.toArray(new String[data.size()]));
	}

	public JList<String> getEmployeeList() {
		return employeeList;
	}
}
