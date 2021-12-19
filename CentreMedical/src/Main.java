import java.io.IOException;
import java.util.Scanner;

public class Main {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        System.out.println("nom patient");
        String nom = sc.nextLine();
       
        System.out.println("prenom patient");
        String prenom = sc.nextLine();

        System.out.println("numero securite sociale patient");
        String NbSSocial = sc.nextLine();
    //  = numero seciurite sociale 
        System.out.println("date  de naissance patient");
        String dateNaissance = sc.nextLine();
        
        Patient pat = new Patient(nom, prenom, NbSSocial, dateNaissance );
        Patient pat2 = new Patient("nassim", "le bg ", "141414141", "j'ai oublié" );

        try{
            pat.ecrirePatient();
        }catch(IOException e){
            System.out.println("IOException");
        }
        
    }
}


