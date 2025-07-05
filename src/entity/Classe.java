package entity;

import java.util.ArrayList;

public class Classe {
    private static int compteur = 0;
    private int id;
    private String libelle;
    private Filiere filiere;
    private Niveau Niveau;
    private ArrayList<Inscription> inscriptions = new ArrayList<>();
    private Attache attache;
    private ArrayList<Professeur> professeurs = new ArrayList<>();
    
    public Classe() {
        this.id = ++compteur;
    }

    public static int getCompteur() {
        return compteur;
    }

    public static void setCompteur(int compteur) {
        Classe.compteur = compteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Niveau getNiveau() {
        return Niveau;
    }

    public void setNiveau(Niveau niveau) {
        Niveau = niveau;
    }

    public ArrayList<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(ArrayList<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public Attache getAttache() {
        return attache;
    }

    public void setAttache(Attache attache) {
        this.attache = attache;
    }

    public ArrayList<Professeur> getProfesseurs() {
        return professeurs;
    }

    public void setProfesseurs(ArrayList<Professeur> professeurs) {
        this.professeurs = professeurs;
    }

    @Override
    public String toString() {
        return "Classe [id=" + id + ", libelle=" + libelle + ", filiere=" + filiere + ", Niveau=" + Niveau
                + ", attache=" + attache + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
        result = prime * result + ((attache == null) ? 0 : attache.hashCode());
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
        Classe other = (Classe) obj;
        if (id != other.id)
            return false;
        if (libelle == null) {
            if (other.libelle != null)
                return false;
        } else if (!libelle.equals(other.libelle))
            return false;
        if (attache == null) {
            if (other.attache != null)
                return false;
        } else if (!attache.equals(other.attache))
            return false;
        return true;
    }

    public void addInscriptionToClasse(Inscription inscription){
        inscriptions.add(inscription);
    }

    public void addProfesseurToClasse(Professeur professeur){
        professeurs.add(professeur);
    }
    

}
