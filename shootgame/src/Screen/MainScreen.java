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

public class MainScreen implements Screen {

	Image background;
	Image arrow;
	
	Font titlefont= new Font("Arial", Font.BOLD, 70);
	Font normalfont = new Font("Arial", Font.BOLD, 40);
	Font helpfont = new Font("Arial", Font.PLAIN, 30);
	
	Sound changesound;
	Sound entersound;
	
	int x, y;
	
	public MainScreen(){
		background = new ImageIcon(Mainclass.class.getResource("../image/mainbackground.jpg")).getImage();
		arrow = new ImageIcon(Mainclass.class.getResource("../image/right-arrow.png")).getImage();
		x = 850;
		y = 450;
	}
	
	public void pressW() {
		changesound = new Sound("change sound.mp3", false);
		changesound.start();
		if (y == 450) return;
		y = 450;
	}
	
	public void pressS() {
		changesound = new Sound("change sound.mp3", false);
		changesound.start();
		if (y == 550) return;
		y = 550;
	}
	
	public void pressEnter() {
		entersound = new Sound("enter sound.mp3", false);
		entersound.start();
		if(y == 550) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
		else ShootGame.mstoss();
	}
	
	
	@Override
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		g.drawImage(arrow, x, y, null);
		g.setColor(Color.white);
		g.setFont(titlefont);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.drawString(Mainclass.title, 30, 120);
		g.setFont(normalfont);
		g.setColor(Color.white);
		g.drawString("Game Start", 950, 500);
		g.drawString("Quit", 1085, 600);
		g.setFont(helpfont);
		g.drawString("press s, w, enter to select", 825, 120);
	}
	


}
