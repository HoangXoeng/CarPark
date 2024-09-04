import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class SevenSeat extends Vehicle{
    private static int id = 0;
    private String type;
    private static ArrayList<SevenSeat> listSevenSeat = new ArrayList<SevenSeat>(); 
    public SevenSeat(int day, int month, int year, String number){
        super(day, month, year, number);
        id = id + 1;
        this.type = "fourSeat";
        listSevenSeat.add(this);
    }
    public SevenSeat(LocalDate date, String number){
        super(date, number);
        id = id + 1;
        this.type = "fourSeat";
        listSevenSeat.add(this);
    }
    public static ArrayList<SevenSeat> getListSevenSeat() {
        return listSevenSeat;
    }
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Override

    public int getTotalAmount(){
        if (this.dayInCarPark() == 0){
            return 4000;
        }
        else return this.dayInCarPark() * 4000;
    }


    public static String getInforAbout7Seat() {
        String result = "____________________Infor about 7 seat car____________________";
        System.out.println();
        int id = -1;
        int total = 0;
        for (SevenSeat car : listSevenSeat) {
            id = id +1 ;
            total = total + 1;
            result += "\nID: " + id + "  Number: " + car.getNumber() + "  Type: " + "Sevent Seat " +
                      "  Date check in: " + car.getDateCheckIn().toString() + "\n _________________________________________________________________________________";
        }
        result += "\nTotal number of 7 Seat: " + total;
        return result;
    }

    public static SevenSeat getCarByNumber(String carNumber){
        for (SevenSeat car : listSevenSeat) {
            if (car.getNumber().equals(carNumber)) {
                return car;
            }
        }
        return null;
    }

}
