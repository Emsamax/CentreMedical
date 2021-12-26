public class AppareilMedical {
    public String nom;
    public boolean enAttente = true;

   public  AppareilMedical (String nom){
       this.nom = nom;

       
   }
   public void octroyer(){
       this.enAttente = false;
   }

}
