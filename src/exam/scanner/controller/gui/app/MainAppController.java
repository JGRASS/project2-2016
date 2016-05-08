package exam.scanner.controller.gui.app;

import javax.swing.JOptionPane;

import exam.scanner.check.CandidatesCheck;
import exam.scanner.controller.gui.capture.CaptureController;
import exam.scanner.controller.gui.dialogs.ShowDialogsController;
import exam.scanner.controller.gui.table.TableController;
import exam.scanner.model.test.Candidate;
import exam.scanner.view.MainAppWindow;
import exam.scanner.view.models.table.TableModel;


/**
 * Class for manipulating with main application window
 * @author LukaNovakovic
 *
 */
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

	/**
	 * Method loads and displays window for capturing new exam
	 * @author LukaNovakovic
	 */
	public static void captureNew() {
		CaptureController.loadCaptureWindow();
	}

	/**
	 * Method sets table model and loads table with all data
	 * @author LukaNovakovic
	 */
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

	/**
	 * Method deletes candidate and reloads table
	 * @param candidate
	 */
	public static void deleteCandidate(Candidate ci) {
		CandidatesCheck.delete(ci);
		mainAppWindow.getTable().setModel(TableController.loadTable());

	}
	/**
	 * Method deletes selected row and displays confirm dialog
	 * @author LukaNovakovic
	 */
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
				Candidate ci = model.getCandidateByIndex(index);
				MainAppController.deleteCandidate(ci);
			}
		}
	}
/**
 * Method save changes made by user in table and reloads table
 * @author LukaNovakovic
 */
public static void saveChanges(){
		
		int option = JOptionPane.showConfirmDialog(null,
				"Do you want to save made changes?", "Confirm",
				JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			TableModel model = (TableModel)mainAppWindow.getTable().getModel();
			model.serializeChanges();
		}
	}
}
