package exam.scanner.controller.gui.app;

import exam.scanner.controller.gui.capture.CaptureController;
import exam.scanner.controller.gui.dialogs.ShowDialogsController;
import exam.scanner.controller.gui.table.TableController;
import exam.scanner.view.MainAppWindow;

public class MainAppController {

	static MainAppWindow mainAppWindow = new MainAppWindow();
	TableController tableController = TableController.getInstance(mainAppWindow);

	public MainAppController() {
	}

	public static void captureNew() {
		CaptureController.loadCaptureWindow();
	}

	public static void displayTable() {
		TableController.loadTable();

	}

	public static void showInfo() {
		ShowDialogsController.showInfoDialog();
	}

	public static void showAuthors() {
		ShowDialogsController.showAuthorsDialog();
	}

	public static void showErrorDeletingRow() {
		ShowDialogsController.showErrorDeletingRowDialog();

	}

	public static void showSaveChanges() {
		ShowDialogsController.showSaveChangesDialog();
	}

	public static void deleteRow() {
		TableController.deleteCandidate();

	}
}
