package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class OceanGraphics {

    private static BufferedImage fishImage, bubbleImage, plantImage, sharkImage,
	    stoneImage, oceanImage;

    private static boolean loaded;

    public OceanGraphics() {

    }

    public static BufferedImage getImage(OceanObject oceanObject) {
	if (!loaded) {
	    loadAllImages();
	}
	if (oceanObject.getClass().equals(Fish.class)) {
	    return fishImage;
	} else if (oceanObject.getClass().equals(Bubble.class)) {
	    return bubbleImage;
	} else if (oceanObject.getClass().equals(Plant.class)) {
	    return plantImage;
	} else if (oceanObject.getClass().equals(Shark.class)) {
	    return sharkImage;
	} else if (oceanObject.getClass().equals(Stone.class)) {
	    return stoneImage;
	} else {
	    return null;
	}
    }

    public static BufferedImage getOceanImage() {
	return oceanImage;
    }

    public static void loadAllImages() {
	try {
	    fishImage = ImageIO
		    .read(OceanGraphics.class.getResource("/res/fish (2).png"));
	    bubbleImage = ImageIO
		    .read(OceanGraphics.class.getResource("/res/bubble.png"));
	    plantImage = ImageIO
		    .read(OceanGraphics.class.getResource("/res/plant.png"));
	    sharkImage = ImageIO
		    .read(OceanGraphics.class.getResource("/res/shark.png"));
	    stoneImage = ImageIO
		    .read(OceanGraphics.class.getResource("/res/stone.png"));
	    oceanImage = ImageIO
		    .read(OceanGraphics.class.getResource("/res/Ocean.png"));
	    loaded = true;
	} catch (IOException e) {
	    loaded = false;
	    JOptionPane optionPane = new JOptionPane();
	    JOptionPane.showMessageDialog(optionPane,
		    "Error while reading ImageFiles",
		    "File not Found", JOptionPane.ERROR_MESSAGE);
	}
    }

}
