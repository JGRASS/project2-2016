package exam.scanner.model;

import java.util.ArrayList;

public class Constants {
	public static String username = System.getProperty("user.name");
	public static final String absoluteStartPath = "C:\\ProgramData\\";
	public static final String programName = "Exam\\";
	public static final String trainingImageDir = ".\\resources\\imgs\\training\\basic";

	public static final String images = "Images\\";
	public static final String settings = "Settings\\";
	public static final String data = "Data\\";
	public static final String resultsData = "results.out";

	public static final String imageDir = Constants.absoluteStartPath + Constants.programName + Constants.images;

	public static final String dataDir = Constants.absoluteStartPath + Constants.programName + Constants.data;

	public static final String resultsDir = Constants.absoluteStartPath + Constants.programName + Constants.data
			+ Constants.resultsData;

	public static final int answers = 20;

	public static final ArrayList<String> programDirectories = new ArrayList<String>() {
		/**
		 * serialVersionUID
		 */
		private static final long serialVersionUID = 1L;

		{
			add(Constants.images);
			add(Constants.settings);
			add(Constants.data);
		}
	};
}
