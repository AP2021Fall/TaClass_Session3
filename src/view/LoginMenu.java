package view;

public class LoginMenu extends Menu{
    public LoginMenu(String name, Menu parent) {
        super(name, parent);
    }

    @Override
    public void show() {
        System.out.println("----------" + this.name +"----------" );
        System.out.println("Write back to return");
    }

    @Override
    public void execute() {
        Menu nextMenu = this;
        String username = getInputFromUser("Enter your username : ");
        String password = getInputFromUser("Enter your password : ");
        boolean output = controller.login(username , password);
        if(output){
            if(controller.isLoggedInUserAdmin())
                nextMenu = new AdminMenu("Admin menu" , this.parent);
            else
                nextMenu = new UserMenu("User menu" , this.parent);
        }
        nextMenu.show();
        nextMenu.execute();
    }
}
