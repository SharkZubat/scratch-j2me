package com.tsg.scratchjava;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

import com.tsg.scratchjava.blocks.BlockRenderer;
import com.tsg.scratchjava.sys.Point;

public class Canvas extends GameCanvas implements Runnable {

	private boolean isRunning;
	private Thread gameThread;
	private Point point = new Point(0,0);
	BlockRenderer b = new BlockRenderer();

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
		Font font = Font.getDefaultFont();
		
		b.renderblock(0, "move (10) steps", point, 0x3061D3, g);
		flushGraphics();
	}
}
