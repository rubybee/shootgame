package object;

import java.awt.Dimension;
import java.awt.Graphics2D;

import Screen.GameScreen;
import shootgame.Mainclass;

public class Normalzombie extends Enemy{

	public Normalzombie(int leftx, int lefty, int startpattern){
		leftdim = new Dimension(leftx, lefty);
		xsize = 80;
		ysize = 120;
		rightdim = new Dimension(leftx + xsize, lefty + ysize);
		
		imageleftdim = new Dimension(startpattern * 80, 0);
		imagerightdim = new Dimension(startpattern * 80 + 80, ysize);
		
		hp = 1;
		pattern = 4;
		
		img = Mainclass.zombie1;
		this.start();
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		if (!die) g.drawImage(img, leftdim.width, leftdim.height, rightdim.width, rightdim.height, imageleftdim.width, imageleftdim.height, imagerightdim.width, imagerightdim.height, null);
		else{
			//die motion plus
		}
		
		
	}
	
	public void close() {
		this.interrupt();
	}
	
	@Override
	public void run() {
		while(hp == 1) {
			for (int i = 0; i < pattern - 1; i++) {
				if(imageleftdim.width == 240) break;
				if (!attack) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					attack = true;
				}
				do {
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}while(GameScreen.pause);
				imageleftdim.width += xsize;
				imagerightdim.width += xsize;
				
			}
			for (int i = 0; i < pattern - 1; i++) {
				if (!attack) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					attack = true;
				}
				do {
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}while(GameScreen.pause);
				imageleftdim.width -= xsize;
				imagerightdim.width -= xsize;
			}
		}
		
		//die motion plus
		//die motion plus
		//die motion plus
		
		delete = true;
	}
	
	public void attacked() {
		hp--;
		attack = false;
	}

}
