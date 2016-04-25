package exam.scanner.check;

import java.util.LinkedList;

import exam.scanner.model.test.Candidate;

public class CandidatesCheck {
	private static Candidate c1 = new Candidate();
	private static Candidate c2 = new Candidate();
	private static LinkedList<Candidate> candidates = new LinkedList<Candidate>();

	private static void setCandidates() {
		c1.setCandidatePassword("c1-password");
		c1.setExamPassword("c1-exam-password");
		c1.setResults(1);

		c2.setCandidatePassword("c2-password");
		c2.setExamPassword("c2-exam-password");
		c2.setResults(2);

	}

	public static LinkedList<Candidate> getCandidates() {
		CandidatesCheck.setCandidates();
		candidates.add(c1);
		candidates.add(c2);
		return candidates;

	}

	public static void delete(Candidate ci) {
		candidates.remove(ci);

	}

}
