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
	
	 public String controlloStringaMail() throws Errore{
        try{
            if(registrati.getNomeProfilo().compareTo("@","."){
                return controlloStringaMail();
            }
        }
        catch(Errore e){
            throw new Errore();
        }
		catch(IllegalFormatException exception){
			System.out.println("Errore nella mail riscrivi: ");
			String nomeProfilo = stringa();
			registrati.setProfilo(nomeProfilo);
		}
    }
}
