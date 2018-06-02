package Screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import shootgame.Mainclass;
import shootgame.ShootGame;
import shootgame.Sound;

public class SelectScreen implements Screen {

	Image background;
	
	Font helpfont = new Font("Arial", Font.PLAIN, 30);
	Font titlefont= new Font("Arial", Font.BOLD, 70);
	
	Sound entersound;
	
	public SelectScreen() {
		background = new ImageIcon(Mainclass.class.getResource("../image/Selectbackground.jpg")).getImage();
	}
	
	
	public void pressESC() {
		entersound = new Sound("enter sound.mp3", false);
		entersound.start();
		ShootGame.screenstatus = 0;
	}

	@Override
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(helpfont);
		g.setColor(Color.WHITE);
		g.drawString("press esc to escape", 825, 120);
		g.setFont(titlefont);
		g.drawString("Select Map", 30, 120);
	}

}
