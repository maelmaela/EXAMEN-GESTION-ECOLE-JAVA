package entity;

public abstract class Personne {
    protected static int compteur=0;
    protected int id;
    protected String nom;
    protected String adresse;
    protected String Telephone; 
    protected TypePersonne typePersonne;

    public Personne(){
        this.id = ++compteur;
    }

    public Personne(int id, String nom, String adresse, String telephone) {
        this.id = ++compteur;
        this.nom = nom;
        this.adresse = adresse;
        Telephone = telephone;
    }

    public String getNom(){
        return nom;
    }

    public static int getCompteur() {
        return compteur;
    }

    public static void setCompteur(int compteur) {
        Personne.compteur = compteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    

    @Override
    public String toString() {
        return "[id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", Telephone=" + Telephone + ", Type=" + typePersonne +"]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
        result = prime * result + ((Telephone == null) ? 0 : Telephone.hashCode());
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
        Personne other = (Personne) obj;
        if (id != other.id)
            return false;
        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;
        if (adresse == null) {
            if (other.adresse != null)
                return false;
        } else if (!adresse.equals(other.adresse))
            return false;
        if (Telephone == null) {
            if (other.Telephone != null)
                return false;
        } else if (!Telephone.equals(other.Telephone))
            return false;
        return true;
    }

    public TypePersonne getTypePersonne() {
        return typePersonne;
    }

    public void setTypePersonne(TypePersonne typePersonne) {
        this.typePersonne = typePersonne;
    }
}
