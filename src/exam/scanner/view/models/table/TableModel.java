package exam.scanner.view.models.table;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import exam.scanner.model.persistance.Serialization;
import exam.scanner.model.test.Candidate;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel {

	private final String[] columns = new String[] { "Student password", "Exam password", "Results" };
	private List<Candidate> candidates;

	public TableModel(LinkedList<Candidate> candidate) {
		if (candidate == null) {
			this.candidates = new LinkedList<Candidate>();
		} else {
			this.candidates = candidate;
		}
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return candidates.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		System.out.println("Call: getValueAt(" + rowIndex + ", " + columnIndex + ")");
		Candidate cand = candidates.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return cand.getCandidatePassword();
		case 1:
			return cand.getExamPassword();
		case 2:
			return Integer.toString(cand.getResults());
		default:
			return "unknown";
		}
	}

	public String getColumnName(int column) {
		return columns[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 2;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Candidate cand = candidates.get(rowIndex);
		switch (columnIndex) {
		case 0:
			cand.setCandidatePassword((String) aValue);
			break;
		case 1:
			cand.setExamPassword((String) aValue);
			break;
		case 2:
			cand.setResults(Integer.parseInt((String) aValue));
			break;
		default:
			break;
		}

	}

	public Candidate getCandidateByIndex(int index) {
		return candidates.get(index);
	}
	
	public void serializeChanges(){
		for(int i = 0; i <getRowCount(); i++){
			Serialization.writeResults(getCandidateByIndex(i));
		}
	}
}
