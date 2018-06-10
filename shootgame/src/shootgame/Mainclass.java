package shootgame;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import object.Score;

public class Mainclass {
	
	public static final String title = "Shooting Game";		//title of game
	
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	public static final int mapnumber = 16;		//number of maps
	public static final int bulletsleeptime = 50;
	public static final int bulletspeed = 5;
	
	public static ArrayList<Image> background = new ArrayList<Image>();		//images of gamebackground
	public static ArrayList<Image> pausebackground = new ArrayList<Image>();		//images of gamebackground
	
	public static final Image wall = new ImageIcon(Mainclass.class.getResource("../image/wall.png")).getImage();	//images of wall
	
	//images of zombie
	public static final Image zombie1 = new ImageIcon(Mainclass.class.getResource("../image/zombie1.png")).getImage();	
	public static final Image zombie2 = new ImageIcon(Mainclass.class.getResource("../image/zombie2.jpg")).getImage();
	public static final Image zombie3 = new ImageIcon(Mainclass.class.getResource("../image/zombie3.jpg")).getImage();
	public static final Image zombie4 = new ImageIcon(Mainclass.class.getResource("../image/zombie4.jpg")).getImage();
	public static final Image zombie5 = new ImageIcon(Mainclass.class.getResource("../image/zombie5.jpg")).getImage();
	public static final Image zombie6 = new ImageIcon(Mainclass.class.getResource("../image/zombie6.jpg")).getImage();
	public static final Image zombie7 = new ImageIcon(Mainclass.class.getResource("../image/zombie7.jpg")).getImage();
	public static final Image zombie8 = new ImageIcon(Mainclass.class.getResource("../image/zombie8.jpg")).getImage();
	
	//images of diezombie
	public static final Image zombiedie1 = new ImageIcon(Mainclass.class.getResource("../image/zombiedie1.png")).getImage();
	public static final Image zombiedie11 = new ImageIcon(Mainclass.class.getResource("../image/zombiedie2.png")).getImage();
	public static final Image zombiedie12 = new ImageIcon(Mainclass.class.getResource("../image/zombiedie3.png")).getImage();
	
	//image of bullet
	public static final Image bullet = new ImageIcon(Mainclass.class.getResource("../image/bullet.png")).getImage();
	
	public static final Image target = new ImageIcon(Mainclass.class.getResource("../image/target.png")).getImage();
	
	public static void main(String[] args) {
		
		for(int i = 0; i < Mainclass.mapnumber/8 + 1; i++) {
			Image tmp = new ImageIcon(Mainclass.class.getResource("../image/gamebackground" + i + ".jpg")).getImage();
			background.add(tmp);
		}
		
		for(int i = 0; i < Mainclass.mapnumber/8 + 1; i++) {
			Image tmp = new ImageIcon(Mainclass.class.getResource("../image/gamebackgroundforpause" + i + ".jpg")).getImage();
			pausebackground.add(tmp);
		}
		
		new ShootGame();
	}

}
