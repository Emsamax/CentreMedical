
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.Scanner;
import java.io.Reader;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.annotation.processing.Filer;

public class patient {
   
    public String nom;
    public String prenom;
    public String NbSScoial;
    public String dateNaissance; 
    static int Compteur= 0;
    

    // getters setters =========
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNbSScoial() {
        return this.NbSScoial;
    }

    public void setNbSScoial(String NbSScoial) {
        this.NbSScoial = NbSScoial;
    }

    public String getDateNaissance() {
        return this.dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

//=======================================

    public patient(){
    }

    public patient(String nom, String prenom, String NbSScoial, String dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.NbSScoial = NbSScoial;
        this.dateNaissance = dateNaissance;
        
 
    }
        
    public void ecrirePatient()throws IOException {
        // si pas de fichier existants on en cree un sinom on ecris dedans
        File f = new File("ListePatient.txt");
        // creation et ecriture
        if(!f.exists()){
            PrintWriter out = new PrintWriter(f); 
            out.println(this.toString());
            out.close();
        } 
        //ecriture
        PrintWriter out = new PrintWriter(new FileWriter(f, true));
        out.write(this.toString());
        System.out.println();
        out.close(); 
        
        }
        // try catch dans le main

        public void rechercherPatient(String nomPatient) throws FileNotFoundException, PatientInexistantException{
          //lien avec le fichier Patient.txt et scanner
            FileReader lecteur = new FileReader("ListePatient.txt");
            try (Scanner lectureFichier = new Scanner(lecteur)) {
                while(lectureFichier.hasNextLine()){
                    String str = lectureFichier.nextLine();
                    String[] mots = str.split("/");
                    // vérifie le nom qui est a la 2eme palce du tableau
                    if(mots[1].equalsIgnoreCase(nomPatient.trim())){

                        System.out.println("fichier du patient "+nomPatient+"  trouvé" );
                        break ;


                    }else throw new PatientInexistantException("===Ce patient n'existe pas===");
                    

                }
                lectureFichier.close();
            }
        }
        //try catch dans le main


        public void supprimerPatient(String nomPatient)throws IOException{
            // lecture du fichier deja existant
            //creation dans un nouveau fichier
            File Fichier = new File("ListePatient.txt");
            File ModifFichier = new File("ListePatientModifie.txt");
            FileReader FileReader = new FileReader(Fichier);
            BufferedReader lecture = new BufferedReader(FileReader);
            FileWriter fileWriter = new FileWriter(ModifFichier);
            String Ligne = null;
        //recherche de la ligne
        //si c'est pas la bonne on reecris la meme ligne dans le nouveau fichier et on saute une ligne.
        //si c'est la bonne on ecris rien et on ne sate pas de ligne
            while((Ligne = lecture.readLine()) != null){
                String[] mots = Ligne.split("/");
                if(mots[1].equalsIgnoreCase(nomPatient)){
                    System.out.println("");
                }else{
                    fileWriter.write(Ligne);
                    fileWriter.write("\n");
                }

                 fileWriter.flush();
            }
            //fermeture
            lecture.close();
            fileWriter.close();
            Fichier.delete();
            
            // verification que le nouveau fichier a ete renommé 
            if(ModifFichier.renameTo(Fichier)){
                System.out.println("Le fichier a été renommé avec succès");
              }else{
                System.out.println("Impossible de renommer le fichier");
              }
            }


        public void modifierpatient(String nomPatient)throws IOException{
        /*
        lecture du fichier deja existant
        creation dans un nouveau fichier
        recherche de la ligne a modifier
        si c'est pas la bonne on la reecris dans le nouveau fichier
        si c'est la bonne : 
        creation d'un tableau de meme taille 
        choix entre -copier une case de l'ancien tableau dans le nouveau(au meme numero de case)
                    -ecrire de nouvelles info a la case du nouveau tableau
        creation d'un string en parcourant le nouveaut tableau 
        ecriture de ce string dans le nouveau fichier;

        
        */
            
        File Fichier = new File("ListePatient.txt");
        File ModifFichier = new File("ListePatientModifie.txt");
        FileReader FileReader = new FileReader(Fichier);
        BufferedReader lecture = new BufferedReader(FileReader);
        FileWriter fileWriter = new FileWriter(ModifFichier);
        String Ligne = null; 

            while((Ligne = lecture.readLine()) != null){
                String[] mots = Ligne.split("/");
               
                if(mots[1].equalsIgnoreCase(nomPatient)){
                    Scanner sc = new Scanner(System.in);
                    System.out.println("patient à modifier");
                    System.out.println(nomPatient); 
                    String NvMots [] = new String [4];
                    for(int i=0; i< NvMots.length-1; i++){
                        System.out.println("Saisir 'e' pour recopier l'information déjà existante \n Saisir 'r' pour ecrire une nouvelle information");
                        char c = sc.nextLine().charAt(0);
                        switch(c){
                            case 'e':
                            NvMots[i] = mots[i];
                            break;

                            case'r':
                            if(i == 0){
                                System.out.println("saisir l'information du compteur");
                                String info = sc.nextLine();
                                NvMots[i] = info;
                                break;
                            }else if(i==1){
                                System.out.println("saisir l'information du nom");
                                String info = sc.nextLine();
                                NvMots[i] = info;
                                break;
                            }else if(i==2){
                                System.out.println("saisir l'information du prénom");
                                String info = sc.nextLine();
                                NvMots[i] = info;
                                break;
                            }else if(i==3){
                                System.out.println("saisir l'information du numero de securité sociale");
                               boolean ok = false;
                               while(!ok){
                                try{
                                    String info = sc.nextLine();
                                    verif(info);
                                    NvMots[i] = info;
                                    ok = true;
                                   }catch(InputMismatchException e){
                                       System.out.println("erreur");
                                   }
                               }
                                break;
                            }else if(i==4){
                                System.out.println("saisir l'information de la date de naissance");
                                String info = sc.nextLine();
                                NvMots[i] = info;
                                break;
                            }
                                  
                        }   
                    }
                    // String avec les nouvelles info
                    // remplisage
                    //derniere info ne pas mettre de "/" pour eviter les erreur ArrayindexOutOfdBounds au prochain split(); 
                    String modifLigne = null;
                    for(int i =0; i< NvMots.length ;i++){
                         if(NvMots.length -i ==0){
                            modifLigne += NvMots[i];
                         } else
                         modifLigne += NvMots[i]+"/";
                    }
                   // ecriture dans le nouveau fichier
                    fileWriter.write(modifLigne);
                    fileWriter.write("\n");

                }else{
                    fileWriter.write(Ligne);
                    fileWriter.write("\n");
                }

                 fileWriter.flush();
                 // fermeture
            }
            lecture.close();
            fileWriter.close();
            Fichier.delete();
            // verification que le nouveau fichier a ete renommé 
            if(ModifFichier.renameTo(Fichier)){
                System.out.println("Le fichier a été renommé avec succès");
              }else{
                System.out.println("Impossible de renommer le fichier");
              }
            }

            
               
                
              
                public void verif(String NbSSocial) throws IOException{

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
            
        

    @Override
   public  String toString() {
        return   Compteur +"/"+ getNom() + "/" + getPrenom() + "/" + getNbSScoial() + "/" +  getDateNaissance() +"\n";
            
    }

  
    
}
    
