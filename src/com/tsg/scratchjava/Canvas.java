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
import com.tsg.scratchjava.sys.SysLoader;

public class Canvas extends GameCanvas implements Runnable {

	private boolean isRunning;
	private Thread gameThread;
	private Point point = new Point(0,0);
	Font font = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
	public Image[] loadedImages;
	String bat = System.getProperty("com.nokia.mid.batterylevel");
	Calendar calendar = Calendar.getInstance();
	public Stage stage = new Stage();

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
	        calendar.setTime(new Date(System.currentTimeMillis()));
	        bat = System.getProperty("com.nokia.mid.batterylevel");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void freeup() {
		// TODO Auto-generated method stub
		System.gc();
	}

	private void draw() {
		Graphics g = getGraphics();
		
		g.setColor(0xd0d0d0);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		stage.render();
		g.drawImage(ImageUtil.scale(stage.view, getWidth(), (int)(360*(getWidth()/480f))), 0, 0, 0);
		BlockRenderer.renderblock(new Block("pointTowards:", point, new Block("forward:", new Point(0,15), null)), loadedImages, g);

		if (Sys.isProto) {
			g.setColor(0);
			g.setFont(Font.getFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_SMALL));
			g.drawString("Scratch j2me proto " + Sys.version + " " + Sys.builds, 0, 20, 0);
			g.drawString(Runtime.getRuntime().freeMemory() + "B/" + Runtime.getRuntime().totalMemory() + "B", 0, Font.getDefaultFont().getHeight()+20, 0);}
		g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
		g.drawString(calendar.get(Calendar.HOUR)+":"+((calendar.get(Calendar.MINUTE) < 10) ? "0" + calendar.get(Calendar.MINUTE) : String.valueOf(calendar.get(Calendar.MINUTE))), 0, 0, 0);
		if (bat != null) {
			g.drawString(bat+"%", getWidth()-g.getFont().stringWidth(bat+"%"), 0, 0);
		} else {
			g.drawString("?%",getWidth()-g.getFont().stringWidth("?%"),0,0);
		}
		flushGraphics();
	}
}
