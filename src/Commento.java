import java.time.LocalDateTime;

public class Commento {
	private String testo;
	private LocalDateTime data;
	
	public Commento(String testo) {
		this.testo = testo;
		this.data = LocalDateTime.now();
	}
	
	public void modifica(String testo) {
		this.testo = testo;
	}
}
