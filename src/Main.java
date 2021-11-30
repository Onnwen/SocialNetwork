
public class Main {

	public static void main(String[] args) {
		SocialNetwork social = new SocialNetwork();
		
		if(social.entra()) {
			System.out.println("Benvenuto " + social.getUtenteConnesso().getNome() + ".");
			while(true) {
				System.out.println("Cerca un utente: ");
				Utente utenteCercato = social.cercaUtente(Leggi.stringa());
				
				if(utenteCercato != null) {
					utenteCercato.azioni();
				}
				else {
					System.out.println("Utente non trovato.");
				}
			}
		} 
		else {
			System.out.println("Terzo tentativo fallito.\nUscita in corso...");
		}
	}
}
