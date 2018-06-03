package object;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;

public abstract class Bullet extends Thread {
	
	public Image visuableimage;
	
	Dimension dim;
	
	public abstract void screenDraw(Graphics2D g);
	public abstract Image getImage();
}
