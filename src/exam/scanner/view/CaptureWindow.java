package exam.scanner.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

import exam.scanner.controller.gui.capture.CaptureController;

public class CaptureWindow extends JFrame {

	private JPanel contentPane;
	private JPanel jpnlCenter;
	private JPanel jpnlSouth;
	private JButton btnStart;
	private JButton btnCapture;
	private JButton btnCancel;

	private List<Webcam> webcams;
	private List<WebcamPanel> panels = new ArrayList<WebcamPanel>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					CaptureWindow frame = new CaptureWindow();
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

	public CaptureWindow(List<Webcam> webcams, List<WebcamPanel> panels) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getJpnlCenter(), BorderLayout.CENTER);
		contentPane.add(getJpnlSouth(), BorderLayout.SOUTH);

		this.webcams = webcams;
		this.panels = panels;
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
