package PushBoxGame2;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PushBox2Main extends JFrame{
	
	public static PushBox2Main mainFrame;

	public static void main(String[] args)
	{
		mainFrame = new PushBox2Main();
	}
	
	public PushBox2Main() {
		
		GameMap gm = new GameMap();
		GamePanel gp = new GamePanel(gm);
		
		addKeyListener((KeyListener)gp);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1920,1080);
		setVisible(true);
		
		add(gp);
	}
}
