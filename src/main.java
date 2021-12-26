import java.io.FileNotFoundException;
import java.security.KeyException;

public class main {
     public static void main(String[] args) {
        try{
        BasePatient baseP = new BasePatient("ListePatient.txt");
        baseP.load();
        Patient bertrand = baseP.rechercherPatient("5566332266995");
        System.out.println(bertrand.toString());
        }catch(KeyException e){
            System.out.println(e.toString());
        }catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
    }
    
}
