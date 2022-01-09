import java.util.Scanner;
public class Registrati {
	private String nomeUtente;
	private String nomeProfilo;
	private String passwordProfilo;
	private int codice;
	private int eta;
	private int codiceInserito;
	
	Scanner scan = new Scanner(System.in);
	
	public Registrati(int eta) {
		this.nomeUtente = "";
		this.nomeProfilo = "";
		this.passwordProfilo = "";
		this.eta = eta;
	}
	
	public String getNome() {
		return nomeUtente;
	}
	
	public String getNomeProfilo() {
		return nomeProfilo;
	}
	
	public void setNome(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}
	
	public void setProfilo(String nomeProfilo) {
		this.nomeProfilo = nomeProfilo;
	}
	
	public void setPasswordProfilo(String passwordProfilo) {
		this.passwordProfilo = passwordProfilo;
	}
	
	public String getPasswordProfilo() {
		return passwordProfilo;
	}
	
	public int getEta() {
		return eta;
	}
	
	public void setEta(int eta) {
		this.eta = eta;
	}
	
	public int creaCodice() {
		int errore = 3;
		for(int i=0;i<4;i++) {
			codice = (int) (Math.random()*9);
		}
		System.out.println("Codice: "+codice);
		System.out.println("Inserisci codice: ");
		codiceInserito = scan.nextInt();
		do {
			if(codiceInserito!=codice) {
				errore--;
				System.out.println("Hai ancora: "+errore);
				if(errore==0) {
					System.out.println("Hai terminato i tentativi: ");
					break;
				}
			}
		}while(codiceInserito==codice);
		
		return codiceInserito=codice;
	}
	
	
	public boolean controlloEta(int eta) {
		this.eta = eta;
		if(eta<10) {
			return false;
		}
		return true;
	}
	
	public void stampaAccount() {
		System.out.println(nomeUtente+"\n"+nomeProfilo);
	}
}
