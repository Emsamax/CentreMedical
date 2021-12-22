import java.io.IOException;
import java.util.Scanner;

public class Main {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        System.out.println("nom patient");
        String nom = sc.nextLine();
       
        System.out.println("prenom patient");
        String prenom = sc.nextLine();

        System.out.println("numero securite sociale patient 13 chiffres max");
        boolean ok = false;
        
        // gestion de l'exception ne marche pas 
        String NbSSocial = "";
        while(!ok){
            try{
                NbSSocial = sc.nextLine();
                ok = true;
                if(NbSSocial.length()>13){
                    throw new NbSecuriteSocialeException("erreur; il ya plus de 13 chiffres");
                }
            }catch( NbSecuriteSocialeException e){
                System.out.println("mauvaise entrée");
            }
            
            
        }
    //  = numero seciurite sociale 
        System.out.println("date  de naissance patient");
        String dateNaissance = sc.nextLine();
        
        Patient pat = new Patient(nom, prenom, NbSSocial, dateNaissance );
        Patient pat2 = new Patient("nassim", "le bg ", "141414141", "j'ai oublié" );

        try{
            pat.ecrirePatient();
            pat2.ecrirePatient();
        }catch(IOException e){
            System.out.println("IOException");
        }
        
        System.out.println("patient a supprimer ");
        try{
            pat2.supprimerPatient("nassim");
        }catch(IOException e){
            System.out.println("sdfgqsdfhwertdhwdfgnwdfgn");
        }
    }
}


