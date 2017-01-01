package de.balticbasements.ambilight;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestCase2 {

	public static void main(String[] args){
				
		JFrame f = new JFrame();
	    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    f.setSize( AmbiSettings.getWebcamX(), AmbiSettings.getWebcamY() );
	    
	    ImageProcessor imgPrc = new ImageProcessor();
	    
	    long timelaps = 1000 / AmbiSettings.getFramesPerSecond();
	    long then = System.currentTimeMillis();
	    
	    while(true){
	    	
	    	long now = System.currentTimeMillis();
	    	if((now - timelaps)<then){
	    		continue;
	    	}else{
	    		then = now;
	    	}
	    	
	    	
			BufferedImage image = CamHandler.getImage();
			List<Integer> colors = imgPrc.processImage(image);
			//f.add( new DrawPanel(colors, image) );   
			image.flush();
			f.setVisible( true );
	    }
	}
}

@SuppressWarnings("serial")
class DrawPanel extends JPanel
{
	BufferedImage image;
	List<Integer> colors;
	
	public DrawPanel(List<Integer> colors,BufferedImage image){
		this.colors = colors;
		this.image = image;
	}
	
  @Override
  protected void paintComponent( Graphics g )
  {
    super.paintComponent( g );
	g.setColor( Color.BLACK );
	g.clearRect(0, 0, AmbiSettings.getWebcamX(), AmbiSettings.getWebcamY());
	    
	    g.drawImage(image,
	    	       1, 1, image.getWidth(), image.getHeight(),
	    	       1, 1, image.getWidth(), image.getHeight(),
	    	       null);
	    
	    int breite = 20;
	    
	    for(int i = 0; i < colors.size(); i++){
	    	g.setColor(new Color(colors.get(i)));
	    	for(int b = 1; b <= breite; b++)
	    		g.drawLine(i*breite+b, 100, i*breite+b, 200);
	    }
	image.flush();
  }
}