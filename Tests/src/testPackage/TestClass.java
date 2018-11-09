package testPackage;
import java.util.*;

public class TestClass {
	public static int rollDice(){
		int Die1 = 0;
		int Die2 = 0;
		int Total = 0;
		Random rand = new Random();
		while (Die1 == Die2){
			Die1 = rand.nextInt(6) + 1;
			Die2 = rand.nextInt(6) + 1;
			Total += Die1 + Die2;
			System.out.println(Die1);
			System.out.println(Die2);
		}
		return Total;
	}


	public static void main(String[] args) {
		System.out.println(rollDice());
	}
}
