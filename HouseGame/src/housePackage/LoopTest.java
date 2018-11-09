package housePackage;
import java.util.concurrent.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class LoopTest extends SwingWorker<Integer, String>{
	static boolean on = false;
	static int money = 10000;
	static int income = 0;
	static int messages = 0;
	static int NumberOfHouses = 0;
	static JPanel GamePanel;
	static JLabel GameMoney;
	static Font BoldLabel = new Font("Bold", Font.BOLD, 16);
	
	@Override
	protected Integer doInBackground() throws Exception{
		addMoney();
		return 1;
	}
	
	public static void addMoney() {
		on = true;
		while (on == true) {
			try {
				TimeUnit.SECONDS.sleep(10);
			}
			catch (Exception e) {
				
			}
			int randomNumber = random(1, 20);
			if (randomNumber == 4 || randomNumber == 15) {
				money += income/2;
				message(GamePanel, "Disaster struck, you lost half your profit.");
			}
			else if (randomNumber == 7) {
				money += income/1.5;
				message(GamePanel, "Some attendents decided not to pay.");
			}
			else if ((randomNumber == 13 || money > 50000 && randomNumber >= 5 && randomNumber < 7) && money > 0) {
				money -= money/5;
				message(GamePanel, "Taxes strike and 20% of your money is taken.");
			}
			else if (randomNumber == 18 && money != 10000) {
				money -= 3000;
				if (money < 0) {
				message(GamePanel, "You lose $3000, and now you owe money to the bank.");
				}
				else {
					message(GamePanel, "You lose $3000.");
				}
			}
			else {
				money += income;
			}
			
			GameMoney.setText("Money: $"+money);
		}
	}
	public static void message(JPanel Pan, String msg) {
		int Items = Pan.getComponents().length;
		int LengthPerChar = 10;
		int MaxX = 640;
		if (messages > 0) {
			for (int i = 0; i < messages; i++) {
				Label Message = (Label)Pan.getComponent(Items - messages + i);
				Message.setBounds(Message.getX(), Message.getY() - 25, Message.getWidth(), Message.getHeight());
			}
		}
		Label MessageLabel = new Label(msg);
		MessageLabel.setBounds(0, 590, msg.length() * LengthPerChar, 25);
		MessageLabel.setFont(BoldLabel);
		Pan.add(MessageLabel);
		messages += 1;
		if (messages > 5) {
			Pan.remove(Pan.getComponent(Items + 1 - messages));
			messages -= 1;
		}
	}
	public static int random(int NumberOne, int NumberTwo) {
		Random Numb = new Random();
		return Numb.nextInt(NumberTwo - NumberOne + 1) + NumberOne;
	}
	public static void setIncome(int Income) {
		income = Income;
	}
	public static void setMoney(int Money) {
		money = Money;
		GameMoney.setText("Money: $"+money);
	}
	public static void setPanel(JPanel Pan, JLabel Mon) {
		GamePanel = Pan;
		GameMoney = Mon;
	}
	public static void setMessages(int Messages) {
		messages = Messages;
	}
	public static int getMoney() {
		return money;
	}
	public static int getMessages() {
		return messages;
	}
}
