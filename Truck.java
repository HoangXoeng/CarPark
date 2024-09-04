import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Truck extends Vehicle {
    private static int id = 0;
    private String type;
    private static ArrayList<Truck> listTruck = new ArrayList<Truck>();

    public Truck(int day, int month, int year, String number) {
        super(day, month, year, number);
        id = id + 1;
        this.type = "fourSeat";
        listTruck.add(this);
    }

    public Truck(LocalDate date, String number) {
        super(date, number);
        id = id + 1;
        this.type = "fourSeat";
        listTruck.add(this);
    }

    public static ArrayList<Truck> getListTruck() {
        return listTruck;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override

    public int getTotalAmount() {
        if (this.dayInCarPark() == 0) {
            return 5000;
        } else
            return this.dayInCarPark() * 5000;
    }

    public static String getInforAboutTruck() {
        String result = "____________________Infor about Truck car____________________";
        System.out.println();
        int total = 0;
        int id = -1;
        for (Truck car : listTruck) {
            total = total + 1;
            id = id + 1;
            result += "\nID: " + id + "  Number: " + car.getNumber() + "  Type: " + "Truck " +
                    "  Date check in: " + car.getDateCheckIn().toString()
                    + "\n _________________________________________________________________________________";
        }
        result += "\nTotal number of truck: " + total;
        return result;
    }

    public static Truck getCarByNumber(String carNumber) {
        for (Truck car : listTruck) {
            if (car.getNumber().equals(carNumber)) {
                return car;
            }
        }
        return null;
    }

}
