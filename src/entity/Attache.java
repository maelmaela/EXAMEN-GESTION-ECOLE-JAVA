package entity;

import java.util.ArrayList;

public class Attache extends Personne {
    private ArrayList<Classe> classes = new ArrayList<>();

    public Attache() {
    }

    public Attache(int id, String nom, String adresse, String telephone) {
        super(id, nom, adresse, telephone);
    }

    public ArrayList<Classe> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Classe> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Attache [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", Telephone=" + Telephone + "]";
    }

    public void addClassToAttache(Classe classe){
        classes.add(classe);
    }

    
}
