import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.Scanner;

public class Patient {
   
    public String nom;
    public String prenom;
    public String NbSScoial;
    public String dateNaissance; 

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

    public Patient(String nom, String prenom, String NbSScoial, String dateNaissance) throws NbSecuriteSocialeException {
        this.nom = nom;
        this.prenom = prenom;
        this.NbSScoial = NbSScoial;
        this.dateNaissance = dateNaissance;

    }
        
    public void ecrirePatient()throws IOException {
        // si pas de fichier existants on en cree un sinom on ecris dedans
        File f = new File("ListePatient.txt");
        // creation et ecriture
        if(!f.exists()){
            PrintWriter out = new PrintWriter(f); 
            out.println(this.toString());
        } 
        //ecriture
        PrintWriter out = new PrintWriter(new FileWriter(f, true));
        out.write(this.toString());
        System.out.println();
        out.close(); 
        
        }


    @Override
   public  String toString() {
        return   getNom() + "/" + getPrenom() + "/" + getNbSScoial() + "/" +  getDateNaissance() +"\n";
            
    }
    
}
