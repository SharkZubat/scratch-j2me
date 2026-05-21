package com.tsg.scratchjava;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

import com.tsg.scratchjava.blocks.BlockArg;
import com.tsg.scratchjava.blocks.BlockRenderer;
import com.tsg.scratchjava.sys.Point;

public class Canvas extends GameCanvas implements Runnable {

	private boolean isRunning;
	private Thread gameThread;
	private Point point = new Point(0,0);

	public Canvas() {
		super(true);
		setFullScreenMode(true);
		// TODO Auto-generated constructor stub
	}
	
	public void start() {
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
		}
	}
	
	private void draw() {
		Graphics g = getGraphics();
		
		BlockRenderer.renderblock(0, new BlockArg[] {
			    new BlockArg(0, new Object[]{"move"}),
			    new BlockArg(1, new Object[]{"10"}),
			    new BlockArg(0, new Object[]{", and"}),
			    new BlockArg(2, new Object[]{"hello"}),
			    new BlockArg(0, new Object[]{"steps"})
			}, point, 0x3061D3, g);
		flushGraphics();
	}
}
