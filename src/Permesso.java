
public class Permesso {
	private Utente perUtente;
	private boolean post;
	private boolean like;
	private boolean commenti;
	
	public Permesso(Utente account) {
		this.perUtente = account;
	}
	
	public void setPermessoPost() {
		this.post = true;
	}
	
	public void setPermessoLike() {
		this.like = true;
	}
	
	public void setPermessoCommenti() {
		this.commenti = true;
	}
	
	public void removePermessoPost() {
		this.post = false;
	}
	
	public void removePermessoLike() {
		this.like = false;
	}
	
	public void removePermessoCommenti() {
		this.commenti = false;
	}
	
	public boolean post() {
		return post;
	}
	
	public boolean like() {
		return like;
	}
	
	public boolean commenti() {
		return commenti;
	}
	
	// DA COMPLETARE!!!!			come vuoi fare?? non ho capito
	public void stampaPermessi() {
		System.out.println("Permessi concessi a " + perUtente.getNome() + "\n[VISUALIZZAZIONE POST] Si\n[LIKE] Si\n[PUBBLICAZIONE COMMENTI] Si");
	}
}
