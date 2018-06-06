package object;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Screen.GameScreen;
import shootgame.Mainclass;

public class Normalbullet extends Bullet{
	
	int tmpx1, tmpx2, tmpy1, tmpy2;
	
	public Normalbullet() {
		shoot = false;
		bullet = Mainclass.bullet;
		bounce = 10;
		visuableimage = new ImageIcon(Mainclass.class.getResource("../image/visuablenormalbullet.png")).getImage();
		imagepos = new Dimension(0, 0);
		size = new Dimension(30, 35);
	}
	
	public Normalbullet(int x, int y) {
		shoot = false;
		bullet = Mainclass.bullet;
		bounce = 10;
		visuableimage = new ImageIcon(Mainclass.class.getResource("../image/visuablenormalbullet.png")).getImage();
		imagepos = new Dimension(0, 0);
		size = new Dimension(20, 40);
		
		Dimension startpos = new Dimension(100, 600);
		Dimension tmpDirection = new Dimension(x-startpos.width, y-startpos.height);
		double tmplong = Math.sqrt(Math.pow(x-startpos.width, 2) + Math.pow(y-startpos.height, 2));
		double speed = 15;
		
		//direction calculate need
		//direction calculate need
		shootbullet(startpos.width, startpos.height, (int)(tmpDirection.width/tmplong * speed + 0.5), (int)(tmpDirection.height/tmplong * speed + 0.5));
		//임시
	}

	public void shootbullet(int x, int y, int directionx, int directiony) {
		shoot = true;
		pos = new Dimension(x, y);
		direction = new Dimension(directionx, directiony);
		center = new Dimension(x + size.width/2, y + size.height/2);
		this.start();
	}

	@Override
	public void screenDraw(Graphics2D g) {
		g.drawImage(bullet, pos.width, pos.height, pos.width + size.width, pos.height + size.height, imagepos.width, imagepos.height, imagepos.width + size.width, imagepos.height + size.height, null);
		//(0, 0) (20, 40) || (20, 0) (60, 40) || (60, 0) (90, 40) || (90, 0) (120, 40)
	}
	
	@Override
	public void run() {
		while(bounce > 0) {
			sleep();
			if(!runnable) return;
			
			collisiontest();
			size = new Dimension(30, 40);
			imagepos.width += size.width;
			pos.width += direction.width;
			pos.height += direction.height;
			setcenter();
			if(bounce == 0) break;

			sleep();
			if(!runnable) return;
			
			collisiontest();
			size = new Dimension(30, 40);
			imagepos.width += size.width;
			pos.width += direction.width;
			pos.height += direction.height;
			setcenter();
			if(bounce == 0) break;
			
			sleep();
			if(!runnable) return;
			
			imagepos.width += size.width;
			pos.width += direction.width;
			pos.height += direction.height;
			setcenter();
			if(bounce == 0) break;
			
			sleep();
			if(!runnable) return;
			
			collisiontest();
			imagepos.width -= size.width;
			pos.width += direction.width;
			pos.height += direction.height;
			setcenter();
			
			sleep();
			if(!runnable) return;
			
			collisiontest();
			size = new Dimension(40, 40);
			imagepos.width -= size.width;
			pos.width += direction.width;
			pos.height += direction.height;
			setcenter();
			
			sleep();
			if(!runnable) return;
			
			collisiontest();
			size = new Dimension(20, 40);
			imagepos.width -= size.width;
			pos.width += direction.width;
			pos.height += direction.height;
			setcenter();
		}
	}
	
