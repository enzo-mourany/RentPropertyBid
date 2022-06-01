package users;

public enum Logins {
    ADMINISTRATOR("Administrator"),
    USER1("User1");

    public final String username;

    private Logins(String _username) {
        this.username = _username;
    }
}
