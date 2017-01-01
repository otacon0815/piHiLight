package de.balticbasements.ambilight;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import com.github.sarxos.webcam.Webcam;

public class CamHandler{
	
	static Webcam webcam = null;
	
	private static void init(){
		webcam = Webcam.getDefault();
		webcam.setViewSize(new Dimension(AmbiSettings.getWebcamX(), AmbiSettings.getWebcamY()));
		webcam.open();
	}
	
	public static BufferedImage getImage(){
		if(webcam==null)
			init();
		BufferedImage image = webcam.getImage();
		return image;
	}
}