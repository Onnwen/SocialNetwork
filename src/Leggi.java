import java.util.Scanner;

public class Leggi {
	static public int intero() {
		Scanner scanInt = new Scanner(System.in);
		System.out.print("-> ");
		try {
			return scanInt.nextInt();
		} catch (Exception e) {
			return intero();
		}
	}
	
	static public String stringa() {
		Scanner scanString = new Scanner(System.in);
		try {
			return scanString.nextLine();
		} catch (Exception e) {
			return stringa();
		}
	}
}
