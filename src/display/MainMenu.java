package display;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private JTextField searchField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 501);
		contentPane = new JPanel();
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0, 0};
		gbl_contentPane.rowHeights = new int[] {0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0};
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
		gbl_GlobalContainer.columnWidths = new int[] {53, 57, 0, 55};
		gbl_GlobalContainer.rowHeights = new int[] {10, 10};
		gbl_GlobalContainer.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0};
		gbl_GlobalContainer.rowWeights = new double[]{0.0, 0.0};
		GlobalContainer.setLayout(gbl_GlobalContainer);
		
		JButton newButton = new JButton("New");
		GridBagConstraints gbc_newButton = new GridBagConstraints();
		gbc_newButton.fill = GridBagConstraints.BOTH;
		gbc_newButton.insets = new Insets(0, 0, 0, 5);
		gbc_newButton.gridx = 0;
		gbc_newButton.gridy = 1;
		GlobalContainer.add(newButton, gbc_newButton);
		
		JButton saveDatabaseButton = new JButton("Save");
		GridBagConstraints gbc_saveDatabaseButton = new GridBagConstraints();
		gbc_saveDatabaseButton.fill = GridBagConstraints.BOTH;
		gbc_saveDatabaseButton.insets = new Insets(0, 3, 0, 5);
		gbc_saveDatabaseButton.gridx = 1;
		gbc_saveDatabaseButton.gridy = 1;
		GlobalContainer.add(saveDatabaseButton, gbc_saveDatabaseButton);
		
		JButton btnSaveAs = new JButton("Save As...");
		GridBagConstraints gbc_btnSaveAs = new GridBagConstraints();
		gbc_btnSaveAs.insets = new Insets(0, 0, 0, 5);
		gbc_btnSaveAs.gridx = 2;
		gbc_btnSaveAs.gridy = 1;
		GlobalContainer.add(btnSaveAs, gbc_btnSaveAs);
		
		JButton loadDatabaseButton = new JButton("Load");
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
		gbl_ActionContainer.columnWidths = new int[] {0, 0, 0, 0, 0, 0};
		gbl_ActionContainer.rowHeights = new int[] {10, 10};
		gbl_ActionContainer.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_ActionContainer.rowWeights = new double[]{0.0, 0.0};
		ActionContainer.setLayout(gbl_ActionContainer);
		
		JLabel employeeControlLabel = new JLabel("Employee Controls");
		GridBagConstraints gbc_employeeControlLabel = new GridBagConstraints();
		gbc_employeeControlLabel.insets = new Insets(0, 0, 5, 0);
		gbc_employeeControlLabel.gridwidth = 7;
		gbc_employeeControlLabel.gridx = 0;
		gbc_employeeControlLabel.gridy = 0;
		ActionContainer.add(employeeControlLabel, gbc_employeeControlLabel);
		
		JButton addButton = new JButton("Add");
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.insets = new Insets(0, 0, 0, 5);
		gbc_addButton.fill = GridBagConstraints.BOTH;
		gbc_addButton.gridx = 0;
		gbc_addButton.gridy = 1;
		ActionContainer.add(addButton, gbc_addButton);
		
		JButton deleteButton = new JButton("Delete");
		GridBagConstraints gbc_deleteButton = new GridBagConstraints();
		gbc_deleteButton.fill = GridBagConstraints.BOTH;
		gbc_deleteButton.insets = new Insets(0, 3, 0, 5);
		gbc_deleteButton.gridx = 1;
		gbc_deleteButton.gridy = 1;
		ActionContainer.add(deleteButton, gbc_deleteButton);
		
		JButton editButton = new JButton("Edit");
		GridBagConstraints gbc_editButton = new GridBagConstraints();
		gbc_editButton.fill = GridBagConstraints.BOTH;
		gbc_editButton.insets = new Insets(0, 3, 0, 5);
		gbc_editButton.gridx = 2;
		gbc_editButton.gridy = 1;
		ActionContainer.add(editButton, gbc_editButton);
		
		JButton replaceButton = new JButton("Replace");
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
		GridBagConstraints gbc_ListContainer = new GridBagConstraints();
		gbc_ListContainer.insets = new Insets(0, 0, 5, 5);
		gbc_ListContainer.fill = GridBagConstraints.BOTH;
		gbc_ListContainer.gridx = 1;
		gbc_ListContainer.gridy = 1;
		contentPane.add(ListContainer, gbc_ListContainer);
		
		JList list = new JList();
		ListContainer.add(list);
	}

}
