package Code;
public class appareilMedical {
    public String nom;
    public boolean enAttente = true;

   public  appareilMedical (String nom){
       this.nom = nom;
   }
   
    public appareilMedical(String nom, boolean enAttente){
        this.nom = nom;
        this.enAttente = enAttente;
    }

   public void valider(){
       this.enAttente = false ;
   }

}
