import java.util.Scanner;
public class Registrazione {
	private String nomeProfilo;
	private String nomeUtente;
	private String cognomeUtente;
	private int eta;
	private int codiceInserito;
	private int nuovaPassword;
    public int codice;
	Scanner s = new Scanner (System.in);
	
	public Registrazione() {
		
	}
	
	public Registrazione(String nomeProfilo,String nomeUtente,String cognomeUtente) {
		this.nomeProfilo = nomeProfilo;
		this.nomeUtente  = nomeUtente;
		this.cognomeUtente = cognomeUtente;
	}
	
	public String getNome(){
		return nomeProfilo;
	}
	
	public void setNome(String nomeProfilo){
		this.nomeProfilo = nomeProfilo;
	}
	
	public String getNomeUtente(){
		return nomeUtente;
	}
	
	public void setNomeUtente(String nomeUtente){
		this.nomeUtente = nomeUtente;
	}
	
	public 
	
	public void stampa(String nomeUtente,String nomeProfilo,String cognomeUtente) {
		System.out.println(nomeUtente +"\n"+nomeProfilo+"\n"+cognomeUtente+"");
	}
	
	public void codiceDiRegistrazione(int codiceInserito) {
		this.codiceInserito = codiceInserito;
		
		for(int i=0;i<4;i++) {
			codice = (int) (Math.random()*9);
			System.out.println("Il codice è: "+codice);
		}
		
		System.out.print("Inserisci codice: ");
		codiceInserito = s.nextInt();
		
		int possibilitaErrore = 2;
		
		do {
			if(codiceInserito!=codice) {
				possibilitaErrore--;
				System.out.println("Errore hai ancora: "+ possibilitaErrore + " tentativi.");
				System.out.print("Inserisci codice: ");
				codiceInserito = s.nextInt();
			}
			if(possibilitaErrore == 0) {
				System.out.println("Uscita in corso...");
				break;
			}
		}while(codiceInserito==codice);
		
		if(codiceInserito == codice) {
			System.out.print("Crea un nome profilo: ");
			nomeProfilo = s.next();
			System.out.print("Inserisci password: ");
			nuovaPassword = s.nextInt();
		}
	}
}
