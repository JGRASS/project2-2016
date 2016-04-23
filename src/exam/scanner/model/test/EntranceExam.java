package exam.scanner.model.test;

public class EntranceExam {

	String candidatePassword;
	String examPassword;
	char[] answers = new char[20];

	public EntranceExam(String candidatePassword, String examPassword, char[] answers) {
		super();
		this.setCandidatePassword(candidatePassword);
		this.setExamPassword(examPassword);
		this.setAnswers(answers);
	}

	public String getCandidatePassword() {
		return candidatePassword;
	}

	public void setCandidatePassword(String candidatePassword) {
		this.candidatePassword = candidatePassword;
	}

	public String getExamPassword() {
		return examPassword;
	}

	public void setExamPassword(String examPassword) {
		this.examPassword = examPassword;
	}

	public char[] getAnswers() {
		return answers;
	}

	public void setAnswers(char[] answers) {
		this.answers = answers;
	}
}
