package com.tsg.scratchjava.sys;

public class AdvMath {
	public static float sin(float f) { return (float) Math.sin(Math.toRadians(f)); }
	public static float cos(float f) { return (float) Math.cos(Math.toRadians(f)); }
	public static float tan(float f) { return (float) Math.tan(Math.toRadians(f)); }
	public static float asin(float f) {
		if (f >= 1.0)  return (float) (Math.PI / 2);
		if (f <= -1.0) return (float) (-Math.PI / 2);
		float guess = f;
		for (int i = 0; i < 10; i++) {
			float cosG = (float) Math.cos(guess);
			if (cosG == 0) break;
			guess -= (Math.sin(guess) - f) / cosG;
		}
		return guess;
	}
	public static float acos(float f) {
		return (float)Math.PI / 2 - asin(f);
	}
	public static float atan(float f) {
		float guess = f / (1.0f + (float)Math.abs(f));
		for (int i = 0; i < 20; i++) {
			float cosG = (float)Math.cos(guess);
			if (cosG == 0) break;
			float cos2 = cosG * cosG;
			guess -= (Math.sin(guess) / cosG - f) * cos2;
		}
		return (float) guess;
	}
	public static float atan2(float x, float y) {
		if (x > 0) {
			return atan(y / x);
		} else if (x < 0) {
	    	if (y >= 0) return atan(y / x) + (float)Math.PI;
	        else return atan(y / x) - (float)Math.PI;
	    } else {
	    	if (y > 0) return (float)Math.PI / 2;
	        if (y < 0) return (float)-Math.PI / 2;
	        return 0;
	    }
	}
}