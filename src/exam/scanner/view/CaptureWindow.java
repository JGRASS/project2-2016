package exam.scanner.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import exam.scanner.controller.gui.capture.CaptureController;

public class CaptureWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel jpnlCenter;
	private JPanel jpnlSouth;
	private JButton btnStart;
	private JButton btnCapture;
	private JButton btnCancel;

	/**
	 * Create the frame.
	 */
	public CaptureWindow() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getJpnlCenter(), BorderLayout.CENTER);
		contentPane.add(getJpnlSouth(), BorderLayout.SOUTH);

	}

	public JPanel getJpnlCenter() {
		if (jpnlCenter == null) {
			jpnlCenter = new JPanel();
		}
		return jpnlCenter;
	}

	public JPanel getJpnlSouth() {
		if (jpnlSouth == null) {
			jpnlSouth = new JPanel();
			jpnlSouth.add(getBtnStart());
			jpnlSouth.add(getBtnCapture());
			jpnlSouth.add(getBtnCancel());
		}
		return jpnlSouth;
	}

	public JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("Start");
			btnStart.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					CaptureController captureController = CaptureController.getInstance();
					captureController.startCapture();
				}
			});
		}
		return btnStart;
	}

	public JButton getBtnCapture() {
		if (btnCapture == null) {
			btnCapture = new JButton("Capture");
			btnCapture.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					CaptureController captureController = CaptureController.getInstance();
					captureController.snapCapture();
				}
			});
		}
		return btnCapture;
	}

	public JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					CaptureController captureController = CaptureController.getInstance();
					captureController.stopCapture();
				}
			});

		}
		return btnCancel;

	}
}
