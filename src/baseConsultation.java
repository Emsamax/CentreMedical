import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.KeyException;
import java.util.HashMap;
import java.util.Scanner;

public class BaseConsultation {
    public String path;
    private HashMap <Integer, Consultation> base;

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

    public void load(BasePatient base) throws FileNotFoundException, KeyException{
     /*
     lis le fichier.txt (path)
     cree les consultations (peupler la base)
     *recupere l'objet patient via son numero de securite sociale
     */
     FileReader lecteur = new FileReader(this.path);
     Scanner lectureFichier = new Scanner(lecteur);
     while(lectureFichier.hasNextLine()){
        String string = lectureFichier.nextLine();
        // mots :ID, date, nbSS , details cliniques, appareilMedical nom, appareilMedical enAttente(boolean).
        String Mots[] = string.split("/");
        Patient pat =  base.rechercherPatient(Mots[2]);
        // cast String to integer
        int ID = Integer.parseInt(Mots[0]);
        boolean enAttente = Boolean.parseBoolean(Mots[5]);
        AppareilMedical app = new AppareilMedical(Mots[4], enAttente);
        Consultation consul = new Consultation(ID, Mots[1], pat, Mots[3], app);
        this.base.put(consul.ID ,consul);
     }
     lectureFichier.close();
    }

    public void save(){
        /**
         * 
         * sauvegarde la base dans le fichier.txt (path)
         */
    
    }
}
