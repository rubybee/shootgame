package Screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import shootgame.Mainclass;
import shootgame.Numberbutton;
import shootgame.ShootGame;
import shootgame.Sound;

public class SelectScreen implements Screen {

	Image background;
	
	int page = 0;
	
	Font helpfont = new Font("Arial", Font.PLAIN, 30);
	Font titlefont= new Font("Arial", Font.BOLD, 70);
	
	//button sound
	Sound entersound;
	
	//button image
	public static ArrayList<Image> mapselectimage = new ArrayList<Image>();
	public static ArrayList<Image> mapselectimageenter = new ArrayList<Image>();
	
	//button
	public static ArrayList<Numberbutton> buttons = new ArrayList<Numberbutton>();
	
	
	public SelectScreen() {
		background = new ImageIcon(Mainclass.class.getResource("../image/selectbackground.jpg")).getImage();
		
		//image initialized
		for (int i = 0; i < Mainclass.mapnumber; i++) {
			mapselectimage.add(new ImageIcon(Mainclass.class.getResource("../image/button/button" + i + ".jpg")).getImage());
			mapselectimageenter.add(new ImageIcon(Mainclass.class.getResource("../image/button/buttonenter" + i + ".jpg")).getImage());
		}
		
		//button initialized
		for (int i = 0; i < Mainclass.mapnumber; i++) {
			buttons.add(new Numberbutton(140 + (i % 7) * 150 , 200 + (i / 7) * 150, i, mapselectimage.get(i)));
		}
		
	}
	
	
	public void pressESC() {
		entersound = new Sound("enter sound.mp3", false);
		entersound.start();
		ShootGame.sstoms();
	}

	@Override
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		if (page == 0) {
			for (int i = 0; i < Mainclass.mapnumber; i++) {
				g.drawImage(buttons.get(i).getImage(), buttons.get(i).getx(), buttons.get(i).gety(), null);
			}
		}
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(helpfont);
		g.setColor(Color.WHITE);
		g.drawString("press esc to escape", 825, 120);
		g.setFont(titlefont);
		g.drawString("Select Map", 30, 120);
	}

}
