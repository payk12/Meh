package game;
import java.util.Scanner;
import java.util.Random;

public class gameClass {

	public static int smallest(int x, int y, int z){
		//Makes a new method called smallest and takes 3 integers for input
		if (x <= y && x <= z){
		//Checks to see if x is smaller then y and z then returns x if it is
		return x;
		}
		else if (y <= x && y <= z){
		//Checks to see if y is smaller then x and z then returns y if it is
		return y;
		}
		else if (z <= x && z <= y) {
		//Checks to see if z is smaller then x and y then returns z if it is
		return z;
		}
		else
		{
		//That means that the lower numbers are 
		return z;
		}
	}
	public static void print(String a) {
		System.out.println(a);
		//Makes a shorter method other then typing out the entire line
	}
	public static String tostring(int a) {
		return Integer.toString(a);
		//Converts an int to a string and returns it
	}
	public static String choice() {
		Scanner cho = new Scanner(System.in);
		String a = cho.next();
		return a ;
		//Get the players choice in a string value and returns it
	}
	public static boolean checks(String a, String b) {
		if(a.toLowerCase().equals(b.toLowerCase())) {
			return true;
		}
		else {
			return false;
		}
		//checks to see if string a is equal to string b it then returns a true or false value
	}
	public static int random(int a, int b) {
		Random n = new Random();
		int numb = n.nextInt(b - a + 1) + a;
		return numb;
		//makes a random int between the values a and b, a being the lower number and b being the higher number and then returns the int
	}
	public static void main(String[] args) {
		System.out.print(smallest(7, 6, 5));
	}
	//Output:
	//What is your name?
	//Cameron
	//Welcome, Cameron please pick a number between 1 and 99.
	//55
	//Incorrect, the number is lower. Please pick a number between 1 and 99.
	//22
	//Incorrect, the number is lower. Please pick a number between 1 and 99.
	//5
	//Correct, Cameron. It took you: 3 guesses, would you like to play again?
	//no
	//Alright the game will now stop.

}
