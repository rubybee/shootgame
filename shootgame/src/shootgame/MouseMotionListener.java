package shootgame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


import Screen.GameScreen;

public class MouseMotionListener extends MouseMotionAdapter{
	
	
	int x;
	int y;
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		if(ShootGame.screenstatus == 2)
			if(GameScreen.click) {
				x = e.getX();
				y = e.getY();
				GameScreen.where(x, y);
			}
	}

}
