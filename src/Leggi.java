import java.util.Scanner;

public class Leggi {
	static public int intero() {
		Scanner scanInt = new Scanner(System.in);
		System.out.print("-> ");
		try {
			int valoreLetto = scanInt.nextInt();
			scanInt.close();
			return valoreLetto;
		} catch (Exception e) {
			return intero();
		}
	}
	
	static public String stringa() {
		Scanner scanString = new Scanner(System.in);
		String valoreLetto = scanString.nextLine();
		scanString.close();
		return valoreLetto;
	}


}
