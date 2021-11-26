import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SocialNetwork {
	private Utente[] utenti;
	private int utentiTotali;
	
	public SocialNetwork() {
		this.utenti = new Utente[100];
		this.utentiTotali = 0;
		this.carica();
		this.stampaUtente();
	}
	
	public void addUtente(Utente utente) {
		utenti[utentiTotali] = utente;
		utentiTotali++;
	}
	
	public Utente cercaUtente(int idUtente) {
		for(int i=0; i<utentiTotali; i++) {
			if(utenti[i].getId() == idUtente) {
				return utenti[i];
			}
		}
		return null;
	}

	public boolean carica() {
		// Caricamento accounts
		System.out.println("Carico database...");
		System.out.println("Leggo dati degli utenti...");
		try {
			File usersFile = new File("users.csv");
			Scanner fileReader = new Scanner(usersFile);
			while(fileReader.hasNext()) {
				String[] datiUtente = fileReader.nextLine().split(";");
				if(datiUtente.length == 4) {
					int idUtente = Integer.parseInt(datiUtente[0]);
					Utente nuovoUtente = new Utente(idUtente, datiUtente[1], datiUtente[2]);
					nuovoUtente.setDataDiNascita(datiUtente[3]);
					addUtente(nuovoUtente);
				}
				else {
					System.out.println("Un utente non è stato leggo correttamente.");
				}
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Non è stato trovato il file \"users.csv\". Caricamento abortato.");
			try {
				File usersFile = new File("users.csv");
				usersFile.createNewFile();
			} catch (IOException e1) {
				System.out.println("E' stato riscontrato un errore con la scrittura del file \"users.csv\". Avvio abortato.");
			}
			return false;
		}
		
		System.out.println("Leggo dati dei post...");
		try {
			File postFile = new File("post.csv");
			Scanner fileReader = new Scanner(postFile);
			while(fileReader.hasNext()) {
				String[] datiUtente = fileReader.nextLine().split(";");
				if(datiUtente.length == 3) {
					int idPost = Integer.parseInt(datiUtente[0]);
					Utente nuovoUtente = new Post(idPost, datiUtente[1], datiUtente[2]);
					nuovoUtente.setDataDiNascita(datiUtente[3]);
					addUtente(nuovoUtente);
				}
				else {
					System.out.println("Un utente non è stato leggo correttamente.");
				}
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Non è stato trovato il file \"users.csv\". Caricamento abortato.");
			try {
				File usersFile = new File("users.csv");
				usersFile.createNewFile();
			} catch (IOException e1) {
				System.out.println("E' stato riscontrato un errore con la scrittura del file \"users.csv\". Avvio abortato.");
			}
			return false;
		}
		
		System.out.println("Caricamento completato con successo.");
		
		return true;
	}
	
	public void stampaUtente() {
		for(int i=0; i<utentiTotali; i++) {
			System.out.println(utenti[i].getNome());
		}
	}
}
