import java.time.LocalDateTime;
import java.util.Arrays;

public class Post {
	private int id;
	private String testo;
	private LocalDateTime data;
	private Commento[] commenti;
	private int like;
	private int commentiTotali;
	
	/**
	 * 
	 * @param testo Testo del post.
	 */
	public Post(String testo) {
		this.testo = testo;
		this.data = LocalDateTime.now();
		this.commenti = new Commento[100];
		this.commentiTotali = 0;
	}
	
	/**
	 * 
	 * @param id ID del post.
	 * @param testo Testo del post.
	 * @param data Data del post.
	 * @param like Numero di like del post.
	 */
	public Post(int id, String testo, LocalDateTime data, int like) {
		this.id = id;
		this.testo = testo;
		this.data = data;
		this.commenti = new Commento[100];
		this.commentiTotali = 0;
		this.like = like;
	}
	
	/**
	 * 
	 * @return Resituisce la data del post sotto forma di stringa.
	 */
	public String getData() {
		return data.getDayOfMonth() + "/" + data.getMonthValue() + "/" + data.getYear();
	}
	
	/**
	 * 
	 * @return Restituisce l'ID del post.
	 */
	public int getId() {
		return id;
	}
	
	public void stampa() {
		System.out.println("\nPubblicato il " + this.getData() + ":");
		System.out.println(this.testo);
		System.out.println("Ha ricevuto " + this.like + " mi piace.\n");
	}
	
	public void azioni() {
		System.out.println("[1] Metti like\n[2] Scrivi commento\n[3] Mostra commenti\n[4] Chiudi");
		
		switch(Leggi.intero()) {
			case 1: {
				addLike();
				System.out.println("Like aggiunto!");
			}
			case 2: {
				System.out.println("Scrivi il tuo commento: ");
				addCommento();
				System.out.println("Commento pubblicato!");
			}
			case 3: {
				this.stampaCommenti();
			}
		}
	}
	
	public void addLike() {
		this.like++;
	}
	
	public void stampaCommenti() {
		if(commentiTotali > 0) {
			for(Commento c:Arrays.copyOf(commenti, commentiTotali)) {
				c.stampa();
			}
		} 
		else {
			System.out.println("Nessun commento pubblicato.");
		}
	}
	
	public void addCommento() {
		commenti[commentiTotali] = new Commento(Leggi.stringa());
		commentiTotali++;
	}
	
	public void addCommento(Commento commento) {
		commenti[commentiTotali] = commento;
		commentiTotali++;
	}
}
