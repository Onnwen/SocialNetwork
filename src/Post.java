
public class Post {
	private String testo;
	private Commento[] commenti;
	private int commentiTotali;
	
	public Post(String testo) {
		this.testo = testo;
		this.commenti = new Commento[100];
		this.commentiTotali = 0;
	}
	
	public void addCommento(String commento)
	{
		commenti[commentiTotali] = new Commento(Leggi.stringa());
	}
}
