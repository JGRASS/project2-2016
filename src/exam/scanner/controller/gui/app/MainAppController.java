package exam.scanner.controller.gui.app;

import exam.scanner.controller.gui.capture.CaptureController;
import exam.scanner.controller.gui.dialogs.ShowDialogsController;
import exam.scanner.controller.gui.table.TableController;
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

	static MainAppWindow mainAppWindow = new MainAppWindow();

	public static void captureNew() {
		CaptureController.loadCaptureWindow();
	}

	public static void displayTable() {
		mainAppWindow.getTable().setModel(TableController.loadTable());

	}

	public static void showInfo() {
		ShowDialogsController.showInfoDialog();
	}

	public static void showAuthors() {
		ShowDialogsController.showAuthors();
	}

}
