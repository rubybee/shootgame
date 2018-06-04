package object;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;

import shootgame.Mainclass;

public abstract class Bullet extends Thread {
	
	public Image bullet;
	public Image visuableimage;
	
	Dimension size;
	Dimension imagepos;
	Dimension pos;
	Dimension center;
	Dimension direction;
	
	public int bounce;
	
	public boolean shoot;
	
	public abstract void screenDraw(Graphics2D g);
	public abstract Image getImage();
	public abstract int gettype();
	public abstract void close();
}
