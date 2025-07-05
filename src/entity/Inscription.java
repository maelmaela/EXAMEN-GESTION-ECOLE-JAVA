package entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Inscription {
    private static int compteur = 0;
    private int id;
    private LocalDate date;
    private Etudiant etudiant;
    private Etat etat;
    private Classe classe;
    private ArrayList<Demande> demandes = new ArrayList<>();

    public Inscription() {
        this.id = ++compteur;
    }

    public Inscription(int id, LocalDate date, Etudiant etudiant, Etat etat, Classe classe) {
        this.id = ++compteur;
        this.date = date;
        this.etudiant = etudiant;
        this.etat = etat;
        this.classe = classe;
    }

    public static int getCompteur() {
        return compteur;
    }

    public static void setCompteur(int compteur) {
        Inscription.compteur = compteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public ArrayList<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(ArrayList<Demande> demandes) {
        this.demandes = demandes;
    }

    @Override
    public String toString() {
        return "Inscription [id=" + id + ", date=" + date + ", etudiant=" + etudiant + ", etat=" + etat + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((etudiant == null) ? 0 : etudiant.hashCode());
        result = prime * result + ((etat == null) ? 0 : etat.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Inscription other = (Inscription) obj;
        if (id != other.id)
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (etudiant == null) {
            if (other.etudiant != null)
                return false;
        } else if (!etudiant.equals(other.etudiant))
            return false;
        if (etat != other.etat)
            return false;
        return true;
    }

    public void addDemandeToInscription(Demande demande){
        demandes.add(demande);
    }
    
}
