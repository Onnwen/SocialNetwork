import java.time.LocalDate;

public class Utente {
	private int id;
	private	String nome;
	private	String cognome;
	private	LocalDate dataDiNascita;
	private Permesso[] permessi;
	
	public Utente(int id, String nome, String cognome) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
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
}
