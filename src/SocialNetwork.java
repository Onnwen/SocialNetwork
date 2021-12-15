import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class SocialNetwork {
	private Utente[] utenti;
	private int utentiTotali;
	private Utente utenteConnesso;
	
	public SocialNetwork() {
		this.utenti = new Utente[100];
		this.utentiTotali = 0;
		this.utenteConnesso = null;
		this.caricaUtenti();
	}
	
	public Utente[] getUtenti() {
		return Arrays.copyOf(utenti, utentiTotali);
	}
	
	public Utente getUtenteConnesso() {
		return utenteConnesso;
	}
	
	public void addUtente(Utente utente) {
		utenti[utentiTotali] = utente;
		utentiTotali++;
	}
	
	public void addPost(Post post, int idUtente) {
		cercaUtente(idUtente).addPost(post);
	}
	
	public void addCommento(Commento commento, int idUtente, int idPost) {
		getPost(idPost).addCommento(commento);
	}
	
	public Post getPost(int idPost) {
		for(Utente utente:getUtenti()) {
			for(Post postUtente:utente.getPost()) {
				if(postUtente.getId() == idPost) {
					return postUtente;
				}
			}
		}
		return null;
	}
	
	public Utente cercaUtente(int idUtente) {
		for(int i=0; i<utentiTotali; i++) {
			if(utenti[i].getId() == idUtente) {
				return utenti[i];
			}
		}
		return null;
	}
	
	public Utente cercaUtente(String nome) {
		for(int i=0; i<utentiTotali; i++) {
			if(utenti[i].getNome().equals(nome)) {
				return utenti[i];
			}
		}
		return null;
	}
	
	public Utente cercaUtente(String email, String password) {
		for(int i=0; i<utentiTotali; i++) {
			if(utenti[i].credenziali.corrette(email, password)) {
				return utenti[i];
			}
		}
		return null;
	}
	
	public boolean registra(){
		System.out.print("Inserisci il nome: ");
		String nomeUtente = Leggi.stringa();
		System.out.print("Inserisci cognome: ");
		String cognomeUtente = Leggi.stringa();
		System.out.print("Inserisci eta: ");
		int eta = Leggi.intero();
		if(eta<10) {
			System.out.println("Non puoi accedere al social.");
			return false;
		}
		
		//registra.codiceDiRegistrazione(0);
		
		System.out.print("Inserisci email: ");
		String email = Leggi.stringa();
		System.out.print("Inserisci password: ");
		String password = Leggi.stringa();
		
		utenteConnesso = new Utente(Id.genera(), nomeUtente, cognomeUtente, email, password);
		addUtente(utenteConnesso);
		return true;
	}
	
	public void caricaUtenti() {
		try {
			File usersFile = new File("users.csv");
			Scanner fileReader = new Scanner(usersFile);
			while(fileReader.hasNext()) {
				String[] datiUtente = fileReader.nextLine().split(";");
				if(datiUtente.length == 6) {
					int idUtente = Integer.parseInt(datiUtente[0]);
					Utente nuovoUtente = new Utente(idUtente, datiUtente[1], datiUtente[2], datiUtente[4], datiUtente[5]);
					nuovoUtente.setDataDiNascita(datiUtente[3]);
					addUtente(nuovoUtente);
				}
				else {
					System.out.println("Un utente non è stato letto correttamente.");
				}
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Non è stato trovato il file \"users.csv\". Caricamento abortito.");
			try {
				File usersFile = new File("users.csv");
				usersFile.createNewFile();
			} catch (IOException e1) {
				System.out.println("E' stato riscontrato un errore con la scrittura del file \"users.csv\". Avvio abortito.");
			}
		}
	}
	
	public void caricaPost() {
		try {
			File postFile = new File("post.csv");
			Scanner fileReader = new Scanner(postFile);
			while(fileReader.hasNext()) {
				String[] datiPost = fileReader.nextLine().split(";");
				if(datiPost.length == 5) {
					int idUtente = Integer.parseInt(datiPost[0]);
					int idPost = Integer.parseInt(datiPost[1]);
					int like = Integer.parseInt(datiPost[3]);
					addPost(new Post(idPost, datiPost[2], LocalDateTime.parse(datiPost[4]), like), idUtente);
				}
				else {
					System.out.println("Un post non è stato letto correttamente.");
				}
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Non è stato trovato il file \"post.csv\". Caricamento abortito.");
			try {
				File usersFile = new File("post.csv");
				usersFile.createNewFile();
			} catch (IOException e1) {
				System.out.println("E' stato riscontrato un errore con la scrittura del file \"post.csv\". Avvio abortito.");
			}
		}
	}
	
	public void caricaCommenti() {
		try {
			File postFile = new File("comments.csv");
			Scanner fileReader = new Scanner(postFile);
			while(fileReader.hasNext()) {
				String[] datiUtente = fileReader.nextLine().split(";");
				if(datiUtente.length == 5) {
					int idUtente = Integer.parseInt(datiUtente[0]);
					int idPost = Integer.parseInt(datiUtente[1]);
					int idCommento = Integer.parseInt(datiUtente[2]);
					addCommento(new Commento(idCommento, cercaUtente(idUtente), datiUtente[3], LocalDateTime.parse(datiUtente[4])), idUtente, idPost);
				}
				else {
					System.out.println("Un commento non è stato letto correttamente.");
				}
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			
			System.out.println("Non è stato trovato il file \"comments.csv\". Caricamento abortito.");
			try {
				File usersFile = new File("comments.csv");
				usersFile.createNewFile();
			} catch (IOException e1) {
				System.out.println("E' stato riscontrato un errore con la scrittura del file \"comments.csv\". Avvio abortito.");
			}
		}
	}
	
	public void carica() {
		caricaUtenti();
		caricaPost();
		caricaCommenti();
	}
	
	public void stampaUtente() {
		for(int i=0; i<utentiTotali; i++) {
			System.out.println(utenti[i].getNome());
		}
	}
	
	public boolean entra() {
		System.out.println("Benvenuto.\n[1] Login\n[2] Registrati");
		
		if(Leggi.intero() == 1) {
			return login();
		}
		else {
			return registra();
		}
	}
	
	public boolean login() {
		int tentativi = 3;
		
		do {
			System.out.print("Inserisci email: ");
			String emailInserita = Leggi.stringa();
			System.out.print("Inserisci password: ");
			String passwordInserita = Leggi.stringa();
			
			if(utenteEsiste(emailInserita, passwordInserita)) {
				this.utenteConnesso = this.cercaUtente(emailInserita, passwordInserita);
				System.out.println("Login effettuato correttamente.");
				return true;
			}
			else {
				tentativi--;
				System.out.println("Nome o password errati. Tentativi rimasti: " + tentativi);
			}
			
		} while(tentativi > 0);
		
		return false;
	}
	
	private boolean utenteEsiste(String email, String password) {
		for(Utente utente:Arrays.copyOf(utenti, utentiTotali)) {
			if(utente.credenziali.corrette(email, password)) {
				return true;
			}
		}
		return false;
	}
}
