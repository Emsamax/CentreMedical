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
        verif(NbSSocial);


        System.out.println("date  de naissance patient");
        String dateNaissance = sc.nextLine();
        
        Patient pat = new Patient(nom, prenom, NbSSocial, dateNaissance );
        
        try{
            pat.ecrirePatient();
        }catch(IOException e){
            System.out.println("IOException");
        }
        
        
    }

    public static void verif(String NbSSocial) throws IOException{

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


