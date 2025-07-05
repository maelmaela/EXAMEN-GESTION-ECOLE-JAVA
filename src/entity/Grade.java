package entity;

public enum Grade {
    INGENIEUR(1), DOCTEUR(2), PROFESSEUR(3);
    private int value;

    private Grade(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
