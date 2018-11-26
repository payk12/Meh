package justPackage;
import com.phidget22.*;
import java.util.concurrent.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MatchClass {
	static boolean red = false;
	static boolean green = false;
	static boolean both = false;
	static int XPos = 1;
	static int YPos = 1;
	static Font BoldLabel = new Font("Bold", Font.BOLD, 16);
	static int[][] Cards1 = new int[14][4];
	static int[][] Cards2 = new int[14][4];
	static ArrayList<Integer> TempCards1 = new ArrayList<>();
	static ArrayList<Integer> TempCards2 = new ArrayList<>();
	public static void sleep(double Time) {
		try {
			TimeUnit.MILLISECONDS.sleep((int)(Time*1000));
		}
		catch (Exception E) {
			
		}
	}
	
	public static void SetPort(DigitalOutput Ob, int Port) throws PhidgetException{
		Ob.setHubPort(Port);
		Ob.setIsHubPortDevice(true);
		Ob.open(1000);
	}
	
	public static void SetPort(Panel Pan, DigitalInput Ob, int Port) throws PhidgetException{
		Ob.setHubPort(Port);
		Ob.setIsHubPortDevice(true);
		ButtonPressed(Pan, Ob, Port);
		Ob.open(1000);
	}
	
	public static void GreenLed(double Time) throws PhidgetException{
		DigitalOutput LED = new DigitalOutput();
		SetPort(LED, 4);
		LED.setState(true);
		sleep(Time);
		LED.setState(false);
		LED.close();
	}
	
	public static void RedLed(double Time) throws PhidgetException{
		DigitalOutput LED = new DigitalOutput();
		SetPort(LED, 5);
		LED.setState(true);
		sleep(Time);
		LED.setState(false);
		LED.close();
	}
	
	public static void MoveSelectBox(JLabel Box, int PosX, int PosY) {
		Box.setBounds(Box.getX() + PosX, Box.getY() + PosY, Box.getWidth(), Box.getHeight());
	}
	
	public static int getPosition(Panel Pan) {
		int CurrentPos = -1;
		both = true;
		if (YPos > 2) {
			CurrentPos = ((YPos - 3)*7) + XPos;
			PickCard(Pan, 2, CurrentPos);
		}
		else {
			CurrentPos = ((YPos - 1) *7) + XPos;
			PickCard(Pan, 1, CurrentPos);
		}
		return CurrentPos;
	}
	
	public static void ButtonPressed(Panel Pan, DigitalInput CButton, int ButtonNumber) throws PhidgetException{
		CButton.addStateChangeListener(new DigitalInputStateChangeListener() {
			@Override
			public void onStateChange(DigitalInputStateChangeEvent E) {
				JLabel SelectBox = (JLabel)Pan.getComponent(0);
				if (E.getState() == true) {
					if (ButtonNumber == 0) {
						red = true;
					}
					else {
						green = true;
					}
				}
				else if (E.getState() == false && (ButtonNumber == 0 && red == true || ButtonNumber == 1 && green == true) ){
					if (ButtonNumber == 0) {
						red = false;
						if (green == false && both == false) {
							
							if (XPos != 7) {
								XPos += 1;
								MoveSelectBox(SelectBox, 90, 0);
							}
							else {
								XPos = 1;
								MoveSelectBox(SelectBox, -540, 0);
							}
						}
						else if (both == true) {
							both = false;
						}
						else {
							
							System.out.println(getPosition(Pan));
						}
					}
					else {
						green = false;
						if (red == false && both == false) {
							if (YPos != 4) {
								YPos += 1;
								MoveSelectBox(SelectBox, 0, 105);
							}
							else {
								YPos = 1;
								MoveSelectBox(SelectBox, 0, -315);
							}
						}
						else if (both == true) {
							both = false;
						}
						else {
							
							System.out.println(getPosition(Pan));
						}
					}
				}
				else {
					if (ButtonNumber == 0) {
						red = false;
					}
					else {
						green = false;
					}
				}
			}
		});
	}
	
	public static void MakeCard(Panel Pan, int PosX, int PosY, int number) {
		JLabel Card = new JLabel("" + number, SwingConstants.CENTER);
		Card.setBounds(PosX, PosY, 85, 100);
		Card.setBackground(Color.GRAY);
		Card.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		Card.setOpaque(true);
		Card.setFont(BoldLabel);
		Pan.add(Card);
	}
	
	public static void PickCard(Panel Pan, int CardDeck, int Pos) {
		JLabel Card;
		if (CardDeck == 1) {
			Card = (JLabel)Pan.getComponent(Pos);
		}
		else {
			Card = (JLabel)Pan.getComponent(Pos + 7*2);
		}
		if (CardDeck == 1) {
			for (int i = 0; i<Cards1.length; i++) {
				if (Cards1[i][1] == 1 && Cards1[i][2] == 0 && i != Pos - 1) {
					System.out.println("A card is showing already.");
					return;
				}
			}
			Card.setText(Cards1[Pos - 1][0] + "");
			Cards1[Pos - 1][1] = 1;
			for (int i = 0; i<Cards2.length; i++) {
				if (Cards1[Pos - 1][0] == Cards2[i][0] && Cards2[i][1] == 1 && Cards2[i][2] == 0) {
					Cards1[Pos - 1][2] = 1;
					Cards2[i][2] = 1;
					System.out.println("Got a card");
					break;
				}
				else if (Cards2[i][1] == 1 && Cards2[i][2] == 0) {
					JLabel TempCard1 = (JLabel)Pan.getComponent(Cards2[i][3] + 1);
					JLabel TempCard2 = (JLabel)Pan.getComponent(Pos);
					sleep(1.5);
					System.out.println(Cards2[i][3]+1);
					TempCard1.setText(Cards2[i][3]+1 + ""); 
					TempCard2.setText(Pos + ""); 
					Cards2[i][1] = 0;
					Cards1[Pos-1][1] = 0;
				}
			}
		}
		else if (CardDeck == 2) {
			for (int i = 0; i<Cards2.length; i++) {
				if (Cards2[i][1] == 1 && Cards2[i][2] == 0 && i != Pos - 1) {
					System.out.println("A card is showing already." + (i));
					return;
				}
			}
			Card.setText(Cards2[Pos - 1][0] + "");
			Cards2[Pos - 1][1] = 1;
			for (int i = 0; i<Cards1.length; i++) {
				if (Cards2[Pos - 1][0] == Cards1[i][0] && Cards1[i][1] == 1 && Cards1[i][2] == 0) {
					Cards2[Pos - 1][2] = 1;
					Cards1[i][2] = 1;
					System.out.println("Got a card");
					break;
				}
				else if (Cards1[i][1] == 1 && Cards1[i][2] == 0) {
					JLabel TempCard1 = (JLabel)Pan.getComponent(Cards1[i][3] + 1);
					JLabel TempCard2 = (JLabel)Pan.getComponent(Cards2[i][3] + 14 + 1);
					System.out.println(Pos-1);
					sleep(1.5);
					TempCard1.setText(Cards1[i][3]+1 + ""); 
					sleep(0.5);
					System.out.println(TempCard2.getText());
					TempCard2.setText(Cards2[i][3]+14+1 + "");
					Cards1[i][1] = 0;
					Cards2[Pos-1][1] = 0;
				}
			}
		}
		
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
	
	public static void RandomCards() {
		//TempCards1
		//TempCards2
		for (int i = 0; i<Cards1.length; i++) {
			int TempNumber = random(1, 999);
			TempCards1.add(random(0, TempCards1.size()), TempNumber);
			TempCards2.add(random(0, TempCards2.size()), TempNumber);
		}
		for (int i = 0; i<Cards1.length; i++) {
			Cards1[i][0] = TempCards1.get(i);
			Cards2[i][0] = TempCards2.get(i);
		}
	}
	
	public static void main(String[] args)  throws PhidgetException{
		System.out.println(Cards2.length);
		JFrame Game = new JFrame("Game");
		Game.setSize(650, 470);
		Game.setResizable(false);
		Panel GamePanel = new Panel();
		GamePanel.setLayout(null);
		Game.add(GamePanel);
		Game.setVisible(true);
		Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel Selection = new JLabel("");
		Selection.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
		Selection.setBounds(10, 10, 86, 101);
		GamePanel.add(Selection);
		int TempCardsX = 0;
		int TempCardsY = 0;
		for (int i = 0; i<28; i++) {
			MakeCard(GamePanel, 10 + (90 * TempCardsX), 10 + (105 * TempCardsY), i + 1);
			TempCardsX += 1;
			if (TempCardsX == 7) {
				TempCardsX = 0;
				TempCardsY += 1;
			}
		}
		for (int i = 0; i<14; i++) {
			Cards1[i][3] = i;
			Cards2[i][3] = i;
		}
		
		//Setup Controls
		DigitalInput Red = new DigitalInput();
		SetPort(GamePanel, Red, 0);
		DigitalInput Green = new DigitalInput();
		SetPort(GamePanel, Green, 1);
		//End of Controls Setup
		RandomCards();
		
	}
}
