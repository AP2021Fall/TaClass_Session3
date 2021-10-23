package view;

import controller.Controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);
    Controller controller =Controller.getController();
    public void run(){
        while (true){
            System.out.println("Enter your command : ");
            String input = scanner.nextLine();
            String[] inputsInArray = input.split("\\s+");
            if(inputsInArray[0].equalsIgnoreCase("Register")){
                System.out.println(register(inputsInArray));
            }else if(inputsInArray[0].equalsIgnoreCase("logout")){
                System.out.println(controller.logout());
            }else if(inputsInArray[0].equalsIgnoreCase("login")){
                System.out.println(login(inputsInArray));
            }else if(inputsInArray[0].equalsIgnoreCase("addTicket")){
                System.out.println(addTicket(inputsInArray));
            }else if(inputsInArray[0].equalsIgnoreCase("showCommands")){
                System.out.println(showCommands());
            }else if(inputsInArray[0].equalsIgnoreCase("showTickets")){
                System.out.println(controller.showAllTicket());
            }else if(inputsInArray[0].equalsIgnoreCase("showTicketInfo")){
                System.out.println(showTicketInfo(inputsInArray));
            }else if(inputsInArray[0].equalsIgnoreCase("exit"))
                break;
            else{
                System.out.println("Invalid command !!!!");
            }
        }
    }

    private String showTicketInfo(String[] inputsInArray) {
        int ticketId = Integer.parseInt(inputsInArray[1]);
        return controller.showTicketInfo(ticketId);
    }

    private String showCommands() {
        return "Register $username $firstName $lastName $email $password $isAdmin\n" +
                "login $username $password \n" +
                "logout\n" +
                "showUserInfo\n" +
                "showTicketInfo $ticketId\n" +
                "------------\n" +
                "ReserveTicket $ticketId\n" +
                "ChangeTicket $ticketId\n" +
                "CancelTicket $ticketId\n" +
                "-------------\n" +
                "addTicket $capacity $origin $destination $flightTime $flightDuration\n" +
                "------------\n" +
                "showCommands \n" +
                "showTickets";
    }

    private String addTicket(String[] inputsInArray) {
        int capacity = Integer.parseInt(inputsInArray[1]);
        String origin = inputsInArray[2];
        String destination = inputsInArray[3];
        LocalDateTime flightDate  = LocalDateTime.parse(inputsInArray[4]);
        LocalTime flightDuration = LocalTime.parse(inputsInArray[5]);
        return controller.addTicket(capacity , origin , destination , flightDate , flightDuration);
    }

    private String login(String[] inputsInArray) {
        String username = inputsInArray[1];
        String password = inputsInArray[2];
//        return controller.login(username , password);
        return "";
    }

    private String register(String[] inputsInArray) {
        String username = inputsInArray[1];
        String firstName = inputsInArray[2];
        String lastName = inputsInArray[3];
        String email = inputsInArray[4];
        String password = inputsInArray[5];
        return controller.register(username ,firstName , lastName , email , password);
    }
}
