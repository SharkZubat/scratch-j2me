package com.tsg.scratchjava.acs;

import javax.microedition.lcdui.Font;

import com.tsg.scratchjava.blocks.BlockArg;
import com.tsg.scratchjava.blocks.BlockRenderer;
import com.tsg.scratchjava.sys.Point;

public class Block {
	private String internalName = "forward:";
	public Point point;
	public Block connectedWith;
	public Block(String string, Point point, Block connectedWith) {
		 internalName = string;
		 this.point = point;
		 this.connectedWith = connectedWith;
	}
	
	public String getIN() {
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
