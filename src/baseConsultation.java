public class BaseConsultation {
    public String path;


    public BaseConsultation(String path) {
        this.path = path;
    }

    
    public Consultation rechercher(int ID){
        //TODO:
        return new Consultation();
    }

    public void ajouter(Consultation consultation){
        //TODO:
    }

    public void supprimer(int ID){
        //TODO:
    }

    public Consultation modifier(int ID, Consultation consultation){
        //TODO:
        return consultation;
    }

    public void load(){
     /*
     lis le fichier.txt (path)
     cree les consultations (peupler la base)
     */
    
     //TODO:
    }

    public void save(){
        /**
         * 
         * sauvegarde la base dans le fichier.txt (path)
         */
    
         //TODO:
    }
}
