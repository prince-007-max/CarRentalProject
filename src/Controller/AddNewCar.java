package Controller;

import Model.Database;
import Model.Operation;
import Model.User;

import java.sql.*;

import java.util.Scanner;

public class AddNewCar implements Operation {


    @Override
    public void operation(Database database, Scanner s, User user) {

        System.out.println("Enter the Brand: ");
        String brand = s.next();
        System.out.println("Enter the model: ");
        String model = s.next();
        System.out.println("Enter the color: ");
        String color = s.next();
        System.out.println("Enter year (int): ");
        int year = s.nextInt();
        System.out.println("Enter the hour(double): ");
        double price = s.nextDouble();
        int available = 0;

        try{
            String sql = """
            INSERT INTO Cars
                   (brand, model, color, year, price, available)
            VALUES (?, ?, ?, ?, ?, ?)
            """;
            Connection con = database.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
