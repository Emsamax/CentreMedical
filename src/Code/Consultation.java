package Code;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Consultation {
    static int IDcourant = 0;
    public int ID;
    public String date;
    public Patient patient;
    public String detailsCiniques;
    public appareilMedical appareilMedical;

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


    public Consultation(appareilMedical appareilMedical) {
        this.appareilMedical = appareilMedical;
    }


    public appareilMedical getAppareilMedical() {
        return this.appareilMedical;
    }

    public void setAppareilMedical(appareilMedical appareilMedical) {
        this.appareilMedical = appareilMedical;
    }

    public Consultation(){
    }
    
    public Consultation(String date, Patient patient, String detailsCiniques) {
        this.date = date;
        this.patient = patient;
        this.detailsCiniques = detailsCiniques;
        IDcourant = dernierID();
        this.ID = (IDcourant + 1);
    }

    public Consultation(String date, Patient patient, String detailsCiniques, appareilMedical appareilMedical) {
        this.date = date;
        this.patient = patient;
        this.detailsCiniques = detailsCiniques;
        this.appareilMedical = appareilMedical;
        IDcourant = dernierID();
        this.ID = (IDcourant + 1);
    }

    public Consultation(int ID, String date, Patient patient, String detailsCiniques, appareilMedical appareilMedical) {
        this.date = date;
        this.patient = patient;
        this.detailsCiniques = detailsCiniques;
        this.appareilMedical = appareilMedical;
        this.ID = ID;
    }

    public void octroyerAppareil(appareilMedical appareilMedical){
        this.appareilMedical = appareilMedical;
    }

    public void validerAppareilMedical(){
        if(this.appareilMedical != null){
            if(this.appareilMedical.enAttente == true){
                this.appareilMedical.valider();
            }throw new InputMismatchException("déjà validé");
           }throw new InputMismatchException("il n'y a pas d'appareil medical");
            
    }

    public int dernierID(){
        //fonction pour trouver le dernier ID des consultations apartir du fichier.txt
        File file;
        FileReader fileReader;
        Scanner sc;
        int id = 1;
        try {
            file = new File("consultation.txt");
            fileReader = new FileReader(file);
            sc = new Scanner(fileReader);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] split = line.split("/");
                id = Integer.parseInt(split[0]);
            }
            fileReader.close();
            sc.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        return id;

    }
    @Override
    public String toString() {
        return Integer.toString(this.ID) + "/" + this.patient.nbSS + "/" + this.detailsCiniques  + "/" + this.date + "/" + this.appareilMedical.nom + "/" + Boolean.toString(this.appareilMedical.enAttente) + "\n";
    }
}
