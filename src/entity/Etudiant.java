package entity;

import java.util.ArrayList;

public class Etudiant extends Personne {
    private String matricule;
    private Classe classe;
    private Sexe sexe;
    private ArrayList<Inscription> inscriptions = new ArrayList<>();
    private ArrayList<Demande> demandes = new ArrayList<>();

    public Etudiant(){}
    
    public Etudiant(String matricule, Classe classe, Sexe sexe) {
        this.matricule = matricule;
        this.classe = classe;
        this.sexe = sexe;
    }
    public Etudiant(int id, String nom, String adresse, String telephone, String matricule, Classe classe,
            Sexe sexe) {
        super(id, nom, adresse, telephone);
        this.matricule = matricule;
        this.classe = classe;
        this.sexe = sexe;
    }
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public Classe getClasse() {
        return classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    public Sexe getSexe() {
        return sexe;
    }
    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }
    public ArrayList<Inscription> getInscriptions() {
        return inscriptions;
    }
    public void setInscriptions(ArrayList<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
    public ArrayList<Demande> getDemandes() {
        return demandes;
    }
    public void setDemandes(ArrayList<Demande> demandes) {
        this.demandes = demandes;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
        result = prime * result + ((classe == null) ? 0 : classe.hashCode());
        result = prime * result + ((sexe == null) ? 0 : sexe.hashCode());
        result = prime * result + ((inscriptions == null) ? 0 : inscriptions.hashCode());
        result = prime * result + ((demandes == null) ? 0 : demandes.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Etudiant other = (Etudiant) obj;
        if (matricule == null) {
            if (other.matricule != null)
                return false;
        } else if (!matricule.equals(other.matricule))
            return false;
        if (classe == null) {
            if (other.classe != null)
                return false;
        } else if (!classe.equals(other.classe))
            return false;
        if (sexe == null) {
            if (other.sexe != null)
                return false;
        } else if (!sexe.equals(other.sexe))
            return false;
        if (inscriptions == null) {
            if (other.inscriptions != null)
                return false;
        } else if (!inscriptions.equals(other.inscriptions))
            return false;
        if (demandes == null) {
            if (other.demandes != null)
                return false;
        } else if (!demandes.equals(other.demandes))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Etudiant [matricule=" + matricule + ", nom=" + nom + ", classe=" + classe + ", adresse=" + adresse
                + ", sexe=" + sexe + ", Telephone=" + Telephone + "]";
    }

    public void addInscriptionToEtudiant(Inscription inscription){
        inscriptions.add(inscription);
    }
    
    public void addDemandeToEtudiant(Demande demande){
        demandes.add(demande);
    }
}
