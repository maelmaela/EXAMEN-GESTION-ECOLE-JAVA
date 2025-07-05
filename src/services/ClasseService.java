package services;
import entity.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClasseService {
    private static ArrayList<Classe> classes = new ArrayList<>();

    private ClasseService(){}

    public static ArrayList<Classe> getClasses() {
        return classes;
    }

    public static void setClasses(ArrayList<Classe> classes) {
        ClasseService.classes = classes;
    }

    public static void addClasse(Classe classe){
        classes.add(classe);
    }

    public static Classe searchClasse(int id){
        for (Classe classe : classes) {
            if (classe.getId() == id) {
                return classe;
            }
        }
        return null;
    }

    public static Classe searchClasseByLibelle(String libelle){
        for (Classe classe : classes) {
            if (classe.getLibelle().equals(libelle)) {
                return classe;
            }
        }
        return null;
    }

    public static int getNbreEtudiantClasse(ArrayList<Inscription> inscriptions, LocalDate date){
        int nbreEtudiant=0;
        for (Inscription inscription : inscriptions) {
            if (inscription.getDate().equals(date)) {
                nbreEtudiant = inscriptions.size();
            }
        }
        return nbreEtudiant;
    }

    public static int getNbreFilleParClasse(ArrayList<Inscription> inscriptions,LocalDate date){
        int nbreFille = 0;
        for (Inscription inscription : inscriptions) {
            if (inscription.getEtudiant().getSexe() == Sexe.FILLE && inscription.getEtat().equals(Etat.ACCEPTER)) {
                nbreFille = nbreFille +1;
            }
        }
        return nbreFille;
    }

    public static int getNbreGarconParClasse(ArrayList<Inscription> inscriptions,LocalDate date){
        int nbreGarcon = 0;
        for (Inscription inscription : inscriptions) {
            if (inscription.getEtudiant().getSexe() == Sexe.GARCON && inscription.getEtat().equals(Etat.ACCEPTER)) {
                nbreGarcon = nbreGarcon +1;
            }
        }
        return nbreGarcon;
    }

}
