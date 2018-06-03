package shootgame;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import javazoom.jl.player.Player;

public class Sound extends Thread{
	private Player play;
	private boolean loop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Sound(String name, boolean loop) {
		try {
			this.loop = loop;
			file = new File(Mainclass.class.getResource("../sound/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			play = new Player(bis);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	public void close() {
		loop = false;
		play.close();
		this.interrupt();
	}
	
	@Override
	public void run() {
		try {
			do {
				play.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				play = new Player(bis);
			}while(loop);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
