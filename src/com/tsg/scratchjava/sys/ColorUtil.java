package com.tsg.scratchjava.sys;

public class ColorUtil {
	public static int colorLerp(int color1, int color2) {
		return (((color1&0xfefefefe)>>1)+((color2&0xfefefefe)>>1));
	}
}
