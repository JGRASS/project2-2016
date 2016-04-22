package exam.scanner.controller.webcam.execute;

import java.util.List;
import java.util.concurrent.Executor;

import com.github.sarxos.webcam.WebcamPanel;

import exam.scanner.view.CaptureWindow;

public class StartAction implements Runnable {
	private List<WebcamPanel> panels;
	private Executor executor;
	CaptureWindow captureWindow;

	public StartAction(CaptureWindow captureWindow, List<WebcamPanel> panels, Executor executor) {
		super();
		this.captureWindow = captureWindow;
		this.panels = panels;
		this.executor = executor;
	}

	public void start() {
		captureWindow.getBtnStart().setEnabled(false);
		captureWindow.getBtnCapture().setEnabled(true);

		executor.execute(this);
	}

	@Override
	public void run() {

		captureWindow.getBtnCancel().setEnabled(true);

		for (WebcamPanel panel : panels) {
			panel.start();
		}

	}
}
