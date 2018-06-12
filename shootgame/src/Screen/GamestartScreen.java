package Screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import object.Structure;
import object.Wall;
import shootgame.Mainclass;

public class GamestartScreen implements Screen{
	
	Image background;
	
	Font normalfont = new Font("Arial", Font.BOLD, 70);
	Font normalfont2 = new Font("Arial", Font.BOLD, 50);
	Font smallfont = new Font("Arial", Font.ITALIC, 50);
	

	public GamestartScreen() {
		background = Mainclass.startbackground.get(GameScreen.index/8);
		System.out.println(GameScreen.index);
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		for (int i = 0; i < 4; i++) GameScreen.structures.get(i).screenDraw(g);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(normalfont);
		g.setColor(Color.white);
		g.drawString("Level " + Integer.toString(GameScreen.index + 1), 530, 200);
		g.setFont(normalfont2);
		g.setColor(Color.red);
		g.drawString("High score : ", 430, 350);
		g.setFont(smallfont);
		g.drawString(Integer.toString(GameScreen.scores[GameScreen.index].gethighscore(GameScreen.index)), 750, 350);
	}
}
