package entity;

public enum TypePersonne {
    RP(1), ATTACHE(2), PROFESSEUR(3), ETUDIANT(4);
    private int value;

    private TypePersonne(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
