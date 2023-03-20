package enums;

public enum StringForSearch {

    Принтер("Принтер"),
    Монитор("Монитор");

    private final String value;

    public String getValue() {
        return value;
    }

    StringForSearch(String value) {
        this.value = value;
    }
}