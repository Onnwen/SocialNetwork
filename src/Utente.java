import java.time.LocalDate;
import java.util.Arrays;

/**
 * Classe Utente. È la classe che permette di gestire gli utenti iscritti al Social Network.
 */
public class Utente {
	private int id;
	private	String nome;
	private	String cognome;
	private	LocalDate dataDiNascita;
	private Permesso[] permessi;
	private int permessiTotali;
	private Post[] post;
	private int postTotali;
	public Credenziali credenziali;

	/**
	 * Inizializza un nuovo tente Utente.
	 *
	 * @param id       ID dell'utente.
	 * @param nome     Nome dell'utente.
	 * @param cognome  Cognome dell'utente.
	 * @param email    Email dell'utente.
	 * @param password Password dell'utente.
	 */
	public Utente(int id, String nome, String cognome, String email, String password) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.postTotali = 0;
		this.credenziali = new Credenziali(email, password);
		this.permessi = new Permesso[20];
		this.permessiTotali = 0;
		this.post = new Post[100];
		this.postTotali = 0;
	}

	/**
	 * Restituisce tutti i post dell'utente.
	 *
	 * @return Un array della dimensione corrispondente al numero totale di post.
	 */
	public Post[] getPost() {
		return Arrays.copyOf(post, postTotali);
	}

	/**
	 * Aggiunge un post.
	 *
	 * @param post Post da aggiungere all'utente.
	 */
	public void addPost(Post post) {
		this.post[postTotali] = post;
		postTotali++;
	}

	/**
	 * Stampa le azioni da svolgere sull'utente.
	 *
	 * @param utenteConnesso l'utente attualmente connesso.
	 */
	public void azioni(Utente utenteConnesso) {
		if(amico(utenteConnesso)) {
			System.out.println("[1] Mostra post");
			switch(Leggi.intero()) {
				case 1: {
					this.stampaPost();
				}
			}
		}
		else {
			System.out.println("[1] Richiedi amicizia");
			switch(Leggi.intero()) {
				case 1: {
					System.out.println(this.getNome() + " riceverà la tua richiesta d'amicizia!");
				}
			}
		}
	}

	/**
	 * Verifica se un determinato utente è stato aggiunto come amico.
	 *
	 * @param utente l'utente da verificare.
	 * @return True se è amico, altrimenti false.
	 */
	public boolean amico(Utente utente) {
		for(Permesso permesso:getPermessi()) {
			if(permesso.getPerUtente() == utente) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Stampa tutti i post.
	 */
	public void stampaPost() {
		if(postTotali > 0) {
			for(Post p:Arrays.copyOf(post, postTotali)) {
				p.stampa();
				p.azioni();
			}
		} 
		else {
			System.out.println("Nessun post pubblicato.");
		}
	}

	/**
	 * Restituisce un post dato un determinato ID.
	 *
	 * @param idPost ID del post.
	 * @return Il post se esiste, altrimenti NULL.
	 */
	public Post getPost(int idPost) {
		for(int i=0; i<postTotali; i++) {
			if (post[i].getId() == idPost)  {
				return post[i];
			}
		}
		return null;
	}

	/**
	 * Restituisce id.
	 *
	 * @return Un ID, intero.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Restituisce il nome.
	 *
	 * @return Una stringa contenente il nome.
	 */
	public String getNome() {
		return nome;	
	}

	/**
	 * Restituisce il cognome.
	 *
	 * @return Una stringa contenente il cognome.
	 */
	public String getCognome() {
		return cognome;	
	}

	/**
	 * Ritorna la data di nascita dell'utente.
	 *
	 * @return Una data.
	 */
	public LocalDate getDataDiNascita() {
		return dataDiNascita;	
	}

	/**
	 * Imposta la data di nascita dell'utente.
	 *
	 * @param stringaData Data di nascita sotto forma di stringa.
	 */
	public void setDataDiNascita(String stringaData) {
		this.dataDiNascita = LocalDate.parse(stringaData);
	}

	/**
	 * Ritorna i permessi.
	 *
	 * @return Un array di permessi.
	 */
	public Permesso[] getPermessi() {
		return Arrays.copyOf(permessi, permessiTotali);
	}
}
