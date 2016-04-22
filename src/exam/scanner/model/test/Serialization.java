package exam.scanner.model.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Serialization {

	public static void writeResults(Candidate candidate){
		
		try {
			DataOutputStream out = new DataOutputStream( 
										new BufferedOutputStream(
												new FileOutputStream("results.out")));
			
			out.writeUTF(candidate.getCandidatePassword());
			out.writeChar('\t');
			out.writeInt(candidate.getResults());
			out.writeChar('\n');
			
			
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void readResults(){
		
		try {
			DataInputStream in = new DataInputStream( 
									new BufferedInputStream(
											new FileInputStream("resuts.out")));
			while(in.available()!=0){
				String candidatePassword = in.readUTF();
				in.readChar();
				int candidateResult = in.readInt();
				in.readChar();
				System.out.println("Candidate: "+candidatePassword+".\tResult: "+candidateResult+"\n");
			}
			
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
