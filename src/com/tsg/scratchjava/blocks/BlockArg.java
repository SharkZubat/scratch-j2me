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
	 * type 7 - green-flag
	 * type 8 - stop-sign
	 * type 9 - clockwise
	 * type 10 - counter clockwise
	 * type 11 - c-block sub-block
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
	
	public static int getWidth(BlockArg blockarg, float size) {
		Font font = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
		Font boldFont = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
		switch (blockarg.getType()) {
		case 0: {
			return boldFont.stringWidth((String)blockarg.getObjectArray()[0]);
		}
		case 1:
		case 2: {
			return font.stringWidth((String)blockarg.getObjectArray()[0])+(int)(4*size);
		}
		case 3: {
			return font.stringWidth((String)blockarg.getObjectArray()[0])+(int)(10*size);
		}
		case 4: {
			return (int)(20*size);
		}
		}
		return 0;
	}
}
