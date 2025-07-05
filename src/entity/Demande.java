package entity;

public class Demande {
    private static int compteur=0;
    private int id;
    private String motif;
    private Etat etat;
    private Etudiant etudiant;
    private Inscription inscription;

    public Demande(){
        this.id = ++compteur;
    }

    public Demande(int id, String motif, Etat etat, Etudiant etudiant, Inscription inscription) {
        this.id = ++compteur;
        this.motif = motif;
        this.etat = etat;
        this.etudiant = etudiant;
        this.inscription = inscription;
    }

    public static int getCompteur() {
        return compteur;
    }

    public static void setCompteur(int compteur) {
        Demande.compteur = compteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    @Override
    public String toString() {
        return "Demande [id=" + id + ", module=" + motif + ", etat=" + etat + ", etudiant=" + etudiant
                + ", inscription=" + inscription + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((etudiant == null) ? 0 : etudiant.hashCode());
        result = prime * result + ((inscription == null) ? 0 : inscription.hashCode());
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
        Demande other = (Demande) obj;
        if (id != other.id)
            return false;
        if (etudiant == null) {
            if (other.etudiant != null)
                return false;
        } else if (!etudiant.equals(other.etudiant))
            return false;
        if (inscription == null) {
            if (other.inscription != null)
                return false;
        } else if (!inscription.equals(other.inscription))
            return false;
        return true;
    }

    
}
