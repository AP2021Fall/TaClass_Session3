package view;

public class RegisterMenu extends Menu{
    public RegisterMenu(String name, Menu parent) {
        super(name, parent);
    }
    @Override
    public void show(){
        System.out.println("----------" + this.name +"----------" );
        System.out.println("Write back to return");
    }

    @Override
    public void execute() {
        Menu nextMenu = this;
        String username = getInputFromUser("Enter your username : ");
        String firstName = getInputFromUser("Enter your first name : ");
        String lastName = getInputFromUser("Enter your last name : ");
        String password = getInputFromUser("Enter your password : ");
        String email = getInputFromUser("Enter your email : ");

        String outPut = controller.register(username ,firstName , lastName , email , password);
        System.out.println(outPut);
        if(outPut.equals("Your account has been created as admin")){
            nextMenu = new AdminMenu("Admin menu" , this.parent);
        }else if(outPut.equals("Your account has been created as user")){
            nextMenu = new UserMenu("User menu" , this.parent);
        }
        //TODO change menu to user menu
        nextMenu.show();
        nextMenu.execute();
    }
}
