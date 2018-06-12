package shootgame;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import Screen.Screen;

public class hitEffect extends Thread implements Screen{
	
	Image hitImage;
	private Dimension hitpos;
	boolean hit;
	
	public hitEffect() {
		hit = false;
	}

	@Override
	public void screenDraw(Graphics2D g) {
		if(hit) g.drawImage(hitImage, hitpos.width-40, hitpos.height-70, 200, 150, null);
	}
	
	@Override
	public void run() {
		hit = true;
		
		Timer effect = new Timer();
		TimerTask showHitImage = new TimerTask() {
			@Override
			public void run() {
				hit = false;
				return;
			}
		};
		effect.schedule(showHitImage, 500);
		
		
		while(hit) {
			
			hitImage = new ImageIcon(Mainclass.class.getResource("../image/blood/blood5.png")).getImage();	
			sleepimage();
			hitImage = new ImageIcon(Mainclass.class.getResource("../image/blood/blood6.png")).getImage();
			sleepimage();
			hitImage = new ImageIcon(Mainclass.class.getResource("../image/blood/blood9.png")).getImage();
			sleepimage();
			hitImage = new ImageIcon(Mainclass.class.getResource("../image/blood/blood10.png")).getImage();
			sleepimage();
			hitImage = new ImageIcon(Mainclass.class.getResource("../image/blood/blood11.png")).getImage();
			sleepimage();
		}
		
		
	}
	
	public void sleepimage(){
		try {
			sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setHitPos(Dimension a) {
		hitpos = a;
	}
	
}
