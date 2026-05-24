package com.tsg.scratchjava.sys;

import javax.microedition.lcdui.Font;

import com.tsg.scratchjava.blocks.BlockArg;
import com.tsg.scratchjava.blocks.BlockRenderer;

public class Block {
	private static String internalName = "moveSteps";
	public Block(String string, Point point) {
		 internalName = string;
	}
	
	public static String getIN() {
		return internalName;
	}
	
	public static int getWidth(BlockArg[] blockArgs, int corners, Font font) {
		Point blocksize = new Point(BlockRenderer.getWidth(blockArgs)-corners, font.getHeight());
		return (int)blocksize.getX()+(corners*4);
	}
	
	public static int getHeight(BlockArg[] blockArgs, int corners, Font font) {
		Point blocksize = new Point(BlockRenderer.getWidth(blockArgs)-corners, font.getHeight());
		return (int)blocksize.getY()+corners;
	}
}
