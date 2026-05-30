package com.tsg.scratchjava.sys;

import java.util.Hashtable;

import javax.microedition.lcdui.Image;

public class ImageUtil {
	// Source - https://stackoverflow.com/a/20273942
	// Posted by mr_lou
	// Retrieved 2026-05-30, License - CC BY-SA 3.0
	
	private static Hashtable cache = new Hashtable();
	
	public static Image scale(Image original, int newWidth, int newHeight) {
		String key = original + "w_" + newWidth + "h_" + newHeight;
		if (cache.get(key) != null) {
			return (Image) cache.get(key);
		}
	 int[] rawInput = new int[original.getHeight() * original.getWidth()];
	 original.getRGB(rawInput, 0, original.getWidth(), 0, 0, original.getWidth(), original.getHeight());

	 int[] rawOutput = new int[newWidth * newHeight];

	 // YD compensates for the x loop by subtracting the width back out
	 int YD = (original.getHeight() / newHeight) * original.getWidth() - original.getWidth();
	 int YR = original.getHeight() % newHeight;
	 int XD = original.getWidth() / newWidth;
	 int XR = original.getWidth() % newWidth;
	 int outOffset = 0;
	 int inOffset = 0;

	 for (int y = newHeight, YE = 0; y > 0; y--) {
	   for (int x = newWidth, XE = 0; x > 0; x--) {
	     rawOutput[outOffset++] = rawInput[inOffset];
	     inOffset += XD;
	     XE += XR;
	     if (XE >= newWidth) {
	       XE -= newWidth;
	       inOffset++;
	     }
	   }
	   inOffset += YD;
	   YE += YR;
	   if (YE >= newHeight) {
	     YE -= newHeight;
	     inOffset += original.getWidth();
	   }
	 }
	 rawInput = null;
	 cache.put(key, Image.createRGBImage(rawOutput, newWidth, newHeight, true));
	 return (Image) cache.get(key);
	}
}
