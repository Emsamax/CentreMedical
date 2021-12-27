import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyException;
import java.util.HashMap;
import java.util.Scanner;

import javax.management.openmbean.KeyAlreadyExistsException;

public class BasePatient {
    public String path;
    private HashMap<String, Patient> base;

    public BasePatient(String path) {
        this.path = path;
        this.base = createBase();
    }
    
    private HashMap<String, Patient> createBase(){
        // cree nv base vide
        HashMap<String, Patient> base = new HashMap<String, Patient>();
        return base;
    }
        

    public void load() throws FileNotFoundException{
        this.base = createBase();
        FileReader lecteur = new FileReader(this.path);
        Scanner lectureFichier = new Scanner(lecteur);
        while(lectureFichier.hasNextLine()){
            String str = lectureFichier.nextLine();
            String[] mots = str.split("/");
            //mots = nom , prenom , nbSS , date naissance
            Patient pat = new Patient(mots[0],mots[1],mots[2],mots[3]);
            this.base.put(pat.nbSS, pat);
            }
        
        lectureFichier.close();    
            
    }

    public void save() throws IOException {
        File Fichier = new File(this.path);
        File ModifFichier = new File(this.path + ".tmp");
        FileWriter fileWriter = new FileWriter(this.path + ".tmp");
        // boucle sur toutes les clés du hashmap.
        for (String nbSS : this.base.keySet()) {
            Patient pat = this.base.get(nbSS);
            String line = pat.nom + "/" + pat.prenom + "/" + pat.nbSS + "/" + pat.dateNaissance;

            fileWriter.write(line);
            fileWriter.write("\n");

        }
        fileWriter.flush();
        fileWriter.close();

        if (ModifFichier.renameTo(Fichier)) {
            System.out.println("Le fichier a été renommé avec succès");
        } else {
            System.out.println("Impossible de renommer le fichier");

        }
    }

    public Patient rechercherPatient(String nbSS) throws KeyException {
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

    public void modifierPatient(Patient modifPatient) throws KeyException {
        // appel de la methode avec le patient modifié.
        if (this.base.containsKey(modifPatient.nbSS)) {
            this.base.replace(modifPatient.nbSS, modifPatient);
        } else
            throw new KeyException("le patient n'existe pas");

    }
}
