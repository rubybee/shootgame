package Screen;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import object.Bomb;
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
	
	
	public static boolean click;
	
	public static ArrayList<Enemy> enes;
	public static ArrayList<MovableEnemy> movenes;
	static ArrayList<Bullet> bullets;
	static ArrayList<Bullet> firebullets;
	public static ArrayList<Structure> structures;
	static ArrayList<Bomb> bombs;
	
	static int index;
	private static int curpointx;
	private static int curpointy;
	static int shootpointx;
	static int shootpointy;
	
	public static boolean lockon;
	public static boolean pause;
	
	public boolean runnable;
	
	public GameScreen(int index) {
		
		runnable = true;
		lockon = false;
		enes = new ArrayList<Enemy>();
		movenes = new ArrayList<MovableEnemy>();
		bullets = new ArrayList<Bullet>();
		firebullets = new ArrayList<Bullet>();
		structures = new ArrayList<Structure>();
		bombs = new ArrayList<Bomb>();
		pause = false;
		bgm = new Sound("Ludovico Einaudi - Time Lapse - In A Time Lapse.mp3", true);
		bgm.start();
		GameScreen.index = index;
		mapsetting();
		this.start();
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
		for (int i = 0; i < bullets.size(); i++) g.drawImage(bullets.get(i).getImage(), i * 60 + 10, 30, null);
		for (int i = 0; i < firebullets.size(); i++) firebullets.get(i).screenDraw(g);
		for (int i = 0; i < movenes.size(); i++) movenes.get(i).screenDraw(g);
		for (int i = 0; i < bombs.size(); i++) bombs.get(i).screenDraw(g);
		
		//g.drawImage(Mainclass.target, curpointx - 50, curpointy-50, null);
		
		if(lockon) g.drawImage(Mainclass.target, curpointx - 50, curpointy - 50, null);
	}

	public void close() {
		bgm.close();
		for (int i = 0; i < enes.size(); i++) enes.get(i).close();
		for (int i = 0; i < firebullets.size(); i++) firebullets.get(i).close();
		for (int i = 0; i < movenes.size(); i++) movenes.get(i).close();
		enes = null;
		bullets = null;
		firebullets = null;
		movenes = null;
		structures = null;
		runnable = false;
		click = false;
	}
	
	public static void where(int x, int y) {
		curpointx = x;
		curpointy = y;
	}
	
	public static void press(int x, int y) {
		shootpointx = x;
		shootpointy = y;
		if(bullets.size() == 0) return;
		lockon = true;
	}
	
	public static void release() {
		if(bullets.size() == 0) return;
		else {
			Bullet tmp = bullets.get(bullets.size() - 1);
			bullets.remove(bullets.size() - 1);
			if(tmp.gettype() == 0) {
				firebullets.add(new Normalbullet(shootpointx, shootpointy));
			}
		}
		lockon = false;
		shootpointx = 0;
		shootpointy = 0;
	}
	
	
	public void run() {
		click = true;
		while(true) {
			for (int i = 0; i < structures.size(); i++) if(structures.get(i).delete) {
				structures.remove(i);
			}
			
			if(!runnable) return;
			
			for (int i = 0; i < enes.size(); i++) if(enes.get(i).delete) {
				System.out.println(i);
				enes.get(i).close();
				enes.remove(i);
			}
			
			if(!runnable) return;
			
			for (int i = 0; i < movenes.size(); i++) if(movenes.get(i).delete) {
				movenes.get(i).close();
				movenes.remove(i);
			}
			
			if(!runnable) return;
			
			for (int i = 0; i < firebullets.size(); i++) {
				if(firebullets.get(i).bounce < 1) {
					firebullets.get(i).close();
					firebullets.remove(i);
				}
			}
		}
	}
	
	public void mapsetting() {
		System.out.println("Ack");
		
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
			bullets.add(new Normalbullet());
			bullets.add(new Normalbullet());
		}
		
		else if (index == 1) {
			bullets.add(new Normalbullet());	//just test
			bullets.add(new Normalbullet());
		}
		
		else if (index == 2) {
			
			
		}
	}

}
