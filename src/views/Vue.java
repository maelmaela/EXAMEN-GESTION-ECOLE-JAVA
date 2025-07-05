package views;

import java.util.Scanner;


public class Vue {
    private static Scanner scanner =new Scanner(System.in);

    private Vue(Scanner scanner){
        Vue.scanner = scanner;
    }

    public static int saisiEntier(String message){
        int n;
        do {
            System.out.println(message);
            n = scanner.nextInt();
        } while (n<0);
        return n;
    }

    public static String saisieChaine(String message){
        String chaine;
        do {
            System.out.println(message);
            chaine = scanner.nextLine();
        } while (chaine.isEmpty());
        return chaine;
    }

    public static int MenuPrincipal(){
        System.out.println("1- Responsable Pedagogique (RP)");
        System.out.println("2- Attaché de classe");
        System.out.println("3- Etudiant");
        System.out.println("4- Quitter");
        return saisiEntier("Entrez votre choix");
    }

    public static int saisieTypePersonne(){
        int type;
        do {
            System.out.println("Faites votre choix");
            System.out.println("1- RP");
            System.out.println("2- Attache");
            System.out.println("3- Professeur");
            System.out.println("4- Etudiant");
            type = Vue.saisiEntier("Faite votre choix");
        } while (type !=1 && type!=2 && type!=3 && type!=4);
        return type;
    }

    public static int saisieGrade(){
        int grade;
        do {
            System.out.println("1- INGENIEUR");
            System.out.println("2- DOCTEUR");
            System.out.println("3- PROFESSEUR");
            grade = Vue.saisiEntier("Faite votre choix");
        } while (grade !=1 && grade!= 2 && grade!=3);
        return grade;
    }

    public static int saisieSexe(){
        int sexe;
        do {
            System.out.println("1- FILLE");
            System.out.println("2- GARCON");
            sexe = Vue.saisiEntier("Faite votre choix");
        } while (sexe !=1 && sexe!= 2);
        return sexe;
    }

    public static int saisiFiliere(){
        int filiere;
        do {
            System.out.println("1- GLRS");
            System.out.println("2- TTL");
            System.out.println("3- CDSD");
            System.out.println("4- CPD");
            System.out.println("5- MAE");
            System.out.println("6- ETSE");
            System.out.println("7- IAGE");
            filiere = Vue.saisiEntier("Faites votre choix");
        } while (filiere!=1 && filiere!=2 && filiere!=3 && filiere!=4 && filiere!=5 && filiere!=6 && filiere!=7);
        return filiere;
    }

    public static int saisiNiveau(){
        int niveau;
        do {
            System.out.println("1- L1");
            System.out.println("2- L2");
            System.out.println("3- L3");
            niveau = Vue.saisiEntier("Faites votre choix");
        } while (niveau!=1 && niveau!=2 && niveau!=3);
        return niveau;
    }

    public static int saisieEtat(){
        int etat;
        do {
            System.out.println("1- ACCEPTER");
            System.out.println("2- REFUSER");
            System.out.println("3- SUSPENSION");
            etat = Vue.saisiEntier("Faites votre choix");
        } while (etat!=1 && etat!=2 && etat!=3);
        return etat;
    }

    public static int menuRP(){
        System.out.println("1- Creer classe");
        System.out.println("2- Lister classe");
        System.out.println("3- Creer module");
        System.out.println("4- Lister module");
        System.out.println("5- Ajouter professeur");
        System.out.println("6- Lister professeur");
        System.out.println("7- Affecter module à professeur");
        System.out.println("8- Affecter classe à professeur");
        System.out.println("9- Lister module d'un professeur");
        System.out.println("10- Lister classes d'un professeur");
        System.out.println("11- Traiter demandes etudiant");
        System.out.println("12- Ajouter attache");
        System.out.println("13- Affecter classe à attacher");
        System.out.println("14- Lister attaches");
        System.out.println("15- Voir effectif ecole par année");
        System.out.println("16- Connaitre le nombre de fille par annee");
        System.out.println("17- Connaitre le nombre de garcon par annee");
        System.out.println("18- Connaitre l'effectif par classe");
        System.out.println("19- Nombre de fille par classe");
        System.out.println("20- Nombre de garcon par classe");
        System.out.println("21- Nombre d'etudiant qui ont suspendu leur inscription par année");
        System.out.println("22- Nombre d'etudiant qui ont annulé leur inscription par année");
        System.out.println("23- Retour");
        System.out.println("24- Quitter");
        return saisiEntier("Entrez votre choix");
    }

    public static int menuAttache(){
        System.out.println("1- Inscrire etudiant");
        System.out.println("2- Reinscrire etudiant");
        System.out.println("3- Lister etudiant inscrit dans une classe");
        System.out.println("4- Lister les etudiants inscrits dans une annee");
        System.out.println("5-Retour");
        System.out.println("6- Quitter");
        return saisiEntier("Entrez votre choix");
    }

    public static int menuEtudiant(){
        System.out.println("1- Faire demande de reinscription");
        System.out.println("2- Faire demande d'annulation");
        System.out.println("3- Faire demande de suspension");
        System.out.println("4- Lister les demandes");
        System.out.println("5- Filtrer demande par etat");
        System.out.println("6-Retour");
        System.out.println("7- Quitter");
        return saisiEntier("Entrez votre choix");
    }

}
