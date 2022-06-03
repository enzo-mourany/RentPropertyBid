package users;

public enum Logins {
    ADMINISTRATOR("Administrator", "Administrator"),
    USER1("Chris", "Owner"),
    USER2("Alex", "Tenant");

    public final String username;
    public final String type;

    private Logins(String _username, String _type) {
        this.username = _username;
        this.type = _type;
    }
}
