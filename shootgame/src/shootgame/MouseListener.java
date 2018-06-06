package shootgame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import Screen.GameScreen;
import Screen.SelectScreen;

public class MouseListener extends MouseAdapter{
	Sound entermusic;
	int index;
	boolean check = false;
	
	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int tmpx;
		int tmpy;
		if (ShootGame.screenstatus == 0 || ShootGame.screenstatus == 3) return;
		else if (ShootGame.screenstatus == 1) {
			for (int i = 0; i < Mainclass.mapnumber; i++) {
				tmpx = SelectScreen.buttons.get(i).getx();
				if (x < tmpx + 100 && x > tmpx) {
					tmpy = SelectScreen.buttons.get(i).gety();
					if (y < tmpy + 100 && y > tmpy ) {
						entermusic = new Sound("enter sound.mp3", false);
						entermusic.start();
						SelectScreen.buttons.get(i).setImage(SelectScreen.mapselectimageenter.get(i));
						check = true;
						index = i;
					}
				}
			}
		}
		else if (ShootGame.screenstatus == 2) {
			if(GameScreen.click) {
				GameScreen.press();
			}
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int tmpx;
		int tmpy;
		if (ShootGame.screenstatus == 0 || ShootGame.screenstatus == 3) return;
		else if (ShootGame.screenstatus == 1) {
			if(check == false) return;
			else {
				tmpx = SelectScreen.buttons.get(index).getx();
				tmpy = SelectScreen.buttons.get(index).gety();
				if (x < tmpx + 100 && x > tmpx && y < tmpy + 100 && y > tmpy) {
					SelectScreen.buttons.get(index).setImage(SelectScreen.mapselectimage.get(index));
					ShootGame.sstogs(index);
					
				}
				else {
					SelectScreen.buttons.get(index).setImage(SelectScreen.mapselectimage.get(index));
				}
			}
		}
		else if (ShootGame.screenstatus == 2) {
			if(GameScreen.click) {
				GameScreen.release(x, y);
			}
		}
	}
	
}
