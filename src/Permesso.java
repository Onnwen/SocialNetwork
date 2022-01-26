
public class Permesso {
	private Utente perUtente;
	private boolean Amicizia;
	private boolean post;
	private boolean like;
	private boolean commenti;
	
	/**
	 * 
	 * @param account Account per il quale si vogliono definire i permessi.
	 */
	public Permesso(Utente account) {
		this.perUtente = account;
	}
	
	/**
	 * 
	 * @return Restituisce l'utente per il quale sono definiti i permessi.
	 */
	public Utente getPerUtente() {
		return this.perUtente;
	}

	/**
	 * Imposta una nuova amicizia. Tutti i permessi su true.
	 */
	public void setAmicizia() {
		this.Amicizia= true;
		this.commenti = true;
		this.like = true;
		this.post = true;
	}

	/**
	 * Rimuove i permessi per i post.
	 */
	public void removePermessoPost() {
		this.post = false;
	}

	/**
	 * Rimuove il permesso per i mi piace.
	 */
	public void removePermessoLike() {
		this.like = false;
	}

	/**
	 * Rimuove il permesso per i commenti.
	 */
	public void removePermessoCommenti() {
		this.commenti = false;
	}
	
	/**
	 * 
	 * @return Restituisce true se l'utente ha accesso ai post, altrimenti false.
	 */
	public boolean post() {
		return post;
	}
	
	/**
	 * 
	 * @return Restituisce true se l'utente ha accesso ai like, altrimenti false.
	 */
	public boolean like() {
		return like;
	}
	
	/**
	 * 
	 * @return Restituisce true se l'utente ha accesso ai commenti, altrimenti false.
	 */
	public boolean commenti() {
		return commenti;
	}

	/**
	 * Metodo non utilizzabile. Da completare.
	 */
	public void stampaPermessi() {
		System.out.println("Permessi concessi a " + perUtente.getNome() + "\n[VISUALIZZAZIONE POST] Si\n[LIKE] Si\n[PUBBLICAZIONE COMMENTI] Si");
	}
}
