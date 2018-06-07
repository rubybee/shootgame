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
	

	public GamestartScreen() {
		background = new ImageIcon(Mainclass.class.getResource("../image/gamestart.jpg")).getImage();
	}
	@Override
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		for (int i = 0; i < 4; i++) GameScreen.structures.get(i).screenDraw(g);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(normalfont);
		g.setColor(Color.white);
		g.drawString("Level " + Integer.toString(GameScreen.index + 1), 550, 200);
	}
}
