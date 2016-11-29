package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Global extends JFrame {

	private static final long serialVersionUID = 2355362759797182589L;
	private JPanel contentPane;
	private JLabel nameLabel;
	private JTextField nameField;
	private JButton okButton;
	private JButton cancelButton;
	
	private String name;
	private boolean function;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Global frame = new Global("test", true, "");
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
	public Global(String title, boolean type, String preText) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 232, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0, 0, 0};
		gbl_contentPane.rowHeights = new int[] {0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		function = type;
		
		nameLabel = new JLabel("Database Name:");
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.anchor = GridBagConstraints.EAST;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 0;
		gbc_nameLabel.gridy = 0;
		contentPane.add(nameLabel, gbc_nameLabel);
		
		nameField = new JTextField();
		nameField.setText(preText);
		nameField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				name = nameField.getText();
			}
			public void removeUpdate(DocumentEvent e) {
				name = nameField.getText();
			}
			public void insertUpdate(DocumentEvent e) {
				name = nameField.getText();
			}
		});
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(0, 0, 5, 0);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 0;
		contentPane.add(nameField, gbc_nameField);
		nameField.setColumns(10);
		
		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				submit();
			}
		});
		GridBagConstraints gbc_okButton = new GridBagConstraints();
		gbc_okButton.insets = new Insets(0, 0, 5, 5);
		gbc_okButton.gridx = 0;
		gbc_okButton.gridy = 1;
		contentPane.add(okButton, gbc_okButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.insets = new Insets(0, 0, 5, 0);
		gbc_cancelButton.gridx = 1;
		gbc_cancelButton.gridy = 1;
		contentPane.add(cancelButton, gbc_cancelButton);
	}
	
	public void submit() {
		if (!name.isEmpty()) {
			System.out.println(name);
			if (function) {
				database.Database.finishSaveAs(name);
			} else {
				database.Database.finishLoad(name);
			}
			setVisible(false);
			dispose();
		}
	}
	
	public void cancel() {
		setVisible(false);
		dispose();
	}

}
