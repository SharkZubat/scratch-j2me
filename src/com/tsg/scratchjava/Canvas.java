package com.tsg.scratchjava;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;

import com.tsg.scratchjava.blocks.BlockArg;
import com.tsg.scratchjava.blocks.BlockRenderer;
import com.tsg.scratchjava.sys.Point;
import com.tsg.scratchjava.sys.Sys;
import com.tsg.scratchjava.sys.SysLoader;

public class Canvas extends GameCanvas implements Runnable {

	private boolean isRunning;
	private Thread gameThread;
	private Point point = new Point(0,0);
	public Image[] loadedImages;

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
	}
	
	protected void pointerDragged(int x, int y) {
		point = new Point(x,y);
	}

	public void run() {
		// TODO Auto-generated method stub
		while (isRunning) {
			draw();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void draw() {
		Graphics g = getGraphics();
		
		g.setColor(0xd0d0d0);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if (Sys.isProto) {
			g.setColor(0);
			g.drawString("Scratch j2me proto " + Sys.version + " " + Sys.builds, 0, 0, 0); }
		
		BlockRenderer.renderblock(3, new BlockArg[] {
			    new BlockArg(0, new Object[]{"label"}),
			    new BlockArg(1, new Object[]{"10"}),
			    new BlockArg(2, new Object[]{"hello"}),
			    new BlockArg(3, new Object[]{"dropdown"}),
			    new BlockArg(4, new Object[]{null}),
			    new BlockArg(5, new Object[]{""}),
			    new BlockArg(6, new Object[]{null}),
			    new BlockArg(7, new Object[]{null}),
			    new BlockArg(8, new Object[]{null}),
			    new BlockArg(9, new Object[]{null}),
			    new BlockArg(10, new Object[]{null}),
			    new BlockArg(11, new Object[]{null})
			}, point, 0x3061D3, loadedImages, g);
		
		flushGraphics();
	}
}
