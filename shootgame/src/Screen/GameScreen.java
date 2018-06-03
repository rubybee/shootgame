package Screen;

import java.awt.Graphics2D;
import java.util.ArrayList;

import object.*;

import shootgame.Mainclass;

public class GameScreen extends Thread implements Screen{
	
	
	ArrayList<Enemy> enes = new ArrayList<Enemy>();
	ArrayList<MovableEnemy> movenes = new ArrayList<MovableEnemy>();
	ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	ArrayList<Structure> structures = new ArrayList<Structure>();
	
	int index;
	
	public GameScreen(int index) {
		this.index = index;
		mapsetting();
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		g.drawImage(Mainclass.background.get(index/8), 0, 0, null);		//change background at 8th 16th 24th.... map
		for (int i = 0; i < structures.size(); i++) structures.get(i).screenDraw(g);
		
	}

	public void close() {
		
	}
	
	public void mapsetting() {
		//basic corner
		structures.add(new Wall(0, 0, Mainclass.SCREEN_WIDTH, 60));
		structures.add(new Wall(0, 0, 40, Mainclass.SCREEN_HEIGHT));
		structures.add(new Wall(Mainclass.SCREEN_WIDTH - 40, 0, Mainclass.SCREEN_WIDTH, Mainclass.SCREEN_HEIGHT));
		structures.add(new Wall(0, Mainclass.SCREEN_HEIGHT - 40, Mainclass.SCREEN_WIDTH, Mainclass.SCREEN_HEIGHT));
		//basic corner
		
	}
}
