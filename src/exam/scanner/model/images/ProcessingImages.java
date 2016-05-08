package exam.scanner.model.images;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import exam.scanner.model.Constants;
/**
 * Class for processing captured images(exams)
 * @author LukaNovakovic
 *
 */
public class ProcessingImages {
	// File representing the folder that you select using a FileChooser
	static final File imageDir = new File(Constants.absoluteStartPath + Constants.programName + Constants.images);

	// array of supported extensions (use a List if you prefer)
	/* , "gif", "png", "bmp" and other formats you need */
	static final String[] EXTENSIONS = new String[] { "jpg" };

	// filter to identify images based on their extensions
	static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

		@Override
		public boolean accept(final File dir, final String name) {
			for (final String ext : EXTENSIONS) {
				if (name.endsWith("." + ext)) {
					return (true);
				}
			}
			return (false);
		}
	};
	/**
	 * method saves captured image
	 * @param renderedImage
	 * @param newImage
	 * @author LukaNovakovic
	 */
	public static void saveImage(RenderedImage renderedImage, File newImage) {
		try {
			ImageIO.write(renderedImage, "JPG", newImage);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public static ArrayList<String> getImages() {
		ArrayList<String> images = new ArrayList<String>();

		// make sure it's a directory
		if (imageDir.isDirectory()) {
			for (final File f : imageDir.listFiles(IMAGE_FILTER)) {
				BufferedImage img = null;

				try {
					img = ImageIO.read(f);

					// you probably want something more involved here
					images.add(f.getName());

					// to display in your UI
					System.out.println("image: " + f.getName());
					System.out.println(" width : " + img.getWidth());
					System.out.println(" height: " + img.getHeight());
					System.out.println(" size  : " + f.length());
				} catch (final IOException e) {
					// handle errors here
					e.printStackTrace();
				}
			}
		}
		return images;
	}

	// TODO [WIP]
	public static char[] saveAnswer(String text) {
		char[] answers = new char[Constants.answers];
		for (int i = 0; i < Constants.answers; i++) {
			answers[i] = text.charAt(i);
			System.out.println(answers[i]);

		}
		return answers;

	}
}
