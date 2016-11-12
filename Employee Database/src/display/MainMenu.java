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

public class MainMenu extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[] {0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.anchor = GridBagConstraints.WEST;
		gbc_toolBar.gridwidth = 2;
		gbc_toolBar.insets = new Insets(0, 0, 5, 5);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		contentPane.add(toolBar, gbc_toolBar);
		
		JPanel GlobalContainer = new JPanel();
		FlowLayout flowLayout = (FlowLayout) GlobalContainer.getLayout();
		GridBagConstraints gbc_GlobalContainer = new GridBagConstraints();
		gbc_GlobalContainer.insets = new Insets(0, 0, 5, 5);
		gbc_GlobalContainer.fill = GridBagConstraints.BOTH;
		gbc_GlobalContainer.gridx = 0;
		gbc_GlobalContainer.gridy = 1;
		contentPane.add(GlobalContainer, gbc_GlobalContainer);
		
		JButton saveDatabaseButton = new JButton("Save");
		GlobalContainer.add(saveDatabaseButton);
		
		JButton loadDatabaseButton = new JButton("Load");
		GlobalContainer.add(loadDatabaseButton);
		
		JButton exitButton = new JButton("Exit");
		GlobalContainer.add(exitButton);
		
		JPanel ActionContainer = new JPanel();
		GridBagConstraints gbc_ActionContainer = new GridBagConstraints();
		gbc_ActionContainer.insets = new Insets(0, 0, 5, 0);
		gbc_ActionContainer.fill = GridBagConstraints.BOTH;
		gbc_ActionContainer.gridx = 1;
		gbc_ActionContainer.gridy = 1;
		contentPane.add(ActionContainer, gbc_ActionContainer);
		
		JPanel ViewContainer = new JPanel();
		GridBagConstraints gbc_ViewContainer = new GridBagConstraints();
		gbc_ViewContainer.insets = new Insets(0, 0, 0, 5);
		gbc_ViewContainer.fill = GridBagConstraints.BOTH;
		gbc_ViewContainer.gridx = 0;
		gbc_ViewContainer.gridy = 2;
		contentPane.add(ViewContainer, gbc_ViewContainer);
		ViewContainer.setLayout(new BorderLayout(0, 0));
		
		JPanel ListContainer = new JPanel();
		GridBagConstraints gbc_ListContainer = new GridBagConstraints();
		gbc_ListContainer.fill = GridBagConstraints.BOTH;
		gbc_ListContainer.gridx = 1;
		gbc_ListContainer.gridy = 2;
		contentPane.add(ListContainer, gbc_ListContainer);
	}

}
