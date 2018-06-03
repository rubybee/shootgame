package shootgame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import Screen.GameScreen;
import Screen.MainScreen;
import Screen.PauseScreen;
import Screen.SelectScreen;

public class ShootGame extends JFrame {
	public static MainScreen MS = new MainScreen();		//initialize screen
	public static PauseScreen PS = new PauseScreen();
	public static SelectScreen SS = new SelectScreen();
	public static GameScreen GS;
	
	Graphics offg;
	Image offscreen;
	
	static Sound introSound;
	
	public static int screenstatus = 0;		//0 = main, 1 = select 2 = game 3 = Pause
	
	
	public ShootGame() {
		introSound = new Sound("Free Fall.mp3", true);
		introSound.start();
		
		setTitle(Mainclass.title);
		setSize(Mainclass.SCREEN_WIDTH, Mainclass.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		
		//input add
		addMouseListener(new shootgame.MouseListener());
		addKeyListener(new KeyListener());
		setFocusable(true);
		
		
	}

	@Override
	public void paint(Graphics g) {
		Image offscreen = createImage(Mainclass.SCREEN_WIDTH, Mainclass.SCREEN_HEIGHT);
		offg = offscreen.getGraphics();
		update((Graphics2D)offg);
		g.drawImage(offscreen, 0, 0, null);
		
	}
	
	//method to double buffering
	public void update(Graphics2D g) {
		switch(screenstatus) {
			case 0:
				MS.screenDraw(g);
				break;
			case 1:
				SS.screenDraw(g);
				break;
			case 2:
				GS.screenDraw(g);
				break;
			case 3:
				PS.screenDraw(g);
				break;
		}
		this.repaint();
	}
	
	//screenchange event
	public static void mstoss() {
		screenstatus = 1;
	}
	
	public static void sstoms() {
		screenstatus = 0;
	}
	
	public static void sstogs(int index) {
		GS = new GameScreen(index);
		introSound.close();
		screenstatus = 2;
	}
	
	public static void gstops() {
		screenstatus = 3;
	}
	
	public static void pstogs() {
		screenstatus = 2;
		GameScreen.pause = false;
		GameScreen.turnonmusic();
	}
	
	public static void pstoss() {
		GS.close();
		introSound = new Sound("Free Fall.mp3", true);
		introSound.start();
		screenstatus = 1;
	}
	
}
