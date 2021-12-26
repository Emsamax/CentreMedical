import java.io.IOException;
import java.util.InputMismatchException;

public class Consultation {
    public int ID;
    public String date;
    public Patient patient;
    public String detailsCiniques;
    public AppareilMedical appareilMedical;

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDetailsCiniques() {
        return this.detailsCiniques;
    }

    public void setDetailsCiniques(String detailsCiniques) {
        this.detailsCiniques = detailsCiniques;
    }


    public Consultation(AppareilMedical appareilMedical) {
        this.appareilMedical = appareilMedical;
    }


    public AppareilMedical getAppareilMedical() {
        return this.appareilMedical;
    }

    public void setAppareilMedical(AppareilMedical appareilMedical) {
        this.appareilMedical = appareilMedical;
    }

    public Consultation(){

    }
    
    public Consultation(String date, Patient patient, String detailsCiniques) {
        this.date = date;
        this.patient = patient;
        this.detailsCiniques = detailsCiniques;
        this.appareilMedical = null;
        
    }

    public Consultation(int ID, String date, Patient patient, String detailsCiniques, AppareilMedical appareilMedical) {
        this.date = date;
        this.patient = patient;
        this.detailsCiniques = detailsCiniques;
        this.appareilMedical = appareilMedical;
    }

    public void octroyerAppareil(){
       if(this.appareilMedical != null ){
        if(this.appareilMedical.enAttente == true){
            this.appareilMedical.octroyer();
        }throw new InputMismatchException(" deja octroyé");
       }throw new InputMismatchException("il n'y a pas d'appareil medical");
        
    }


}
