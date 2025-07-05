package entity;

public enum Etat {
    ACCEPTER(1), REFUSER(2), SUSPENSION(3);
    private int value;

    private Etat(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static Etat getOptionByValue(int value){
        Etat[] options = Etat.values();
        for (int i = 0; i < options.length; i++) {
            if (options[i].getValue() == value) {
                return options[i];
            }
        }
        return null;
    }
}
