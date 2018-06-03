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

public class PauseScreen implements Screen{
	
	Sound entersound, changesound;
	
	Image menu;
	Image background;
	
	Font normalfont = new Font("Arial", Font.BOLD, 40);
	Font smallfont = new Font("Arial", Font.ITALIC, 30);
	
	Color continuecolor;
	Color selectmenucolor;
	Color quitcolor;
	
	int nowselected = 1;
	
	public PauseScreen() {
		menu = new ImageIcon(Mainclass.class.getResource("../image/pauseimage.png")).getImage();
		background = new ImageIcon(Mainclass.class.getResource("../image/selectbackground.jpg")).getImage();
		continuecolor = Color.black;
		selectmenucolor = Color.white;
		quitcolor = Color.white;
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		g.drawImage(Mainclass.pausebackground.get(GameScreen.index/8), 0, 0, null);
		g.drawImage(menu, 240, 150, null);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(smallfont);
		g.setColor(Color.white);
		g.drawString("Menu", 600, 230);
		g.setFont(normalfont);
		g.setColor(continuecolor);
		g.drawString("continue", 550, 320);
		g.setColor(selectmenucolor);
		g.drawString("selectmenu", 525, 400);
		g.setColor(quitcolor);
		g.drawString("quit", 600, 480);
		g.setColor(Color.black);
		g.drawString("black mean selected, press Enter to select", 230, 100);
		g.drawString("use also w, s", 515, 650);
	}

	public void pressEnter() {
		entersound = new Sound("enter sound.mp3", false);
		entersound.start();
		if(nowselected == 1) ShootGame.pstogs();
		else if(nowselected == 3) System.exit(0);
		else ShootGame.pstoss();
	}

	public void pressW() {
		changesound = new Sound("change sound.mp3", false);
		changesound.start();
		if (nowselected == 1) return;
		else if (nowselected == 2) {
			continuecolor = Color.black;
			selectmenucolor = Color.white;
			nowselected = 1;
		}
		else {
			selectmenucolor = Color.black;
			quitcolor = Color.white;
			nowselected = 2;
		}
	}

	public void pressS() {
		changesound = new Sound("change sound.mp3", false);
		changesound.start();
		if (nowselected == 3) return;
		else if (nowselected == 2) {
			quitcolor = Color.black;
			selectmenucolor = Color.white;
			nowselected = 3;
		}
		else {
			continuecolor = Color.white;
			selectmenucolor = Color.black;
			nowselected = 2;
		}
		
	}

}
