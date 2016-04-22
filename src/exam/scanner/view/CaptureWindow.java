package exam.scanner.view;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class CaptureWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel southPanel;
	private JButton btnCapture;
	private JButton btnCancle;
	private JPanel centralPanel;
	public CaptureWindow() {
		setTitle("New exam");
		getContentPane().add(getSouthPanel(), BorderLayout.SOUTH);
		getContentPane().add(getCentralPanel(), BorderLayout.CENTER);
	}
	private JPanel getSouthPanel() {
		if (southPanel == null) {
			southPanel = new JPanel();
			southPanel.add(getBtnCapture());
			southPanel.add(getBtnCancle());
		}
		return southPanel;
	}
	private JButton getBtnCapture() {
		if (btnCapture == null) {
			btnCapture = new JButton("Capture");
			btnCapture.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnCapture;
	}
	private JButton getBtnCancle() {
		if (btnCancle == null) {
			btnCancle = new JButton("Cancle");
		}
		return btnCancle;
	}
	private JPanel getCentralPanel() {
		if (centralPanel == null) {
			centralPanel = new JPanel();
		}
		return centralPanel;
	}
}

