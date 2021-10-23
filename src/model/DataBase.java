package model;

import java.util.HashMap;

public class DataBase {
    private static DataBase dataBase = new DataBase();

    private HashMap<User , Boolean> allUsers;

    private DataBase() {
        this.allUsers = new HashMap<>();
    }

    public static DataBase getDataBase() {
        return dataBase;
    }

    public HashMap<User, Boolean> getAllUsers() {
        return allUsers;
    }
}
