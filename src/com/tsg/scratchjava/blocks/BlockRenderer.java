package com.tsg.scratchjava.blocks;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

import com.tsg.scratchjava.sys.ColorUtil;
import com.tsg.scratchjava.sys.Point;


public class BlockRenderer {
	static Font font = Font.getDefaultFont();
	private static float size = font.getHeight()/15f;
	private static int space = (int) (8f*size);
	private static int jigsawspace = (int) (8f*size);
	private static int corners = (int) (3f*size);
	private static boolean light = true;
	public static void renderblock(int type, BlockArg[] blockArgs, Point point, int color, Graphics g) {
		Point blocksize = new Point(getWidth(blockArgs)-corners, font.getHeight());
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
					g.drawLine((int)point.getX()+corners+space+jigsawspace, (int)point.getY()+corners,
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
							(int)point.getX()+corners+space+jigsawspace-1, (int)point.getY()+(int)blocksize.getY()+(corners*2)-1);
					g.drawLine((int)point.getX()+corners+space+jigsawspace-1, (int)point.getY()+(int)blocksize.getY()+(corners*2)-1,
							(int)point.getX()+(corners*2)+space+jigsawspace-1, (int)point.getY()+(int)blocksize.getY()+corners-1);
					g.drawLine((int)point.getX()+(corners*2)+space+jigsawspace-1, (int)point.getY()+(int)blocksize.getY()+corners-1,
							(int)point.getX()+(corners*3)+(int)blocksize.getX()-1, (int)point.getY()+(int)blocksize.getY()+corners-1);
					g.drawLine((int)point.getX()+(corners*3)+(int)blocksize.getX()-1, (int)point.getY()+(int)blocksize.getY()+corners-1,
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
			width += BlockArg.getWidth(blockArgs[i]) + corners;
		}
	}
	
	private static int getWidth(BlockArg[] blockArgs) {
		// TODO Auto-generated method stub
		int width = 0;
		for (int i = 0; i < blockArgs.length; i++) {
			width += BlockArg.getWidth(blockArgs[i]) + corners;
		}
		return width;
	}

	public static void renderblockarg(Point point, BlockArg blockarg, Graphics g) {
		g.setColor(0xffffff);
		switch (blockarg.getType()) {
		case 0: {
			g.drawString((String) blockarg.getObjectArray()[0], (int)point.getX()+(corners*2), (int)point.getY()+corners, 0);
			break;
		}
		case 1: {
			g.fillRoundRect((int)point.getX()+(corners*2), (int)point.getY()+(int)(corners*1.5f), font.stringWidth((String) blockarg.getObjectArray()[0])+4, font.getHeight()-corners, (int)(5*size), (int)(5*size));
			g.setColor(0);
			g.drawString((String) blockarg.getObjectArray()[0], (int)point.getX()+(corners*2)+2, (int)point.getY()+corners, 0);
			break;
		}
		}
		System.out.println("successfully rendered argument (value display): " + (String) blockarg.getObjectArray()[0]);
	}
}
