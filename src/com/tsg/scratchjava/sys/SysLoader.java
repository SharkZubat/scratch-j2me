package com.tsg.scratchjava.sys;

import java.io.IOException;

import javax.microedition.lcdui.Image;

import com.tsg.scratchjava.Launcher;

public class SysLoader {
	public SysLoader() {
		try {
			Launcher.canvas.loadedImages = new Image[]{
					Image.createImage("/res/img/back-16.png"),
					Image.createImage("/res/img/greenflag-16.png"),
					Image.createImage("/res/img/stop-16.png"),
					Image.createImage("/res/img/clockwise-16.png"),
					Image.createImage("/res/img/cc-16.png")
			};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
