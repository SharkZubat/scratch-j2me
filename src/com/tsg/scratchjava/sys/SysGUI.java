package com.tsg.scratchjava.sys;

import java.util.Calendar;
import java.util.Hashtable;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class SysGUI {
	private static Hashtable cache = new Hashtable();

	public static void rendertopbar(Graphics g, Calendar calendar, String bat, int width) {
		String widthkey = "W"+width;
		String key = "W1"+width;
		String widthval = String.valueOf(width);
		Image image = null;
		if ((cache.get(key) != null)) {
			image = (Image) cache.get(key);
		} else {
			int[] argb = new int[width*g.getFont().getHeight()];
			for (int i = 0; i < argb.length; i++) {
				argb[i] = 0x80000000;
			}
			image = Image.createRGBImage(argb, width, g.getFont().getHeight(), true);
			cache.put(key, image);
		}
		g.drawImage(image, 0, 0, 0);
		cache.put(widthkey, widthval);
		g.setColor(0xffffff);
		g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
		g.drawString(calendar.get(Calendar.HOUR)+":"+((calendar.get(Calendar.MINUTE) < 10) ? "0" + calendar.get(Calendar.MINUTE) : String.valueOf(calendar.get(Calendar.MINUTE))), 0, 0, 0);
		if (bat != null) {
			g.drawString(bat+"%",width-g.getFont().stringWidth(bat+"%"),0,0);
		} else {
			g.drawString("?%",width-g.getFont().stringWidth("?%"),0,0);
		}
	}
}
