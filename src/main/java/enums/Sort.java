package enums;

public enum Sort {

    Дороже("Дороже"),
    Дешевле("Дешевле");

    private final String value;

    public String getValue() {
        return value;
    }

    Sort(String value) {
        this.value = value;
    }
}