package controller;

import model.DataBase;
import model.Ticket;
import model.User;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private static Controller controller = new Controller();

    private Controller() {
    }

    public static Controller getController() {
        return controller;
    }

    public String register(String username, String firstName,
                           String lastName, String email,
                           String password) {
        if (findLoggedInUser() != null)
            return "You must log out first !!!";
        if (!isUsernameValid(username)) {
            return "This username has already taken!!!!";
        }
        if (!isEmailValid(email)) {
            return "This email is invalid!!!!";
        }
        if (findAdmin() != null) {
            User user = new User(username, firstName, lastName, email, password, false);
            return "Your account has been created as user";
        } else {
            User user = new User(username, firstName, lastName, email, password, true);
            return "Your account has been created as admin";
        }
    }

    public String logout() {
        User activeUser = findLoggedInUser();
        if (activeUser == null) {
            return "You must first login";
        }
        User.getAllUsers().replace(activeUser, false);
        return "" + activeUser.getUsername() + " has logged out!!";
    }

    public User findAdmin() {
        for (User user : User.getAllUsers().keySet()) {
            if (user.isAdmin())
                return user;
        }
        return null;
    }

    private boolean isUsernameValid(String username) {
        for (User user : User.getAllUsers().keySet()) {
            if (user.getUsername().equals(username))
                return false;
        }
        return true;
    }

    private boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches())
            return true;
        return false;
    }

    private User findLoggedInUser() {
        for (User user : User.getAllUsers().keySet()) {
            if (User.getAllUsers().get(user))
                return user;
        }
        return null;
    }

    public boolean isAnyUserLoggedIn(){
        if(findLoggedInUser() != null)
            return true;
        return false;
    }

    public boolean login(String username, String password) {
        User activeUser = findLoggedInUser();
        if (activeUser != null) {
            System.out.println("You must logout first!!!");
            return false;
        } else {
            for (User user : User.getAllUsers().keySet()) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    activeUser = user;
                }
            }
            if (activeUser == null) {
                System.out.println("Username or password is wrong!!!");
                return false;
            }
            else {
                User.getAllUsers().replace(activeUser, true);
                System.out.println("" + activeUser.getUsername() + " has logged in successfully");
                return true;
            }
        }
    }

    public boolean isLoggedInUserAdmin(){
        User user = findLoggedInUser();
        return user.isAdmin();
    }

    public String addTicket(int capacity, String origin,
                          String destination, LocalDateTime flightDate,
                          LocalTime flightDuration) {
        User activeUser = findLoggedInUser();
        if(activeUser ==null)
            return "You must login as admin first!!";
        if(!activeUser.isAdmin()){
            return "Only admin can add ticket to app!!!!";
        }
        LocalDateTime now = LocalDateTime.now();
        if(flightDate.isBefore(now)){
            return "This date is invalid !!!";
        }
        Ticket ticket = new Ticket(capacity, origin, destination, flightDate, flightDuration);
        return "" + ticket.getId() + " has created successfully.";
    }

    private String showTicket(Ticket ticket){
        return "{" + ticket.getId() + "," + ticket.getOrigin() + "," + ticket.getDestination()
                + " , " + ticket.getFlightDate() + " , " + ticket.getCapacity() + " , " + ticket.getDestination() +" }\n";
    }

    public String showAllTicket(){
        updateTicketList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("------------------------------------\n");
        for(Ticket ticket : Ticket.getAllTickets()){
            stringBuilder.append(showTicket(ticket));
        }
        stringBuilder.append("------------------------------------\n");
        return stringBuilder.toString();
    }
    public void updateTicketList(){
        LocalDateTime now = LocalDateTime.now();
        ArrayList<Ticket> invalidTickets = new ArrayList<>();
        for(Ticket ticket : Ticket.getAllTickets()){
            if(ticket.getFlightDate().isBefore(now)){
                invalidTickets.add(ticket);
            }
        }
        Ticket.getAllTickets().removeAll(invalidTickets);
    }

    public String showTicketInfo(int ticketId) {
        for(Ticket ticket : Ticket.getAllTickets()){
            if(ticket.getId() == ticketId)
                return showTicket(ticket);
        }
        return "This id is invalid !!";
    }
}
