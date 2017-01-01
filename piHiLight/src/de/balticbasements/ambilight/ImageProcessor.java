package de.balticbasements.ambilight;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ImageProcessor {

	public ImageProcessor(){
		
	}
	
	public List<Integer> processImage(BufferedImage image){
		
		ArrayList<Integer> ledData = new ArrayList<Integer>();
		
		int abstandX = image.getWidth() / ( AmbiSettings.getLedCountX() - 2);	//eine LED sitzt bei 0:0, eine jeweils am ende
		int abstandY = image.getHeight() / AmbiSettings.getLedCountY();
		
		//TODO pfade entlang einer linie zwischen 2 punkten berechnen
		
		//Oben links auslesen
		ledData.add(processPoint(0, 0, image));
		
		//Oben von links nach rechts auslesen
		for(int i = abstandX; i < image.getWidth(); i+=abstandX)
			ledData.add(processPoint(i, 0, image));
		
		//Oben rechts auslesen
		ledData.add(processPoint(image.getWidth()-1, 0, image));
		
		//Rechts von oben nach unten auslesen
		for(int i = abstandY; i < image.getHeight(); i+=abstandY)
			ledData.add(processPoint(image.getWidth()-1, i, image));
		
		//Rechts unten auslesen
		ledData.add(processPoint(image.getWidth()-1, image.getHeight()-1, image));
		
		//Unten von rechts nach links auslesen
		for(int i = image.getWidth() - 1 - abstandX; i > 0; i-=abstandX)
			ledData.add(processPoint(i, image.getHeight()-1, image));
		
		//Unten links auslesen
		ledData.add(processPoint(0, image.getHeight()-1, image));
		
		//Links von unten nach oben auslesen
		for(int i = image.getHeight() -1 - abstandY; i > 0; i-=abstandY)
			ledData.add(processPoint(0, i, image));
		
		
		
		return ledData;
	}
	
	private int processPoint(int x, int y, BufferedImage image){
		return image.getRGB(x,y);
	}

}
