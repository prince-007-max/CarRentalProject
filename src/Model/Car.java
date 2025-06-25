package Model;

public class Car {

    private int ID;
    private String brand;
    private String model;
    private String color;
    private int year;
    private double price;
    private int available;

    public int getID(){
        return ID;

    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getbrand(){
        return brand;

    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel(){
        return model;

    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getcolor(){
        return color;

    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice(){
        return price;

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int isAvailable(){
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
