package object;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import shootgame.Mainclass;

public class Normalbullet extends Bullet{
	
	public Normalbullet() {
		visuableimage = new ImageIcon(Mainclass.class.getResource("../image/visuablenormalbullet.png")).getImage();
		
	}

	@Override
	public void screenDraw(Graphics2D g) {
		
		
	}
	
	public Image getImage() {
		return visuableimage;
	}
}
