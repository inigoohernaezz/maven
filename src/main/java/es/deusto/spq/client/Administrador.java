package es.deusto.spq.client;

public class Administrador {
    
    private String email;
    private String password;

    public Administrador(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Setters

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString method
    @Override
    public String toString() {
        return "Administrador{" +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
