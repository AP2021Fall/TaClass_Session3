package view;

public class LogoutMenu extends Menu{
    public LogoutMenu(String name, Menu parent) {
        super(name, parent);
    }

    @Override
    public void show() {

    }

    @Override
    public void execute() {
        System.out.println(controller.logout());
        parent.show();
        parent.execute();
    }
}
