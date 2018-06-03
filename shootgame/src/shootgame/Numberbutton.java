package shootgame;

import java.awt.Dimension;
import java.awt.Image;

public class Numberbutton {
	Dimension dim;
	int index;
	Image img;
	
	public Numberbutton(int x, int y, int index, Image img) {
		this.dim = new Dimension(x, y);
		this.index = index;
		this.img = img;
	}
	
	public int getindex() {
		return index;
	}
	
	public int getx() {
		return dim.width;
	}
	
	public int gety() {
		return dim.height;
	}
	
	public void setImage(Image image) {
		this.img = image;
	}
	
	public Image getImage() {
		return img;
	}
}
