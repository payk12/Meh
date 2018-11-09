package arrayPackage;
import java.util.*;

public class ArrayClass {
	public static String ReturnCorrect(String Word) {
		String TempWord = "";//Makes a temp string to store the word without any dots, commas, slashs and question marks
		for (int i = 0; i<Word.length(); i++) {
			//Checks how many characters are in the word and makes a for loop based on it
			char check = Word.charAt(i);
			if (check != '.' && check != ',' && check != '/' && check != '?' && check != '-') {
				TempWord = TempWord+check;
			}
			//Makes a new char value to have to type less and makes a new if statement to check if the char doesn't match any of the chars
		}
		return TempWord;
		//Returns the word without any special characters
	}
	
	public static void main(String[] args) {
		String[] EnglishWords = {"Hello", "Name", "My", "Is", "And", "Computer", "The", "Best", "I", "Love", "To", "Play", "On", "Enjoy",
				"It", "Enjoying", "Playing", "Am"};
		String[] FrenchWords = {"Bonjour", "Prénom", "Mon", "Est", "Et", "Ordinateur", "La", "Meilleur", "Je", "Amour", "à", "Jouer", "Sur", "Prendre plaisir",
				"Il", "En profitant", "En jouant", "Un m"};
		//Makes 2 new String arrays to check if one of the words inputed is in the array and get the french word for that word.
		String ConvertedText = "";
		boolean Found = false;
		//Makes a temp ConvertedText to store the french line in it and makes a new boolean for found - used later on.
		Scanner Scan = new Scanner(System.in);
		String Words = Scan.nextLine();
		String[] WordsSplit = Words.split(" ");
		//Makes a new scan to get the persons input and makes a new String array to store it.
		for (int i = 0; i<WordsSplit.length; i++) {
			for (int a = 0; a<EnglishWords.length; a++) {
				if (ReturnCorrect(WordsSplit[i]).toLowerCase().equals(EnglishWords[a].toLowerCase())) {
					ConvertedText = ConvertedText + FrenchWords[a] + " ";
					Found = true;
					break;
					//Makes 2 new for loops, the first to check the words that is split in the persons input and the second to get the
					//English word and check if it is equal to the persons word, and if found it adds the french word to the Converted Text Line
					//and makes the Found boolean true and stops the current for loop to save a bit of time.
				}
			}
			if (Found == false) {
				ConvertedText = ConvertedText + WordsSplit[i] + " ";
			}
			//Checks to see if the word was found and if not puts it into the ConvertedText and sets Found boolean to false after it is done.
			Found = false;
		}
		System.out.println(ConvertedText);
		//Prints the Converted Text after it is done.
		//Output:
		//Hello, my name is cameron and I love to program on the computer.
		//Bonjour Mon Prénom Est cameron Et Je Amour à program Sur La Ordinateur 
	}
}
