package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class OceanGraphics {

    /**
     * Images for all OceanObjects and Ocean
     */
    private static BufferedImage fishImage, bubbleImage, plantImage,
	    sharkImage, stoneImage, oceanImage;

    /**
     * Boolean Flag if Images have been loaded successfully
     */
    private static boolean loaded;

    /**
     * Default Constructor
     */
    public OceanGraphics() {

    }

    /**
     * 
     * @param oceanObject
     *            The OceanObject you need the Image of
     * @return image The BufferedImage that belongs to the OceanObject
     */
    public static BufferedImage getImage(OceanObject oceanObject) {
	if (!loaded) {
	    loadAllImages();
	}
	BufferedImage image = null;
	if (oceanObject.getClass().equals(Fish.class)) {
	    image = fishImage;
	} else if (oceanObject.getClass().equals(Bubble.class)) {
	    image = bubbleImage;
	} else if (oceanObject.getClass().equals(Plant.class)) {
	    image = plantImage;
	} else if (oceanObject.getClass().equals(Shark.class)) {
	    image = sharkImage;
	} else if (oceanObject.getClass().equals(Stone.class)) {
	    image = stoneImage;
	}
	return image;
    }

    /**
     * Returns the Image of the OceanBackground
     * 
     * @return oceanImage
     * 			The Image of the OceanBackgrounf
     */
    public static BufferedImage getOceanImage() {
	return oceanImage;
    }

    /**
     * Tries to load all Images, when failed it informs the user about it
     */
    public static void loadAllImages() {
	try {
	    fishImage = ImageIO.read(OceanGraphics.class
		    .getResource("/res/fish (2).png"));
	    bubbleImage = ImageIO.read(OceanGraphics.class
		    .getResource("/res/bubble.png"));
	    plantImage = ImageIO.read(OceanGraphics.class
		    .getResource("/res/plant.png"));
	    sharkImage = ImageIO.read(OceanGraphics.class
		    .getResource("/res/shark.png"));
	    stoneImage = ImageIO.read(OceanGraphics.class
		    .getResource("/res/stone.png"));
	    oceanImage = ImageIO.read(OceanGraphics.class
		    .getResource("/res/Ocean.png"));
	    loaded = true;
	} catch (IOException e) {
	    loaded = false;
	    JOptionPane optionPane = new JOptionPane();
	    JOptionPane.showMessageDialog(optionPane,
		    "Error while reading ImageFiles", "File not Found",
		    JOptionPane.ERROR_MESSAGE);
	}
    }

}
