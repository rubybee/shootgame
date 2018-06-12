package object;

import java.awt.Dimension;
import java.awt.Graphics2D;

import shootgame.Mainclass;

public class WoodWall extends Structure{

	
	public WoodWall(int leftx, int lefty, int rightx, int righty){
		leftdim = new Dimension(leftx,  lefty);
		rightdim = new Dimension(rightx, righty);
		img = Mainclass.woodwall;
		type = 1;
	}
	
	public void screenDraw(Graphics2D g){
		g.drawImage(img, leftdim.width, leftdim.height, rightdim.width, rightdim.height, leftdim.width, leftdim.height, rightdim.width, rightdim.height, null);
	}
	
	public int gettype() {
		return type;
	}
	
	public void destruct() {
		delete = true;
	}
	

}
