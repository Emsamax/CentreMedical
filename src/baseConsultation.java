import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyException;
import java.util.HashMap;
import java.util.Scanner;

import javax.management.openmbean.KeyAlreadyExistsException;

public class baseConsultation {
    public String path;
    public HashMap <Integer, Consultation> base;

    public baseConsultation(String path) {
        this.path = path;
        this.base = createBase();
    }

    private HashMap<Integer, Consultation> createBase(){
        // cree nv base vide
        HashMap<Integer, Consultation> base = new HashMap<Integer, Consultation>();
        return base;
    }
    
    public Consultation rechercherConsultation(int ID) throws KeyException{
        if(this.base.containsKey(ID)){
            return this.base.get(ID);
        }else throw new KeyException("la consultation n'existe pas");
       
    }

    public void ajouterConsultation(Consultation consultation){
        if (this.base.containsKey(consultation.ID)) {
            throw new KeyAlreadyExistsException("la consultation existe déjà");
        } else {
            this.base.put(consultation.ID, consultation);
        }
    }

    public void supprimerConsultation(int ID){
            if (!this.base.containsKey(ID)) {
                throw new KeyAlreadyExistsException("la consultation n'existe pas");
            } else
                this.base.remove(ID);
    }

    public void modifierConsultation(Consultation modifConsultation) throws KeyException{
        // appel de la methode avec la consultation modifié.
        if (this.base.containsKey(modifConsultation.ID)) {
            this.base.replace(modifConsultation.ID, modifConsultation);
        } else
            throw new KeyException("la consultation n'existe pas");
    }

    public void load(basePatient base) throws KeyException, IOException{
        /*
        lis le fichier.txt (path)
        cree les consultations (peupler la base)
        *recupere l'objet patient via son numero de securite sociale
        */
        this.base = createBase();
        FileReader lecteur = new FileReader(this.path);
        Scanner lectureFichier = new Scanner(lecteur);
        while(lectureFichier.hasNextLine()){
            String string = lectureFichier.nextLine();
            // mots :ID, date, nbSS , details cliniques, appareilMedical nom, appareilMedical enAttente(boolean).
            String Mots[] = string.split("/");
            Patient pat = base.rechercherPatient(Mots[1]);
            // cast String to integer
            int ID = Integer.parseInt(Mots[0]);
            boolean enAttente = Boolean.parseBoolean(Mots[4]);
            appareilMedical app = new appareilMedical(Mots[3], enAttente);
            Consultation consul = new Consultation(ID, Mots[1], pat, Mots[3], app);
            this.base.put(consul.ID ,consul);
        }
        lectureFichier.close();
        lecteur.close();
    }

    public void save() throws IOException{
        /**
         * sauvegarde la base dans le fichier.txt (path)
         */
        File Fichier = new File(this.path);
        File ModifFichier = new File(this.path + ".tmp");
        FileWriter fileWriter = new FileWriter(this.path + ".tmp");
        PrintWriter out = new PrintWriter(new FileWriter(ModifFichier, true));
        // boucle sur toutes les clés du hashmap.
        for (int ID : this.base.keySet()) {
            Consultation cons = this.base.get(ID); 
            String line = Integer.toString(cons.ID) + "/" + cons.patient.nbSS + "/" + cons.detailsCiniques  + "/" + cons.appareilMedical.nom + "/" + Boolean.toString(cons.appareilMedical.enAttente) + "\n";
            out.write(line);
            out.close();
            fileWriter.write(line);
        }
        fileWriter.flush();
        fileWriter.close();
        
        Fichier.delete();

        if (ModifFichier.renameTo(Fichier)) {
            System.out.println("Le fichier a été renommé avec succès");
        } else {
            System.out.println("Impossible de renommer le fichier");

        }
    }
    public void afficherBaseConsultation(baseConsultation base){
        String MapString = null;
        for(int ID: this.base.keySet()){
            MapString = this.base.get(ID).toString();
             System.out.println(" les elements de la hashmap sont :"+ MapString.toString());
             

        }
        
    }
}
