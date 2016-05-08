package exam.scanner.model.persistance;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;

import exam.scanner.model.Constants;
import exam.scanner.model.test.Candidate;

public class Serialization {

	private static LinkedList<Candidate> results = new LinkedList<Candidate>();
	
	/**
	 * Method serializes all data related to candidate
	 * @param candidate
	 * @throws Exception
	 * @author LukaNovakovic
	 */
	public static void writeResults(Candidate candidate) {

		results.add(candidate);

		try {

			DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(Constants.dataDir)));

			out.writeUTF(candidate.getCandidatePassword());
			out.writeChar('\t');
			out.writeUTF(candidate.getExamPassword());
			out.writeChar('\t');
			out.writeInt(candidate.getResults());
			out.writeChar('\n');

			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method reads all data related to candidate for serialized file
	 * @throws Exception
	 * @author LukaNovakovic
	 */
	public void readResults() {

		try {
			DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("resuts.out")));
			while (in.available() != 0) {
				String candidatePassword = in.readUTF();
				in.readChar();
				String examPassword = in.readUTF();
				in.readChar();
				int candidateResult = in.readInt();
				in.readChar();
				System.out.println("Candidate: " + candidatePassword + ".\tExam: " + examPassword + ".\tResult: "
						+ candidateResult + "\n");
			}

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static LinkedList<Candidate> getResults() {
		LinkedList<Candidate> listT = new LinkedList<>();
		Candidate c1 = new Candidate();
		Candidate c2 = new Candidate();

		c1.setCandidatePassword("123");
		c1.setExamPassword("999");
		c1.setResults(99);

		c2.setCandidatePassword("456");
		c2.setExamPassword("111");
		c2.setResults(30);

		listT.add(c1);

		return listT;
	}

}
