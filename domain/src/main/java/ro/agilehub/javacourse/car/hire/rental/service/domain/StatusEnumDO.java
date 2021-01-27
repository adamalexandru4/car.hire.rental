package ro.agilehub.javacourse.car.hire.rental.service.domain;

public enum StatusEnumDO {
    ACTIVE("active"),
    DELETED("deleted");

    private String value;

    StatusEnumDO(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static StatusEnumDO fromValue(String value) {
        for (StatusEnumDO b : StatusEnumDO.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
