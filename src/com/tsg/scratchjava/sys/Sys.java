package com.tsg.scratchjava.sys;

import com.tsg.scratchjava.acs.Block;
import com.tsg.scratchjava.acs.BlockSpecs;
import com.tsg.scratchjava.blocks.BlockArg;

public class Sys {
	public static String name = "Scratch J2ME";
	public static String portbyuser = "thesharkguy";
	public static String version = "v0.1";
	public static String builds = "118";
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
				new BlockArg(0, new Object[]{"turn"}),
				new BlockArg(6, new Object[]{null}),
				new BlockArg(1, new Object[]{"10"}),
				new BlockArg(0, new Object[]{"degress"})
			}, 0x3061D3, "tst:")
	};
}
