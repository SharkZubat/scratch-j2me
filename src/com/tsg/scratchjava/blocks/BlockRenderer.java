package com.tsg.scratchjava.blocks;

import java.io.IOException;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import com.tsg.scratchjava.sys.ColorUtil;
import com.tsg.scratchjava.sys.Point;


public class BlockRenderer {
	static Font font = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
	static Font boldFont = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
	private static float size = font.getHeight()/15f;
	private static int space = (int) (8f*size);
	private static int jigsawspace = (int) (8f*size);
	private static int corners = (int) (3f*size);
	private static boolean light = true;
	private static int colorset = 0;
	public static void renderblock(int type, BlockArg[] blockArgs, Point point, int color, Graphics g) {
		Point blocksize = new Point(getWidth(blockArgs)-corners, font.getHeight());
		colorset = color;
		g.setColor(color);
		switch (type) {
			case 0: {
				/* TOP CORNERS */
				g.fillTriangle((int)point.getX(),(int)point.getY()+corners,
						(int)point.getX()+corners, (int)point.getY(),
						(int)point.getX()+corners, (int)point.getY()+corners);
				g.fillTriangle((int)point.getX()+corners+space,(int)point.getY(),
						(int)point.getX()+(corners*2)+space, (int)point.getY()+corners,
						(int)point.getX()+corners+space, (int)point.getY()+corners);
				g.fillTriangle((int)point.getX()+corners+space+jigsawspace,(int)point.getY()+corners,
						(int)point.getX()+(corners*2)+space+jigsawspace, (int)point.getY(),
						(int)point.getX()+(corners*2)+space+jigsawspace, (int)point.getY()+corners);
				g.fillTriangle((int)point.getX()+(corners*3)+(int)blocksize.getX(), (int)point.getY(),
						(int)point.getX()+(corners*4)+(int)blocksize.getX(), (int)point.getY()+corners,
						(int)point.getX()+(corners*3)+(int)blocksize.getX(), (int)point.getY()+corners);
				/* BOTTOM CORNERS */
				g.fillTriangle((int)point.getX(),(int)point.getY()+(int)blocksize.getY(),
						(int)point.getX()+corners, (int)point.getY()+corners+(int)blocksize.getY(),
						(int)point.getX()+corners, (int)point.getY()+(int)blocksize.getY());
				g.fillTriangle((int)point.getX()+corners+space,(int)point.getY()+corners+(int)blocksize.getY(),
						(int)point.getX()+(corners*2)+space, (int)point.getY()+(corners*2)+(int)blocksize.getY(),
						(int)point.getX()+(corners*2)+space, (int)point.getY()+corners+(int)blocksize.getY());
				g.fillTriangle((int)point.getX()+2+space+jigsawspace,(int)point.getY()+corners+(int)blocksize.getY(),
						(int)point.getX()+(corners*2)+space+jigsawspace, (int)point.getY()+corners+(int)blocksize.getY(),
						(int)point.getX()+corners+space+jigsawspace, (int)point.getY()+(corners*2)+(int)blocksize.getY());
				g.fillTriangle((int)point.getX()+(corners*3)+(int)blocksize.getX(),(int)point.getY()+(int)blocksize.getY(),
						(int)point.getX()+(corners*4)+(int)blocksize.getX(), (int)point.getY()+(int)blocksize.getY(),
						(int)point.getX()+(corners*3)+(int)blocksize.getX(), (int)point.getY()+corners+(int)blocksize.getY());
				/* BODY */
				g.fillRect((int)point.getX(), (int)point.getY()+corners, (corners*4)+(int)blocksize.getX(), (int)blocksize.getY()-corners);
				/* TOP BORDERS */
				g.fillRect((int)point.getX()+corners, (int)point.getY(), space, corners);
				g.fillRect((int)point.getX()+space+jigsawspace+(corners*2), (int)point.getY(), (int)blocksize.getX()-space-jigsawspace+corners, corners);
				/* BOTTOM BORDERS */
				g.fillRect((int)point.getX()+corners, (int)point.getY()+(int)blocksize.getY(), (int)blocksize.getX()+(corners*2), corners);
				g.fillRect((int)point.getX()+space+(corners*2), (int)point.getY()+(int)blocksize.getY()+corners, jigsawspace-corners, corners);
				
				if (light) {
					/* LIGHT */
					g.setColor(ColorUtil.colorLerp(color, 0xffffff));
					g.drawLine((int)point.getX(), (int)point.getY()+(int)blocksize.getY(),
							(int)point.getX(), (int)point.getY()+corners);
					g.drawLine((int)point.getX(), (int)point.getY()+corners,
							(int)point.getX()+corners, (int)point.getY());
					g.drawLine((int)point.getX()+corners, (int)point.getY(),
							(int)point.getX()+corners+space, (int)point.getY());
					g.drawLine((int)point.getX()+corners+space+jigsawspace+1, (int)point.getY()+corners-1,
							(int)point.getX()+(corners*2)+space+jigsawspace, (int)point.getY());
					g.drawLine((int)point.getX()+(corners*2)+space+jigsawspace, (int)point.getY(),
							(int)point.getX()+(corners*3)+(int)blocksize.getX()-1, (int)point.getY());
					/* SHADOW */
					g.setColor(ColorUtil.colorLerp(color, ColorUtil.colorLerp(color, 0)));
					g.drawLine((int)point.getX()+corners, (int)point.getY()+(int)blocksize.getY()+corners-1,
							(int)point.getX()+corners+space-1, (int)point.getY()+(int)blocksize.getY()+corners-1);
					g.drawLine((int)point.getX()+corners+space-1, (int)point.getY()+(int)blocksize.getY()+corners-1,
							(int)point.getX()+(corners*2)+space-1, (int)point.getY()+(int)blocksize.getY()+(corners*2)-1);
					g.drawLine((int)point.getX()+(corners*2)+space-1, (int)point.getY()+(int)blocksize.getY()+(corners*2)-1,
							(int)point.getX()+corners+space+jigsawspace, (int)point.getY()+(int)blocksize.getY()+(corners*2)-1);
					g.drawLine((int)point.getX()+corners+space+jigsawspace, (int)point.getY()+(int)blocksize.getY()+(corners*2)-1,
							(int)point.getX()+(corners*2)+space+jigsawspace, (int)point.getY()+(int)blocksize.getY()+corners-1);
					g.drawLine((int)point.getX()+(corners*2)+space+jigsawspace-1, (int)point.getY()+(int)blocksize.getY()+corners-1,
							(int)point.getX()+(corners*3)+(int)blocksize.getX(), (int)point.getY()+(int)blocksize.getY()+corners-1);
					g.drawLine((int)point.getX()+(corners*3)+(int)blocksize.getX(), (int)point.getY()+(int)blocksize.getY()+corners-1,
							(int)point.getX()+(corners*4)+(int)blocksize.getX()-1, (int)point.getY()+(int)blocksize.getY());
					g.drawLine((int)point.getX()+(corners*4)+(int)blocksize.getX()-1, (int)point.getY()+(int)blocksize.getY(),
							(int)point.getX()+(corners*4)+(int)blocksize.getX()-1, (int)point.getY()+corners);
				}
				break;
			}
			case 1: {
				/* TOP CORNERS */
				g.fillTriangle((int)point.getX(),(int)point.getY()+(int)(corners*1.5f),
						(int)point.getX()+(int)(corners*1.5f), (int)point.getY(),
						(int)point.getX()+(int)(corners*1.5f), (int)point.getY()+(int)(corners*1.5f));
				g.fillTriangle((int)point.getX()+(int)(corners*3f)+(int)blocksize.getX(), (int)point.getY()+(int)(corners*1.5f),
						(int)point.getX()+(int)(corners*1.5f)+(int)blocksize.getX(),(int)point.getY(),
						(int)point.getX()+(int)(corners*1.5f)+(int)blocksize.getX(), (int)point.getY()+(int)(corners*1.5f));
				/* BOTTOM CORNERS */
				g.fillTriangle((int)point.getX(),(int)point.getY()+(int)blocksize.getY()-corners/2,
						(int)point.getX()+(int)(corners*1.5f), (int)point.getY()+corners+(int)blocksize.getY(),
						(int)point.getX()+(int)(corners*1.5f), (int)point.getY()-corners/2+(int)blocksize.getY());
				g.fillTriangle((int)point.getX()+(int)(corners*3f)+(int)blocksize.getX(),(int)point.getY()+(int)blocksize.getY()-corners/2,
						(int)point.getX()+(int)(corners*1.5f)+(int)blocksize.getX(), (int)point.getY()+corners+(int)blocksize.getY(),
						(int)point.getX()+(int)(corners*1.5f)+(int)blocksize.getX(), (int)point.getY()-corners/2+(int)blocksize.getY());
				/* BODY */
				g.fillRect((int)point.getX(), (int)point.getY()+(int)(corners*1.5f), (corners*3)+(int)blocksize.getX(), 
						((int)point.getY()+(int)blocksize.getY()-corners/2)-((int)point.getY()+(int)(corners*1.5f)));
				g.fillRect((int)point.getX()+(int)(corners*1.5f), (int)point.getY(), (int)blocksize.getX(), (corners*2)+(int)blocksize.getY()-corners);
				if (light) {
					/* LIGHT */
					g.setColor(ColorUtil.colorLerp(color, 0xffffff));
					g.drawLine((int)point.getX(), (int)point.getY()-1+(int)blocksize.getY()-corners/2,
							(int)point.getX(), (int)point.getY()+(int)(corners*1.5f));
					g.drawLine((int)point.getX(), (int)point.getY()+(int)(corners*1.5f),
							(int)point.getX()+(int)(corners*1.5f), (int)point.getY());
					g.drawLine((int)point.getX()+(int)(corners*1.5f), (int)point.getY(),
							(int)point.getX()+(int)blocksize.getX()+corners, (int)point.getY());
					/* SHADOW */
					g.setColor(ColorUtil.colorLerp(color, ColorUtil.colorLerp(color, 0)));
					g.drawLine((int)point.getX()+(int)(corners*1.5f), (int)point.getY()-1+(int)blocksize.getY()-corners/2+(int)(corners*1.5f),
							(int)point.getX()+(int)blocksize.getX()+corners, (int)point.getY()-1+(int)blocksize.getY()-corners/2+(int)(corners*1.5f));
					g.drawLine((int)point.getX()+(int)blocksize.getX()+corners, (int)point.getY()-1+(int)blocksize.getY()-corners/2+(int)(corners*1.5f),
							(int)point.getX()+(int)blocksize.getX()+(corners*3), (int)point.getY()-1+(int)blocksize.getY()-corners/2);
					g.drawLine((int)point.getX()+(int)blocksize.getX()+(corners*3), (int)point.getY()-1+(int)blocksize.getY()-corners/2,
							(int)point.getX()+(int)blocksize.getX()+(corners*3), (int)point.getY()+(int)(corners*1.5f)+1);
				}
				break;
			}
			case 2: {
				/* LEFT EDGE */
				g.fillTriangle((int)point.getX()+(int)Math.ceil(blocksize.getY()/2),(int)point.getY(),
						(int)point.getX(), (int)point.getY()+(int)Math.floor(((corners*2)+(blocksize.getY()-corners)+0.001)/2)-1,
						(int)point.getX()+(int)Math.ceil(blocksize.getY()/2), (int)point.getY()+(corners*2)+(int)blocksize.getY()-corners);
				g.fillTriangle((int)point.getX()+(int)Math.ceil(blocksize.getY()/2),(int)point.getY(),
						(int)point.getX(), (int)point.getY()+(int)+Math.ceil(((corners*2)+(blocksize.getY()-corners)+0.001)/2)-1,
						(int)point.getX()+(int)Math.ceil(blocksize.getY()/2), (int)point.getY()+(corners*2)+(int)blocksize.getY()-corners);
				/* RIGHT EDGE */
				g.fillTriangle((int)point.getX()+(int)Math.ceil(blocksize.getY()/2)+(int)blocksize.getX()+(corners*4)-(int)blocksize.getY(),(int)point.getY(),
						(int)point.getX()+(int)blocksize.getX()+(corners*4)+1, (int)point.getY()+(int)Math.floor(((corners*2)+(blocksize.getY()-corners)+0.001)/2)-1,
						(int)point.getX()+(int)Math.ceil(blocksize.getY()/2)-1+(int)blocksize.getX()+(corners*4)-(int)blocksize.getY(), (int)point.getY()+(corners*2)+(int)blocksize.getY()-corners);
				g.fillTriangle((int)point.getX()+(int)Math.ceil(blocksize.getY()/2)+(int)blocksize.getX()+(corners*4)-(int)blocksize.getY(),(int)point.getY(),
						(int)point.getX()+(int)blocksize.getX()+(corners*4)+1, (int)point.getY()+(int)+Math.ceil(((corners*2)+(blocksize.getY()-corners)+0.001)/2)-1,
						(int)point.getX()+(int)Math.ceil(blocksize.getY()/2)-1+(int)blocksize.getX()+(corners*4)-(int)blocksize.getY(), (int)point.getY()+(corners*2)+(int)blocksize.getY()-corners);
				/* BODY */
				g.fillRect((int)point.getX()+(int)Math.ceil(blocksize.getY()/2), (int)point.getY(), (int)blocksize.getX()+(corners*4)-(int)blocksize.getY(), (corners*2)+(int)blocksize.getY()-corners);
				
				if (light) {
					/* LIGHT */
					g.setColor(ColorUtil.colorLerp(color, 0xffffff));
					g.drawLine((int)point.getX(), (int)point.getY()+(int)Math.floor(((corners*2)+(blocksize.getY()-corners)+0.001)/2)-1,
							(int)point.getX()+(int)Math.ceil(blocksize.getY()/2),(int)point.getY());
					g.drawLine((int)point.getX()+(int)Math.ceil(blocksize.getY()/2),(int)point.getY(),
							(int)point.getX()+(int)Math.ceil(blocksize.getY()/2)-1+(int)blocksize.getX()+(corners*4)-(int)blocksize.getY(),(int)point.getY());
					/* SHADOW */
					g.setColor(ColorUtil.colorLerp(color, ColorUtil.colorLerp(color, 0)));
					g.drawLine((int)point.getX()+1+(int)Math.ceil(blocksize.getY()/2), (int)point.getY()+(corners*2)+(int)blocksize.getY()-corners,
							(int)point.getX()+(int)Math.ceil(blocksize.getY()/2)-1+(int)blocksize.getX()+(corners*4)-(int)blocksize.getY(), (int)point.getY()+(corners*2)+(int)blocksize.getY()-corners);
					g.drawLine((int)point.getX()+(int)Math.ceil(blocksize.getY()/2)-1+(int)blocksize.getX()+(corners*4)-(int)blocksize.getY(), (int)point.getY()+(corners*2)+(int)blocksize.getY()-corners,
							(int)point.getX()+(int)blocksize.getX()+(corners*4)+1, (int)point.getY()+(int)+Math.ceil(((corners*2)+(blocksize.getY()-corners)+0.001)/2)-1);
				}
				break;
			}
			case 3: {
				/* TOP CORNERS */
				g.fillTriangle((int)point.getX(),(int)point.getY()+corners,
						(int)point.getX()+corners, (int)point.getY(),
						(int)point.getX()+corners, (int)point.getY()+corners);
				g.fillTriangle((int)point.getX()+(corners*3)+(int)blocksize.getX(), (int)point.getY(),
						(int)point.getX()+(corners*4)+(int)blocksize.getX(), (int)point.getY()+corners,
						(int)point.getX()+(corners*3)+(int)blocksize.getX(), (int)point.getY()+corners);
				/* BOTTOM CORNERS */
				g.fillTriangle((int)point.getX(),(int)point.getY()+(int)blocksize.getY(),
						(int)point.getX()+corners, (int)point.getY()+corners+(int)blocksize.getY(),
						(int)point.getX()+corners, (int)point.getY()+(int)blocksize.getY());
				g.fillTriangle((int)point.getX()+corners+space,(int)point.getY()+corners+(int)blocksize.getY(),
						(int)point.getX()+(corners*2)+space, (int)point.getY()+(corners*2)+(int)blocksize.getY(),
						(int)point.getX()+(corners*2)+space, (int)point.getY()+corners+(int)blocksize.getY());
				g.fillTriangle((int)point.getX()+2+space+jigsawspace,(int)point.getY()+corners+(int)blocksize.getY(),
						(int)point.getX()+(corners*2)+space+jigsawspace, (int)point.getY()+corners+(int)blocksize.getY(),
						(int)point.getX()+corners+space+jigsawspace, (int)point.getY()+(corners*2)+(int)blocksize.getY());
				g.fillTriangle((int)point.getX()+(corners*3)+(int)blocksize.getX(),(int)point.getY()+(int)blocksize.getY(),
						(int)point.getX()+(corners*4)+(int)blocksize.getX(), (int)point.getY()+(int)blocksize.getY(),
						(int)point.getX()+(corners*3)+(int)blocksize.getX(), (int)point.getY()+corners+(int)blocksize.getY());
				/* BODY */
				g.fillRect((int)point.getX(), (int)point.getY()+corners, (corners*4)+(int)blocksize.getX(), (int)blocksize.getY()-corners);
				/* TOP BORDERS */
				g.fillRect((int)point.getX()+corners, (int)point.getY(), space, corners);
				g.fillRect((int)point.getX()+(corners*2), (int)point.getY(), (int)blocksize.getX()+corners, corners);
				g.fillTriangle((int)point.getX()+corners, (int)point.getY(),
						(int)point.getX()+corners+(int)(size*30), (int)point.getY()-(int)(size*10),
						(int)point.getX()+corners+(int)(size*60), (int)point.getY());
				/* BOTTOM BORDERS */
				g.fillRect((int)point.getX()+corners, (int)point.getY()+(int)blocksize.getY(), (int)blocksize.getX()+(corners*2), corners);
				g.fillRect((int)point.getX()+space+(corners*2), (int)point.getY()+(int)blocksize.getY()+corners, jigsawspace-corners, corners);
				
				if (light) {
					/* LIGHT */
					g.setColor(ColorUtil.colorLerp(color, 0xffffff));
					g.drawLine((int)point.getX(), (int)point.getY()+(int)blocksize.getY(),
							(int)point.getX(), (int)point.getY()+corners);
					g.drawLine((int)point.getX(), (int)point.getY()+corners,
							(int)point.getX()+corners, (int)point.getY());
					g.drawLine((int)point.getX()+corners, (int)point.getY(),
							(int)point.getX()+corners+(int)(size*30), (int)point.getY()-(int)(size*10));
					g.drawLine((int)point.getX()+corners+(int)(size*30), (int)point.getY()-(int)(size*10),
							(int)point.getX()+corners+(int)(size*60), (int)point.getY());
					g.drawLine((int)point.getX()+corners+(int)(size*60), (int)point.getY(),
							(int)point.getX()+(corners*3)+(int)blocksize.getX()-1, (int)point.getY());
					/* SHADOW */
					g.setColor(ColorUtil.colorLerp(color, ColorUtil.colorLerp(color, 0)));
					g.drawLine((int)point.getX()+corners, (int)point.getY()+(int)blocksize.getY()+corners-1,
							(int)point.getX()+corners+space-1, (int)point.getY()+(int)blocksize.getY()+corners-1);
					g.drawLine((int)point.getX()+corners+space-1, (int)point.getY()+(int)blocksize.getY()+corners-1,
							(int)point.getX()+(corners*2)+space-1, (int)point.getY()+(int)blocksize.getY()+(corners*2)-1);
					g.drawLine((int)point.getX()+(corners*2)+space-1, (int)point.getY()+(int)blocksize.getY()+(corners*2)-1,
							(int)point.getX()+corners+space+jigsawspace, (int)point.getY()+(int)blocksize.getY()+(corners*2)-1);
					g.drawLine((int)point.getX()+corners+space+jigsawspace, (int)point.getY()+(int)blocksize.getY()+(corners*2)-1,
							(int)point.getX()+(corners*2)+space+jigsawspace, (int)point.getY()+(int)blocksize.getY()+corners-1);
					g.drawLine((int)point.getX()+(corners*2)+space+jigsawspace-1, (int)point.getY()+(int)blocksize.getY()+corners-1,
							(int)point.getX()+(corners*3)+(int)blocksize.getX(), (int)point.getY()+(int)blocksize.getY()+corners-1);
					g.drawLine((int)point.getX()+(corners*3)+(int)blocksize.getX(), (int)point.getY()+(int)blocksize.getY()+corners-1,
							(int)point.getX()+(corners*4)+(int)blocksize.getX()-1, (int)point.getY()+(int)blocksize.getY());
					g.drawLine((int)point.getX()+(corners*4)+(int)blocksize.getX()-1, (int)point.getY()+(int)blocksize.getY(),
							(int)point.getX()+(corners*4)+(int)blocksize.getX()-1, (int)point.getY()+corners);
				}
				break;
			}
		}
		renderargs(blockArgs, point, g);
	}
	
