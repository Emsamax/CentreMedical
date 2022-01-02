import java.security.KeyException;

public class Medecin {
    
    public String nom;
    

    public Medecin(String nom) {
        this.nom = nom;
    }

    public Consultation rechercherConsultation(int ID, baseConsultation baseCons) throws KeyException{
        Consultation cons = baseCons.rechercherConsultation(ID);
        return cons;
    }
    public void ajoutConsultation(baseConsultation baseCons, Consultation consultation){
        baseCons.ajouterConsultation(consultation);
    }

    public void supprimerConsultation(baseConsultation baseCons, int ID){
        baseCons.supprimerConsultation(ID);
    }

    public void modifierConsultation(baseConsultation baseCons, Consultation consultation) throws KeyException{
        baseCons.modifierConsultation(consultation);
    }
    
    public void ajouterPathologie(Patient patient, Pathologie pathologie){
        // appeler sous la forme Pathologie.COUDE (tout ce qui se trouve dans enum)
        patient.ajouterPathologie(pathologie);

    }
    public Consultation createConsultation(String date, Patient patient, String detailsCliniques,appareilMedical appareilMedical ){  
        Consultation cons = new Consultation(date, patient, detailsCliniques);
        cons.octroyerAppareil(appareilMedical);
        return cons;
    }
    public appareilMedical createAppareilMedical(String nom){
        appareilMedical app = new appareilMedical(nom);
        return app;
    }
}
