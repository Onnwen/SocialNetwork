import java.time.LocalDateTime;

public class Commento {
	private int id;
	private Utente utente;
	private String testo;
	private LocalDateTime data;
	
	public Commento(String testo) {
		this.id = Id.genera();
		this.testo = testo;
		this.data = LocalDateTime.now();
	}
	
	public Commento(int id, Utente utente, String testo, LocalDateTime data) {
		this.id = id;
		this.utente = utente;
		this.testo = testo;
		this.data = data;
	}
	
	public int getId() {
		return id;
	}
	
	public void modifica(String testo) {
		this.testo = testo;
	}
	
	public String getData() {
		return data.getDayOfMonth() + "/" + data.getMonthValue() + "/" + data.getYear();
	}
	
	public void stampa() {
		System.out.println("\nPubblicato il " + this.getData() + " da " + this.utente.getNome() + " " + this.utente.getCognome() + ":");
		System.out.println(this.testo);
		System.out.println("\n");
	}
}
