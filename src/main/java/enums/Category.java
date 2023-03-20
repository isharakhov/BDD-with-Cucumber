package enums;

public enum Category {

    ОргтехникаИРасходники("Оргтехника и расходники"),
    ТоварыДляКомпьютера("Товары для компьютера");

    private String value;

    public String getValue() {
        return value;
    }

    Category(String value) {
        this.value = value;
    }
}