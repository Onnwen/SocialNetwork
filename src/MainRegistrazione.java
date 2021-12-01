import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Registrazione registra = new Registrazione();
		int scelta;
		Scanner obj = new Scanner (System.in);
		
		System.out.println("Scegli se: 1]login 2]crea account ");
		scelta = obj.nextInt();
		
		switch (scelta) {
		case 1: 
			if (scelta == 1) {
				
			}
		case 2: 
			if (scelta == 2) {
				System.out.println("Inserisci il nome: ");
				String nomeUtente = obj.next();
				System.out.print("Inserisci cognome: ");
				String cognomeUtente = obj.next();
				System.out.println("Inserisci eta: ");
				int eta = obj.nextInt();
				if(eta<10) {
					System.out.println("Non puoi accedere al social: ");
					break;
				}
				
				registra.codiceDiRegistrazione(0);
				
				System.out.println("Inserisci nome del profilo: ");
				String nomeProfilo = obj.next();
				System.out.println("Inserisci password : ");
				int password = obj.nextInt();
				registra.stampa(nomeUtente, cognomeUtente, nomeProfilo);
			}	
		}
	}
}
