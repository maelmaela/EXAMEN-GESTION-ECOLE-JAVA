package entity;

public enum Sexe {
    FILLE(1),GARCON(2);
    int value;
    private Sexe(int value){
        this.value = value;
    }
    public int getValu(){
        return value;
    }
}
