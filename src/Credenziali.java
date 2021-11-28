
public class Credenziali {
	private String email;
	private String password;
	
	public Credenziali() {
		this.email = "";
		this.password = "";
	}
	
	public Credenziali(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public boolean corrette(String email, String password) {
		return email.equals(this.email) && password.equals(this.password);
	}
}
