public class Credenziali {
	private String email;
	private String password;

	/**
	 * Costruttore.
	 */
	public Credenziali() {
		this.email = "";
		this.password = "";
	}

	/**
	 * 
	 * @param email Email utilizzata.
	 * @param password Password utilizzata.
	 */
	public Credenziali(String email, String password) {
		this.email = email;
		this.password = password;
	}

	/**
	 * 
	 * @return Restituisce la password utilizzata.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password Password da settare.
	 */
	public void setCredenziali(String password){
		this.password = password;
	}

	/**
	 * 
	 * @param email Email da verificare.
	 * @param password Password da verificare.
	 * @return Restituisce true se le credenziali sono corrette, altrimenti false.
	 */
	public boolean corrette(String email, String password){
		return email.equals(this.email) && password.equals(this.password);
	}
}