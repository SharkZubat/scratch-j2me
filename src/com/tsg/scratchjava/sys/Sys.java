package com.tsg.scratchjava.sys;

import com.tsg.scratchjava.acs.Block;
import com.tsg.scratchjava.acs.BlockSpecs;
import com.tsg.scratchjava.blocks.BlockArg;

public class Sys {
	public static String name = "Scratch J2ME";
	public static String portbyuser = "thesharkguy";
	public static String version = "v0.1";
	public static String builds = "119";
	public static boolean isProto = true;
	
	public static BlockSpecs[] motion = new BlockSpecs[]{
		new BlockSpecs(0, new BlockArg[] {
			    new BlockArg(0, new Object[]{"move"}),
			    new BlockArg(1, new Object[]{"10"}),
			    new BlockArg(0, new Object[]{"steps"})
			}, 0x3061D3, "forward:"),
		new BlockSpecs(0, new BlockArg[] {
			    new BlockArg(0, new Object[]{"turn"}),
			    new BlockArg(9, new Object[]{null}),
			    new BlockArg(1, new Object[]{"10"}),
			    new BlockArg(0, new Object[]{"degress"})
			}, 0x3061D3, "turnRight:"),
		new BlockSpecs(0, new BlockArg[] {
				new BlockArg(0, new Object[]{"turn"}),
				new BlockArg(10, new Object[]{null}),
				new BlockArg(1, new Object[]{"10"}),
				new BlockArg(0, new Object[]{"degress"})
			}, 0x3061D3, "turnLeft:"),
		new BlockSpecs(0, new BlockArg[] {
				new BlockArg(0, new Object[]{"point in direction"}),
				new BlockArg(13, new Object[]{"90"})
			}, 0x3061D3, "heading:"),
		new BlockSpecs(0, new BlockArg[] {
				new BlockArg(0, new Object[]{"point towards"}),
				new BlockArg(3, new Object[]{null})
			}, 0x3061D3, "pointTowards:")
	};
}
