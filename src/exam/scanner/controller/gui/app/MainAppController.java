package exam.scanner.controller.gui.app;

import exam.scanner.controller.gui.capture.CaptureController;

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

	public void captureNew() {
		CaptureController captureController = CaptureController.getInstance();
		captureController.loadCaptureWindow();
	}
	
}
