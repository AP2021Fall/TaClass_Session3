package view;

import controller.Controller;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Menu {
    protected static Scanner scanner = new Scanner(System.in);
    protected String name;
    protected Menu parent;
    protected HashMap<Integer , Menu> subMenus;
    protected Controller controller;

    public Menu(String name, Menu parent) {
        this.name = name;
        this.parent = parent;
        this.subMenus = new HashMap<>();
        this.controller = Controller.getController();
    }

    public String getName() {
        return name;
    }

    public Menu getParent() {
        return parent;
    }

    public HashMap<Integer, Menu> getSubMenus() {
        return subMenus;
    }

    public void show(){
        System.out.println("----------" + this.name +"----------" );
        if(this.parent != null)
            System.out.println("1.Back");
        else
            System.out.println("1.Exit");
        for(int index : subMenus.keySet()){
            System.out.println("" + index + "."+subMenus.get(index).getName());
        }
    }
    public void execute(){
        Menu nextMenu = this;
        String input = scanner.nextLine().trim();
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            int inputInInteger = Integer.parseInt(input);
            if(inputInInteger > subMenus.size() +1){
                System.out.println("Input is out of boundary!!!!");
            }else{
                if(inputInInteger == 1){
                    if(this.parent == null)
                        System.exit(1);
                    else
                        nextMenu = this.parent;
                }else{
                    nextMenu = subMenus.get(inputInInteger);
                }
            }
        }else{
            System.out.println("Invalid input !!!!");
        }
        nextMenu.show();
        nextMenu.execute();
    }

    protected void returnToParentMenu(String input){
        if(input.trim().equals("back")){
            parent.show();
            parent.execute();
        }
    }

    protected String getInputFromUser(String text){
        System.out.println(text);
        String input = scanner.nextLine();
        returnToParentMenu(input);
        return input;
    }
}
