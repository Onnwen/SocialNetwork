import java.util.Scanner;

public class Leggi {
	
	/**
	 * 
	 * @return Restituisce un valore intero inserite da tastiera.
	 */
	static public int intero() {
		Scanner scanInt = new Scanner(System.in);
		System.out.print("-> ");
		try {
			return scanInt.nextInt();
		} catch (Exception e) {
			return intero();
		}
	}
	
	/**
	 * 
	 * @return Restituisce una stringa inserita da tastiera.
	 */
	static public String stringa() {
		Scanner scanString = new Scanner(System.in);
		try {
			return scanString.nextLine();
		} catch (Exception e) {
			return stringa();
		}
	}
	
	public String controlloStringaMail(){
        try{
            if(registrati.getNomeProfilo().contains(segno)){
                return controlloStringaMail();
            }
            else{
                System.out.println("Errore nella mail riscrivi: ");
			    String nomeProfilo = stringa();
			    registrati.setProfilo(nomeProfilo);
            }
        }
        catch(Exception errore){
            System.out.println("Errore nella mail riscrivi: ");
			String nomeProfilo = stringa();
			registrati.setProfilo(nomeProfilo);
        }
        return null;
    }
}
