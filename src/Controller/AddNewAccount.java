package Controller;

import Model.Client;
import Model.Database;
import Model.Operation;
import Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AddNewAccount implements Operation{

    private int acctype;

    public AddNewAccount(int accType){
        this.acctype = accType;
    }


    @Override
    public void operation(Database database, Scanner s, User user) {
        System.out.println("Enter the First Name: ");
        String first_name = s.next();

        System.out.println("Enter the Last name: ");
        String last_name = s.next();
        System.out.println("Enter the Email: ");
        String email = s.next();
        System.out.println("Enter the Phone number: ");
        String phone_number = s.next();
        System.out.println("Enter the Password: ");
        String password = s.next();
        System.out.println("Enter the Confirm Password: ");
        String confirmpassword = s.next();
        while(!password.equals(confirmpassword)){
            System.out.println("Password dosn't match");
            System.out.println("Enter the Password: ");
            password = s.next();
            System.out.println("Enter the Confirm Password: ");
            confirmpassword = s.next();
        }



        try {

            ArrayList<String> emails = new ArrayList<>();
            ResultSet rse = database.getStatement().executeQuery("select `email` from `Users`");
            while(rse.next()){
                emails.add(rse.getString("email"));
            }

            if(emails.contains(email)){
                System.out.println("This email is used before!");
                return;

            }


            String insertQuery = "INSERT INTO Users (first_name, last_name, email, phone_number, password, type) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = database.getConnection().prepareStatement(insertQuery);

            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            pstmt.setString(4, phone_number);
            pstmt.setString(5, password);
            pstmt.setInt(6, acctype);


            pstmt.execute();

            System.out.println("✅ Account created successfully!");

            if(acctype == 0){
                user = new Client();
                user.setFirst_name(first_name);
                user.setLast_name(last_name);
                user.setEmail(email);
                user.setPhoneNumber(phone_number);
                user.setPassword(phone_number);
                user.showList(database,s);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
