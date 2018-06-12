package Screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

import object.Bomb;
import object.Bullet;
import object.Enemy;
import object.MovableEnemy;
import object.Normalbullet;
import object.Normalmovezombie;
import object.Normalzombie;
import object.Score;
import object.Structure;
import object.Wall;
import object.WoodWall;
import shootgame.Mainclass;
import shootgame.ShootGame;
import shootgame.Sound;

public class GameScreen extends Thread implements Screen{
	
	
	
	static Sound bgm;
	Sound pausesound;
	Sound scoresound;
	
	Font smallfont = new Font("Arial", Font.ITALIC, 20);
	
	
	public static boolean click;
	
	public static Score [] scores = new Score[16];
	
	public static ArrayList<Enemy> enes;
	public static ArrayList<MovableEnemy> movenes;
	static ArrayList<Bullet> bullets;
	static ArrayList<Bullet> firebullets;
	public static ArrayList<Structure> structures;
	public static ArrayList<Bomb> bombs;
	
	public static int index;
	private static int curpointx;
	private static int curpointy;
	static int shootpointx;
	static int shootpointy;
	private int scorenum;
	
	public static boolean lockon;
	public static boolean pause;
	public static boolean bulletempty;
	public static boolean allkilled;
	
	public boolean runnable;
	
	public static Dimension playerPos = new Dimension();
	
	public GameScreen(int index) {
		
		runnable = true;
		lockon = false;
		bulletempty = false;
		allkilled = false;
		
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
		scores[index] = new Score();
		scores[index].setinitscore();
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
		g.drawImage(Mainclass.player, playerPos.width, playerPos.height, 100, 100, null);
		g.setFont(smallfont);
		g.setColor(Color.yellow);
		for (int i = 0; i < structures.size(); i++) structures.get(i).screenDraw(g);
		
		for (int i = 0; i < enes.size(); i++) enes.get(i).screenDraw(g);
		for (int i = 0; i < bullets.size(); i++) g.drawImage(bullets.get(i).getImage(), i * 60 + 10, 30, null);
		for (int i = 0; i < scorenum; i++) g.drawString("3000", i * 60 + 15, 100);
		for (int i = 0; i < firebullets.size(); i++) firebullets.get(i).screenDraw(g);
		for (int i = 0; i < movenes.size(); i++) movenes.get(i).screenDraw(g);
		for (int i = 0; i < bombs.size(); i++) bombs.get(i).screenDraw(g);
		
		
		scores[index].screenDraw(g);
		
		//g.drawImage(Mainclass.target, curpointx - 50, curpointy-50, null);
		
		if(lockon) g.drawImage(Mainclass.target, curpointx - 50, curpointy - 50, null);
	}

	public void close() {
		bgm.close();
		for (int i = 0; i < enes.size(); i++) enes.get(i).close();
		for (int i = 0; i < firebullets.size(); i++) firebullets.get(i).close();
		for (int i = 0; i < movenes.size(); i++) movenes.get(i).close();
		
		runnable = false;
		click = false;
	}
	
	public static void where(int x, int y) {
		curpointx = x;
		curpointy = y;
	}
	
	public static void press(int x, int y) {
		curpointx = x;
		curpointy = y;
		if(bullets.size() == 0) return;
		lockon = true;
	}
	
