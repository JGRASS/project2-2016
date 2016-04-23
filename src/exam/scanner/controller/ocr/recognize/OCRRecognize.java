package exam.scanner.controller.ocr.recognize;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import exam.scanner.model.Constants;
import exam.scanner.model.images.ProcessingImages;
import net.sourceforge.javaocr.ocrPlugins.OCRDemo.OCRScannerDemo;
import net.sourceforge.javaocr.ocrPlugins.mseOCR.CharacterRange;
import net.sourceforge.javaocr.ocrPlugins.mseOCR.OCRScanner;
import net.sourceforge.javaocr.ocrPlugins.mseOCR.TrainingImage;
import net.sourceforge.javaocr.ocrPlugins.mseOCR.TrainingImageLoader;
import net.sourceforge.javaocr.scanner.PixelImage;

@SuppressWarnings("deprecation")
public class OCRRecognize {

	private static boolean debug = true;
	private static Image image;
	private static OCRScanner scanner;

	public OCRRecognize() {
		scanner = new OCRScanner();
	}

	/**
	 * Load demo training images.
	 * 
	 * @param trainingImageDir
	 *            The directory from which to load the images.
	 */
	private void loadTrainingImages(String trainingImageDir) {
		if (debug) {
			System.err.println("loadTrainingImages(" + trainingImageDir + ")");
		}
		if (!trainingImageDir.endsWith(File.separator)) {
			trainingImageDir += File.separator;
		}
		try {
			scanner.clearTrainingImages();
			TrainingImageLoader loader = new TrainingImageLoader();
			HashMap<Character, ArrayList<TrainingImage>> trainingImageMap = new HashMap<Character, ArrayList<TrainingImage>>();
			if (debug) {
				System.err.println("ascii.png");
			}
			loader.load(trainingImageDir + "ascii.png", new CharacterRange('!', '~'), trainingImageMap);
			if (debug) {
				System.err.println("hpljPica.jpg");
			}
			loader.load(trainingImageDir + "hpljPica.jpg", new CharacterRange('!', '~'), trainingImageMap);
			if (debug) {
				System.err.println("digits.jpg");
			}
			loader.load(trainingImageDir + "digits.jpg", new CharacterRange('0', '9'), trainingImageMap);
			if (debug) {
				System.err.println("adding images");
			}
			scanner.addTrainingImages(trainingImageMap);
			if (debug) {
				System.err.println("loadTrainingImages() done");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(2);
		}
	}

	private static void process(String imageFilename) {
		if (debug) {
			System.err.println("process(" + imageFilename + ")");
		}
		try {
			image = ImageIO.read(new File(imageFilename));
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (image == null) {
			System.err.println("Cannot find image file: " + imageFilename);
			return;
		}

		if (debug) {
			System.err.println("constructing new PixelImage");
		}

		PixelImage pixelImage = new PixelImage(image);
		if (debug) {
			System.err.println("converting PixelImage to grayScale");
		}
		pixelImage.toGrayScale(true);
		if (debug) {
			System.err.println("filtering");
		}
		pixelImage.filter();
		if (debug) {
			System.err.println("setting image for display");
		}

		System.out.println(imageFilename + ":");
		String text = scanner.scan(image, 0, 0, 0, 0, null);
		System.out.println("[" + text + "]");
		ProcessingImages.saveAnswer(text);
	}

	public static void recognize(String[] images) {
		if (images.length < 1) {
			System.err.println("Please specify one or more image filenames.");
			System.exit(1);
		}
		if (Constants.trainingImageDir == null) {
			System.err.println("Please specify trainingImageDir.");
			return;
		}
		OCRRecognize recognize = new OCRRecognize();
		recognize.loadTrainingImages(Constants.trainingImageDir);
		for (int i = 0; i < images.length; i++) {
			OCRRecognize.process(Constants.imageDir + "\\" + images[i]);
		}
		System.out.println("done.");
	}

	private static final Logger LOG = Logger.getLogger(OCRScannerDemo.class.getName());
}
