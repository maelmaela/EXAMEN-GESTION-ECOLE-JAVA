package views;

import java.util.ArrayList;
import java.util.Scanner;

import entity.*;
import entity.Module;
import services.PersonneService;

public class PersonneVue {
    private static Scanner scanner =new Scanner(System.in);

    private PersonneVue(Scanner scanner){
        PersonneVue.scanner= scanner;
    }

    public static Personne saisiePersonne(int type) {
    Personne personne = null; 
    String adresse = Vue.saisieChaine("Entrez l'adresse de la personne");
    String nom = Vue.saisieChaine("Entrez le nom de la personne");
    String telephone ;
    do {
        telephone = Vue.saisieChaine("Entrez le numéro de téléphone de la personne");
    } while (PersonneService.searchPersonneByTel(telephone)!=null);
    // int type = Vue.saisieTypePersonne();  
    switch (type) {
        case 2:
            personne = new Attache();
            break;
        case 3:
            personne = new Professeur();
            int grade = Vue.saisieGrade();
            if (grade == 1) {
                ((Professeur) personne).setGrade(Grade.DOCTEUR);
            } else if (grade == 2) {
                ((Professeur) personne).setGrade(Grade.INGENIEUR);
            } else {
                ((Professeur) personne).setGrade(Grade.PROFESSEUR);
            }
            break;
        case 4:
            personne = new Etudiant();
            String matricule;
            do{
                matricule = Vue.saisieChaine("Entrez la matricule");
            }while (PersonneService.searchEtudiantByMatricule(matricule)!=null) ;
            ((Etudiant) personne).setMatricule(matricule);
            int sexe = Vue.saisieSexe();
            if (sexe == 1) {
                ((Etudiant) personne).setSexe(Sexe.FILLE);
            } else {
                ((Etudiant) personne).setSexe(Sexe.GARCON);
            }
            break;
        default:
            System.out.println("Erreur : type invalide.");
            return null; 
    }

    if (personne != null) {
        personne.setAdresse(adresse);
        personne.setNom(nom);
        personne.setTelephone(telephone);
    }

    return personne;
    }

    public static void afficheAllPersonne(ArrayList<Personne> personnes){
        for (Personne personne : personnes) {
            System.out.println(personne.toString());
        }
    }

    public static void afficheEtudiant(ArrayList<Etudiant> etudiants){
        for (Etudiant etudiant : etudiants) {
            System.out.println(etudiant.toString());
        }
    }

    public static void afficheProfesseur(ArrayList<Professeur> professeurs){
        for (Professeur professeur : professeurs) {
            System.out.println(professeur.toString());
        }
    }

    public static void afficheAttache(ArrayList<Attache> attaches){
        for (Attache attache : attaches){
            System.out.println(attache.toString());
        }
    }

    public static void afficheClasseProf(Professeur professeur){
        ArrayList<Classe> classes = new ArrayList<>();
        classes = professeur.getClasses();
        if (classes.size() == 0) {
            System.out.println("Ce professeur n'a pas de classe");
        }else{
            for (Classe classe : classes) {
                System.out.println(classe.toString());
            }
           
        }
    }

    public static void afficheModuleProf(Professeur professeur){
        ArrayList<Module> modules = new ArrayList<>();
        modules = professeur.getModules();
        if (modules.size()==0) {
            System.out.println("Ce professeur n'a aucun module");
        }else{
            for (Module module : modules) {
                System.out.println(module.toString());
            }
        }
    }
}
