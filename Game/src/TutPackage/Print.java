package TutPackage;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.w3c.dom.events.EventException;


public class Print {
	
	public void print(String a) {
		System.out.println(a);
	}
	public void print(int a) {
		System.out.println(a);
	}
	public void print(boolean a) {
		System.out.println(a);
	}
	public void print(float a) {
		System.out.println(a);
	}
	public void print(double a) {
		System.out.println(a);
	}
	public void print(long a) {
		System.out.println(a);
	}
	public int random(int a, int b) {
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
	public int retc() {
		try {
			Scanner inp = new Scanner(System.in);
			return inp.nextInt();
		}
		catch(Exception e) {
			print("Error Letters Found");
			return 0;
		}
	}
	public void sleep(int a) {
		try {
			TimeUnit.SECONDS.sleep(a);
		}
		catch(Exception e) {
			
		}
	}
	
}
