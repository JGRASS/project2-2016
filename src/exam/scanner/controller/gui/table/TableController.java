package exam.scanner.controller.gui.table;

import exam.scanner.check.CandidatesCheck;
import exam.scanner.view.models.table.TableModel;

public class TableController {

	private static TableController instance = null;

	public TableController() {
	}

	public static TableController getInstance() {
		if (instance == null) {
			instance = new TableController();
		}
		return instance;
	}

	public static TableModel loadTable() {
		return new TableModel(CandidatesCheck.getCandidates());
	}

}
