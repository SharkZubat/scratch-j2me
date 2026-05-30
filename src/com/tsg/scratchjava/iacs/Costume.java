package com.tsg.scratchjava.iacs;

import java.io.IOException;
import java.util.Hashtable;

import javax.microedition.lcdui.Image;

public class Costume {
	public String name;
	public Image image;
	private Hashtable cache = new Hashtable();

	public Costume(String string, Image createImage) {
		// TODO Auto-generated constructor stub
		name = string;
		image = createImage;
	}

	public static Costume load(String string) {
		// TODO Auto-generated method stub
		try {
			return new Costume(string, Image.createImage(string));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("catched nothing");
			return null;
		}
	}
	
	public Image getImage() {
		String key = "C_" + image;
		if (cache.get(key) != null) {
			return (Image) cache.get(key);
		}
		cache.put(key, image);
		return (Image) cache.get(key);
	}
}
