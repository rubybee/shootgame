package shootgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;




public class KeyListener extends KeyAdapter {
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(ShootGame.screenstatus) {
			case 0:
				if(e.getKeyCode() == KeyEvent.VK_W) {
					ShootGame.MS.pressW();
				}
				else if(e.getKeyCode() == KeyEvent.VK_S) {
					ShootGame.MS.pressS();
				}
				else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					ShootGame.MS.pressEnter();
				}
				break;
			case 1:
				
		}
	}
}