	public void sleep() {
		do {
			try {
				Thread.sleep(Mainclass.bulletsleeptime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(GameScreen.pause);
	}
	
	public void close() {
		runnable = false;
	}
	
	public void collisiontest() {
		for (int i = 0; i < GameScreen.structures.size(); i++) {			//수직 수평이 확실하지않은 오브젝트 추가시 수정이 필요
			Structure tmp = GameScreen.structures.get(i);
			tmpx1 = tmp.leftdim.width; tmpx2 = tmp.rightdim.width;
			tmpy1 = tmp.leftdim.height; tmpy2 = tmp.rightdim.height;
			if(pos.width < tmpx2 && pos.width > tmpx1 && center.height < tmpy2 && center.height > tmpy1) {
				direction.width = -(direction.width);
				bounce--;
				return;
			}
			if(pos.width + size.width < tmpx2 && pos.width + size.width > tmpx1 && center.height < tmpy2 && center.height > tmpy1) {
				direction.width = -(direction.width);
				bounce--;
				return;
			}
			if(pos.height < tmpy2 && pos.height > tmpy1 && center.width > tmpx1 && center.width < tmpx2) {
				direction.height = -(direction.height);
				bounce--;
				return;
			}
			if(pos.height + size.height > tmpy1 && pos.height + size.height < tmpy2 && center.width > tmpx1 && center.width < tmpx2 ) {
				direction.height = -(direction.height);
				bounce--;
				return;
			}
		}
		
		for (int i = 0; i < GameScreen.enes.size(); i++) {
			Enemy tmp = GameScreen.enes.get(i);
			tmpx1 = tmp.leftdim.width; tmpx2 = tmp.rightdim.width;
			tmpy1 = tmp.leftdim.height; tmpy2 = tmp.rightdim.height;
			if(pos.width < tmpx2 && pos.width > tmpx1 && center.height < tmpy2 && center.height > tmpy1) {
				if (tmp.attack) {
					tmp.attacked();
					bounce--;
					return;
				}
			}
			if(pos.width + size.width < tmpx2 && pos.width + size.width > tmpx1 && center.height < tmpy2 && center.height > tmpy1) {
				if (tmp.attack) {
					tmp.attacked();
					bounce--;
					return;
				}
			}
			if(pos.height < tmpy2 && pos.height > tmpy1 && center.width > tmpx1 && center.width < tmpx2) {
				if (tmp.attack) {
					tmp.attacked();
					bounce--;
					return;
				}
			}
			if(pos.height + size.height > tmpy1 && pos.height + size.height < tmpy2 && center.width > tmpx1 && center.width < tmpx2 )  {
				if (tmp.attack) {
					tmp.attacked();
					bounce--;
					return;
				}
			}
		}
		
		for (int i = 0; i < GameScreen.movenes.size(); i++) {
			MovableEnemy tmp = GameScreen.movenes.get(i);
			tmpx1 = tmp.leftdim.width; tmpx2 = tmp.rightdim.width;
			tmpy1 = tmp.leftdim.height; tmpy2 = tmp.rightdim.height;
			if(pos.width < tmpx2 && pos.width > tmpx1 && center.height < tmpy2 && center.height > tmpy1) {
				if (tmp.attack) {
					tmp.attacked();
					bounce--;
					return;
				}
			}
			if(pos.width + size.width < tmpx2 && pos.width + size.width > tmpx1 && center.height < tmpy2 && center.height > tmpy1) {
				if (tmp.attack) {
					tmp.attacked();
					bounce--;
					return;
				}
			}
			if(pos.height < tmpy2 && pos.height > tmpy1 && center.width > tmpx1 && center.width < tmpx2) {
				if (tmp.attack) {
					tmp.attacked();
					bounce--;
					return;
				}
			}
			if(pos.height + size.height > tmpy1 && pos.height + size.height < tmpy2 && center.width > tmpx1 && center.width < tmpx2 ) {
				if (tmp.attack) {
					tmp.attacked();
					bounce--;
					return;
				}
			}
		}
	}
	
	public void setcenter() {
		center.width = pos.width + size.width/2;
		center.height = pos.height + size.height/2;
	}
	
	public Image getImage() {
		return visuableimage;
	}
	
	public int getcenterx() {
		return center.width;
	}
	
	public int getcentery() {
		return center.height;
	}

	@Override
	public int gettype() {
		return 0;
	}
}
