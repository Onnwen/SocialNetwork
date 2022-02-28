import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Onnwen Cassitto, Filippo Gardini, Andrea Gargiulo, Rohit Thind
 * @version 1.3
 */

/**
 * Classe SocialNetwork. È la classe madre che permette di gestire tutto il Social Network.
 */
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

	/**
	 * Restituisce tutti gli account creati nel Social Network.
	 *
	 * @return Un array, della dimensione esatta, contenenti tutti gli utenti attualmenti iscritti (caricati).
	 */
	public Utente[] getUtenti() {
		return Arrays.copyOf(utenti, utentiTotali);
	}

	/**
	 * Restituisce l'utente connesso.
	 *
	 * @return L'utente connesso.
	 */
	public Utente getUtenteConnesso() {
		return utenteConnesso;
	}


	/**
	 * Permette d'aggiungere un utente.
	 *
	 * @param utente L'utente da aggiungere.
	 */
	public void addUtente(Utente utente) {
		utenti[utentiTotali] = utente;
		utentiTotali++;
	}

	/**
	 * Permette d'aggiungere un post a un utente.
	 *
	 * @param post Post da aggiungere.
	 * @param idUtente ID dell'utente a cui aggiungere il post.
	 */
	public void addPost(Post post, int idUtente) {
		cercaUtente(idUtente).addPost(post);
	}

	/*
	public void addAmico(Utente utente, Utente utente2) {
		utente.addAmico(utente2);
	//	set true se è amico
	}

	public void addAmico(Utente utente, Utente utente2) {
		utente2.setAmicizia();
	}
	*/

	/**
	 * Permette d'aggiungere un commento a un utente, l'autore di quest'ultimo.
	 *
	 * @param commento Commento da aggiungere.
	 * @param idUtente ID dell'utente che ha scritto il commento.
	 * @param idPost ID del post da cui a ggiungere il commento.
	 */
	public void addCommento(Commento commento, int idUtente, int idPost, int idCommento, boolean aggiungiAPost) {
		if (aggiungiAPost) {
			getPost(idPost).addCommento(commento);
		}
		else {
			getPost(idPost).getCommento(idCommento).addCommento(commento);
		}
	}

	/**
	 * Permette di ricercare un post dato un ID.
	 *
	 * @param idPost ID del post da cercare.
	 * @return Post corrispondente all'ID dato come parametro.
	 */
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

	/**
	 * Permette di ricercare un utente dato un ID.
	 *
	 * @param idUtente ID dell'utente da cercare.
	 * @return Utente corrispondente all'ID dato come parametro.
	 */
	public Utente cercaUtente(int idUtente) {
		for(int i=0; i<utentiTotali; i++) {
			if(utenti[i].getId() == idUtente) {
				return utenti[i];
			}
		}
		return null;
	}


	//metodo askAmicizia, ricerca utente e scrittura su file

	public Utente askAmicizia(int idUtente) {
		//ricerca dell'utente
		for(int i=0; i<utentiTotali; i++) {
			if(utenti[i].getId() == idUtente) {
				return utenti[i];
				//scrittura su file per richiedere l'amicizia
				File file = new File("richieste.txt");
				file.createNewFile();
				FileWriter myWriter = new FileWriter(file);
				myWriter.write(utenteConnesso.getId());
				myWriter.close();

			}
		}
		return null;
	}


	/**
	 * Permette di ricercare un utente dato il nome.
	 *
	 * @param nome Nome dell'utente da cercare
	 * @return Restituisce l'utente corrispondente a quel nome, se esiste, altrimenti null.
	 */
	public Utente cercaUtente(String nome) {
		for(int i=0; i<utentiTotali; i++) {
			if(utenti[i].getNome().equals(nome)) {
				return utenti[i];
			}
		}
		return null;
	}

	/**
	 * Permette di ricercare un utente dati email e password.
	 *
	 * @param email Indirizzo email utilizzato dall'utente.
	 * @param password Password utilizzato dall'utente.
	 * @return Restituisce l'utente corrispondente a quelle credenziali, se esiste, altrimenti null.
	 */
	public Utente cercaUtente(String email, String password) {
		for(int i=0; i<utentiTotali; i++) {
			if(utenti[i].credenziali.corrette(email, password)) {
				return utenti[i];
			}
		}
		return null;
	}

	/**
	 * Permette di registrare un nuovo utente nel Social Network.
	 *
	 * @return Restituisce true se l'utente si è registrato correttamente, altrimenti false.
	 */
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

	/**
	 * Carica gli utenti presenti nel file all'interno dell'array degli utenti.
	 */
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

	/**
	 * Carica i post presenti nel file all'interno dell'array dei post.
	 */
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

	/**
	 * Carica i commenti presenti nel file all'interno dell'array dei commenti.
	 */
	public void caricaCommenti() {
		try {
			File postFile = new File("comments.csv");
			Scanner fileReader = new Scanner(postFile);
			while(fileReader.hasNext()) {
				String[] datiUtente = fileReader.nextLine().split(";");
				if(datiUtente.length == 6) {
					int idUtente = Integer.parseInt(datiUtente[0]);
					int idPost = Integer.parseInt(datiUtente[1]);
					int idCommento = Integer.parseInt(datiUtente[2]);
					boolean aggiungiAPost = Boolean.parseBoolean(datiUtente[3]);
					addCommento(new Commento(idCommento, cercaUtente(idUtente), datiUtente[4], LocalDateTime.parse(datiUtente[5])), idUtente, idPost, idCommento, aggiungiAPost);
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

	/**
	 * Carica tutti i dati presenti nei file all'interno dell'oggetto.
	 */
	public void carica() {
		caricaUtenti();
		caricaPost();
		caricaCommenti();
	}

	/**
	 * Stampa tutti gli utenti.
	 */
	public void stampaUtente() {
		for(int i=0; i<utentiTotali; i++) {
			System.out.println(utenti[i].getNome());
		}
	}

	/**
	 * Stampa un menu per l'accesso al Social Network, gestisce autonomamente il login o la registrazione.
	 *
	 * @return Restituisce l'esito dell'accesso.
	 */
	public boolean entra() {
		System.out.println("Benvenuto.\n[1] Login\n[2] Registrati");

		if(Leggi.intero() == 1) {
			return login();
		}
		else {
			return registra();
		}
	}

	/**
	 * Effettua il login. L'utente ha tre tentativi per inserire le proprie credenziali.
	 *
	 * @return Restituisce l'esito del login.
	 */
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

	/**
	 * Verifica se un utente, dati email e password, esiste.
	 *
	 * @param email Email dell'utente da controllare.
	 * @param password Password dell'utente da controllare.
	 * @return Restituisce true se l'utente con le credenziali fornite esiste, altrimenti false.
	 */
	private boolean utenteEsiste(String email, String password) {
		for(Utente utente:Arrays.copyOf(utenti, utentiTotali)) {
			if(utente.credenziali.corrette(email, password)) {
				return true;
			}
		}
		return false;
	}
}
