package reverse;

public class namer {
	
	public static String StringReverseName(String Name) {
		String TempName = "";
		for (int i = 0; i<Name.length(); i++) {
			TempName = TempName + Name.substring(Name.length() - 1 - i, Name.length() - i);
		}
		return TempName;
	}
	public static String CharReverseName(String Name) {
		String TempName = "";
		for (int i = 0; i <Name.length(); i++) {
			TempName = TempName + Name.charAt(Name.length() - 1 - i);
		}
		return TempName;
	}
	
	
	
	public static String ConvertToInt(String code, int ShiftValue) {
		//Makes a new method called ConvertToInt this is what converts the message, it asks for the message and the shift value
		String ConvertedCode = "";
		//Makes a new String called ConvertedCode for later use
		for (int i = 0; i<code.length(); i++) {
			//Makes a new local int called i and it is the length of chars in the variable code
			ConvertedCode = ConvertedCode + " " + ((int)code.charAt(i) - ShiftValue);
			//This is where the ConvertedCode gets used and the chars are converted to ints
		}
		return ConvertedCode.substring(1);
		//Returns ConvertedCode with a substring of 1 because of a space showing up at the start of the code without substring
	}
	public static String ConvertFromInt(String code, int ShiftValue) {
		//Makes a new method called ConvertFromInt this converts the message from ints, it takes the message and shift value
		String ConvertedCode = "";
		//Makes a new String called ConvertedCode for later use
		String[] CodeArray = code.split(" ");
		//This String Array is used to split the message by spaces and is much easier to handle
		for (int i = 0; i<CodeArray.length; i++) {
			//Makes a new for loop with a length of the amount of strings in the CodeArray
			ConvertedCode = ConvertedCode+((char)(Integer.parseInt(CodeArray[i]) + ShiftValue));
			//Uses the ConvertedCode and converts the numbers in the CodeArray to change them back to a char using the Integer parseInt to convert the string to an int and add a Shift Value
		}
		return ConvertedCode;
		//Returns the converted Code
	}
	public static void main(String[] args) {
		System.out.println(CharReverseName("Burgers cause more problems then they solve"));
		System.out.println(StringReverseName("[: ylF naC sniugneP | Penguins Can Fly :]"));
		System.out.println(ConvertToInt("Spaces Don't Effect This :O", 5));
		System.out.println(ConvertFromInt(ConvertToInt("//Spaces Don't Effect This :O", 5), 5));
		System.out.println(ConvertFromInt("95 65 70 61", -20));
	}

}
