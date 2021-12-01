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
	
	public void stampa(String nomeUtente,String nomeProfilo,String cognomeUtente) {
		System.out.println(nomeUtente +"\n"+nomeProfilo+"\n"+cognomeUtente+"");
	}
	
	public void codiceDiRegistrazione(int codiceInserito) {
		this.codiceInserito = codiceInserito;
		
		for(int i=0;i<4;i++) {
			codice = (int) (Math.random()*9);
			System.out.println("Il codice e: "+codice);
		}
		
		System.out.println("Inserisci codice: ");
		codiceInserito = s.nextInt();
		
		int possibilitaErrore = 2;
		
		do {
			if(codiceInserito!=codice) {
				possibilitaErrore--;
				System.out.println("Errore hai ancora: "+possibilitaErrore);
				System.out.println("Inserisci codice: ");
				codiceInserito = s.nextInt();
			}
			if(possibilitaErrore == 0) {
				System.out.println("Uscita in corso...");
				break;
			}
		}while(codiceInserito==codice);
		
		if(codiceInserito == codice) {
			System.out.println("Crea un nome profilo: ");
			nomeProfilo = s.next();
			System.out.println("Inserisci password: ");
			nuovaPassword = s.nextInt();
		}
	}
}
