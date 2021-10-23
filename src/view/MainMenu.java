package view;

public class MainMenu extends Menu{
    public MainMenu(String name, Menu parent) {
        super(name, parent);
            subMenus.put(2, new RegisterMenu("Register", this));
            subMenus.put(3, new LoginMenu("Login", this));
            subMenus.put(4, new TicketMenu("Tickets", this));
    }

    @Override
    public void show() {
        if(controller.isAnyUserLoggedIn()) {
            this.getSubMenus().clear();
            this.subMenus.put(2, new LogoutMenu("Logout", this));
            this.subMenus.put(3, new TicketMenu("Ticket", this));
        }else {
            this.getSubMenus().clear();
            subMenus.put(2, new RegisterMenu("Register", this));
            subMenus.put(3, new LoginMenu("Login", this));
            subMenus.put(4, new TicketMenu("Tickets", this));
        }
        super.show();
    }

    @Override
    public void execute() {
        super.execute();
    }
}
