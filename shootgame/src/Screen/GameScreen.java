package Screen;

import java.awt.Graphics2D;
import java.util.ArrayList;

import object.Bullet;
import object.Enemy;
import object.MovableEnemy;
import object.Structure;
import object.Wall;
import object.normalzombie;
import shootgame.Mainclass;
import shootgame.ShootGame;
import shootgame.Sound;

public class GameScreen extends Thread implements Screen{
	
	Sound bgm;
	Sound pausesound;
	
	ArrayList<Enemy> enes = new ArrayList<Enemy>();
	ArrayList<MovableEnemy> movenes = new ArrayList<MovableEnemy>();
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
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
		
		enes.add(new normalzombie(400, 400));		//just test
	}

	
}
