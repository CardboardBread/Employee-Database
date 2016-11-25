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
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;

public class SaveDatabaseAs extends JFrame {

	private JPanel contentPane;
	private JLabel nameLabel;
	private JLabel widthLabel;
	private JTextField widthField;
	private JTextField nameField;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaveDatabaseAs frame = new SaveDatabaseAs();
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
	public SaveDatabaseAs() {
		setTitle("Add Database");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 232, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[] {0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		nameLabel = new JLabel("Database Name:");
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.anchor = GridBagConstraints.EAST;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 0;
		gbc_nameLabel.gridy = 0;
		contentPane.add(nameLabel, gbc_nameLabel);
		
		nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(0, 0, 5, 0);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 0;
		contentPane.add(nameField, gbc_nameField);
		nameField.setColumns(10);
		
		widthLabel = new JLabel("Database Width:");
		GridBagConstraints gbc_widthLabel = new GridBagConstraints();
		gbc_widthLabel.insets = new Insets(0, 0, 5, 5);
		gbc_widthLabel.anchor = GridBagConstraints.EAST;
		gbc_widthLabel.gridx = 0;
		gbc_widthLabel.gridy = 1;
		contentPane.add(widthLabel, gbc_widthLabel);
		
		widthField = new JTextField();
		GridBagConstraints gbc_widthField = new GridBagConstraints();
		gbc_widthField.insets = new Insets(0, 0, 5, 0);
		gbc_widthField.fill = GridBagConstraints.HORIZONTAL;
		gbc_widthField.gridx = 1;
		gbc_widthField.gridy = 1;
		contentPane.add(widthField, gbc_widthField);
		widthField.setColumns(10);
		
		okButton = new JButton("OK");
		GridBagConstraints gbc_okButton = new GridBagConstraints();
		gbc_okButton.insets = new Insets(0, 0, 0, 5);
		gbc_okButton.gridx = 0;
		gbc_okButton.gridy = 2;
		contentPane.add(okButton, gbc_okButton);
		
		cancelButton = new JButton("Cancel");
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.gridx = 1;
		gbc_cancelButton.gridy = 2;
		contentPane.add(cancelButton, gbc_cancelButton);
	}

}
