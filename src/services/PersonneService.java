package services;
import entity.*;

import java.util.ArrayList;

public class PersonneService {
    private static ArrayList<Personne> personnes = new ArrayList<>();

    private PersonneService(){}

    public static ArrayList<Personne> getPersonnes() {
        return personnes;
    }

    public static void setPersonnes(ArrayList<Personne> personnes) {
        PersonneService.personnes = personnes;
    }

    public static void addPersonne(Personne personne){
        personnes.add(personne);
    }

    public static Personne searchPersonneByid(int id){
        for (Personne personne : personnes) {
            if (personne.getId() == id) {
                return personne;
            }
        }
        return null;
    }

    public static ArrayList<Etudiant> getAllEtudiant(){
        ArrayList<Etudiant> etudiants = new ArrayList<>();
        for (Personne personne : personnes) {
            if (personne instanceof Etudiant) {
               etudiants.add((Etudiant)personne);
            }
        }
        return etudiants;
    }

    public static ArrayList<Professeur> getAllProfesseur(){
        ArrayList<Professeur> professeurs = new ArrayList<>();
        for (Personne personne : personnes) {
            if (personne instanceof Professeur) {
                professeurs.add((Professeur)personne);
            }
        }
        return professeurs;
    }

    public static ArrayList<Attache> getAllAttache(){
        ArrayList<Attache> attaches = new ArrayList<>();
        for (Personne personne : personnes) {
            if (personne instanceof Attache) {
                attaches.add((Attache)personne);
            }
        }
        return attaches;
    }

    public static Etudiant searchEtudiantByMatricule(String matricule){
        ArrayList<Etudiant> etudiants = new ArrayList<>();
        etudiants = PersonneService.getAllEtudiant();
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getMatricule().equals(matricule)) {
                return etudiant;
            }
        }
        return null;
    } 

    public static Personne searchPersonneByTel(String tel){
        for (Personne personne : personnes) {
            if (personne.getTelephone().equals(tel)) {
                return personne;
            }
        }
        return null;
    }

    
}