	public static void release(int x, int y) {
		shootpointx = x;
		shootpointy = y;
		if(bullets.size() == 0) return;
		else {
			if(!allkilled) {
				Bullet tmp = bullets.get(bullets.size() - 1);
				if(tmp.gettype() == 0) {
					Sound shootSound = new Sound("shoot.mp3", false);
					shootSound.start();
					firebullets.add(new Normalbullet(shootpointx, shootpointy));
				}
				bullets.remove(bullets.size() - 1);
				if(bullets.size() == 0)
					bulletempty = true;
				
			}
			
		}
		lockon = false;
	}
	
	
	public void run() {
		click = true;
		
		while(true) {
			
			deleteBullet();
			
			if((!allkilled) && bulletempty && firebullets.size() == 0) {
				try {
					sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ShootGame.gstors(2);
				//type 2
			}
			
			for (int i = 0; i < structures.size(); i++) if(structures.get(i).delete) {
				structures.remove(i);
			}
			
			if(!runnable) return;
			
			for (int i = 0; i < enes.size(); i++) {
				
				
				if(enes.get(i).delete) {
					System.out.println(i);
					enes.get(i).close();
					enes.remove(i);
				}
			
				
				
			}
				
			
			if(!runnable) return;
			
			for (int i = 0; i < movenes.size(); i++) if(movenes.get(i).delete) {
				System.out.println(i);
				movenes.get(i).close();
				movenes.remove(i);
			}
			
			if(!runnable) return;
			
			if(enes.size() == 0 && movenes.size() == 0)
				allkilled = true;
			
			if(allkilled) {
				deleteBullet();
				for(int j = 0; j < bullets.size(); j++) {
					try {
						for(int k = 0; k < 14; k++) {
							sleep(50);
							deleteBullet();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					deleteBullet();
					
					sleep();
					scorenum = j+1;
					if(!runnable) return;
					scores[index].plusbBulletScore();
					scoresound = new Sound("showscore.mp3", false);
					scoresound.start();
					if(!runnable) return;
				}
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(!runnable) return;
				sleep();
				if(!runnable) return;
				scores[index].sethighscore(index);
				if(!runnable) return;
				ShootGame.gstors(1);
				
			}
			
		}
	}
	
	public void deleteBullet() {
		for (int i = 0; i < firebullets.size(); i++) {
			if(firebullets.get(i).bounce < 1) {
				firebullets.get(i).close();
				firebullets.remove(i);
			}
		}
	}

	public void sleep() {
		do {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(pause);
	}
	
	public void bulletAdd() {
		bullets.add(new Normalbullet());
		bullets.add(new Normalbullet());
		bullets.add(new Normalbullet());
		bullets.add(new Normalbullet());
		bullets.add(new Normalbullet());
	}
	
	public void setPlayerPos(int x, int y) {
		playerPos.width = x;
		playerPos.height = y;
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
			setPlayerPos(50, 560);
			
			structures.add(new Wall(500, 400, 610, 440));
			
			enes.add(new Normalzombie(700, 570, 2));
			enes.add(new Normalzombie(1000, 570, 1));
			enes.add(new Normalzombie(530, 290, 3));
			
			bulletAdd();
		}
		
		else if (index == 1) {

			setPlayerPos(50, 560);
			
			structures.add(new Wall(500, 400, 900, 440));
			structures.add(new Wall(750, 200, 1000, 240));
			
			enes.add(new Normalzombie(530, 290, 3));
			enes.add(new Normalzombie(730, 290, 1));
			enes.add(new Normalzombie(800, 90, 3));
			enes.add(new Normalzombie(700, 570, 2));
			bulletAdd();

		}
		
		else if (index == 2) {
			setPlayerPos(50, 560);
			
			structures.add(new Wall(700, 400, 1100, 440));
			structures.add(new Wall(500, 500, 1000, 540));
			structures.add(new Wall(300, 600, 900, 640));
			
			enes.add(new Normalzombie(370, 490, 2));
			enes.add(new Normalzombie(570, 390, 1));
			enes.add(new Normalzombie(770, 290, 3));
			enes.add(new Normalzombie(870, 290, 0));
			enes.add(new Normalzombie(970, 290, 1));
			
			
			bulletAdd();
		}
		
		else if (index == 3) {
			setPlayerPos(50, 560);
			
			structures.add(new Wall(510, 300, 550, 480));
			structures.add(new Wall(510, 480, 800, 520));
			structures.add(new Wall(760, 300, 800, 480));
			structures.add(new Wall(900, 500, 940, 700));
		
			enes.add(new Normalzombie(600, 370, 3));
			enes.add(new Normalzombie(1000, 570, 1));
			
			bulletAdd();
		}
		
		else if (index == 4) {
			setPlayerPos(580, 100);
			
			structures.add(new Wall(40, 300, 200, 340));
			structures.add(new Wall(1080, 300, 1240, 340));
			structures.add(new Wall(530, 510, 720, 550));
			
			enes.add(new Normalzombie(580, 400, 3));
			enes.add(new Normalzombie(90, 190, 3));
			enes.add(new Normalzombie(1100, 190, 3));
			
			bulletAdd();
			
		}
		else if (index == 5) {
			setPlayerPos(550, 100);
			
			structures.add(new Wall(350, 300, 390, 540));
			structures.add(new Wall(350, 500, 1240, 540));
			
			enes.add(new Normalzombie(600, 390, 3));
			enes.add(new Normalzombie(700, 390, 1));
			enes.add(new Normalzombie(800, 390, 0));
			enes.add(new Normalzombie(900, 390, 2));
			enes.add(new Normalzombie(300, 570, 1));
			
			bulletAdd();
			
		}
		
		else if (index == 6) {
			setPlayerPos(50, 560);
			
			structures.add(new Wall(400, 450, 1100, 490));
			structures.add(new WoodWall(370, 250, 400, 680));
			
			enes.add(new Normalzombie(600, 570, 3));
			enes.add(new Normalzombie(700, 570, 1));
			enes.add(new Normalzombie(800, 570, 0));
			enes.add(new Normalzombie(900, 570, 2));
			enes.add(new Normalzombie(630, 340, 0));
			enes.add(new Normalzombie(730, 340, 3));
			enes.add(new Normalzombie(830, 340, 1));
			bulletAdd();
			
		}
		
		else if (index == 7) {
			setPlayerPos(50, 560);
			
			movenes.add(new Normalmovezombie(400, 400, 200));
			
			
			bulletAdd();
		}
		
		else if (index == 8) {
			setPlayerPos(50, 560);
			
			movenes.add(new Normalmovezombie(400, 400, 200));
			
			
			bulletAdd();
		}
		
		else if (index == 9) {
			setPlayerPos(50, 560);
			
			movenes.add(new Normalmovezombie(400, 400, 200));
			
			
			bulletAdd();
		}
		
		else if (index == 10) {
			setPlayerPos(50, 560);
			
			movenes.add(new Normalmovezombie(400, 400, 200));
			
			
			bulletAdd();
		}
		
		else if (index == 11) {
			setPlayerPos(50, 560);
			
			movenes.add(new Normalmovezombie(400, 400, 200));
			
			
			bulletAdd();
		}
		
		else if (index == 12) {
			setPlayerPos(50, 560);
			
			movenes.add(new Normalmovezombie(400, 400, 200));
			
			
			bulletAdd();
		}
		
		else if (index == 13) {
			setPlayerPos(50, 560);
			
			movenes.add(new Normalmovezombie(400, 400, 200));
			
			
			bulletAdd();
		}
		
		else if (index == 14) {
			setPlayerPos(50, 560);
			
			movenes.add(new Normalmovezombie(400, 400, 200));
			
			
			bulletAdd();
		}
		
		else if (index == 15) {
			setPlayerPos(50, 560);
			
			movenes.add(new Normalmovezombie(400, 400, 200));
			
			
			bulletAdd();
		}
		
		else if (index == 16) {
			setPlayerPos(50, 560);
			
			movenes.add(new Normalmovezombie(400, 400, 200));
			
			
			bulletAdd();
		}
		
		
		
		
	}

}
