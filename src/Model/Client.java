package Model;

public class Client extends User{

    public Client(){

    }

    @Override
    public void showList() {
        System.out.println("\n1. View Cars");
        System.out.println("2. Rent Car");
        System.out.println("3. Return Car");
        System.out.println("4. Show my Rents");
        System.out.println("5. Edit My Data");
        System.out.println("6. Quit\n");

    }
}
