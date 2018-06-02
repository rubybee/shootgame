package Screen;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import shootgame.Mainclass;
import shootgame.ShootGame;
import shootgame.Sound;

public class SelectScreen implements Screen {

	Image background;
	
	int map;
	
	Sound entersound;
	
	public SelectScreen() {
		background = new ImageIcon(Mainclass.class.getResource("../image/Selectbackground.jpg")).getImage();
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		
	}

	public void pressESC() {
		entersound = new Sound("enter sound.mp3", false);
		entersound.start();
		ShootGame.screenstatus = 0;
	}

}
