package object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import Screen.Screen;

public class Score implements Screen{
	private static int [] highscores = new int[16];
	private int score;
	
	Font normalfont = new Font("Arial", Font.BOLD, 40);
	Font smallfont = new Font("Arial", Font.ITALIC, 30);
	
	public Score() {
		score = 0;
		
	}
	
	public void plusScore() {
		score += 1000;
	}
	
	public void sethighscore(int index) {
		if(highscores[index] < score)
			highscores[index] = score;
	}
	
	public void plusbBulletScore() {
		score += 3000;
	}
	
	public void setinitscore() {
		score = 0;
	}

	@Override
	public void screenDraw(Graphics2D g) {
		
		g.setFont(smallfont);
		g.setColor(Color.white);
		g.drawString(Integer.toString(score), 600, 100);
		
	}
	
	public int getscore() {
		return score;
	}
	
	public int gethighscore(int index) {
		return highscores[index];
	}
}
