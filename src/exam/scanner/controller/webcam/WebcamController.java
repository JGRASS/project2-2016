package exam.scanner.controller.webcam;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

/**
 * Class manipulates with webcam actions
 *
 */
public class WebcamController {
	private static WebcamController instance = null;

	@SuppressWarnings("unused")
	private List<Webcam> webcams = null;

	@SuppressWarnings("unused")
	private Dimension size = null;

	@SuppressWarnings("unused")
	private List<WebcamPanel> panels = null;

	public WebcamController() {
	}

	public WebcamController(List<Webcam> webcams, Dimension size, List<WebcamPanel> panels) {
		super();
		this.webcams = webcams;
		this.size = size;
		this.panels = panels;
	}

	public static WebcamController getInstance() {
		if (instance == null) {
			instance = new WebcamController();
		}
		return instance;
	}

	public List<Webcam> getWebcams() {
		return Webcam.getWebcams();
	}

	public void setWebcams(List<Webcam> webcams) {
		this.webcams = webcams;
	}

	public Dimension getSize() {
		return WebcamResolution.VGA.getSize();
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public List<WebcamPanel> getPanels() {
		return new ArrayList<WebcamPanel>();
	}

	public void setPanels(List<WebcamPanel> panels) {
		this.panels = panels;
	}

}
