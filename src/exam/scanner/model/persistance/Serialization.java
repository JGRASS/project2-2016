package exam.scanner.model.persistance;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import exam.scanner.model.Constants;
import exam.scanner.model.test.Candidate;

public class Serialization {

	public static boolean writeResults(Candidate candidate) {

		try {

			DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(Constants.resultsDir)));

			out.writeUTF(candidate.getCandidatePassword());
			out.writeChar('\t');
			out.writeUTF(candidate.getExamPassword());
			out.writeChar('\t');
			out.writeInt(candidate.getResults());
			out.writeChar('\n');

			out.close();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public Candidate readResults() {
		Candidate candidate = new Candidate();

		try {
			DataInputStream in = new DataInputStream(
					new BufferedInputStream(new FileInputStream(Constants.resultsDir)));
			while (in.available() != 0) {
				String candidatePassword = in.readUTF();
				candidate.setCandidatePassword(candidatePassword);
				in.readChar();

				String examPassword = in.readUTF();
				candidate.setExamPassword(examPassword);
				in.readChar();

				int candidateResult = in.readInt();
				candidate.setResults(candidateResult);
				in.readChar();

				System.out.println("Candidate: " + candidatePassword + ".\tExam: " + examPassword + ".\tResult: "
						+ candidateResult + "\n");
			}
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return candidate;
	}

}
