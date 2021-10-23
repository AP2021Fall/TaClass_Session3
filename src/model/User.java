package model;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private static HashMap<User, Boolean> allUsers = new HashMap<>();
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isAdmin;
    private ArrayList<Ticket> tickets;

    public User(String username, String firstName,
                String lastName, String email,
                String password, boolean isAdmin) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.tickets = new ArrayList<>();

        allUsers.put(this , true);
    }

    public static HashMap<User, Boolean> getAllUsers() {
        return allUsers;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
