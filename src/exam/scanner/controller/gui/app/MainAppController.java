package exam.scanner.controller.gui.app;

import javax.swing.JOptionPane;

import exam.scanner.check.CandidatesCheck;
import exam.scanner.controller.gui.capture.CaptureController;
import exam.scanner.controller.gui.dialogs.ShowDialogsController;
import exam.scanner.controller.gui.table.TableController;
import exam.scanner.model.test.Candidate;
import exam.scanner.view.MainAppWindow;
import exam.scanner.view.models.table.TableModel;

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

	public static void errorDeletingRow() {
		JOptionPane.showMessageDialog(null, "Please select a row to delete!", "Error!!!",
				JOptionPane.ERROR_MESSAGE);
		
	}

	public static void deleteCandidate(Candidate ci) {
		CandidatesCheck.delete(ci);
		mainAppWindow.getTable().setModel(TableController.loadTable());

	}
	
	public static void deleteRow(){
		int index = mainAppWindow.getTable().getSelectedRow();
		if (index == -1) {
			MainAppController.errorDeletingRow();
		} else {
			int option = JOptionPane.showConfirmDialog(null,
					"Are You sure?", "Confirm",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				TableModel model = (TableModel)mainAppWindow.getTable().getModel();
				Candidate ci = model.getKnjigaByIndex(index);
				MainAppController.deleteCandidate(ci);
			}
		}
	}
}
