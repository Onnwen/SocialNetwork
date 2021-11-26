import java.util.Scanner;

public class Leggi {
	static Scanner scan = new Scanner(System.in);
	
	static public int intero() {
		return scan.nextInt();
	}
	
	static public String stringa() {
		return scan.nextLine();
	}
}
