package exam.scanner.model.domain;

import java.io.Serializable;

public class Student implements Serializable {

	private int studentPassword;
	private int examPassword;
	private int results;
	
	public int getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(int studentPassword) {
		this.studentPassword = studentPassword;
	}
	public int getExamPassword() {
		return examPassword;
	}
	public void setExamPassword(int examPassword) {
		this.examPassword = examPassword;
	}
	public int getResults() {
		return results;
	}
	public void setResults(int results) {
		this.results = results;
	}
	
	
}
