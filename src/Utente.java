import java.time.LocalDate;
import java.util.Arrays;

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
	 * 
	 * @param id ID dell'utente.
	 * @param nome Nome dell'utente.
	 * @param cognome Cognome dell'utente.
	 * @param email Email dell'utente.
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
	 * 
	 * @return Restituisce tutti i post dell'utente. Array della dimensione corrispondente al numero di post.
	 */
	public Post[] getPost() {
		return Arrays.copyOf(post, postTotali);
	}
	
	/**
	 * 
	 * @param post Post da aggiungere all'utente.
	 */
	public void addPost(Post post) {
		this.post[postTotali] = post;
		postTotali++;
	}
	
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
	
	public boolean amico(Utente utente) {
		for(Permesso permesso:getPermessi()) {
			if(permesso.getPerUtente() == utente) {
				return true;
			}
		}
		return false;
	}
	
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
	
	public Post getPost(int idPost) {
		for(int i=0; i<postTotali; i++) {
			if (post[i].getId() == idPost)  {
				return post[i];
			}
		}
		return null;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {	
		return nome;	
	}
	
	public String getCognome() {	
		return cognome;	
	}
	
	public LocalDate getDataDiNascita() {	
		return dataDiNascita;	
	}
	
	public void setDataDiNascita(String stringaData) {
		this.dataDiNascita = LocalDate.parse(stringaData);
	}
	
	public Permesso[] getPermessi() {
		return Arrays.copyOf(permessi, permessiTotali);
	}
}
