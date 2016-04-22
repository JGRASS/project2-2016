package exam.scanner.controller.webcam.execute;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;

public class SnapMeAction {
	private List<Webcam> webcams;

	public SnapMeAction(List<Webcam> webcams) {
		super();
		this.webcams = webcams;
	}

	public void snap() {
		for (int i = 0; i < webcams.size(); i++) {
			Webcam webcam = webcams.get(i);
			File file = new File(String.format("image-%d.jpg", i));
			try {
				ImageIO.write(webcam.getImage(), "JPG", file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// System.out.format("Image for %s saved in %s \n",
			// webcam.getName(),file);

		}
	}

}
