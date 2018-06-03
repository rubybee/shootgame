package Screen;

import java.awt.Graphics2D;
import java.util.ArrayList;

import object.Bullet;
import object.Enemy;
import object.MovableEnemy;
import object.Normalbullet;
import object.Normalzombie;
import object.Structure;
import object.Wall;
import shootgame.Mainclass;
import shootgame.ShootGame;
import shootgame.Sound;

public class GameScreen extends Thread implements Screen{
	
	static Sound bgm;
	Sound pausesound;
	
	ArrayList<Enemy> enes = new ArrayList<Enemy>();
	ArrayList<MovableEnemy> movenes = new ArrayList<MovableEnemy>();
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	ArrayList<Bullet> firebullets = new ArrayList<Bullet>();
	ArrayList<Structure> structures = new ArrayList<Structure>();
	
	static int index;
	
	public static boolean pause;
	
	public GameScreen(int index) {
		pause = false;
		bgm = new Sound("Ludovico Einaudi - Time Lapse - In A Time Lapse.mp3", true);
		bgm.start();
		this.index = index;
		mapsetting();
	}
	
	public static void turnonmusic() {
		bgm = new Sound("Ludovico Einaudi - Time Lapse - In A Time Lapse.mp3", true);
		bgm.start();
	}
	
	public void pressESC() {
		pausesound = new Sound("change sound.mp3", false);
		pausesound.start();
		bgm.close();
		pause = true;
		ShootGame.gstops();
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		g.drawImage(Mainclass.background.get(index/8), 0, 0, null);		//change background at 8th 16th 24th.... map
		for (int i = 0; i < structures.size(); i++) structures.get(i).screenDraw(g);
		for (int i = 0; i < enes.size(); i++) enes.get(i).screenDraw(g);
		for (int i = 0; i < bullets.size(); i++) {
			g.drawImage(bullets.get(i).getImage(), i * 60 + 10, 30, null);
		}
	}

	public void close() {
		bgm.close();
		this.interrupt();
	}
	
	public void mapsetting() {
		//basic corner
		structures.add(new Wall(0, 0, Mainclass.SCREEN_WIDTH, 60));
		structures.add(new Wall(0, 0, 40, Mainclass.SCREEN_HEIGHT));
		structures.add(new Wall(Mainclass.SCREEN_WIDTH - 40, 0, Mainclass.SCREEN_WIDTH, Mainclass.SCREEN_HEIGHT));
		structures.add(new Wall(0, Mainclass.SCREEN_HEIGHT - 40, Mainclass.SCREEN_WIDTH, Mainclass.SCREEN_HEIGHT));
		//basic corner
		
		if(index == 0) {
			enes.add(new Normalzombie(400, 400, 0));	//just test
			enes.add(new Normalzombie(500, 400, 1));
			enes.add(new Normalzombie(600, 400, 2));
			enes.add(new Normalzombie(700, 400, 1));
			enes.add(new Normalzombie(800, 400, 1));
		}
		
		else if (index == 1) {
			bullets.add(new Normalbullet());	//just test
			bullets.add(new Normalbullet());
		}
		
		else if (index == 2) {
			
			
		}
	}

	

	
}
