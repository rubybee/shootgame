package shootgame;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Mainclass {
	
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	public static final String title = "Shooting Game";		//title of game
	public static final int mapnumber = 16;		//number of maps
	
	public static ArrayList<Image> background = new ArrayList<Image>();		//images of gamebackground
	public static final Image wall = new ImageIcon(Mainclass.class.getResource("../image/wall.png")).getImage();	//images of wall
	
	public static void main(String[] args) {
		for(int i = 0; i < Mainclass.mapnumber/8 + 1; i++) {
			Image tmp = new ImageIcon(Mainclass.class.getResource("../image/gamebackground" + i + ".jpg")).getImage();
			background.add(tmp);
		}
		new ShootGame();
	}

}
