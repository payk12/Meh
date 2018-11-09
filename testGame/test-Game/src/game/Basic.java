package game;
import java.awt.*; 
import javax.swing.*;
import java.awt.event.KeyListener;

public class Basic {
	public static void ssize(JFrame a, int sizex, int sizey) {
		a.setSize(sizex, sizey);
	}

	public static void object(JPanel a, int x, int y) {
		JButton OB = new JButton("DX");
		OB.setBounds(x, y, 60, 60);
		OB.setBackground(Color.CYAN);
		a.add(OB);
	}
	
	public static void character(JPanel a, int x, int y) {
		JButton Head = new JButton("");
		Head.setBounds(x + 15, y, 30, 30);
		Head.setBackground(Color.BLACK);
		JButton Torso = new JButton("");
		Torso.setBounds(x + 15, y + 30, 30, 45);
		Torso.setBackground(Color.BLACK);
		JButton LA = new JButton("");
		LA.setBounds(x, y + 30, 15, 45);
		JButton RA = new JButton("");
		RA.setBounds(x+45, y + 30, 15, 45);
		JButton LL = new JButton("");
		LL.setBounds(x+15, y+75, 15, 45);
		JButton RR = new JButton("");
		RR.setBounds(x+30, y+75, 15, 45);
		a.add(Head);
		a.add(Torso);
		a.add(LA);
		a.add(RA);
		a.add(LL);
		a.add(RR);
		
	}
	
	public static void main (String[] args) {
		JFrame frame = new JFrame("TestRunner");
		frame.setSize(400, 400);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		object(panel, 100, 300);
		character(panel, 15, 15);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
