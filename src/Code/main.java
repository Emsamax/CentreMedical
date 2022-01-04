package Code;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyException;
import java.util.Scanner;



public class main {
     public static void main(String[] args) {

        try{
        basePatient basePat = new basePatient("ListePatient.txt");
        baseConsultation baseCons = new baseConsultation("consultation.txt");
        Medecin medoc = new Medecin("Dr.Matriño");
        basePat.load();
        baseCons.load(basePat);

        Scanner sc = new Scanner(System.in);
        System.out.println("nom patient");
        String nom = sc.nextLine();
       
        System.out.println("prenom patient");
        String prenom = sc.nextLine();

        System.out.println("numero securite sociale patient 13 chiffres max");

        String  nbSS = sc.nextLine();

        System.out.println("date  de naissance patient");
        String dateNaissance = sc.nextLine();

        Patient pat = new Patient(nom, prenom, nbSS, dateNaissance);
        basePat.ajouterPatient(pat);
        basePat.save();
        //Consultation cons = new Consultation(14,"28:12;20211", pat, "douleur cuisse", appMedic);
        //baseCons.ajouterConsultation(cons);
        //baseCons.afficherBaseConsultation(baseCons);
        //basePat.afficherBasePatient();
        //AppareilMedical appMedic = new AppareilMedical("atelle");
        
        Consultation cons  = new Consultation("29:12:2021", pat, "test", medoc.createAppareilMedical("cerveau"));
        medoc.ajoutConsultation(baseCons, cons);
        baseCons.save();

        //Patient patR = basePat.rechercherPatient("2222222222222");
        //System.out.println(patR.toString());
        
        //basePat.modifierPatient("2222222222222");
        //basePat.save();
       
        
    System.out.println(pat.toString());
         }catch(KeyException e){
             System.out.println(e.toString());
        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }catch(IOException e){
            System.out.println((e.toString()));
        }
    }
    
}
