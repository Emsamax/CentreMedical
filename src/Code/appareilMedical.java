package Code;
public class appareilMedical {
    public String nom;
    public boolean enAttente = true;

    public  appareilMedical (){
    }

   public  appareilMedical (String nom){
       this.nom = nom;
    }
   
    public appareilMedical(String nom, boolean enAttente){
        this.nom = nom;
        this.enAttente = enAttente;
    }

   public boolean valider(){
        return this.enAttente = false;
    }

}
