package exam.scanner.controller.gui.main;

import java.awt.EventQueue;

import exam.scanner.controller.gui.capture.CaptureController;
import exam.scanner.view.MainAppWindow;

public class MainAppController {
	private static MainAppController instance = null;

	private MainAppController() {
	}

	public static MainAppController getInstance() {
		if (instance == null) {
			instance = new MainAppController();
		}
		return instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new MainAppWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void captureNew() {
		CaptureController captureController = CaptureController.getInstance();
		captureController.loadCaptureWindow();
	}

}
