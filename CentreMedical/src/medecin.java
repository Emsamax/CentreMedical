import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class medecin{
   String nompat;
   String nommedecin;
   String dateconsultation;
   String pathologie ;
   String appareil;
   String octroyé;  



// ======================getters and setters=====================
   
    public String getNompat() {
    return nompat;
}
public void setNompat(String nompat) {
    this.nompat = nompat;
}
public String getNommedecin() {
    return nommedecin;
}
public void setNommedecin(String nommedecin) {
    this.nommedecin = nommedecin;
}
public String getDateconsultation() {
    return dateconsultation;
}
public void setDateconsultation(String dateconsultation) {
    this.dateconsultation = dateconsultation;
}
public String getPathologie() {
    return pathologie;
}
public void setPathologie(String pathologie) {
    this.pathologie = pathologie;
}
public String getAppareil() {
    return appareil;
}
public void setAppareil(String appareil) {
    this.appareil = appareil;
}
public String getOctroyé() {
    return octroyé;
}
public void setOctroyé(String octroyé) {
    this.octroyé = octroyé;
}



public medecin(String nompat, String nommedecin, String dateconsultation, String pathologie, String appareil, String octroyé) {
    this.nompat = nompat;
    this.nommedecin = nommedecin;
    this.dateconsultation = dateconsultation;
    this.pathologie = pathologie;
    this.appareil = appareil;
    this.octroyé = octroyé;
    

}


    public  void ecrireconsultation()throws IOException {
        // si pas de fichier existants on en cree un sinom on ecris dedans
        File f = new File("consultation.txt");
        // creation et ecriture
        if(!f.exists()){
            PrintWriter out = new PrintWriter(f); 
            out.println(this.toString());
            out.close();
        } else {
        
        //ecriture
        PrintWriter out = new PrintWriter(new FileWriter(f, true));
        out.write(this.toString());
        System.out.println();
        out.close(); 
        }
            
        
        }
        public void rechercherconsultation(String nommedecin) throws FileNotFoundException, consultationInexistantException{
            //lien avec le fichier Patient.txt et scanner
              FileReader lecteur = new FileReader("consultation.txt");
              try (Scanner lectureFichier = new Scanner(lecteur)) {
                  while(lectureFichier.hasNextLine()){
                      String str = lectureFichier.nextLine();
                      String[] mots = str.split("/");
                      // vérifie le nom qui est a la 2eme palce du tableau
                      if(mots[1].equalsIgnoreCase(nommedecin)){
                          System.out.println("fichier du patient "+nommedecin+"trouvé" );
                          System.out.println(str);
                          break;
                          
                          
                      }else throw new PatientInexistantException("===Ce medecin n'existe pas===");
                      
  
                  }
                  lectureFichier.close();
              }
          }
    public void supprimerconsultation(){
    
    }
    public void creeruneconsultation(){
    
    }
    public void modfifierconsultation(){
    
    }
    
    
}
