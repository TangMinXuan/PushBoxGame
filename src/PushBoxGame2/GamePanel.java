package PushBoxGame2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener{
	
	public static GameMap gm;
	public static Hero hero;
	
	public GamePanel(GameMap gm) {
		this.gm = gm;
		hero = new Hero();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		for(int i=0;i<gm.maparr.length;i++) {
			for(int j=0;j<gm.maparr[i].length;j++) {
				drawMap(g,i,j,gm.maparr[i][j]);//j->panel's x
				if(gm.maparr[i][j]==3) { //This i.j is hero
					hero.i = i;
					hero.j = j;
				}
				if(i==3&&j==3 || i==3&&j==4 || i==4&&j==4) {
					drawtarget(g, i, j);
				}
				if(gm.maparr[3][3]==2&&gm.maparr[3][4]==2&&gm.maparr[4][4]==2) {
					drawWinText(g);
				}
			}
		}
		
		repaint();
	}
	
	private void drawMap(Graphics g,int y,int x,int type) {
		x = x*100;
		y = y*100;
		
		switch (type) {
		case 1:
			drawWall(g, x, y);
			break;
		case 2:
			drawBox(g, x, y);
			break;
		case 3:
			drawHero(g, x, y);
		default:
			break;
		}
		
		g.setColor(Color.black);
		g.drawRect(x, y, 100, 100);
		
	}
	
	private void drawWall(Graphics g,int x,int y) {
		g.setColor(Color.black);
		g.fillRect(x, y, 100, 100);
	}
	
	private void drawtarget(Graphics g,int y,int x) {
		x = x*100;
		y = y*100;
		g.setColor(Color.red);
		g.drawLine(x, y, x+100, y+100);
		g.drawLine(x+100, y, x, y+100);
	}
	
	private void drawHero(Graphics g,int x,int y) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, 100, 100);
	}
	
	private void drawBox(Graphics g,int x,int y) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 100, 100);
	}
	
	private void drawWinText(Graphics g) {
		g.setColor(Color.red);
		g.setFont(new Font("ËÎÌå", Font.BOLD, 100));
		g.drawString("You Win !!!", 900, 100);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		/**
		 * 0£ºnull
		 * 1£ºwall
		 * 2£ºbox
		 * 3: hero
		 */
		int i = hero.i;
		int j = hero.j;
		
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			if (judgeLocation(1) == 1) {
				gm.maparr[i - 1][j] = 3;
				gm.maparr[i][j] = 0;
			} else if (judgeLocation(1) == 2) {
				gm.maparr[i - 2][j] = 2;
				gm.maparr[i - 1][j] = 3;
				gm.maparr[i][j] = 0;
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			if(judgeLocation(2) == 1) {
				gm.maparr[i + 1][j] = 3;
				gm.maparr[i][j] = 0;
			}else if (judgeLocation(2) == 2) {
				gm.maparr[i + 2][j] = 2;
				gm.maparr[i + 1][j] = 3;
				gm.maparr[i][j] = 0;
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			if(judgeLocation(3) == 1) {
				gm.maparr[i][j - 1] = 3;
				gm.maparr[i][j] = 0;
			}else if (judgeLocation(3) == 2) {
				gm.maparr[i][j - 2] = 2;
				gm.maparr[i][j - 1] = 3;
				gm.maparr[i][j] = 0;
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			if(judgeLocation(4) == 1) {
				gm.maparr[i][j + 1] = 3;
				gm.maparr[i][j] = 0;
			} else if (judgeLocation(4) == 2) {
				gm.maparr[i][j + 2] = 2;
				gm.maparr[i][j + 1] = 3;
				gm.maparr[i][j] = 0;
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_R)
		{
			for (int n = 0; n < 8; n++) {
				for (int m = 0; m < 8; m++) {
					gm.maparr[n][m] = gm.mapBackUp[n][m];
				}
			}
		}
	}
	
	private int judgeLocation(int dir) {
		/**
		 * 0: can't move
		 * 1: normally move 
		 * 2: normally push box
		 */
		int i = hero.i;
		int j = hero.j;
		if(dir==1) {
			if (gm.maparr[i - 1][j] == 0) {
				return 1;
			} else if (gm.maparr[i - 1][j] == 2) {
				if (gm.maparr[i - 2][j] == 0) {
					return 2;
				}
			}
		}
		
		if(dir==2) {
			if (gm.maparr[i + 1][j] == 0) {
				return 1;
			} else if (gm.maparr[i + 1][j] == 2) {
				if (gm.maparr[i + 2][j] == 0) {
					return 2;
				}
			}
		}
		
		if(dir==3) {
			if (gm.maparr[i][j - 1] == 0) {
				return 1;
			} else if (gm.maparr[i][j - 1] == 2) {
				if (gm.maparr[i][j - 2] == 0) {
					return 2;
				}
			}
		}
		
		if(dir==4) {
			if (gm.maparr[i][j + 1] == 0) {
				return 1;
			} else if (gm.maparr[i][j + 1] == 2) {
				if (gm.maparr[i][j + 2] == 0) {
					return 2;
				}
			}
		}
		
		return 0;
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
}
