/**
 * The type Main.
 */
public class Main {

	/**
	 * Main principale.
	 */
	public static void main(String[] args) {
		SocialNetwork social = new SocialNetwork();
		
		if(social.entra()) {
			System.out.println("Benvenuto " + social.getUtenteConnesso().getNome() + ".");
			while(true) {
				System.out.print("Cerca un utente: ");
				Utente utenteCercato = social.cercaUtente(Leggi.stringa());
				
				if(utenteCercato != null) {
					social.caricaPost();
					social.caricaCommenti();
					utenteCercato.azioni(social.getUtenteConnesso());
				}
				else {
					System.out.println("Utente non trovato.");
				}
			}
		} 
		else {
			System.out.println("Uscita in corso...");
		}
	}
}
