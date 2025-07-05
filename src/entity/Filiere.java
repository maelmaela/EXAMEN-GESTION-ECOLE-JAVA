package entity;

public enum Filiere {
    GLRS(1), TTL(2), CDSD(3), CPD(4), MAE(5), ETSE(6), IAGE(7);
    private int value;

    private Filiere(int value){
        this.value=value;
    }

    public int getValue(){
        return value;
    }


    public static Filiere getOptionByValue(int value){
        Filiere[] options = Filiere.values();
        for (int i = 0; i < options.length; i++) {
            if (options[i].getValue() == value) {
                return options[i];
            }
        }
        return null;
    }
}
