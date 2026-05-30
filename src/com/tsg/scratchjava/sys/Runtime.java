package com.tsg.scratchjava.sys;

import com.tsg.scratchjava.acs.Sprite;

public class Runtime {
	public void greenflag() {
		
	}
	
	public void stop() {
		
	}
	
	public void run(String blockName, Object[] args, Sprite sprite) {
		if (blockName == "forward:") {
			sprite.pos.changePos(Float.valueOf((String)args[0]).floatValue()*(float)Math.cos(sprite.pos.d), Float.valueOf((String)args[0]).floatValue()*(float)Math.sin(sprite.pos.d), 0f);
		}
	}
}
