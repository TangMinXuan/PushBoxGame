package PushBoxGame2;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PushBox2Main extends JFrame{
	
	public static PushBox2Main pbm;
	
	public static GameMap gm;
	
	public static GamePanel gp;

	public static void main(String[] args)
	{
		pbm = new PushBox2Main();
		initMap();
		
		pbm.add(gp);
		pbm.addKeyListener( (KeyListener)gp );
		pbm.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pbm.setSize(1920,1080);
		pbm.setVisible(true);
	}
	
	private static void initMap(){
		gm = new GameMap();
		gp = new GamePanel(gm);
	}
}
