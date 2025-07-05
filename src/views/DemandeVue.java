package views;

import java.util.ArrayList;

import entity.Demande;
import entity.Etat;
import entity.Etudiant;

public class DemandeVue {
    private DemandeVue(){}

    public static Demande saisieDemande(Etudiant etudiant){
        Demande demande = new Demande();
        demande.setMotif(Vue.saisieChaine("Entrez le motif de votre demande"));
        demande.setEtat(Etat.getOptionByValue(Vue.saisieEtat()));
        demande.setEtudiant(etudiant);
        return demande;
    }

    public static void affciheDemande(ArrayList<Demande> demandes){
        for (Demande demande : demandes) {
            System.out.println(demande.toString());
        }
    }

    public static void afficheDemandeEtudiant(Etudiant etudiant){
        ArrayList<Demande> demandes = new ArrayList<>();
        demandes = etudiant.getDemandes();
        for (Demande demande : demandes) {
            System.out.println(demande.toString());
        }
    }
}
