package exam.scanner.view.models;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import exam.scanner.model.test.Candidate;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel {

	private final String[] columns = new String[] { "Student password", "Exam password", "Results" };
	private List<Candidate> candidate;

	public TableModel(List<Candidate> candidate) {
		if (candidate == null) {
			this.candidate = new LinkedList<>();
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
	public Object getValueAt(int column, int row) {
		Candidate s = candidate.get(row);
		switch (column) {

		case 0:
			return s.getCandidatePassword();
		case 1:
			return s.getExamPassword();
		case 2:
			return s.getResults();
		default:
			return "unknown";
		}
	}

	public String getColumnName(int column) {
		return columns[column];
	}

	public void upload(List<Candidate> candidate) {
		this.candidate = candidate;
		fireTableDataChanged();
	}

}
