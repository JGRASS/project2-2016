package exam.scanner.controller.gui.capture;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

import exam.scanner.controller.webcam.WebcamController;
import exam.scanner.controller.webcam.execute.SnapMeAction;
import exam.scanner.controller.webcam.execute.StartAction;
import exam.scanner.controller.webcam.execute.StopAction;
import exam.scanner.view.CaptureWindow;

public class CaptureController {
	private static CaptureController instance = null;

	private Executor executor = Executors.newSingleThreadExecutor();

	// private List<Webcam> webcams = Webcam.getWebcams();
	// private Dimension size = WebcamResolution.VGA.getSize();
	// private List<WebcamPanel> panels = new ArrayList<WebcamPanel>();

	private List<Webcam> webcams = new WebcamController().getWebcams();
	private Dimension size = new WebcamController().getSize();
	private List<WebcamPanel> panels = new WebcamController().getPanels();

	CaptureWindow captureWindow = new CaptureWindow();

	SnapMeAction snapMeAction = new SnapMeAction(webcams);
	StartAction startAction = new StartAction(captureWindow, panels, executor);
	StopAction stopAction = new StopAction(captureWindow, panels);

	private CaptureController() {
	}

	public static CaptureController getInstance() {
		if (instance == null) {
			instance = new CaptureController();
		}
		return instance;
	}

	public void loadCaptureWindow() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {

					for (Webcam webcam : webcams) {
						webcam.setViewSize(size);
						WebcamPanel panel = new WebcamPanel(webcam, size, false);
						panel.setFPSDisplayed(true);

						// panel.setFillArea(true);
						// panel.setDisplayDebugInfo(true);
						// panel.setImageSizeDisplayed(true);
						// panel.setMirrored(true);

						panels.add(panel);

					}

					captureWindow.getBtnCapture().setEnabled(false);
					captureWindow.getBtnCancel().setEnabled(false);

					captureWindow.getJpnlCenter().setLayout(new FlowLayout());

					for (WebcamPanel panel : panels) {
						captureWindow.getJpnlCenter().add(panel);
					}
					captureWindow.pack();
					captureWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void startCapture() {
		startAction.start();
	}

	public void stopCapture() {
		stopAction.stop();
	}

	public void snapCapture() {
		snapMeAction.snap();
	}

}
