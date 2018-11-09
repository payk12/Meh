package housePackage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Main_Game {
	static LoopTest MoneyAdd = new LoopTest();
	static int messages = 0;
	static int income = 0;
	static Object[][] Houses = {
			{"House 1", 10000, 970, false},
			{"House 2", 14000, 1420, false},
			{"House 3", 23000, 1975, false},
			{"House 4", 54050, 2862, false},
			{"House 5", 92510, 4620, false},
			{"House 6", 172960, 7385, false},
			{"House 7", 210520, 11520, false},
			{"House 8", 302600, 13205, false},
			{"House 9", 415025, 17620, false},
			{"House 10", 584610, 24750, false},
			{"House 11", 750250, 32660, false},
			{"House 12", 870995, 41064, false},
			{"House 13", 1205202, 62068, false},
			{"House 14", 1328500, 71205, false},
			{"House 15", 1726205, 92619, false}
	};
	static Font Bold = new Font("Bold", Font.BOLD, 12);
	static Font BoldLabel = new Font("Bold", Font.BOLD, 16);
	public static void buyHouse(JPanel Pan, Button HouseSlot, int HouseNumber) {
		if (MoneyAdd.getMoney() >= (int)Houses[HouseNumber][1] && (boolean)Houses[HouseNumber][3] == false) {
			HouseSlot.setLabel("Income: "+(int)Houses[HouseNumber][2]);
			Houses[HouseNumber][3] = true;
			MoneyAdd.setMoney(MoneyAdd.getMoney() -(int)Houses[HouseNumber][1]);//Set Money
			income += (int)Houses[HouseNumber][2];//Set new income
			MoneyAdd.setIncome(income);
			message(Pan, "House bought for: $"+(int)Houses[HouseNumber][1]);
		}
	}
	public static void houseButton(JPanel Pan, int ButtonNumber, int x, int y) {
		Button HouseSlot = new Button((String)Houses[ButtonNumber][0]+": "+(int)Houses[ButtonNumber][1]);
		HouseSlot.setBounds(x, y, 110, 80);
		HouseSlot.setBackground(Color.CYAN);
		HouseSlot.setFont(Bold);
		HouseSlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				buyHouse(Pan, HouseSlot, ButtonNumber);
			}
		});
		Pan.add(HouseSlot);
	}
	public static void message(JPanel Pan, String msg) {
		messages = MoneyAdd.getMessages();
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
		MoneyAdd.setMessages(messages);
	}
	public static void main(String[] args) {
		JFrame GameFrame = new JFrame("Game");
		GameFrame.setSize(650, 650);
		GameFrame.setResizable(false);
		JPanel Panel = new JPanel();
		Panel.setLayout(null);
		GameFrame.add(Panel);
		GameFrame.setVisible(true);
		GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel MoneyLabel = new JLabel("Money: $10000");
		MoneyLabel.setBounds(490, -5, 150, 45);
		MoneyLabel.setFont(Bold);
		Panel.add(MoneyLabel);
		houseButton(Panel, 0, 30, 40);
		houseButton(Panel, 1, 150, 40);
		houseButton(Panel, 2, 270, 40);
		houseButton(Panel, 3, 390, 40);
		houseButton(Panel, 4, 510, 40);
		houseButton(Panel, 5, 30, 130);
		houseButton(Panel, 6, 150, 130);
		houseButton(Panel, 7, 270, 130);
		houseButton(Panel, 8, 390, 130);
		houseButton(Panel, 9, 510, 130);
		houseButton(Panel, 10, 30, 220);
		houseButton(Panel, 11, 150, 220);
		houseButton(Panel, 12, 270, 220);
		houseButton(Panel, 13, 390, 220);
		houseButton(Panel, 14, 510, 220);
		MoneyAdd.setPanel(Panel, MoneyLabel);
		MoneyAdd.execute();
	}
}
