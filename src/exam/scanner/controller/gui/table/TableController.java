package exam.scanner.controller.gui.table;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import exam.scanner.check.CandidatesCheck;
import exam.scanner.controller.gui.app.MainAppController;
import exam.scanner.model.persistance.Serialization;
import exam.scanner.model.test.Candidate;
import exam.scanner.view.MainAppWindow;
import exam.scanner.view.models.table.TableModel;

public class TableController {

	private static TableController instance = null;

	static MainAppWindow mainAppWindow = null;

	public TableController(MainAppWindow mainAppWindow) {
		TableController.mainAppWindow = mainAppWindow;
	}

	public static TableController getInstance(MainAppWindow mainAppWindow) {
		if (instance == null) {
			instance = new TableController(mainAppWindow);
		}
		return instance;
	}

	public static void loadTable() {
		mainAppWindow.getTable().setModel(new TableModel(CandidatesCheck.getCandidates()));;
	}

	public static void deleteCandidate() {
		int index = mainAppWindow.getTable().getSelectedRow();
		if (index == -1) {
			MainAppController.showErrorDeletingRow();
		} else {
			int option = JOptionPane.showConfirmDialog(null, "Are You sure?", "Confirm", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {

				TableModel model = (TableModel) mainAppWindow.getTable().getModel();
				for (int i = 0; i < model.getCandidates().size(); i++) {
					if (i == index) {
						CandidatesCheck.delete(model.getCandidates().get(i));
					}
				}
				model.fireTableDataChanged();
			}
		}

	}

	public static LinkedList<Candidate> returnCandidatesFromTable() {
		LinkedList<Candidate> test;
		TableModel model = (TableModel) mainAppWindow.getTable().getModel();
		test = (LinkedList<Candidate>) model.getCandidates();
		return test;
	}

	public static boolean saveTableChanges() {
		for (Candidate candidate : returnCandidatesFromTable()) {
			Serialization.writeResults(candidate);
		}
		return true;

	}

}
