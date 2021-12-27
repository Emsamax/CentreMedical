public class AppareilMedical {
    public String nom;
    public boolean enAttente = true;

   public  AppareilMedical (String nom){
       this.nom = nom;
   }
   
    public AppareilMedical(String nom, boolean enAttente){
        this.nom = nom;
        this.enAttente = enAttente;
    }

   public void octroyer(){
       this.enAttente = false;
   }

}
