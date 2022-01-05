package Code;
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

public class basePatient {
    static int nombreDePatient;
    public String path;
    public HashMap<String, Patient> base;
    //la hashmap prend en parametre le nbSS(numero securite sociale) et l'objet patient. 
    //clé de la hashMap = nbSS, car il sera unique pour chaque patient.
    public basePatient(String path) {
        this.path = path;
    }
    
    private HashMap<String, Patient> createBase(){
        // cree nv base vide
        HashMap<String, Patient> base = new HashMap<String, Patient>();
        return base;
    }
        

    public void load() throws FileNotFoundException{
        /* 
        *a besoin d'une nv base vide pour la remplire
        *lis le fichier.txt (path)
        *cree les consultations à partir du fichier.txt (peupler la base)
        *recupere l'objet patient via son numero de securite sociale
        */
        this.base = createBase();
        FileReader lecteur = new FileReader(this.path);
        Scanner lectureFichier = new Scanner(lecteur);
        while(lectureFichier.hasNextLine()){
            String str = lectureFichier.nextLine();
            String[] mots = str.split("/");
            //mots = nom , prenom , nbSS , date naissance
            Patient pat = new Patient(mots[0],mots[1],mots[2],mots[3]);
            this.base.put(pat.nbSS, pat);
            nombreDePatient++;
        }
        
        lectureFichier.close();    
            
    }

    public void save() throws IOException {
        /*
         * parcour la base
         * ecris dans le fichier txt
         * sauvegarde la base dans le fichier.txt (path)
         */
        File Fichier = new File(this.path);
        File ModifFichier = new File(this.path + ".tmp");
        FileWriter fileWriter = new FileWriter(this.path + ".tmp");
        PrintWriter out = new PrintWriter(new FileWriter(ModifFichier, true));
        // boucle sur toutes les clés du hashmap.
        for (String nbSS : this.base.keySet()) {
            Patient pat = this.base.get(nbSS);
            String line = pat.nom + "/" + pat.prenom + "/" + pat.nbSS + "/" + pat.dateNaissance + "\n";
            out.write(line);
            out.close();  
            fileWriter.write(line);
        }
        fileWriter.flush();
        fileWriter.close();
        Fichier.delete();
        // vérification que le fichier à bien été supprimé et rennomé
        if (ModifFichier.renameTo(Fichier)) {
            System.out.println("Le fichier a été renommé avec succès");
        } else {
            System.out.println("Impossible de renommer le fichier");
        }
    }

    public Patient rechercherPatient(String nbSS) throws KeyException {
        // la recherche de patient se fait avec le nbSS, c'est la clé de la hashmap.
        if (this.base.containsKey(nbSS)) {
            return this.base.get(nbSS);
        } else
            throw new KeyException("le patient n'existe pas");

    }

    public void ajouterPatient(Patient patient) {
        if (this.base.containsKey(patient.nbSS)) {
            throw new KeyAlreadyExistsException(" le patient existe déjà");
        } else {
            this.base.put(patient.nbSS, patient);
        }
    }

    public void supprimerPatient(String nbSS) {
        if (!this.base.containsKey(nbSS)) {
            throw new KeyAlreadyExistsException(" le patient n'existe pas");
        } else
            this.base.remove(nbSS);

    }

    public void modifierPatient(String nom, String prenom, String nbss, String dateNaissance) throws KeyException {
        // recherche du patient a modifier avec son ID, ne change pas le nbSS du patient  
        Patient modifPatient = new Patient(nom, prenom, nbss, dateNaissance);
        if (this.base.containsKey(modifPatient.nbSS)) {
            this.base.replace(modifPatient.nbSS, modifPatient);
            System.out.println("le patient a ete modidife avec succes");
        } else
            throw new KeyException("le patient n'existe pas"); 
    }

    public void afficherBasePatient(){
        String MapString = null;
        for(String nbSS: this.base.keySet()){
            MapString = this.base.get(nbSS).toString();
             System.out.println(" les elements de la hashmap sont :"+ MapString.toString());
            }
    }

    public int getNbPAtient(){
        return nombreDePatient;
    }

    public void setnombreDePatient(int nb) {
        nombreDePatient = nb;
    }
}
