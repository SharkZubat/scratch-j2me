package com.tsg.scratchjava;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class Launcher extends MIDlet {
	private Display display;
	public static Canvas canvas;
	private boolean isRunning;
    
    public void startApp() {
    	if (!isRunning) {
	    	isRunning = true;
	    	display = Display.getDisplay(this);
	    	canvas = new Canvas();
	        canvas.start();
	        Display.getDisplay(this).setCurrent(canvas);
    	}
    }

    public void pauseApp() {}

    public void destroyApp(boolean arg0) {
    	isRunning = false;
    }
    
    public void switchDisplay(Displayable nextDisplayable) {
        display.setCurrent(nextDisplayable);
    }

}