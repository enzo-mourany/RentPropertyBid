package users;

public enum Logins {
    ADMINISTRATOR("Administrator", "1234"),
    USER1("User1", "0000");

    public final String username;
    public final String password;

    private Logins(String _username, String _password) {
        this.username = _username;
        this.password = _password;
    }
}
