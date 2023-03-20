package enums;

public enum City {

    Владивосток("Владивосток"),
    Иркутск("Иркутск");

    private final String value;

    public String getValue() {
        return value;
    }

    City(String value) {
        this.value = value;
    }
}