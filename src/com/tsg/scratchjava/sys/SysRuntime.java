package com.tsg.scratchjava.sys;

import com.tsg.scratchjava.acs.Sprite;
import com.tsg.scratchjava.iacs.Stage;

public class SysRuntime {
	public Stage stage = new Stage();

	public void greenflag() {
		
	}
	
	public void stop() {
		
	}
	
	public void run(String blockName, Object[] args, int spriteIndex, boolean runWithoutRefresh) {
		if (blockName == "forward:") {
			((Sprite) stage.sprites.elementAt(spriteIndex)).pos.changePos(Float.valueOf((String)args[0]).floatValue()*(float)AdvMath.sin(((Sprite) stage.sprites.elementAt(spriteIndex)).pos.d), Float.valueOf((String)args[0]).floatValue()*(float)AdvMath.cos(((Sprite) stage.sprites.elementAt(spriteIndex)).pos.d), 0f);
			if (!runWithoutRefresh)
			stage.render(null);
		}
	}
}
