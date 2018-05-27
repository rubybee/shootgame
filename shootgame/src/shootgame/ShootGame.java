package shootgame;

import javax.swing.JFrame;

public class ShootGame extends JFrame {

	public ShootGame() {
		setTitle("Shoot Game");
		setSize(Mainclass.SCREEN_WIDTH, Mainclass.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	
}
