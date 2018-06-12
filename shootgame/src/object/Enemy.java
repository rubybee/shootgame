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
	
	
	Image idleimg;
	Image dieimg;
	
	public boolean runnable = true;
	
	public boolean die = false;
	public boolean delete = false;
	boolean attack;
	
	public abstract void screenDraw(Graphics2D g);
	public abstract void close();
	public abstract void attacked();

}
