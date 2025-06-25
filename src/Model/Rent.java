package Model;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Rent extends User{

    private int ID;
    private User user;
    private Car car;
    private LocalDateTime dataTime;
    private int hours;
    private double total;
    private String status;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM hh:mm");

    public Rent(){
        dataTime = LocalDateTime.now();
    }

    public int getID(){
        return ID;

    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = LocalDateTime.parse(dataTime, formatter);
    }

    public String getDataTime(){
        return formatter.format(dataTime);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public void showList(Database database, Scanner s) {

    }
}
