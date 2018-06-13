package object;

import java.awt.Dimension;
import java.awt.Graphics2D;

import shootgame.Mainclass;

public class FireWall extends Structure{

	public FireWall(int leftx, int lefty, int rightx, int righty){
		leftdim = new Dimension(leftx,  lefty);
		rightdim = new Dimension(rightx, righty);
		img = Mainclass.firewall;
		type = 2;
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		g.drawImage(img, leftdim.width, leftdim.height, rightdim.width, rightdim.height, leftdim.width, leftdim.height, rightdim.width, rightdim.height, null);
	}

	@Override
	public int gettype() {
		return type;
	}

	@Override
	public void destruct() {
	}

}
