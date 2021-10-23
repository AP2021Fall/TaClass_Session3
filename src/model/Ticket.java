package model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Ticket {
    private static ArrayList<Ticket> allTickets = new ArrayList<>();
    private int id;
    private int capacity;
    private final String origin;
    private final String destination;
    private final LocalDateTime flightDate;
    private final LocalTime flightDuration;
    private ArrayList<User> users;

    public Ticket(int capacity, String origin,
                  String destination, LocalDateTime flightDate,
                  LocalTime flightDuration) {
        generateId();
        this.capacity = capacity;
        this.origin = origin;
        this.destination = destination;
        this.flightDate = flightDate;
        this.flightDuration = flightDuration;
        this.users = new ArrayList<>();
        allTickets.add(this);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    private void generateId(){
        if(allTickets.isEmpty()){
            this.id =0;
        }else{
            int lastIndex = allTickets.size() -1;
            int lastId = allTickets.get(lastIndex).getId();
            this.id = lastId +1 ;
        }
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public static ArrayList<Ticket> getAllTickets() {
        return allTickets;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getFlightDate() {
        return flightDate;
    }

    public LocalTime getFlightDuration() {
        return flightDuration;
    }
}
