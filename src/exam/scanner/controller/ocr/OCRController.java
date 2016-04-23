package exam.scanner.controller.ocr;

import java.util.ArrayList;

import exam.scanner.controller.ocr.recognize.OCRRecognize;
import exam.scanner.model.images.ProcessingImages;

public class OCRController {
	public static void loadTestResults() {
		ArrayList<String> list = ProcessingImages.getImages();
		String[] arr = list.toArray(new String[list.size()]);
		OCRRecognize.recognize(arr);

	}

}
