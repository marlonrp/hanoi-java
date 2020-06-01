package hanoi;

public enum TowersEnum {
    LEFTSTACk(1), MIDDLESTACK(2), RIGHTSTACK(3);

    private int value;

    private TowersEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TowersEnum getTowerByCode(int code) {
        for(TowersEnum tower : TowersEnum.values()) {
            if(tower.getValue() == code)
                return tower;
        }
        throw new IllegalArgumentException("Code " + code + " is not valid!");
    }
}
