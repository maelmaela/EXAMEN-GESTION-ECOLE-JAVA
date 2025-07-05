package entity;

import java.util.ArrayList;

public class Professeur extends Personne{
    private Grade grade;
    private ArrayList<Module> modules = new ArrayList<>();
    private ArrayList<Classe> classes = new ArrayList<>();

    public Professeur(){}
    
    public Professeur(Grade grade) {
        this.grade = grade;
    }
    public Professeur(int id, String nom, String adresse, String telephone, Grade grade) {
        super(id, nom, adresse, telephone);
        this.grade = grade;
    }
    public Grade getGrade() {
        return grade;
    }
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    public ArrayList<Module> getModules() {
        return modules;
    }
    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
    public ArrayList<Classe> getClasses() {
        return classes;
    }
    public void setClasses(ArrayList<Classe> classes) {
        this.classes = classes;
    }
    @Override
    public String toString() {
        return "Professeur [grade=" + grade + ", nom=" + nom + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((grade == null) ? 0 : grade.hashCode());
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
        Professeur other = (Professeur) obj;
        if (grade != other.grade)
            return false;
        return true;
    }

    public void addModuleToProfesseur(Module module){
        modules.add(module);
    }

    public void addClasseToProfesseur(Classe classe){
        classes.add(classe);
    }
}
