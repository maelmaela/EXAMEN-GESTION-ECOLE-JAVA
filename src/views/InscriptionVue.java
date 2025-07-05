package views;

import java.time.LocalDate;
import java.util.ArrayList;

import entity.Classe;
import entity.Etat;
import entity.Etudiant;
import entity.Inscription;

public class InscriptionVue {
    private InscriptionVue(){

    }

    public static Inscription saisieInscription(Etudiant etudiant,Classe classe){
        Inscription inscription = new Inscription();
        inscription.setDate(LocalDate.now());
        inscription.setEtat(Etat.getOptionByValue(Vue.saisieEtat()));
        inscription.setClasse(classe);
        inscription.setEtudiant(etudiant);
        return inscription;
    }

    public static void afficheEtudiantInscritsAnne(ArrayList<Inscription> inscriptions,LocalDate date){
        for (Inscription inscription : inscriptions) {
            if (inscription.getDate().equals(date)) {
                System.out.println(inscription.getEtudiant().toString());
            }
        }
    }

    public static void afficheInscription(ArrayList<Inscription> inscriptions){
        for (Inscription inscription : inscriptions) {
            System.out.println(inscription.toString());
        }
    }

    
    
}
