package exam.scanner.view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfirmWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton btnOkay;
	private JButton btnAgain;
	private JPanel panel_1;
	private JLabel lblPicture;

	/**
	 * Create the frame.
	 */
	public ConfirmWindow() {
		setTitle("Are you sure?");
		getContentPane().add(getPanel(), BorderLayout.SOUTH);
		getContentPane().add(getPanel_1(), BorderLayout.CENTER);
	}

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnOkay());
			panel.add(getBtnAgain());
		}
		return panel;
	}

	public JButton getBtnOkay() {
		if (btnOkay == null) {
			btnOkay = new JButton("Okay");
		}
		return btnOkay;
	}

	public JButton getBtnAgain() {
		if (btnAgain == null) {
			btnAgain = new JButton("Again");
		}
		return btnAgain;
	}

	public JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getLblPicture());
		}
		return panel_1;
	}

	public JLabel getLblPicture() {
		if (lblPicture == null) {
			lblPicture = new JLabel("");
			lblPicture.setIcon(new ImageIcon(ConfirmWindow.class.getResource("/imgs/webcam.jpg")));
			lblPicture.setBounds(0, 0, 434, 228);
		}
		return lblPicture;
	}
}
