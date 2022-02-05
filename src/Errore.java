public class Errore extends Exception {
     String errore = "";
    
    public Errore(){
    
    }
    
    public void setErrore(){
         errore = "";
    }
    
    public String getErrore(){
        return errore;
    }
}
