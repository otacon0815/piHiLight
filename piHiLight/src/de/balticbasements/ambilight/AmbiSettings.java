package de.balticbasements.ambilight;

public class AmbiSettings {
	
	static int webcamX = 640;
	static int webcamY = 480;
	static int ledCountX = 10;
	static int ledCountY = 5;
	static int framesPerSecond = 10;

	public static int getWebcamX() {
		return webcamX;
	}

	public static void setWebcamX(int value) {
		webcamX = value;
	}

	public static int getWebcamY() {
		return webcamY;
	}

	public static void setWebcamY(int value) {
		webcamY = value;
	}

	public static int getLedCountX() {
		return ledCountX;
	}

	public static void setLedCountX(int getLedCountX) {
		AmbiSettings.ledCountX = getLedCountX;
	}

	public static int getLedCountY() {
		return ledCountY;
	}

	public static void setLedCountY(int getLedCountY) {
		AmbiSettings.ledCountY = getLedCountY;
	}

	public static int getFramesPerSecond() {
		return framesPerSecond;
	}

	public static void setFramesPerSecond(int framesPerSecond) {
		AmbiSettings.framesPerSecond = framesPerSecond;
	}
	
	
}
