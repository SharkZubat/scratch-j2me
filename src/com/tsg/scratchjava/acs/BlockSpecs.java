package com.tsg.scratchjava.acs;

import com.tsg.scratchjava.blocks.BlockArg;

public class BlockSpecs {
	private int type;
	private BlockArg[] blockArgs;
	private int color;
	private String iN;

	public BlockSpecs(int type, BlockArg[] blockArgs, int color, String iN) {
		this.type = type;
		this.blockArgs = blockArgs;
		this.color = color;
		this.iN = iN;
	}
	
	public int getType() {
		return type;
	}
	
	public BlockArg[] getBAs() {
		return blockArgs;
	}
	
	public int getColor() {
		return color;
	}
	
	public String getIN() {
		return iN;
	}
	
	public static int getIdxFrom(String iN, BlockSpecs[] bs) {
		for (int i=0; i < bs.length; i++) {
			if (bs[i].getIN() == iN) {
				System.out.println(bs[i].getIN() + "is" + iN + i);
				return i;
			} else {
				System.out.println(bs[i].getIN() + "is not" + iN + i);
			}
		}
		return -1;
	}
}
