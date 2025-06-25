package Controller;

import Model.Admin;
import Model.Client;
import Model.Database;
import Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Database database = new Database();
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to car Rental System! ");
        System.out.println("Enter the email:\n(-1) to create new account");
        String email = s.next();
        if(email.equals("-1")){
            new AddNewAccount(0).operation(database,s,null);
            return;
        }
        System.out.println("Enter the Password: ");
        String password = s.next();

        ArrayList<User> users = new ArrayList<>();

        try{
            String select = "SELECT * FROM Users";
            ResultSet rs = database.getStatement().executeQuery(select);
            while(rs.next()){
                User user;
                int ID = rs.getInt("ID");
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");
                String em = rs.getString("email");
                String phonenum = rs.getString("phone_number");
                String pass = rs.getString("password");
                int type = rs.getInt("Type");

                if(type == 0) {

                    user = new Client();
                    user.setID(ID);
                    user.setFirst_name(firstname);
                    user.setLast_name(lastname);
                    user.setEmail(em);
                    user.setPhoneNumber(phonenum);
                    user.setPassword(pass);
                    users.add(user);

                }
                else if (type == 1) {

                    user = new Admin();
                    user.setID(ID);
                    user.setFirst_name(firstname);
                    user.setLast_name(lastname);
                    user.setEmail(em);
                    user.setPhoneNumber(phonenum);
                    user.setPassword(pass);
                    users.add(user);
                }




            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        boolean loggedIn = false;
        for(User u: users) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                System.out.println("Welcome " + u.getFirst_name() + "!");
                loggedIn = true;
                u.showList(database, s);
            }
        }

        if(!loggedIn){
            System.out.println("Email or password not match!");
            s.close();
        }
    }
}
