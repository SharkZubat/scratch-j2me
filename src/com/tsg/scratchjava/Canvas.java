package com.tsg.scratchjava;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;

import com.tsg.scratchjava.acs.Block;
import com.tsg.scratchjava.acs.Sprite;
import com.tsg.scratchjava.blocks.BlockRenderer;
import com.tsg.scratchjava.iacs.Stage;
import com.tsg.scratchjava.sys.ImageUtil;
import com.tsg.scratchjava.sys.Point;
import com.tsg.scratchjava.sys.Sys;
import com.tsg.scratchjava.sys.SysGUI;
import com.tsg.scratchjava.sys.SysLoader;
import com.tsg.scratchjava.sys.SysRuntime;

public class Canvas extends GameCanvas implements Runnable {

	private boolean isRunning;
	private Thread gameThread;
	private Point point = new Point(0,0);
	Font font = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
	public Image[] loadedImages;
	String bat = System.getProperty("com.nokia.mid.batterylevel");
	Calendar calendar = Calendar.getInstance();
	public SysRuntime runtime = new SysRuntime();
	public SysGUI gui = new SysGUI();

	public Canvas() {
		super(true);
		setFullScreenMode(true);
		// TODO Auto-generated constructor stub
	}
	
	public void start() {
		new SysLoader();
		isRunning = true;
        gameThread = new Thread(this);
		gameThread.start();
		draw();
	}
	
	protected void pointerDragged(int x, int y) {
		point = new Point(x,y);
		draw();
	}
	
	protected void sizeChanged(int x, int y) {
		draw();
	}

	public void run() {
		// TODO Auto-generated method stub
		while (isRunning) {
	        if (Runtime.getRuntime().freeMemory() <= Runtime.getRuntime().totalMemory()/5) {
	        	freeup();
	        }
	        runtime.run("forward:", new Object[]{"1"}, 0, true);
	        runtime.run("turnRight:", new Object[]{"0.4"}, 0, true);
	        calendar.setTime(new Date(System.currentTimeMillis()));
	        bat = System.getProperty("com.nokia.mid.batterylevel");
			try {
				Thread.sleep(33);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void freeup() {
		// TODO Auto-generated method stub
//		System.gc();
	}

	private void draw() {
		Graphics g = getGraphics();
		
		g.setColor(0xd0d0d0);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		Point point1 = (getWidth() < getHeight()) ? new Point(getWidth(), (360*(getWidth()/480f))) : new Point((480*(getHeight()/360f)), getHeight());
		runtime.stage.render(point1);
		g.drawImage(runtime.stage.view, 0, 0, 0);
		//g.drawImage(runtime.stage.view, 0, 0, 0);
		BlockRenderer.renderblock(new Block("pointTowards:", point, new Block("forward:", new Point(0,15), null)), loadedImages, g);

		if (Sys.isProto) {
			g.setColor(0);
			g.setFont(Font.getFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_SMALL));
			g.drawString("Scratch j2me proto " + Sys.version, 0, 20, 0);
			g.drawString(Runtime.getRuntime().freeMemory() + "B/" + Runtime.getRuntime().totalMemory() + "B", 0, Font.getDefaultFont().getHeight()+20, 0);}
		SysGUI.rendertopbar(g, calendar, bat, getWidth());
		flushGraphics();
	}
}
