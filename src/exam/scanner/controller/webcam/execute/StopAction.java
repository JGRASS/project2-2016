package exam.scanner.controller.webcam.execute;

import java.util.List;

import com.github.sarxos.webcam.WebcamPanel;

import exam.scanner.view.CaptureWindow;

public class StopAction {
	CaptureWindow capture;
	private List<WebcamPanel> panels;

	public StopAction(CaptureWindow capture, List<WebcamPanel> panels) {
		super();
		this.capture = capture;
		this.panels = panels;
	}

	public void stop() {
		capture.getBtnStart().setEnabled(true);
		capture.getBtnCapture().setEnabled(false);
		capture.getBtnCancel().setEnabled(false);

		for (WebcamPanel panel : panels) {
			panel.stop();
		}
	}

}
