package object;

import java.awt.Dimension;
import java.awt.Graphics2D;

import Screen.GameScreen;
import shootgame.Mainclass;
import shootgame.hitEffect;

public class Normalmovezombie extends MovableEnemy{
	
	
	hitEffect dieEffect;
	int movepoint, tmpmovepoint;
	
	public Normalmovezombie(int leftx, int lefty, int move){
		
		movepoint = move;
		tmpmovepoint = 0;
		
		right = true;
		leftdim = new Dimension(leftx, lefty);
		xsize = 60;
		ysize = 120;
		rightdim = new Dimension(leftx + xsize, lefty + ysize);
		
		dieEffect = new hitEffect();
		dieEffect.setHitPos(leftdim);
		
		imageleftdim = new Dimension(0, 0);
		imagerightdim = new Dimension(60, ysize);
		
		hp = 1;
		pattern = 4;
		
		idlerightimg = Mainclass.zombiemoveright1;
		idleleftimg = Mainclass.zombiemoveleft1;
		dieimg = Mainclass.zombiedie1;
		this.start();
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		dieEffect.setHitPos(leftdim);
		if (!die) {
			if(right) g.drawImage(idlerightimg, leftdim.width, leftdim.height, rightdim.width, rightdim.height, imageleftdim.width, imageleftdim.height, imagerightdim.width, imagerightdim.height, null);
			else g.drawImage(idleleftimg, leftdim.width, leftdim.height, rightdim.width, rightdim.height, imageleftdim.width, imageleftdim.height, imagerightdim.width, imagerightdim.height, null);
		}
		else{
			g.drawImage(dieimg, leftdim.width, leftdim.height, rightdim.width, rightdim.height, imageleftdim.width, imageleftdim.height, imagerightdim.width, imagerightdim.height, null);
			dieEffect.screenDraw(g);
		}
	}

	@Override
	public void close() {
		runnable = false;
	}

	@Override
	public void attacked() {
		hp--;
		attack = false;
	}
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(hp == 1) {
			while(tmpmovepoint < movepoint) {
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
				
				tmpmovepoint += 10;
				leftdim.width += 10;
				rightdim.width += 30;
				imageleftdim.width += 60;
				imagerightdim.width += 80;
				
				if(tmpmovepoint > movepoint) break;
				if(hp == 0) break;
				
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
				
				tmpmovepoint += 10;
				leftdim.width += 10;
				rightdim.width += 15;
				imageleftdim.width += 80;
				imagerightdim.width += 85;
				
				if(tmpmovepoint > movepoint) break;
				if(hp == 0) break;
				
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
				
				tmpmovepoint += 10;
				leftdim.width += 10;
				rightdim.width += 5;
				imageleftdim.width += 85;
				imagerightdim.width += 75;
				
				if(tmpmovepoint > movepoint) break;
				if(hp == 0) break;
				
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
				
				tmpmovepoint += 10;
				leftdim.width += 10;
				rightdim.width -= 10;
				imageleftdim.width += 75;
				imagerightdim.width += 55;
				
				if(tmpmovepoint > movepoint) break;
				if(hp == 0) break;
				
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
				
				tmpmovepoint += 10;
				leftdim.width += 10;
				rightdim.width += 10;
				imageleftdim.width += 55;
				imagerightdim.width += 55;
				
				if(tmpmovepoint > movepoint) break;
				if(hp == 0) break;
				
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
				imageleftdim.width = 0;
				imagerightdim.width = 60;
				rightdim.width = leftdim.width + 60;
			}
			
			if(hp == 0) break;
			right = false;
			tmpmovepoint = 0;
			imageleftdim.width = 350;
			imagerightdim.width = 412;
			rightdim.width = leftdim.width + 62;
			
			while(tmpmovepoint < movepoint) {
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
				
				tmpmovepoint += 10;
				leftdim.width -= 10;
				rightdim.width += 8;
				imageleftdim.width -= 80;
				imagerightdim.width -= 62;
				
				if(tmpmovepoint > movepoint) break;
				if(hp == 0) break;
				
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
				
				tmpmovepoint += 10;
				leftdim.width -= 10;
				rightdim.width -= 10;
				imageleftdim.width -= 80;
				imagerightdim.width -= 80;
				
				if(tmpmovepoint > movepoint) break;
				if(hp == 0) break;
				
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
				
				tmpmovepoint += 10;
				leftdim.width -= 10;
				rightdim.width -= 5;
				imageleftdim.width -= 75;
				imagerightdim.width -= 80;
				
				if(tmpmovepoint > movepoint) break;
				if(hp == 0) break;
				
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
				
				tmpmovepoint += 10;
				leftdim.width -= 10;
				rightdim.width = leftdim.width + 60;
				imageleftdim.width -= 60;
				imagerightdim.width -= 75;
				
				if(tmpmovepoint > movepoint) break;
				if(hp == 0) break;
				
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
				
				tmpmovepoint += 10;
				leftdim.width -= 10;
				rightdim.width -= 10;
				imageleftdim.width -= 60;
				imagerightdim.width -= 60;
				
				if(tmpmovepoint > movepoint) break;
				if(hp == 0) break;
				
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
				
				imageleftdim.width = 350;
				imagerightdim.width = 412;
				rightdim.width = leftdim.width + 62;
			}
			
			if(hp == 0) break;
			tmpmovepoint = 0;
			imageleftdim.width = 0;
			imagerightdim.width = 60;
			right = true;
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

}
