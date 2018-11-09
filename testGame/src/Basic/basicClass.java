package Basic; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class basicClass {
	static int ph = 100;
	static int pa = 15;
	static int ene = 2;
	static int maxe = 23;
	static int items = 7;
	static int nfood = 0;
	static int foods = 5;
	static int dif = 1;
	public static void print(String a) {
		System.out.println(a);
	}
	public static void print(int a) {
		System.out.println(a);
	}
	public static void print(boolean a) {
		System.out.println(a);
	}
	public static void print(float a) {
		System.out.println(a);
	}
	public static void print(double a) {
		System.out.println(a);
	}
	public static void print(long a) {
		System.out.println(a);
	}
	public static void sleep(long a) {
		try {
			TimeUnit.MILLISECONDS.sleep(a * 1000);
		}
		catch(Exception e)
		{
			print("Error!");
		}
	}
	public static void sleep(int a) {
		try {
			TimeUnit.SECONDS.sleep(a);
		}
		catch(Exception e) {
			
		}
	}
	public static void makee(JPanel a, String ENa, int x, int y) {
		JLabel EnN = new JLabel("");
		EnN.setBounds(x, y, 40, 40);
		EnN.setText(ENa);
		EnN.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
		a.add(EnN);
	}
	public static void enemy(JPanel a, String ENa, int EX, int EY) {
		if (EX > 45) {
			if (EX > 300) {
				EX = 300;
			}
		}
		else {
			EX = 45;
		}
		if (EY > 45) {
			if (EY > 300) {
				EY = 300;
			}
		}
		else {
			EY = 45;
		}
		makee(a, ENa, EX, EY);
	}
	public static int random(int a, int b) {
		try {
			if(b>a&&a>-1) {
				Random r = new Random();
				int numb = r.nextInt(b + 1 - a) + a;
				return numb;
			}
			return 0;
		}
		catch(Exception e) {
			return 0;
		}
	}
	public static int randn() {
		int r = random(1, 8);
		if (r < 5) {
			return -1;
		}
		else {
			return 1;
		}
	}
	public static String tostring(int a) {
		return Integer.toString(a);
	}
	
	public static void eat(Object[][] fd, int fnum, JPanel pan) {
		ph = ph + (int) fd[fnum][1];
		pa = pa + (int) fd[fnum][2];
		pan.remove(pan.getComponent(items + 3 + fnum));
		nfood = nfood - 1;
		JLabel Attack = (JLabel) pan.getComponent(5);
		Attack.setText("Attack: " + tostring(pa));
		JLabel Health = (JLabel) pan.getComponent(6);
		Health.setText("Health: " + tostring(ph));
		if (fnum == 0) {
			fd[0][0] = fd[1][0];
			fd[1][0] = fd[2][0];
			fd[2][0] = "Food";
			fd[0][1] = fd[1][1];
			fd[1][1] = fd[2][1];
			fd[2][1] = 1;
			fd[0][2] = fd[1][2];
			fd[1][2] = fd[2][2];
			fd[2][2] = 0;
		}
		else if (fnum == 1) {
			fd[1][0] = fd[2][0];
			fd[2][0] = "Food";
			fd[1][1] = fd[2][1];
			fd[2][1] = 1;
			fd[1][2] = fd[2][2];
			fd[2][2] = 0;
		}
		else {
			fd[2][0] = "Food";
			fd[2][1] = 1;
			fd[2][2] = 0;
		}
	}
	
	public static void food(Object[][] fd, JPanel pan, int numb) {
		int rfood = numb + random(1, foods);
		fd[nfood][0] = fd[rfood + 1][0];
		fd[nfood][1] = fd[rfood + 1][1];
		fd[nfood][2] = fd[rfood + 1][2]; 
		
		JLabel Food = new JLabel("");
		Food.setBounds(random(45, 450), random(45, 450), 40, 40);
		Food.setText((String) fd[numb][0]);
		Food.setBorder(BorderFactory.createDashedBorder(Color.CYAN));
		pan.add(Food);
	}
	
	public static void attack(Object[][] en, int enN, JPanel pan) {
		// en is for the enemy object array, enN is for enemy Number, pan is for the JPanel and it is all passed through by movechar
		int attack = ((int) en[enN][1] * 3 + (pa/12))*dif ;
		int enH = ((int) en[enN][2] + (ph/10)) * dif;
		// I made the 2 values so they could be printed rather then writing more code attack is the strength of the enemy
		// enH is the enemys health
		while (ph > 0 && enH > 0) {
			int ea = random(attack - 3, attack);
			ph = ph - ea;
			print("Enemy did: " + tostring(ea) + " Damage! You have " + tostring(ph) + " health left.");
			if (ph > 0) {
				int ma = random(pa - 10, pa);
				enH = enH - ma;
				print("You did: " + tostring(ma) + " Damage! Enemy has: " + tostring(enH) + " health left.");
				sleep(1);
			}
			//Made a while statement for the battle, the enemy always goes first and then it checks to see if the player has health left before continuing
		}
		if (ph > 0) {
			//Checks to see if the player has health other wise the enemy killed them
			print("You have won!");
			en[enN][5] = 0;
			for (int i = 0; i<en[enN].length; i++) {
				en[en.length - 1][i] = en[enN][i];
				en[enN][i] = en[ene + 1][i];
				en[ene + 1][i] = en[en.length - 1][i];
			}
			//It moves the old enemy into a temp array to move the new enemy into the old array and then moves the old enemy into the new array
			en[enN][5] = 1;
			ene += 1;
			//Sets the value of the new enemy to 1 so it can be fought, and adds 1 to the enemys count.
			JLabel Box = (JLabel) pan.getComponent(items + enN);
			Box.setText((String) en[enN][0]);
			//Gets the name from the enemy Object array, and items makes it easier for me to change when more stuff is added.
			if (ene == maxe) {
				dif = dif + 1;
				ene = 2;
			}
			JLabel Attack = (JLabel) pan.getComponent(5);
			Attack.setText("Attack: " + tostring(pa));
			JLabel Health = (JLabel) pan.getComponent(6);
			Health.setText("Health: " + tostring(ph));
		}
		else {
			print("You have lost!");
			pan.removeAll();
			JLabel Lost = new JLabel("You Have Died");
			Lost.setBounds(200, 240,100, 60);
			pan.add(Lost);
		}
	}
	public static void movechar(JPanel pan, JButton Me, String move, Object[][] en, Object[][] fd) {
		if (pan.getComponentCount() < 1) {
			return;
		}
		int movep = 25;
		int x = Me.getBounds().x;
		int y = Me.getBounds().y;
		if (move == "Down") {
			y = y + movep;
		}
		else if(move == "Up") {
			y = y - movep;
		}
		else if(move == "Right") {
			x = x + movep;
		}
		else if(move == "Left") {
			x = x - movep;
		}
		else
		{
			return;
		}
		int Mx = Me.getBounds().x;
		int My = Me.getBounds().y;
		if (x >= 5 && x <= 500 && y >= 5 && y <= 480) {
			//checks to make sure the x values is between 5 and 500 and if y is between 5 and 480.
			Me.setBounds(x, y, 80, 80);
			if (random(1, 20) == 12 && nfood < 3) {
				food(fd, pan, nfood);
				nfood = nfood + 1;
			}
			for (int i = 0; i<3; i++) {//moves the enemys x and y positions randomly
				if ((int) en[i][3] >= 500) {
					en[i][3] = (int) en[i][3] - random(8, 12);
				}
				else if ((int) en[i][3] <= 5) {
					en[i][3] = (int) en[i][3] + random(8, 12);
				}
				else {
					en[i][3] = (int) en[i][3] + random(8, 12) * randn();
				}
				if ((int) en[i][4] >= 480) {
					en[i][4] = (int) en[i][4] - random(8, 12);
				}
				else if ((int) en[i][4] <= 5) {
					en[i][4] = (int) en[i][4] + random(8, 12);
				}
				else {
					en[i][4] = (int) en[i][4] + random(8, 12) * randn();
				}
				
				en[i][4] = (int) en[i][4] + random(8, 12) * randn();
				pan.getComponent((items) + i).setBounds((int) en[i][3], (int) en[i][4], 40, 40);
				int ex = (int) en[i][3];
				int ey = (int) en[i][4];
				if (Mx - ex > -60 && Mx - ex < 0 && My - ey > -60 && My - ey < 0 && (int) en[i][5] == 1) {
					print("Close " + tostring(i));
					attack(en, i, pan);
				}
			}
			if (nfood > 0) {//Checks to see if the number of food is over 0
				for (int i = 0; i<nfood;i++) {
					JLabel f = (JLabel) pan.getComponent(items + 3 + i);
					int Fx = f.getBounds().x;
					int Fy = f.getBounds().y;
					if (Mx - Fx > -60 && Mx - Fx < 0 && My - Fy > -60 && My - Fy < 0) {
						eat(fd, i, pan);
					}
				}
			}
		}
	}
	public static void button(JPanel pan, JButton Me, String name, int x, int y, Object[][] en, Object[][] fd) {
		JButton a = new JButton(name);
		a.setBounds(x, y, 80, 60);
		a.setBackground(Color.WHITE);
		a.setOpaque(false);
		a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				movechar(pan, Me, name, en, fd);
			}
		});
		pan.add(a);
	}
	public static void AddEnemyFromTable(JPanel Panel, Object[][]en) {
		for (int i = 0; i<en.length; i++) {
			if ((int) en[i][5] == 1) {
				enemy(Panel, (String) en[i][0], (int) en[i][3], (int) en[i][4]);
			}
		}
	}
	public static void main(String[] args) {
		Object[][] Enemys = {
				{"Lvl.1", 1, 100, random(45, 460), random(45, 460), 1},
				{"Lvl.2", 2, 110, random(45, 460), random(45, 460), 1},
				{"Lvl.3", 3, 120, random(45, 460), random(45, 460), 1},
				{"Lvl.4", 4, 130, random(45, 460), random(45, 460), 0},
				{"Lvl.5", 5, 140, random(45, 460), random(45, 460), 0},
				{"Boss1", 6, 240, random(45, 460), random(45, 460), 0},
				{"Lvl.6", 6, 150, random(45, 460), random(45, 460), 0},
				{"Lvl.7", 7, 160, random(45, 460), random(45, 460), 0},
				{"Lvl.8", 8, 170, random(45, 460), random(45, 460), 0},
				{"Lvl.9", 9, 180, random(45, 460), random(45, 460), 0},
				{"Lvl.10", 10, 190, random(45, 460), random(45, 460), 0},
				{"Boss2", 12, 400, random(45, 460), random(45, 460), 0},
				{"Lvl.11", 11, 200, random(45, 460), random(45, 460), 0},
				{"Lvl.12", 12, 210, random(45, 460), random(45, 460), 0},
				{"Lvl.13", 13, 220, random(45, 460), random(45, 460), 0},
				{"Lvl.14", 14, 230, random(45, 460), random(45, 460), 0},
				{"Lvl.15", 15, 240, random(45, 460), random(45, 460), 0},
				{"Boss3", 19, 500, random(45, 460), random(45, 460), 0},
				{"Lvl.16", 16, 250, random(45, 460), random(45, 460), 0},
				{"Lvl.17", 17, 260, random(45, 460), random(45, 460), 0},
				{"Lvl.18", 18, 270, random(45, 460), random(45, 460), 0},
				{"Lvl.19", 19, 280, random(45, 460), random(45, 460), 0},
				{"Lvl.20", 20, 290, random(45, 460), random(45, 460), 0},
				{"Temp", 0, 0, 0, 0, 0}
				
		};
		Object[][] Food = {
				//Name Health Attack
				{"Food", 1, 0},
				{"Food", 1, 0},
				{"Food", 1, 0},
				{"Bread", 25, 1},
				{"Fruit", 15, 3},
				{"Steak", 45, 4},
				{"Potato", 5, 3},
				{"Pork", -25, 5},
				{"Fish", 40, -3}
		};
		JFrame BasicGame = new JFrame("TestGame");
		BasicGame.setSize(600, 600);
		BasicGame.setResizable(false);
		JPanel Panel = new JPanel();
		BasicGame.add(Panel);
		BasicGame.setVisible(true);
		BasicGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton Me = new JButton("");
		Me.setBounds(100, 100, 80, 80);
		Me.setBackground(Color.blue);
		button(Panel, Me, "Down", 260, 480, Enemys, Food);
		button(Panel, Me, "Up", 260, 420, Enemys, Food);
		button(Panel, Me, "Left", 180, 440, Enemys, Food);
		button(Panel, Me, "Right", 340, 440, Enemys, Food);
		//5 buttons
		JLabel Attack = new JLabel("");
		Attack.setBounds(0, 0, 90, 25);
		Attack.setText("Attack: " + tostring(pa));
		Attack.setBorder(BorderFactory.createDashedBorder(Color.CYAN));
		JLabel Health = new JLabel("");
		Health.setBounds(90, 0, 90, 25);
		Health.setText("Health: " + tostring(ph));
		Health.setBorder(BorderFactory.createDashedBorder(Color.CYAN));
		Panel.setLayout(null);
		Panel.add(Me);
		Panel.add(Attack);
		Panel.add(Health);
		AddEnemyFromTable(Panel, Enemys);
	}
}
