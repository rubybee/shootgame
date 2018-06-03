package object;

import java.awt.Dimension;
import java.awt.Graphics2D;

import Screen.GameScreen;
import shootgame.Mainclass;

public class normalzombie extends Enemy{

	public normalzombie(int leftx, int lefty){
		leftdim = new Dimension(leftx, lefty);
		xsize = 80;
		ysize = 120;
		rightdim = new Dimension(leftx + xsize, lefty + ysize);
		
		imageleftdim = new Dimension(0, 0);
		imagerightdim = new Dimension(xsize, ysize);
		
		hp = 1;
		pattern = 4;
		
		img = Mainclass.zombie1;
		this.start();
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		g.drawImage(img, leftdim.width, leftdim.height, rightdim.width, rightdim.height, imageleftdim.width, imageleftdim.height, imagerightdim.width, imagerightdim.height, null);
		
	}
	
	@Override
	public void run() {
		while(hp == 1) {
			for (int i = 0; i < pattern - 1; i++) {
				
				do {
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}while(GameScreen.pause);
				imageleftdim.width += xsize;
				imagerightdim.width += xsize;
			}
			for (int i = 0; i < pattern - 1; i++) {
				do {
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}while(GameScreen.pause);
				imageleftdim.width -= xsize;
				imagerightdim.width -= xsize;
			}

			
			
		}
		
	}

}
