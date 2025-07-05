package services;
import entity.*;


import java.time.LocalDate;
import java.util.ArrayList;

public class InscriptionService {
    private static ArrayList<Inscription> inscriptions = new ArrayList<>();

    private InscriptionService(){}

    public static void addInscription(Inscription inscription){
        inscriptions.add(inscription);
    }

    public static ArrayList<Inscription> getInscriptions() {
        return inscriptions;
    }

    public static void setInscriptions(ArrayList<Inscription> inscriptions) {
        InscriptionService.inscriptions = inscriptions;
    }

    public static int getNbreFilleParAnne(LocalDate date){
        int nbreFille = 0;
         for (Inscription inscription : inscriptions) {
            if (inscription.getDate().equals(date) && inscription.getEtudiant().getSexe().equals(Sexe.FILLE) && inscription.getEtat().equals(Etat.ACCEPTER)) {
                nbreFille++;
            }
        }
        return nbreFille;
    }

    public static int getNbreGarconParAnne(LocalDate date){
        int nbreGarcon = 0;
        for (Inscription inscription : inscriptions) {
            if (inscription.getDate().equals(date) && inscription.getEtudiant().getSexe().equals(Sexe.GARCON) && inscription.getEtat().equals(Etat.ACCEPTER)) {
                nbreGarcon++;
            }
        }
        return nbreGarcon;
    }

    public static Inscription searchInscriptionById(int id){
        for (Inscription inscription : inscriptions) {
            if (inscription.getId()==id) {
                return inscription;
            }
        }
        return null;
    }

    public static int getAllInscriptionAnnes(LocalDate date){
        int nbreInscritsAnne=0;
        for (Inscription inscription : inscriptions) {
            if (inscription.getDate().equals(date) && inscription.getEtat() == Etat.ACCEPTER) {
                nbreInscritsAnne++;
            }
        }
        return nbreInscritsAnne;
    }

    public static int getNbreEtudiantInscriptionSuspendu(LocalDate date){
        int inscriptionSuspendu=0;
        for (Inscription inscription : inscriptions) {
            if (inscription.getEtat().equals(Etat.SUSPENSION)) {
                inscriptionSuspendu++;
            }
        }
        return inscriptionSuspendu;
    }

    public static int getNbreEtudiantInscriptionAnnule(LocalDate date){
        int inscriptionAnnule=0;
        for (Inscription inscription : inscriptions) {
            if (inscription.getEtat().equals(Etat.REFUSER)) {
                inscriptionAnnule++;
            }
        }
        return inscriptionAnnule;
    }
    
}
