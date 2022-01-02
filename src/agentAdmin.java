import java.security.KeyException;

public class agentAdmin {
    public String nom;
    public String prenom;

 
    public agentAdmin(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Patient rechercherPatient(String nbSS, basePatient basePat) throws KeyException{
        Patient pat = basePat.rechercherPatient(nbSS);
        return pat;
    }

    public void ajouterPatient(basePatient basePat, Patient patient){
        basePat.ajouterPatient(patient);
    }

    public void supprimerPatient(String nbSS, basePatient basePat){
        basePat.supprimerPatient(nbSS);
    }

    public Patient modifierPatient(String nom, String prenom, String nbSS, String dateNaissance){
        Patient pat = modifierPatient(nom, prenom, nbSS, dateNaissance);
        return pat ;
    }
    
}
