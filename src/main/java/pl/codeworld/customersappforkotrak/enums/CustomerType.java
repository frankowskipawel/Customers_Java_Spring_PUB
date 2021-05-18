package pl.codeworld.customersappforkotrak.enums;

public enum CustomerType {
        PERSON("Klient detaliczny"), COMPANY("Firma");

    private String description;

    CustomerType(String description) {
        this.description = description;
    }
}
