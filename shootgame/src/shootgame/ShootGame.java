package shootgame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;

import Screen.*;

public class ShootGame extends JFrame {
	
	public static MainScreen MS = new MainScreen();		//initialize screen
	public static PauseScreen PS = new PauseScreen();
	public static SelectScreen SS = new SelectScreen();
	public static GameScreen GS;
	
	Graphics offg;
	Image offscreen;
	
	public static int screenstatus = 0;		//0 = main, 1 = select 2 = game 3 = Pause
	
	
	public ShootGame() {
		Sound introSound = new Sound("Free Fall.mp3", true);
		introSound.start();
		
		setTitle(Mainclass.title);
		setSize(Mainclass.SCREEN_WIDTH, Mainclass.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		addKeyListener(new KeyListener());
		setFocusable(true);
		
	}

	@Override
	public void paint(Graphics g) {
		Image offscreen = createImage(Mainclass.SCREEN_WIDTH, Mainclass.SCREEN_HEIGHT);
		offg = offscreen.getGraphics();
		update(offg);
		g.drawImage(offscreen, 0, 0, null);
		
	}
	
	//method to double buffering
	public void update(Graphics g) {    
		switch(screenstatus) {
			case 0:
				MS.screenDraw((Graphics2D) g);
				break;
			case 1:
				SS.screenDraw((Graphics2D) g);
				break;
			case 2:
				GS.screenDraw((Graphics2D) g);
				break;
			case 3:
				PS.screenDraw((Graphics2D) g);
				break;
		}
		
		this.repaint();
	}
	
}
