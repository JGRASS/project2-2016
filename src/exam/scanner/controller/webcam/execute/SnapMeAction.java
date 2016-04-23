package exam.scanner.controller.webcam.execute;

import java.io.File;
import java.util.List;

import com.github.sarxos.webcam.Webcam;

import exam.scanner.model.Constants;
import exam.scanner.model.images.ProcessingImages;

public class SnapMeAction {
	private List<Webcam> webcams;

	public SnapMeAction(List<Webcam> webcams) {
		super();
		this.webcams = webcams;
	}

	public void snap() {
		for (int i = 0; i < webcams.size(); i++) {
			Webcam webcam = webcams.get(i);
			File newImage = new File(String.format(Constants.imageDir + "\\image-%d.jpg", i));
			ProcessingImages.saveImage(webcam.getImage(), newImage);

		}
	}

}
