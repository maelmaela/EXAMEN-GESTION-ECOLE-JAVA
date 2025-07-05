package entity;

public enum Niveau {
    L1(1),L2(2),L3(3);
    private int value;

    private Niveau(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static Niveau getOptionByValue(int value){
        Niveau[] options = Niveau.values();
        for (int i = 0; i < options.length; i++) {
            if (options[i].getValue() == value) {
                return options[i];
            }
        }
        return null;
    }
}