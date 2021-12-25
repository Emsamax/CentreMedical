import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;



public class Main {
   
    public static void main(String[] args) throws IOException {

       

        Scanner sc = new Scanner(System.in);
        System.out.println("nom patient");
        String nom = sc.nextLine();
       
        System.out.println("prenom patient");
        String prenom = sc.nextLine();

        System.out.println("numero securite sociale patient 13 chiffres max");

        String  NbSSocial = sc.nextLine();
        verifier(NbSSocial);

        System.out.println("date  de naissance patient");
        String dateNaissance = sc.nextLine();
        
        patient pat = new patient(nom, prenom, NbSSocial, dateNaissance);
        
/*
        System.out.println("nom patient consultation");
        String nompat = sc.nextLine();

        System.out.println("nom medecin");
        String nommedecin = sc.nextLine();

        System.out.println("date consultation");
        String dateconsultation = sc.nextLine();

        System.out.println("pathologie");
        String pathologie = sc.nextLine();


        System.out.println("nom appareil");
        String appareil = sc.nextLine();

        System.out.println("appareil octroyé ?");
        String octroye = sc.nextLine();
        
        medecin consul = new medecin (nompat , nommedecin, dateconsultation,pathologie,  appareil, octroye);
        consul.ecrireconsultation();
 */
       
        try{
            pat.ecrirePatient();
          //  pat.rechercherPatient("toto");
            pat.modifierpatient("dinosaure");
        }catch( PatientInexistantException e){
            System.out.println("ce patient n'existe pas");
        }
        
    }
    public static void verifier(String NbSSocial) throws IOException{

        //  = numero seciurite sociale 
        // verification nombre si c'est des chiffres //si il y en a 13 pile
   
        char Chiffre =' ';
        if(NbSSocial.length()<13 || NbSSocial.length()>13){
            throw new NbSecuriteSocialeException("pas le bon nombre de caracteres saisis ");
        }
        // initialisation du tableau de l'alphabet
        char Alphabet[] = new char [26];
        for(int i=0; i<NbSSocial.length();i++){
           Chiffre = NbSSocial.charAt(i);
            // utilisation ascii
           for(int j =97;j<122;j++){
               if(Chiffre ==(Alphabet[i])){
                   throw new IOException(" erreur de  saisi");
                   
           }
   
        }
        
        }
       }
   
}


