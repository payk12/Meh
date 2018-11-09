package TutPackage;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class testClass {
	int HP = 50;
	String Gun = "";
	
	public static void print(String Line) {
		System.out.println(Line);
	}
	
	public static void sleep(int time) {
		try {
			TimeUnit.SECONDS.sleep(time);
		}
		catch(Exception e) {
			
		}
	}
	
	public static int returnChoice() {
		try {
			Scanner inp = new Scanner(System.in);
			return inp.nextInt();
		}
		catch(Exception e) {
			print("Error something other then numbers was found.");
			return 0;
		}
	}
	
	public static void YourRoom() {
		print("Your name is Rebly");
		sleep(4);
		print("Rebly wakes up in their room.");
		sleep(3);
		print("You wake up with only underwear on.");
		sleep(3);
		print("You hear glass breaking outside.");
		sleep(3);
		print("You look out the window and zombies are overrunning the place.");
		sleep(4);
		print("You know you have to make a quick decisions.");
		sleep(3);
		print("Your options are: \n1: Jump out the window(Potential Danger)\n2: Walk out of the room(Potential Danger)");
		int choice = returnChoice();
		if (choice == 1) {
			window1();
		}
		else if (choice == 2) {
			door1();
		}
		else
		{
			print("Please chose a proper option next time.");
			sleep(3);
			YourRoom();
		}
		
	}
	
	private static void window1() {
		print("You die from the fall. Bad choice.");
		sleep(1);
		YourRoom();
	}
	
	private static void door1() {
		print("You end up in your kitchen.");
		sleep(3);
		print("You hear a noise coming from the basement.");
		sleep(3);
		print("1: Go see what made the noise");
		print("2: Stay in kitchen");
		int choice = returnChoice();
		if (choice == 1) {
			basement1();
		}
		else if (choice == 2) {
			kitchen1();
		}
		else {
			print("Please Chose a proper option next time.");
			sleep(1);
			door1();
		}
	}
	
	private static void basement1() {
		print("You enter the basement.");
		sleep(3);
		print("False alarm, it was just a box.");
		sleep(3);
		print("There is however clothes for you to put on.");
		sleep(3);
		print("Would you like to put them on?");
		print("1: Yes");
		print("2: No");
		int choice = returnChoice();
		if (choice == 1) {
			print("You put the clothes on.");
		}
		else if (choice == 2) {
			print("Thats alright, I like being without clothes.");
		}
		else {
			print("Please Chose a proper option next time.");
			sleep(1);
			basement1();
		}
		print("You suddenly remember your dad had a safe with guns.");
		sleep(3);
		print("There is however an alarm on the door to the room.");
		sleep(3);
		print("You don't know what the passcode to turn off the alarm is.");
		sleep(3);
		print("1: Continue through the door anyways.");
		print("2: Go back to the kitchen.");
		choice = returnChoice();
		if (choice == 1) {
			gunroom();
		}
		else if (choice == 2) {
			kitchen1();
		}
		else {
			print("Please Chose a proper option next time.");
			sleep(1);
			basement1();
		}
		
	}
	
	private static void kitchen1() {
		print("You returned to the kitchen");
		sleep(2);
		print("You have to make a choice whether to leave the house and find people, or stay and make a hideout.");
		print("1: Leave house and find people.");
		print("2: Stay and make a hideout.");
		int choice = returnChoice();
		if (choice == 1) {
			print("The moment you leave the house you find people.");
			sleep(3);
			print("The people you have found are family members");
			sleep(3);
			Endgame();
		}
		else if (choice == 2) {
			print("Okay, well if your going to stay you might as well secure this place.");
			sleep(3);
			print("Theres a few things you could take apart.");
			sleep(3);
			print("Would you like to take apart the chair's, the table's, or the cabinet's?");
			sleep(3);
			print("1: There are 3 chair's and each chair gives 4 wood");
			sleep(3);
			print("2: There is 1 table and it gives 10 wood");
			sleep(3);
			print("3: There are 7 cabinets which give 3 wood each.");
			sleep(3);
			print("You require 21 wood to complete the house, you only have enough energy to take apart 1 set of items.");
		    sleep(3);
		    choice = returnChoice();
		    if (choice == 1) {
		    	print ("Calculating...");
		    	sleep(2);
		        print ("...........");
		        sleep(2);
		        print("I think you might need to practice your math a bit.");
		        kitchen1();
		    }
		    else if (choice == 2) {
		    	print ("Calculating...");
		    	sleep(2);
		        print ("...........");
		        sleep(2);
		        print("If only there was another table than you would be good.");
		        sleep(3);
		        print("But sadly I think your math is a bit off");
		        kitchen1();
		    }
		    else if (choice == 3) {
		    	print ("Calculating...");
		    	sleep(2);
		        print ("...........");
		        sleep(2);
		        print("Well done sir! Your math is on point!");
		        sleep(3);
		        print("Wow, that was some hard work.");
		        sleep(3);
		        print("I think you deserve some rest, you'll continue tomorrow.");
		        sleep(4);
		        wakeup();
		    }
		    else {
		    	print("Please Chose a proper option next time.");
				sleep(1);
				kitchen1();
		    }
		}
		else {
			print("Please Chose a proper option next time.");
			sleep(1);
			kitchen1();
		}
	}
	
	private static void wakeup() {
		Print Basics = new Print();
		Basics.print("Yawwwwn!");
		Basics.sleep(2);
		Basics.print("That was a good rest don't you think?");
		Basics.print("1: Yes.");
		Basics.print("2: No.");
		int choice = Basics.retc();
		if (choice == 1) {
			Basics.print("You bet it was!");
		    Basics.sleep(1);
		    Basics.print("Now let's continue this journey shall we?");
		    Basics.sleep(2);
		    Basics.print("1: Continue.");
		    Basics.print("2: Stop.");
		    choice = Basics.retc();
		    if (choice == 1) {
		    	 Basics.print("Great let's get back to securing this place!");
		         Basics.sleep(2);
		         journeycontinue();
		    }
		    else if (choice == 2) {
		    	Basics.print("You stopped the journey.");
		        Basics.sleep(2);
		        Basics.print("Just kidding you can't stop this journey.");
		        Basics.sleep(3);
		        Basics.print("Now let's continue and stop being lazy");
		        Basics.sleep(2);
		        journeycontinue();
		    }
		    else {
		    	Basics.print("Please Chose a proper option next time.");
				Basics.sleep(1);
				wakeup();
		    }
		    journeycontinue();
		}
		else if (choice == 2) {
			Basics.print("Well you have no choice we're continuing this journey!");
		    Basics.sleep(2);
		    journeycontinue();
		}
		else {
			Basics.print("Please Chose a proper option next time.");
			Basics.sleep(1);
			wakeup();
		}
	}
	
	public static void journeycontinue() {
		Print Basics = new Print();
		Basics.print("Well we have baricaded the windows and doors already");
		Basics.sleep(3);
		Basics.print("We might as well dismantle the table and chairs too.");
		Basics.sleep(3);
		Basics.print("What would you like to dismantle first?");
		Basics.print("1: Table.");
		Basics.print("2: Chairs.");
		Basics.sleep(2);
		int choice = Basics.retc();
		if (choice == 1){
		    Basics.print("You begin to dismantle the tables.");
		    Basics.sleep(2);
		    Basics.print("As you dismantle the table you find something wierd under it.");
		    Basics.sleep(4);
		    Basics.print("It is a secret passage...");
		    Basics.sleep(2);
		  secretpassageentrance();
		}
		else if (choice == 2) {
		    Basics.print("You dismantle all of the chairs in a quick matter.");
		    Basics.sleep(3);
		    Basics.print("Once you finish the chairs, you begin to dismantle all the tables.");
		    Basics.sleep(4);
		    Basics.print("Under one of the tables you find something rather wierd.");
		    Basics.sleep(3);
		    Basics.print("There is a secret passageway.");
		    Basics.sleep(2);
		    	secretpassageentrance();
		}
		else {
			Basics.print("Please Chose a proper option next time.");
			Basics.sleep(1);
			journeycontinue();
		}
	}
	
	private static void secretpassageentrance() {
		Print Basics = new Print();
		Basics.print("Do you want to enter this secret passage?");
		Basics.sleep(2);
		Basics.print("1: Yes.");
		Basics.print("2: No.");
		int choice = Basics.retc();
		if (choice == 1) {
			Basics.print("Ok here we go !");
			Basics.sleep(2);
			secretpassage();
		}
		else if (choice == 2) {
			knockknock();
		}
		else {
			Basics.print("Please Chose a proper option next time.");
			Basics.sleep(1);
			secretpassageentrance();
		}
	}
	
	private static void secretpassage() {
		Print Basics = new Print();
		Basics.print("You enter the Secret passage");
		Basics.sleep(3);
		Basics.print("There are 3 doors ahead of you.");
		Basics.sleep(3);
		Basics.print("Each are labeled Trap door. Do not Enter");
		Basics.sleep(3);
		Basics.print("Do you want to Enter one of the doors or leave?");
		Basics.print("1: Enter door 1.");
		Basics.print("2: Enter door 2.");
		Basics.print("3: Enter door 3.");
		Basics.print("4: Go back to kitchen.");
		Basics.sleep(3);
		int choice = Basics.retc();
		if (choice == 1) {
			Basics.print("You enter Trap door 1");
			Basics.sleep(2);
			Basics.print("It is infact a trap.");
			Basics.sleep(2);
			Basics.print("You die.");
			Basics.sleep(2);
			secretpassage();
		}
		else if (choice == 2) {
			Basics.print("You enter Trap door 2");
			Basics.sleep(2);
			Basics.print("It is infact a trap.");
			Basics.sleep(2);
			Basics.print("You die.");
			Basics.sleep(2);
			secretpassage();
		}
		else if (choice == 3) {
			Basics.print("You enter Trap door 3");
			Basics.sleep(2);
			Basics.print("It is infact a trap.");
			Basics.sleep(2);
			Basics.print("You die.");
			Basics.sleep(2);
			secretpassage();
		}
		else if (choice == 4) {
			Basics.print("Are you sure you want to go back?");
			Basics.sleep(3);
			Basics.print("1: Go back.");
			Basics.print("2: Stay");
			choice = Basics.retc();
			if (choice == 1) {
				Basics.print("Okay! Let's Go!");
			    Basics.sleep(2);
			    knockknock();
			}
			else if (choice == 2) {
				Basics.print("Alright! Let's go back!");
			    Basics.sleep(2);
			    secretpassage();
			}
			else {
				Basics.print("Please Chose a proper option next time.");
				Basics.sleep(1);
				secretpassage();
			}
		}
		else {
			Basics.print("Please Chose a proper option next time.");
			Basics.sleep(1);
			secretpassage();
		}
			
	}
	
	private static void knockknock() {
		Print Basics = new Print(); 
		Basics.print("You hear a knock coming from the door.");
		Basics.sleep(3);
		Basics.print("Do you want to open the door?");
		Basics.sleep(1);
		Basics.print("1: Open.");
		Basics.print("2: Leave it.");
		int choice = Basics.retc();
		if (choice == 1) {
			Basics.print("You open the door....");
		    Basics.sleep(5);
		    Basics.print("To your surprise it's someone you know.");
		    Basics.sleep(3);
		    Basics.print("It's...");
		    Basics.sleep(1);
		    Basics.print("It's...");
		    Basics.sleep(1);
		    Basics.print("It's Your family they live!");
		    Basics.sleep(2);
		    Endgame();
		    return;
		}
		else if (choice == 2) {
			Basics.print("The noise is getting louder.");
		    Basics.sleep(2);
		    Basics.print("You begin to hear whispers outside the door.");
		    Basics.sleep(3);
		    Basics.print("Someone outside says.");
		    Basics.sleep(2);
		    Basics.print("OPEN THE DOOR, OR WE WILL!");
		    Basics.sleep(3);
		    Basics.print("You're going to have to make a choice whether to open the door or not.");
		    Basics.print("1: Open the door.");
		    Basics.print("2: Keep it closed.");
		    choice = Basics.retc();
		    if (choice == 1) {
		    	Basics.print("You aproach the door quickly");
		        Basics.sleep(2);
		        Basics.print("You can still go back if you'd like?");
		        Basics.sleep(2);
		        Basics.print("1: Open Door.");
		        Basics.print("2: Step Back.");
		        choice = Basics.retc();
		        if (choice == 1) {
		        	Basics.print("You slowly turn the handle.");
		            Basics.sleep(2);
		            Basics.print("The door opens.");
		            Basics.sleep(2);
		            Basics.print("It's Your family.");
		            Basics.sleep(3);
		            Endgame();
		            return;
		        }
		        else if (choice == 2) {
		        	Basics.print("You step back and wait to see what happens.");
		            Basics.sleep(3);
		            Bustdoor();
		        }
		        else {
		        	Basics.print("Please Chose a proper option next time.");
					Basics.sleep(1);
					knockknock();
		        }
		    }
		    else if (choice == 2) {
		    	Basics.print("You patiently wait for what happens next.");
		        Basics.sleep(3);
		        Bustdoor();
		    }
		    else {
		    	Basics.print("Please Chose a proper option next time.");
				Basics.sleep(1);
				knockknock();
		    }
		}
		else {
			Basics.print("Please Chose a proper option next time.");
			Basics.sleep(1);
			knockknock();
		}
	}
	
	private static void Bustdoor() {
		Print Basics = new Print();
		Basics.print("The door gets busted down.");
		Basics.sleep(3);
		Basics.print("It's your family.");
		Basics.sleep(3);
		Endgame();
		return;
	}
	
	private static void gunroom() {
		Print Basics = new Print();
		Basics.print("Ok, you don't have to continue if you dont want to.");
		Basics.sleep(2);
		Basics.print("1: Turn the handle and take the chance of the alarm going off.");
		Basics.print("2: Return to kitchen.");
		int choice = Basics.retc();
		if (choice == 1) {
			Basics.print("BEEP! BEEP! BEEP!");
		    Basics.sleep(3);
		    Basics.print("....Groan....");
		    Basics.sleep(3);
		    gunroominside();
		}
		else if (choice == 2) {
			kitchen1();
		}
		else {
			Basics.print("Please Chose a proper option next time.");
			Basics.sleep(1);
			gunroom();
		}
	}
	
	private static void gunroominside() {
		Print Basics = new Print();
		Basics.print("Quickly! Grab a gun! THE ZOMBIES ARE COMING!");
		Basics.sleep(2);
		Basics.print("You have a choice between: ");
		Basics.print("1: Pistol.");
		Basics.print("2: Shotgun.");
		int choice = Basics.retc();
		if (choice == 1) {
			Basics.print("You pick up the pistol, really flexible gun with lots of options.");
		}
		else if (choice == 2) {
			Basics.print("You pick up the shotgun, great for taking a lot of zombies out.");
		}
		else {
			Basics.print("Please Chose a proper option next time.");
			Basics.sleep(1);
			gunroominside();
		}
		Basics.print("5 zombies are incoming!");
		Basics.sleep(3);
		Basics.print("Are you going to run? Or are you going to fight?");
		Basics.print("1: Run.");
		Basics.print("2: Fight.");
		choice = Basics.retc();
		if (choice == 1) {
			Basics.print("You run right into the hoard of zombies and get caught.");
		    Basics.sleep(3);
		    Basics.print("You die sorry.");
		    Basics.sleep(3);
		    gunroominside();
		}
		else if (choice == 2) {
			Basics.print("PREPARE TO FIGHT!!");
		    Fightnumber1();
		}
		else {
			Basics.print("Please Chose a proper option next time.");
			Basics.sleep(1);
			gunroominside();
		}
		
	}
	
	public static void Fightnumber1() {
		Print Basics = new Print();
		Basics.print("Intense music incoming!");
		Basics.sleep(3);
		Basics.print("First zombie coming");
		Basics.sleep(2);
		Basics.print("1: Shoot the zombies in the head.");
		Basics.print("2: Shoot the zombies in the chest.");
		int choice = Basics.retc();
		if (choice == 1) {
			Basics.print("You shoot the zombies in the head 1 by 1.");
			Basics.sleep(1);
			Basics.print("All 5 zombies die and you manage to equip your self enough for this apocalypse.");
			Basics.print("Congratulations you won.");
		}
		else if (choice == 2) {
			Basics.print("You manage to slow them down but you run out of ammo so you can't kill them.");
			Basics.sleep(1);
			Basics.print("You die a slow death.");
		}
		else {
			Basics.print("Please Chose a proper option next time.");
			Basics.sleep(1);
			Fightnumber1();
		}
	}
	
	private static void Endgame() {
		Print Basics = new Print();
		Basics.print("Congratulations!");
		Basics.sleep(2);
		Basics.print("You have succesfully found your family!");
		Basics.sleep(3);
		Basics.print("And without dying too!");
		Basics.sleep(2);
		Basics.print("I hope....");
		Basics.sleep(2);
		Basics.print("Would you like to play again or End?");
		Basics.sleep(3);
		Basics.print("1: Yes.");
		Basics.print("2: No.");
		int choice = Basics.retc();
		if (choice == 1) {
			Basics.print("Good Luck!");
			Basics.sleep(2);
			YourRoom();
		}
		else if (choice == 2) {
			Basics.print("Ok that's Fine!");
			Basics.print("Hope you had fun.");
		}
		else {
			Basics.print("If you did this before I thought you would of understood by now...");
			Basics.print("But you have completed the game, if you want to play again please press the play button.");
		}
	}
	public static void main(String[] args){
		print("This game will be based on your choices");
		print("Chose Wisely");
		YourRoom();
	}
}