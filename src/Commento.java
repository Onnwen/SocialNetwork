import java.time.LocalDateTime;

public class Commento {
	private int id;
	private Utente utente;
	private String testo;
	private LocalDateTime data;
	
	/**
	 * 
	 * @param testo Testo del commento.
	 */
	public Commento(String testo) {
		this.id = Id.genera();
		this.testo = testo;
		this.data = LocalDateTime.now();
	}
	
	/**
	 * 
	 * @param id ID del commento.
	 * @param utente Utente che ha pubblicato il commento.
	 * @param testo Testo del commento.
	 * @param data Data del commento.
	 */
	public Commento(int id, Utente utente, String testo, LocalDateTime data) {
		this.id = id;
		this.utente = utente;
		this.testo = testo;
		this.data = data;
	}
	
	/**
	 * 
	 * @return Restituisce l'ID del commento.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @param testo Nuovo testo del commento.
	 */
	public void modifica(String testo) {
		this.testo = testo;
	}
	
	/**
	 * 
	 * @return Restituisce la data del commento sotto forma di stringa.
	 */
	public String getData() {
		return data.getDayOfMonth() + "/" + data.getMonthValue() + "/" + data.getYear();
	}
	
	public void stampa() {
		System.out.println("\nPubblicato il " + this.getData() + " da " + this.utente.getNome() + " " + this.utente.getCognome() + ":");
		System.out.println(this.testo);
		System.out.println("\n");
	}
}
