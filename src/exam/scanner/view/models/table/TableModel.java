package exam.scanner.view.models.table;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import exam.scanner.model.test.Candidate;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel {

	private final String[] columns = new String[] { "Student password", "Exam password", "Results" };
	private List<Candidate> candidate;

	public TableModel(LinkedList<Candidate> candidate) {
		if (candidate == null) {
			this.candidate = new LinkedList<Candidate>();
		} else {
			this.candidate = candidate;
		}
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return candidate.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		System.out.println("Call: getValueAt(" + row + ", " + column + ")");
		Candidate s = candidate.get(row);
		switch (column) {

		case 0:
			return s.getCandidatePassword();
		case 1:
			return s.getExamPassword();
		case 2:
			return Integer.toString(s.getResults());
		default:
			return "unknown";
		}
	}

	public String getColumnName(int column) {
		return columns[column];
	}

}
