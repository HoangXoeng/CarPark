import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Vehicle{
    private static int total = 0;
    private LocalDate dateCheckIn;
    private String carNumber;

    public Vehicle(int day, int month, int year, String number){
        
        this.dateCheckIn = LocalDate.of(year, month, day);
        if (this.dayInCarPark() >= 0) {
            total = total + 1;
            this.carNumber = number;
        }
        else{
            throw new IllegalArgumentException("The date of check-in cannot be in the furute.");
        }
    }
    public Vehicle(LocalDate date, String number){
        this.dateCheckIn = date;
        this.carNumber = number;
    }

    
    public static int getTotal() {
        return total;
    }

    public LocalDate getDateCheckIn() {
        return dateCheckIn;
    }
    public void setDateCheckIn(LocalDate dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }
    public String getNumber() {
        return carNumber;
    }
    public void setNumber(String number) {
        this.carNumber = number;
    }   

    public abstract int getTotalAmount();

    public int dayInCarPark() {
        LocalDate currentDate = LocalDate.now();
        return (int) ChronoUnit.DAYS.between(this.dateCheckIn, currentDate);
    }
    


}