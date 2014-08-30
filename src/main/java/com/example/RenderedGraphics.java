package com.example;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/** A simple class to show how to do vector graphics. */
public class RenderedGraphics {

	public static void main(String [] args) throws IOException {
	    // Create a buffered image.
	    int width = 100; int height = 100;
		RenderedImage image = createImage( new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB) );

		// Write generated image to a file
		saveImage( image, "newImage.png", "png" );
		saveImage( image, "newImage.jpg", "jpg" );
	}

	/** Render graphics into the given image. */
	public static RenderedImage createImage( BufferedImage image ) {
	    int width = image.getWidth(); 
		int height = image.getHeight();
		
	    // Create a graphics contents on the buffered image
	    Graphics2D g2d = image.createGraphics();
		// Raster raster = image.getData();

	    // Draw graphics
	    g2d.setColor(Color.white);
	    g2d.fillRect(0, 0, width, height);
	    g2d.setColor(Color.darkGray);
	    g2d.fillOval(0, 0, width, height);
	    g2d.setColor(Color.red);
	    g2d.fillOval(width/4, height/4, width/2, height/2);
	    g2d.setColor(new Color( Color.HSBtoRGB( 0.75f, 0.90f, 0.50f) ));
	    g2d.fillOval(width/4, height/4, width/4, height/4);

	    // Graphics context no longer needed so dispose it
	    g2d.dispose();

	    return image;
	}
	
	/** Save a image given image to a file name of given type ("jpg", "png", etc.) */
	public static void saveImage( RenderedImage image, String name, String type ) throws IOException {
		// File file = new File("newimage.png");
		// ImageIO.write(rendImage, "png", file);
	    // file = new File("newimage.jpg");
	    // ImageIO.write(rendImage, "jpg", file);

		File file = new File( name );
		ImageIO.write( image, type, file );
	}
}