package Screen;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import shootgame.Mainclass;
import shootgame.Sound;

public class ResultScreen implements Screen{

	Sound entersound, changesound;
	
	Image result;
	Image background;
	Image clear;
	
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
		
		retrycolor = Color.BLACK;
		selectmenucolor = Color.WHITE;
		quitcolor = Color.WHITE;
	}
	
	
	@Override
	public void screenDraw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(Mainclass.pausebackground.get(GameScreen.index/8), 0, 0, null);
		g.drawImage(result, 400, 30, null);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	
		if(type == 1) {
			g.drawImage(clear, 460, 90, null);
			g.setFont(smallfont);
			g.setColor(Color.white);
			g.drawString("Level Cleared", 560, 230);
			g.drawString(Integer.toString(GameScreen.scores[GameScreen.index].getscore()), 615, 280);
		}
		else if(type == 2) {
			g.setFont(smallfont);
			g.setColor(Color.white);
			g.drawString("False", 600, 230);
		}
	}
	
	public void settype(int type) {
		this.type = type;
	}

}
