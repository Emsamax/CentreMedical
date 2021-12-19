import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Patient {
   
    public String nom;
    public String prenom;
    public String NbSScoial;
    public String dateNaissance;
    static int nbClient = 0;

    // getters setters =========
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNbSScoial() {
        return this.NbSScoial;
    }

    public void setNbSScoial(String NbSScoial) {
        this.NbSScoial = NbSScoial;
    }

    public String getDateNaissance() {
        return this.dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
//=======================================

    public Patient(){
    }

    public Patient(String nom, String prenom, String NbSScoial, String dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.NbSScoial = NbSScoial;
        this.dateNaissance = dateNaissance;
    }
       
    
    public void ecrirePatient()throws IOException {
        // si pas de fichier existants on en cree un sinom on ecris dedans
        File f = new File("ListePatient.txt");
        
        if(!f.exists()){
            PrintWriter out = new PrintWriter(f); 
            out.println(this.toString());
        } PrintWriter out = new PrintWriter(new FileWriter(f, true));// probleme ici
        out.close(); 
            
        }


    @Override
   public  String toString() {
        return "{" +
            " nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", NbSScoial='" + getNbSScoial() + "'" +
            ", dateNaissance='" + getDateNaissance() + "'" +
            "}";
    }

}
