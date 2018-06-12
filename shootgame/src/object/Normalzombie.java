package object;

import java.awt.Dimension;
import java.awt.Graphics2D;

import Screen.GameScreen;
import shootgame.Mainclass;
import shootgame.hitEffect;

public class Normalzombie extends Enemy{

	hitEffect dieEffect;
	
	public Normalzombie(int leftx, int lefty, int startpattern){
		
		leftdim = new Dimension(leftx, lefty);
		xsize = 80;
		ysize = 120;
		rightdim = new Dimension(leftx + xsize, lefty + ysize);
		
		dieEffect = new hitEffect();
		dieEffect.setHitPos(leftdim);
		
		imageleftdim = new Dimension(startpattern * 80, 0);
		imagerightdim = new Dimension(startpattern * 80 + 80, ysize);
		
		hp = 1;
		pattern = 4;
		
		idleimg = Mainclass.zombie1;
		dieimg = Mainclass.zombiedie1;
		this.start();
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		if (!die) g.drawImage(idleimg, leftdim.width, leftdim.height, rightdim.width, rightdim.height, imageleftdim.width, imageleftdim.height, imagerightdim.width, imagerightdim.height, null);
		else{
			g.drawImage(dieimg, leftdim.width, leftdim.height, rightdim.width, rightdim.height, imageleftdim.width, imageleftdim.height, imagerightdim.width, imagerightdim.height, null);
			dieEffect.screenDraw(g);
		}
		
		
	}
	
	public void close() {
		runnable = false;
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
				if(!runnable) return;
				do {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}while(GameScreen.pause);
				
				imageleftdim.width += xsize;
				imagerightdim.width += xsize;
				if(hp == 0) break;
			}
			if(hp == 0) break;
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
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}while(GameScreen.pause);
				imageleftdim.width -= xsize;
				imagerightdim.width -= xsize;
				if(hp == 0) break;
			}
			if(!runnable) return;
		}
		//die motion
		
		die = true;
		
		
		GameScreen.scores[GameScreen.index].plusScore();
		
		dieEffect.start();
		imageleftdim.width = 0;
		imageleftdim.height = 0;
		imagerightdim.width = 60;
		imagerightdim.height = 120;
		rightdim.width -= 20;
		
		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(GameScreen.pause);
		
		rightdim.width += 14;
		imageleftdim.width += 60;
		imagerightdim.width += 74;
		
		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(GameScreen.pause);
		
		rightdim.width += 16;
		imageleftdim.width += 74;
		imagerightdim.width += 90;
		
		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(GameScreen.pause);
		
		rightdim.width += 20;
		imageleftdim.width += 90;
		imagerightdim.width += 110;
		
		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(GameScreen.pause);
		
		rightdim.width += 20;
		imageleftdim.width += 115;
		imagerightdim.width += 135;
		
		
		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(GameScreen.pause);
		
		imageleftdim.width = 0;
		imageleftdim.height = 120;
		imagerightdim.width = 130;
		imagerightdim.height = 180;
		rightdim.width += 10;
		leftdim.height += 60;
		
		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(GameScreen.pause);
		
		rightdim.width += 20;
		imageleftdim.width += 130;
		imagerightdim.width += 150;
		
		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(GameScreen.pause);
		
		rightdim.width += 10;
		imageleftdim.width += 150;
		imagerightdim.width += 160;
		
		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(GameScreen.pause);
		
		imageleftdim.width = 0;
		imageleftdim.height = 0;
		imagerightdim.width = 136;
		imagerightdim.height = 60;
		dieimg = Mainclass.zombiedie11;
		
		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(GameScreen.pause);
		
		dieimg = Mainclass.zombiedie12;
		
		do {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(GameScreen.pause);
		
		delete = true;
	}
	
	public void attacked() {
		hp--;
		attack = false;
	}

}
