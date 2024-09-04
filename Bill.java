import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bill {
    private static ArrayList<Bill> listBill = new ArrayList<Bill>();

    private String carNumber;
    private LocalDate date;
    private int amount;

    public Bill(String carNumber, LocalDate date, int amount) {
        this.carNumber = carNumber;
        this.date = date;
        this.amount = amount;
        listBill.add(this);
    }

    public static ArrayList<Bill> getListBill() {
        return listBill;
    }

    public static void setListBill(ArrayList<Bill> listBill) {
        Bill.listBill = listBill;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setType(String carNumber) {
        this.carNumber = carNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public static int getTotalAmountInDay(LocalDate date) {
        int totalAmoutInDay = 0;
        for (Bill billItem : listBill) {
            if (billItem.getDate().equals(date)) {
                totalAmoutInDay += billItem.getAmount();
            }
        }
        return totalAmoutInDay;
    }

    public static int getTotalAmountInMonth(int month, int year) {
        int totalAmoutInMonth = 0;
        for (Bill billItem : listBill) {
            if (billItem.getDate().getMonth().getValue() == month && billItem.getDate().getYear() == year) {
                totalAmoutInMonth += billItem.getAmount();
            }
        }
        return totalAmoutInMonth;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getAmount());
    }
}
