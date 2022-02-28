import java.io.FileWriter;
import java.io.IOException;
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
	 * Costruttore per nuovo Post.
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
	 * Costruttore per Post caricato da file.
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
	 * Salva il post su file
	 *
	 * @param idUtente ID dell'utente che ha pubblicato il post.
	 */
	public void salvaPost(int idUtente) {
		try {
			FileWriter fileWriter = new FileWriter("post.csv", true);
			fileWriter.write(idUtente + ";" + id + ";" + testo + ";" + like + ";" + data.toString() + "\n");
			fileWriter.close();
		} catch (IOException e) {}
	}

	public Commento getCommento(int idCommento) {
		for(int i=0; i<commentiTotali; i++) {
			if (commenti[i].getId() == id) {
				return commenti[i];
			}
		}
		return null;
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

	/**
	 * Stampa il contenuto del post, con data e numero di like.
	 */
	public void stampa() {
		System.out.println("\nPubblicato il " + this.getData() + ":");
		System.out.println(this.testo);
		System.out.println("Ha ricevuto " + this.like + " mi piace.\n");
	}

	/**
	 * Stampa le azioni disponibili per il post.
	 */
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

	/**
	 * Aggiunge 1 like.
	 */
	public void addLike() {
		this.like++;
	}

	/**
	 * Stampa i commenti del post.
	 */
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

	/**
	 * Aggiungere un commento da tastiera.
	 */
	public void addCommento() {
		commenti[commentiTotali] = new Commento(Leggi.stringa());
		commentiTotali++;
	}

	/**
	 * Aggiungere un commento esistente.
	 *
	 * @param commento Oggetto commento preesistente.
	 */
	public void addCommento(Commento commento) {
		commenti[commentiTotali] = commento;
		commentiTotali++;
	}
}
