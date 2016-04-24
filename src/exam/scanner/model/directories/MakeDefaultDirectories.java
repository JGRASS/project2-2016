package exam.scanner.model.directories;

import java.io.File;

import exam.scanner.model.Constants;

public class MakeDefaultDirectories {
	public static void programDirectoriesCreate() {
		File file;
		int i = 0;
		for (@SuppressWarnings("unused") String element : Constants.programDirectories) {
			file = new File(Constants.absoluteStartPath + Constants.programName + Constants.programDirectories.get(i));

			if (!file.exists()) {
				file.mkdirs();
			}

		}
	}
}
