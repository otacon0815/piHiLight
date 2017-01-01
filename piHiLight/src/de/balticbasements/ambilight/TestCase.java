package de.balticbasements.ambilight;

import java.awt.image.BufferedImage;

public class TestCase {

	public static void main(String[] args) {

		BufferedImage image = CamHandler.getImage();
		
		ImageProcessor processor = new ImageProcessor();
		processor.processImage(image);
	}

}
