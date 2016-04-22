package exam.scanner.view.models;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import exam.scanner.model.domain.Student;

@SuppressWarnings("serial")
public class TableModel extends AbstractTableModel {

	
	private final String[] columns = new String[] { "Student password", "Exam password", "resuts"};
	private List<Student> students;
	
	public TableModel(List<Student> students) {
		if (students == null) {
			this.students = new LinkedList<>();
		} else {
			this.students = students;
		}
	}
	
	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return students.size();
	}

	@Override
	public Object getValueAt(int column, int row) {
		Student s = students.get(row);
		switch(column){
		
		case 0: 
			return s.getStudentPassword();
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
	
	public void upload(List<Student> students) {
		this.students = students;
		fireTableDataChanged();
	}
	
}
