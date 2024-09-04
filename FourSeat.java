import java.util.*;
import java.time.LocalDate;

public class FourSeat extends Vehicle {
    private static int id = 0;
    private String type;
    private static ArrayList<FourSeat> listFourSeat = new ArrayList<FourSeat>();

    public FourSeat(int day, int month, int year, String number) {
        super(day, month, year, number);
        id = id + 1;
        this.type = "fourSeat";
        listFourSeat.add(this);
    }

    public FourSeat(LocalDate date, String number) {
        super(date, number);
        id = id + 1;
        this.type = "fourSeat";
        listFourSeat.add(this);
    }

    public static ArrayList<FourSeat> getListFourSeat() {
        return listFourSeat;
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
            return 3000;
        } else
            return this.dayInCarPark() * 3000;
    }

    public static String getInforAbout4Seat() {
        String result = "____________________Infor about 4 seat car____________________";
        System.out.println();
        int id = -1, total = 0;
        for (FourSeat car : listFourSeat) {
            id = id + 1;
            total = total + 1;
            result += "\nID: " + id + "  Number: " + car.getNumber() + "  Type: " + "Four Seat " +
                    "  Date check in: " + car.getDateCheckIn().toString()
                    + "\n _________________________________________________________________________________";
        }
        result += "\nTotal number of 4 seat: " + total;

        return result;
    }

    public static FourSeat getCarByNumber(String carNumber) {
        for (FourSeat car : listFourSeat) {
            if (car.getNumber().equals(carNumber)) {
                return car;
            }
        }
        return null;
    }

}
