import java.security.KeyException;

public class AgentAdmin {
    public String nom;
    public String prenom;

 
    public AgentAdmin(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Patient rechercherPatient(String nbSS, BasePatient basePat) throws KeyException{
        Patient pat = basePat.rechercherPatient(nbSS);
        return pat;
    }

    public void ajouterPatient(BasePatient basePat, Patient patient){
        basePat.ajouterPatient(patient);
    }

    public void supprimerPatient(String nbSS, BasePatient basePat){
        basePat.supprimerPatient(nbSS);
    }

    public Patient modifierPatient(String nom, String prenom, String nbSS, String dateNaissance){
        Patient pat = modifierPatient(nom, prenom, nbSS, dateNaissance);
        return pat;
    }
    
}
