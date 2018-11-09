package connect;
import java.util.*;

public class ConnectFourClass {

	public static void print(String line) {//Makes a method called print - less typing, it takes in a String and prints it out
		System.out.println(line);
	}
	public static void print(int line) {//Makes a method called print - less typing, it takes in a int and prints it out / Method overloading is used here
		System.out.println(line);
	}
	public static int Choice() {//Makes a method called Choice it doesn't take anything in and returns an int at the end - less typing
		Scanner Number = new Scanner(System.in);//Makes a new Scanner called Number
		try {//The program tries to run the choice and take in an int, but in the case anything other then an int is put it, it won't error and stop the program
			return Number.nextInt();//If the person put in a correct int it will return it
		}
		catch (Exception problem) {
			return 0;//Other wise the Catch will get the error and return a 0
		}
	}
	public static boolean Check(String[][] ConnectFour, int Number, String Player) {//Makes a method called Check, it checks if the spot chosen is open
		//it takes in the 2D Array ConnectFour, int Number and String Player
		if (Number>0 && Number<=7) {//First it checks to make sure the Number is bigger then 0 and is smaller or equal to 7
			for (int i = 0; i<ConnectFour[Number - 1].length; i++) {//If the Number is bigger then 0 and smaller or equal to 7 then it makes a for loop the length of how many Strings are in the Array at Number
				if (ConnectFour[ConnectFour[Number - 1].length - 1 - i][Number - 1].equals("")) {//Checks to see if the space is equal to nothing and then sets it to the Player, and it starts at the bottom and works it way up
					ConnectFour[ConnectFour[Number - 1].length - 1 - i][Number - 1] = Player;
					return true;//If it is open it returns true
				}
			}
		}
		return false;//If it can't find an open space in the spot the player chose then it returns false
	}
	public static boolean CheckIfWin(String[][] ConnectFour) 
	{//Makes a new method called CheckIfWin and takes the ConnectFour 2D Array
		for (int i = 0; i<ConnectFour.length; i++) {//Makes a for loop for how many Arrays are in the ConnectFour 2D Array
			int Count = 0;
			String CurrentPlayer = "";//Makes 2 new varibles, an int and a string value to store information for winning
			for (int a = 0; a<ConnectFour[i].length;a++) {//Makes a for loop for how many Strings are in the Array 
				//Checks Four Right
				if (CurrentPlayer.equals(ConnectFour[i][a]) && !CurrentPlayer.equals("")) {//Checks to see if the CurrentPlayer is equal to the current spot on the ConnectFour Array
					//And makes sure that spot doesn't equal to nothing to prevent no one from winning
					Count += 1;
					if (Count >=4) {
						print("Winner: "+CurrentPlayer);
						return true;
					}
					//If it is equal to the CurrentPlayer then 1 is added to Count, and if Count = 4 then it will return true and print out who won.
				}
				else {
					CurrentPlayer = ConnectFour[i][a];
					Count = 1;
					//If the CurrentPlayer is = nothing or CurrentPlayer doesn't equal to the person in the current spot then CurrentPlayer is set to that
					//And Count is set to 1
				}
			}//
			if (i<4) {
				//Checks Four Down Right
				for (int a = 0; a<ConnectFour[i].length-3; a++) {
					Count = 0;
					CurrentPlayer = "";
					//Sets Count to 0 and CurrentPlayer to nothing
					for (int b = 0; b<4; b++) {
						if (CurrentPlayer.equals(ConnectFour[i+b][a+b]) && !CurrentPlayer.equals("")) {//Checks to see if the CurrentPlayer is equal to the current spot on the ConnectFour Array
							//And makes sure that spot doesn't equal to nothing to prevent no one from winning
							Count += 1;
							if (Count >=4) {
								print("Winner: "+CurrentPlayer);
								return true;
							}
							//If it is equal to the CurrentPlayer then 1 is added to Count, and if Count = 4 then it will return true and print out who won.
						}
						else {
							CurrentPlayer = ConnectFour[i+b][a+b];
							Count = 1;
							//If the CurrentPlayer is = nothing or CurrentPlayer doesn't equal to the person in the current spot then CurrentPlayer is set to that
							//And Count is set to 1
						}
					}
				}
				for (int a = 0; a<ConnectFour[i].length; a++) {
					//Checks Down Four
					Count = 0;
					CurrentPlayer = "";
					//Sets Count to 0 and CurrentPlayer to nothing
					for (int b = 0; b<4; b++) {
						if (CurrentPlayer.equals(ConnectFour[i+b][a]) && !CurrentPlayer.equals("")) {//Checks to see if the CurrentPlayer is equal to the current spot on the ConnectFour Array
							//And makes sure that spot doesn't equal to nothing to prevent no one from winning
							Count += 1;
							if (Count >=4) {
								print("Winner: "+CurrentPlayer);
								return true;
							}
							//If it is equal to the CurrentPlayer then 1 is added to Count, and if Count = 4 then it will return true and print out who won.
						}
						else {
							CurrentPlayer = ConnectFour[i+b][a];
							Count = 1;
							//If the CurrentPlayer is = nothing or CurrentPlayer doesn't equal to the person in the current spot then CurrentPlayer is set to that
							//And Count is set to 1
						}
					}
				}
			}
			if(i>3){
				//Checks up right
				for (int a = 0; a<ConnectFour[i].length-3; a++) {
					Count = 0;
					CurrentPlayer = "";
					//Sets Count to 0 and CurrentPlayer to nothing
					for (int b = 0; b<4; b++) {
						if (CurrentPlayer.equals(ConnectFour[i-b][a+b]) && !CurrentPlayer.equals("")) {//Checks to see if the CurrentPlayer is equal to the current spot on the ConnectFour Array
							//And makes sure that spot doesn't equal to nothing to prevent no one from winning
							Count += 1;
							if (Count >=4) {
								print("Winner: "+CurrentPlayer);
								return true;
							}
							//If it is equal to the CurrentPlayer then 1 is added to Count, and if Count = 4 then it will return true and print out who won.
						}
						else {
							CurrentPlayer = ConnectFour[i-b][a+b];
							Count = 1;
							//If the CurrentPlayer is = nothing or CurrentPlayer doesn't equal to the person in the current spot then CurrentPlayer is set to that
							//And Count is set to 1
						}
					}
				}
			}
		}
		return false;//If no winner is found then false is returned
	}
	public static void PrintBoard(String[][] ConnectFour) {
		String Board = "1|2|3|4|5|6|7|\n";//Makes a new method called PrintBoard which takes in The ConnectFour 2D Array and makes a new String called Board
		for (int i = 0; i<ConnectFour.length;i++) {
			for (int a = 0; a<ConnectFour[i].length;a++) {//Makes a for loop for how many Arrays are in the ConnectFour 2D Array and a for loop for the amount of Strings in that array
				if (ConnectFour[i][a].equals("Player1")) {//Checks to see if the spot is equal to Player1 and Adds to the Board String X|
					Board = Board+"X|";
				}
				else if(ConnectFour[i][a].equals("Player2")) {//Checks to see if the spot is equal to Player2 and Adds to the Board String O|
					Board = Board+"O|";
				}
				else {//If it doesn't equal to any of them then a  | is added
					Board = Board+ " |";
				}
			}
			Board = Board+ "\n";//For each new Array in the 2D away a new line is added to the Board String
		}
		print(Board);//Prints the Board out after.
	}

	
	public static void main(String[] args) {
		String[][] ConnectFour = new String[7][7];//Makes a 2D Array called ConnectFour
		for (int i = 0; i<ConnectFour.length; i++) {
			for (int a = 0; a<ConnectFour[0].length; a++) {
				ConnectFour[i][a] = "";
			}
		}//Sets all the spots to nothing instead of null
		PrintBoard(ConnectFour);
		String CurrentPlayer = "Player1";
		print(CurrentPlayer+"'s Turn.");
		//prints the board, makes and new String Called CurrentPlayer and sets it to Player1, then prints the current players turn
		while (true) {//Makes a while loop
			print("Choose a number between 1 and 7");
			int Number = Choice();//asks the user to choose a number between 1 and 7 and gets their choice
			if (Check(ConnectFour, Number, CurrentPlayer) == true) {//checks to see if the number the player chose is valid
				if (CheckIfWin(ConnectFour) == true) {//If the number chosen is valid then it goes on to check if anyone won
					PrintBoard(ConnectFour);//If someone won it prints the board and breaks the loop to stop the game.
					break;
				}
				if (CurrentPlayer.equals("Player1")) {
					CurrentPlayer = "Player2";
				}//If the game didn't end and the number chosen was valid then it checks to see if CurrentPlayer is equal to Playe1 and
				//If it is then sets it to Player2
				else {
					CurrentPlayer = "Player1";
				}//If it doesn't equal to Player1 then CurrentPlayer is set to Player1
			}
			PrintBoard(ConnectFour);
			print(CurrentPlayer+"'s Turn.");
			//Prints the board and the current players turn.
		}
	}
}
