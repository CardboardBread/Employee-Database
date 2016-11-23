package display;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class ListItem extends JPanel {

	/**
	 * Create the panel.
	 */
	public ListItem() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel empPicture = new JLabel("Picture goes here...");
		empPicture.setIcon(null);
		GridBagConstraints gbc_empPicture = new GridBagConstraints();
		gbc_empPicture.insets = new Insets(0, 0, 0, 5);
		gbc_empPicture.gridwidth = 2;
		gbc_empPicture.gridheight = 2;
		gbc_empPicture.gridx = 0;
		gbc_empPicture.gridy = 0;
		add(empPicture, gbc_empPicture);
		
		JLabel empIdent = new JLabel("Employee #<ID>");
		GridBagConstraints gbc_empIdent = new GridBagConstraints();
		gbc_empIdent.gridx = 2;
		gbc_empIdent.gridy = 0;
		add(empIdent, gbc_empIdent);

	}

}
