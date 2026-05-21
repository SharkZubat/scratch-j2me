package com.tsg.scratchjava.blocks;

import javax.microedition.lcdui.Font;

public class BlockArg {
	/*
	 * type 0 - text/label
	 * type 1 - number
	 * type 2 - string input
	 * type 3 - dropdown
	 * type 4 - boolean
	 * type 5 - variable/list dropdown
	 * type 6 - sub-block
	 */
	
	private int type;
	private Object[] objects;
	
	public BlockArg(int type, Object[] objects) {
		// test
		this.type = type;
		this.objects = objects;
	}
	
	public int getType() {
		return type;
	}
	
	public Object[] getObjectArray() {
		return objects;
	}
	
	public static int getWidth(BlockArg blockarg) {
		Font font = Font.getDefaultFont();
		switch (blockarg.getType()) {
		case 0: {
			return font.stringWidth((String)blockarg.getObjectArray()[0]);
		}
		case 1:
		case 2: {
			return font.stringWidth((String)blockarg.getObjectArray()[0])+4;
		}
		}
		return 0;
	}
}
