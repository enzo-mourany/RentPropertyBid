package property;

public enum PropertyType {
    HOUSE("House"),
    APARTMENT("Apartment"),
    DOMAIN("Domain");

    private final String NAME;
    PropertyType(String _name) {
        this.NAME = _name;
    }

    public String getName() {
        return NAME;
    }
}
