package views;

import java.time.LocalDate;
import java.util.ArrayList;

import entity.Classe;
import entity.Filiere;
import entity.Inscription;
import entity.Niveau;
import services.ClasseService;

public class ClasseVue {

    private ClasseVue(){}

    public static Classe saisieClasse(){
        Classe classe = new Classe();
        classe.setFiliere(Filiere.getOptionByValue(Vue.saisiFiliere()));
        classe.setNiveau(Niveau.getOptionByValue(Vue.saisiNiveau()));
        String libelle = classe.getNiveau().toString()+classe.getFiliere().toString();
        classe.setLibelle(libelle);
        if (ClasseService.searchClasseByLibelle(libelle)==null) {
            ClasseService.addClasse(classe);
            System.out.println("La classe a été ajoutée avec succes");
        }else{
            System.out.println("cette classe existe deja");
            classe = ClasseService.searchClasseByLibelle(libelle);
        }
       return classe;
    }

    public static void afficheClasse(ArrayList<Classe> classes){
        for (Classe classe : classes) {
            System.out.println(classe.toString());
        }
    }

    public static void afficheInscriptionClasse(Classe classe,LocalDate date){
        ArrayList<Inscription> inscriptions = new ArrayList<>();
        inscriptions = classe.getInscriptions();
        for (Inscription inscription : inscriptions) {
            if (inscription.getDate().equals(date)) {
                System.out.println(inscription.getEtudiant().toString());
            }
        }
    }

}
