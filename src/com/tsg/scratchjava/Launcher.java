package com.tsg.scratchjava;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class Launcher extends MIDlet {
	private Display display;
	private boolean isRunning;
	private Canvas levelGame;
    
    public void startApp() {
    	if (!isRunning) {
	    	isRunning = true;
	    	display = Display.getDisplay(this);
	    	levelGame = new Canvas();
	        levelGame.start();
	        Display.getDisplay(this).setCurrent(levelGame);
    	}
    }

    public void pauseApp() {
        // todo: make to pause, not returning to beginning one
    }

    public void destroyApp(boolean arg0) {
    	isRunning = false;
    }
    
    public void switchDisplay(Displayable nextDisplayable) {
        display.setCurrent(nextDisplayable);
    }

}