	private static void renderargs(BlockArg[] blockArgs, Point point, Graphics g) {
		// TODO Auto-generated method stub
		int width = 0;
		for (int i = 0; i < blockArgs.length; i++) {
			renderblockarg(new Point(point.getX()+width, point.getY()), blockArgs[i], g);
			width += BlockArg.getWidth(blockArgs[i], size) + corners;
		}
	}
	
	private static int getWidth(BlockArg[] blockArgs) {
		// TODO Auto-generated method stub
		int width = 0;
		for (int i = 0; i < blockArgs.length; i++) {
			width += BlockArg.getWidth(blockArgs[i], size) + corners;
		}
		return width;
	}

	public static void renderblockarg(Point point, BlockArg blockarg, Graphics g) {
		g.setColor(0xffffff);
		Object argset = blockarg.getObjectArray()[0];
		if (argset == null) {
			argset = "";
		}
		switch (blockarg.getType()) {
		case 0: {
			g.setFont(boldFont);
			g.drawString((String) argset, (int)point.getX()+(corners*2), (int)point.getY()+corners, 0);
			break;
		}
		case 1: {
			g.setFont(font);
			g.fillRoundRect((int)point.getX()+(corners*2), (int)point.getY()+(int)(corners*1.5f), font.stringWidth((String) argset)+4, font.getHeight()-corners, (int)(10*size), (int)(10*size));
			g.setColor(0xAAAAAA);
			g.drawRoundRect((int)point.getX()+(corners*2), (int)point.getY()+(int)(corners*1.5f), font.stringWidth((String) argset)+4, font.getHeight()-corners-1, (int)(10*size), (int)(10*size));
			g.setColor(0);
			g.drawString((String) argset, (int)point.getX()+(corners*2)+2, (int)point.getY()+corners, 0);
			break;
		}
		case 2: {
			g.setFont(font);
			g.fillRoundRect((int)point.getX()+(corners*2), (int)point.getY()+(int)(corners*1.5f), font.stringWidth((String) argset)+4, font.getHeight()-corners, (int)(5*size), (int)(5*size));
			g.setColor(0xAAAAAA);
			g.drawRoundRect((int)point.getX()+(corners*2), (int)point.getY()+(int)(corners*1.5f), font.stringWidth((String) argset)+4, font.getHeight()-corners-1, (int)(5*size), (int)(5*size));
			g.setColor(0);
			g.drawString((String) argset, (int)point.getX()+(corners*2)+2, (int)point.getY()+corners, 0);
			break;
		}
		case 5:
		case 3: {
			g.setFont(font);
			g.setColor(ColorUtil.colorLerp(colorset, ColorUtil.colorLerp(colorset, 0)));
			g.fillRect((int)point.getX()+(corners*2), (int)point.getY()+(int)(corners*1.5f), (int)Math.ceil(10*size)+font.stringWidth((String) argset), (int)(12*size));
			g.setColor(0);
			g.fillTriangle((int)point.getX()+(corners*2)+(int)(2*size)+font.stringWidth((String) argset), (int)point.getY()+(int)(corners*1.5f)+(int)(5*size),
					(int)point.getX()+(corners*2)+(int)(5*size)+font.stringWidth((String) argset), (int)point.getY()+(int)(corners*1.5f)+(int)(8*size),
					(int)point.getX()+(corners*2)+(int)(8*size)+font.stringWidth((String) argset), (int)point.getY()+(int)(corners*1.5f)+(int)(5*size));
			if (light) {
				/* HIGHLIGHT */
				g.setColor(ColorUtil.colorLerp(colorset, 0));
				g.drawLine((int)point.getX()+(corners*2), (int)point.getY()+(int)(corners*1.5f)+(int)(12*size),
						(int)point.getX()+(corners*2), (int)point.getY()+(int)(corners*1.5f));
				g.drawLine((int)point.getX()+(corners*2), (int)point.getY()+(int)(corners*1.5f),
						(int)point.getX()+(corners*2)+(int)(10*size)+font.stringWidth((String) argset), (int)point.getY()+(int)(corners*1.5f));
				/* SHADOW */
				g.setColor(ColorUtil.colorLerp(colorset, 0xffffff));
				g.drawLine((int)point.getX()+(corners*2), (int)point.getY()+(int)(corners*1.5f)+(int)(12*size),
						(int)point.getX()+(corners*2)+(int)(10*size)+font.stringWidth((String) argset), (int)point.getY()+(int)(corners*1.5f)+(int)(12*size));
				g.drawLine((int)point.getX()+(corners*2)+(int)(10*size)+font.stringWidth((String) argset), (int)point.getY()+(int)(corners*1.5f)+(int)(12*size),
						(int)point.getX()+(corners*2)+(int)(10*size)+font.stringWidth((String) argset), (int)point.getY()+(int)(corners*1.5f));
			}
			g.setColor(0xffffff);
			g.drawString((String) argset, (int)point.getX()+(corners*2)+2, (int)point.getY()+corners, 0);
			break;
		}
		case 4: {
			g.setColor(ColorUtil.colorLerp(colorset, ColorUtil.colorLerp(colorset, 0)));
			g.fillTriangle((int)point.getX()+(int)(6*size)+(corners*2), (int)point.getY()+(int)(corners*1.5f),
					(int)point.getX()+(corners*2), (int)point.getY()+(int)(6*size)+(int)(corners*1.5f),
					(int)point.getX()+(int)(6*size)+(corners*2), (int)point.getY()+(int)(12*size)+(int)(corners*1.5f));
			g.fillTriangle((int)point.getX()+(int)(14*size)+(corners*2), (int)point.getY()+(int)(corners*1.5f),
					(int)point.getX()+(int)(20*size)+(corners*2), (int)point.getY()+(int)(6*size)+(int)(corners*1.5f),
					(int)point.getX()+(int)(14*size)+(corners*2), (int)point.getY()+(int)(12*size)+(int)(corners*1.5f));
			g.fillRect((int)point.getX()+(int)(6*size)+(corners*2), (int)point.getY()+(int)(corners*1.5f), (int)Math.ceil(8*size), (int)(12*size));
			if (light) {
				/* HIGHLIGHT */
				g.setColor(ColorUtil.colorLerp(colorset, 0));
				g.drawLine((int)point.getX()+(corners*2), (int)point.getY()+(int)(6*size)+(int)(corners*1.5f),
						(int)point.getX()+(int)(6*size)+(corners*2), (int)point.getY()+(int)(corners*1.5f));
				g.drawLine((int)point.getX()+(int)(6*size)+(corners*2), (int)point.getY()+(int)(corners*1.5f),
						(int)point.getX()+(int)(14*size)+(corners*2), (int)point.getY()+(int)(corners*1.5f));
				g.drawLine((int)point.getX()+(int)(14*size)+(corners*2), (int)point.getY()+(int)(corners*1.5f),
						(int)point.getX()+(int)(20*size)+(corners*2), (int)point.getY()+(int)(6*size)+(int)(corners*1.5f));
				/* SHADOW */
				g.setColor(ColorUtil.colorLerp(colorset, 0xffffff));
				g.drawLine((int)point.getX()+(corners*2), (int)point.getY()+(int)(6*size)+(int)(corners*1.5f),
						(int)point.getX()+(int)(6*size)+(corners*2), (int)point.getY()+(int)(12*size)+(int)(corners*1.5f));
				g.drawLine((int)point.getX()+(int)(6*size)+(corners*2), (int)point.getY()+(int)(12*size)+(int)(corners*1.5f),
						(int)point.getX()+(int)(14*size)+(corners*2), (int)point.getY()+(int)(12*size)+(int)(corners*1.5f));
				g.drawLine((int)point.getX()+(int)(14*size)+(corners*2), (int)point.getY()+(int)(12*size)+(int)(corners*1.5f),
						(int)point.getX()+(int)(20*size)+(corners*2), (int)point.getY()+(int)(6*size)+(int)(corners*1.5f));
			}
			break;
		}
		case 7: {
			Image greenflag = null;
			try {
				greenflag = Image.createImage("/res/img/greenflag-16.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(greenflag, (int)point.getX()+(corners*2), (int)point.getY()+corners, 0);
			break;
		}
		case 8: {
			Image greenflag = null;
			try {
				greenflag = Image.createImage("/res/img/stop-16.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(greenflag, (int)point.getX()+(corners*2), (int)point.getY()+corners, 0);
			break;
		}
		case 9: {
			Image greenflag = null;
			try {
				greenflag = Image.createImage("/res/img/clockwise-16.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(greenflag, (int)point.getX()+(corners*2), (int)point.getY()+corners, 0);
			break;
		}
		case 10: {
			Image greenflag = null;
			try {
				greenflag = Image.createImage("/res/img/cc-16.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(greenflag, (int)point.getX()+(corners*2), (int)point.getY()+corners, 0);
			break;
		}
		}
		System.out.println("successfully rendered argument (value display): " + (String) argset);
	}
}
