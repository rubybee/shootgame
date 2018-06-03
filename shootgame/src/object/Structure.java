package object;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;

public abstract class Structure {
	
	Dimension leftdim;
	Dimension rightdim;
	Image img;

	public abstract void screenDraw(Graphics2D g);
}
