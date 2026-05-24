package com.tsg.scratchjava.sys;

import java.io.IOException;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Image;

import com.tsg.scratchjava.Launcher;

public class SysLoader {
	public SysLoader() {
		Font font = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
		int size = 16;
		if (font.getHeight() >= 24) {
			size = 24;
		} else if (font.getHeight() >= 32) {
			size = 32;
		}
		try {
			Launcher.canvas.loadedImages = new Image[]{
					Image.createImage("/res/img/back-" + size + ".png"),
					Image.createImage("/res/img/greenflag-" + size + ".png"),
					Image.createImage("/res/img/stop-" + size + ".png"),
					Image.createImage("/res/img/clockwise-" + size + ".png"),
					Image.createImage("/res/img/cc-" + size + ".png")
			};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
