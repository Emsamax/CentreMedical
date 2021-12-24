
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.Scanner;
import java.io.Reader;
import java.util.Scanner;

import javax.annotation.processing.Filer;

public class patient {
   
    public String nom;
    public String prenom;
    public String NbSScoial;
    public String dateNaissance; 
    private static int Compteur= 0;
    

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

    public patient(){
    }

    public patient(String nom, String prenom, String NbSScoial, String dateNaissance) {
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
            out.close();
        } 
        //ecriture
        PrintWriter out = new PrintWriter(new FileWriter(f, true));
        out.write(this.toString());
        System.out.println();
        out.close(); 
        
        }
        // try catch dans le main

        public void rechercherPatient(String nomPatient) throws FileNotFoundException, PatientInexistantException{
          //lien avec le fichier Patient.txt et scanner
            FileReader lecteur = new FileReader("ListePatient.txt");
            try (Scanner lectureFichier = new Scanner(lecteur)) {
                while(lectureFichier.hasNextLine()){
                    String str = lectureFichier.nextLine();
                    String[] mots = str.split("/");
                    // vérifie le nom qui est a la 2eme palce du tableau
                    if(mots[1].equalsIgnoreCase(nomPatient)){
                        System.out.println("fichier du patient "+nomPatient+"  trouvé" );
                        System.out.println( getNom() + "/" + getPrenom() + "/" + getNbSScoial() + "/" +  getDateNaissance() +"\n"); 
                        break ;

                    }else throw new PatientInexistantException("===Ce patient n'existe pas===");
                }
                lectureFichier.close();
            }
        }
        //try catch dans le main

        public void supprimerPatient(String nomPatient)throws IOException{
            File Fichier = new File("ListePatient.txt");
            File ModifFichier = new File("ListePatientModifie.txt");
            FileReader FileReader = new FileReader(Fichier);
            BufferedReader lecture = new BufferedReader(FileReader);
            FileWriter fileWriter = new FileWriter(ModifFichier);
            String Ligne = null;
           

            while((Ligne = lecture.readLine()) != null){
                System.out.println(Ligne);
                String[] mots = Ligne.split("/");
                if(mots[1].equalsIgnoreCase(nomPatient)){
                    System.out.println("");
                }else{
                    fileWriter.write(Ligne);
                    fileWriter.write("\n");
                }

                 fileWriter.flush();
            }
            lecture.close();
            fileWriter.close();
            Fichier.delete();
            
           
            if(ModifFichier.renameTo(Fichier)){
                System.out.println("Le fichier a été renommé avec succès");
              }else{
                System.out.println("Impossible de renommer le fichier");
              }
            }

    @Override
   public  String toString() {
        return   Compteur +"/"+ getNom() + "/" + getPrenom() + "/" + getNbSScoial() + "/" +  getDateNaissance() +"\n";
            
    }
    
}
    
