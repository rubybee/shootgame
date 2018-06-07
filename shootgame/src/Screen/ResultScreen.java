package Screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import shootgame.Mainclass;
import shootgame.MouseListener;
import shootgame.ShootGame;
import shootgame.Sound;

public class ResultScreen implements Screen{

	Sound entersound, changesound;
	
	Image result;
	Image background;
	Image clear;
	Image fail;
	
	Font normalfont = new Font("Arial", Font.BOLD, 40);
	Font smallfont = new Font("Arial", Font.ITALIC, 30);
	
	Color retrycolor;
	Color selectmenucolor;
	Color quitcolor;
	
	int nowselected = 1;
	private int type;
	
	public ResultScreen() {
		result = new ImageIcon(Mainclass.class.getResource("../image/Result.png")).getImage();
		clear = new ImageIcon(Mainclass.class.getResource("../image/Clearimage.png")).getImage();
		fail = new ImageIcon(Mainclass.class.getResource("../image/Fail.png")).getImage();
		
		retrycolor = Color.BLACK;
		selectmenucolor = Color.WHITE;
		quitcolor = Color.WHITE;
	}
	
	
	@Override
	public void screenDraw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(Mainclass.pausebackground.get(GameScreen.index/8), 0, 0, null);
		g.drawImage(result, 380, 30, null);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	
		if(type == 1) {
			g.drawImage(clear, 460, 90, null);
			g.setFont(smallfont);
			g.setColor(Color.white);
			g.drawString("Level Cleared", 540, 230);
			g.drawString(Integer.toString(GameScreen.scores[GameScreen.index].getscore()), 595, 280);
		}
		else if(type == 2) {
			g.drawImage(fail, 440, 110, null);
		}
		
		g.setFont(normalfont);
		g.setColor(retrycolor);
		g.drawString("retry", 590, 400);
		g.setColor(selectmenucolor);
		g.drawString("selectmenu", 525, 480);
		g.setColor(quitcolor);
		g.drawString("quit", 600, 560);
		g.setColor(Color.black);
	}
	
	public void settype(int type) {
		this.type = type;
	}

	public void pressEnter() {
		entersound = new Sound("enter sound.mp3", false);
		entersound.start();
		if(nowselected == 1) ShootGame.rstogs(MouseListener.index);
		else if(nowselected == 3) System.exit(0);
		else ShootGame.rstoss();
	}

	public void pressW() {
		changesound = new Sound("change sound.mp3", false);
		changesound.start();
		if (nowselected == 1) return;
		else if (nowselected == 2) {
			retrycolor = Color.black;
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
			retrycolor = Color.white;
			selectmenucolor = Color.black;
			nowselected = 2;
		}
		
	}
}
