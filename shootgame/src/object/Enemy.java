package object;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;

public abstract class Enemy extends Thread{
	Dimension leftdim;
	Dimension rightdim;
	
	Dimension imageleftdim;
	Dimension imagerightdim;
	
	int hp, pattern;
	int xsize, ysize;
	
	Image img;
	
	public abstract void screenDraw(Graphics2D g);

}
