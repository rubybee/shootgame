package object;

import java.awt.Dimension;
import java.awt.Graphics2D;

import shootgame.Mainclass;

public class Wall extends Structure{
	
	public Wall(int leftx, int lefty, int rightx, int righty){
		leftdim = new Dimension(leftx,  lefty);
		rightdim = new Dimension(rightx, righty);
		img = Mainclass.wall;
	}
	
	public void screenDraw(Graphics2D g){
		g.drawImage(img, leftdim.width, leftdim.height, rightdim.width, rightdim.height, leftdim.width, leftdim.height, rightdim.width, rightdim.height, null);
	}
}
