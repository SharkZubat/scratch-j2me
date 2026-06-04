package com.tsg.scratchjava.sys;

import java.util.Hashtable;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class ImageUtil {
	private static Hashtable cache = new Hashtable();

	/**
	  * This methog resizes an image by resampling its pixels
	  * @param src The image to be resized
	  * @return The resized image
	  */

	  public static Image resizeImage(Image src, int screenWidth, int screenHeight) {
	      int srcWidth = src.getWidth();
	      int srcHeight = src.getHeight();
	      Image tmp = Image.createImage(screenWidth, srcHeight);
	      Graphics g = tmp.getGraphics();
	      int ratio = (srcWidth << 16) / screenWidth;
	      int pos = ratio/2;
	      //Horizontal Resize        

	      for (int x = 0; x < screenWidth; x++) {
	          g.setClip(x, 0, 1, srcHeight);
	          g.drawImage(src, x - (pos >> 16), 0, Graphics.LEFT | Graphics.TOP);
	          pos += ratio;
	      }

	      Image resizedImage = Image.createImage(screenWidth, screenHeight);
	      g = resizedImage.getGraphics();
	      ratio = (srcHeight << 16) / screenHeight;
	      pos = ratio/2;        

	      //Vertical resize

	      for (int y = 0; y < screenHeight; y++) {
	          g.setClip(0, y, screenWidth, 1);
	          g.drawImage(tmp, 0, y - (pos >> 16), Graphics.LEFT | Graphics.TOP);
	          pos += ratio;
	      }
	      return resizedImage;

	  }//resize image
	  
	    public static Image rotateImage(Image image, float angle) {
	    	String key = image.hashCode() + "D_" + Math.floor(angle*2)/2;
	    	if (cache.get(key) != null) {
	    		return (Image)cache.get(key);
	    	}
	    	//radians and sin, cos
	    	double radians = Math.toRadians(Math.floor(angle*2)/2);
	    	float sin = (float) Math.sin(radians);
	    	float cos = (float) Math.cos(radians);
	    	//datas
	    	int[] srcData = new int[image.getWidth()*image.getHeight()];
	        image.getRGB(srcData, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
	        int newWidth = (int) Math.floor(Math.abs(image.getWidth()*cos)+Math.abs(image.getHeight()*sin));
	        int newHeight = (int) Math.floor(Math.abs(image.getHeight()*cos)+Math.abs(image.getWidth()*sin));
	        int[] dstData = new int[newWidth*newHeight];
	        for (int y = 0; y < newHeight; y++) {
	            for (int x = 0; x < newWidth; x++) {
	                int srcX = (int)((x-newWidth/2)*cos-(y-newHeight/2)*sin+image.getWidth()/2);
	                int srcY = (int)((x-newWidth/2)*sin+(y-newHeight/2)*cos+image.getHeight()/2);
	                if (srcX >= 0 && srcX < image.getWidth() && srcY >= 0 && srcY < image.getHeight()) {
	                    dstData[x+y*newWidth] = srcData[srcX+srcY*image.getWidth()];
	                } else {
	                    dstData[x+y*newWidth] = 0x00000000;
	                }
	            }
	        }
	        cache.put(key, Image.createRGBImage(dstData, newWidth, newHeight, true));
	        return (Image)cache.get(key);
	    }
}
