import java.time.LocalDate;
import java.util.Scanner;

public class Application {
    static Scanner inputVar = new Scanner(System.in);

    public static void main(String[] args) {

        mockData();
        int choice;
        String carNumber;
        do {
            System.out.println("__________________________Menu________________________________");
            System.out.println("1: Wiew ");
            System.out.println("2: Find by car number:");
            System.out.println("3: Add new car");
            System.out.println("4: make bill");
            System.out.println("5: Exit");
            System.out.println("Enter your choice");
            choice = inputVar.nextInt();
            switch (choice) {
                case 1:
                    functionOption1();
                    break;
                case 2:
                    functionOption2();
                    break;
                case 3:
                    inputVar.nextLine();
                    functionOption3();
                    break;
                case 4:
                    functionOption4();
                    break;
            }
        } while (choice != 5);
    }

    public static void functionOption1() {
        System.out.println(FourSeat.getInforAbout4Seat());
        System.out.println(SevenSeat.getInforAbout7Seat());
        System.out.println(Truck.getInforAboutTruck());
    }

    public static void functionOption2() {
        String carNumber;
        int choiceInf2;
        do {
            System.out.println("What type of car: \n1:Four Seat\n2:Sevent Seat\n3:Truck\n4:Exit");
            choiceInf2 = inputVar.nextInt();
            LocalDate currentDate = LocalDate.now();
            switch (choiceInf2) {
                case 1:
                    carNumber = "";
                    System.out.println("Enter car number to find");
                    carNumber = inputVar.next();
                    FourSeat car = FourSeat.getCarByNumber(carNumber);
                    if (car != null) {
                        System.out.println(car.toString());
                        Bill bill4Seat = new Bill(carNumber, currentDate, car.getTotalAmount());
                        FourSeat.getListFourSeat().remove(car);
                        System.out.println("Car number: " + bill4Seat.getCarNumber());
                        System.out.println("Total amount: " + car.getTotalAmount());
                    } else
                        System.out.println("Car not found");
                    break;
                case 2:
                    System.out.println("Enter car number to find");
                    carNumber = inputVar.next();
                    SevenSeat car7 = SevenSeat.getCarByNumber(carNumber);
                    if (car7 != null) {
                        System.out.println(car7.toString());
                        Bill bill7Seat = new Bill(carNumber, currentDate, car7.getTotalAmount());
                        SevenSeat.getListSevenSeat().remove(car7);
                        System.out.println("Car number: " + bill7Seat.getCarNumber());
                        System.out.println("Total amount: " + car7.getTotalAmount());
                        System.out.println("");
                    } else
                        System.out.println("Car not found");
                    break;
                case 3:
                    System.out.println("Enter car number to find");
                    carNumber = inputVar.next();
                    Truck truck = Truck.getCarByNumber(carNumber);
                    if (truck != null) {
                        System.out.println(truck.toString());
                        Bill billTruck = new Bill(carNumber, currentDate, truck.getTotalAmount());
                        Truck.getListTruck().remove(truck);
                        System.out.println("Car number: " + billTruck.getCarNumber());
                        System.out.println("Total amount: " + truck.getTotalAmount());
                        System.out.println("");
                    } else
                        System.out.println("Car not found");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choiceInf2 != 4);
    };

    public static void functionOption3() {
        String carNumber;
        LocalDate currentDate = LocalDate.now();
        System.out.println("Enter car number: ");
        carNumber = inputVar.nextLine();
        System.out.println("Choose your type:");
        System.out.println("1: 4 Seat\n2: 7 Seat\n 3: Truck");
        int type = inputVar.nextInt();
        switch (type) {
            case 1:
                FourSeat newCar = new FourSeat(currentDate, carNumber);
                System.out.println("new car added");
                break;
            case 2:
                SevenSeat newCar7 = new SevenSeat(currentDate, carNumber);
                System.out.println("new car added");
                break;
            case 3:
                Truck newTruck = new Truck(currentDate, carNumber);
                System.out.println("new car added");
                break;
            default:
                break;
        }
    }

    public static void functionOption4() {
        int choice;
        do {

            System.out.println(
                    "1: view total bill in current day\n2: view total bill in specified day\n3: view total bill in specified month\n4:Exit");
            System.out.println("Enter your choice:");
            choice = inputVar.nextInt();
            switch (choice) {
                case 1:
                    LocalDate currentDateInCase4 = LocalDate.now();
                    System.out.println(
                            "Total in curent date: " + Bill.getTotalAmountInDay(currentDateInCase4));
                    break;
                case 2:
                    System.out.println("enter day");
                    int day = inputVar.nextInt();
                    System.out.println("enter month");
                    int month = inputVar.nextInt();
                    System.out.println("enter year");
                    int year = inputVar.nextInt();
                    LocalDate specificDate = LocalDate.of(year, month, day);
                    System.out.println(
                            "Total in specific date: " + Bill.getTotalAmountInDay(specificDate));
                    break;
                case 3:
                    System.out.println("enter month");
                    int monthCase3 = inputVar.nextInt();
                    System.out.println("enter year");
                    int yearCase3 = inputVar.nextInt();
                    System.out.println(
                            "Total in specific date: " + Bill.getTotalAmountInMonth(monthCase3, yearCase3));
                    break;
                default:
                    break;
            }
        } while (choice != 4);
    }

    public static void mockData() {
        FourSeat carFourSeat1 = new FourSeat(20, 8, 2024, "74AB283122");
        FourSeat carFourSeat2 = new FourSeat(2, 9, 2024, "74AB183122");
        FourSeat carFourSeat3 = new FourSeat(1, 9, 2024, "74AB183172");
        FourSeat carFourSeat4 = new FourSeat(1, 9, 2024, "74AB183182");
        FourSeat carFourSeat5 = new FourSeat(1, 9, 2024, "74AB83122");

        SevenSeat carSevenSeat1 = new SevenSeat(20, 8, 2024, "74AB2834522");
        SevenSeat carSevenSeat2 = new SevenSeat(2, 9, 2024, "74AB1834522");
        SevenSeat carSevenSeat3 = new SevenSeat(1, 9, 2024, "74AB18311232");
        SevenSeat carSevenSeat4 = new SevenSeat(1, 9, 2024, "74AB181482");
        SevenSeat carSevenSeat5 = new SevenSeat(1, 9, 2024, "74AB182422");

        Truck carTruck1 = new Truck(20, 8, 2024, "74AB28322");
        Truck carTruck2 = new Truck(2, 9, 2024, "74AB183122");
        Truck carTruck3 = new Truck(1, 9, 2024, "74AB18342");
        Truck carTruck4 = new Truck(1, 9, 2024, "74AB1831232");
        Truck carTruck5 = new Truck(1, 9, 2024, "74AB18324");

        Bill bill1 = new Bill("74AB123222", LocalDate.of(2024, 9, 2), 20000);
        Bill bill2 = new Bill("74AB123222", LocalDate.of(2024, 9, 2), 10000);
        Bill bill3 = new Bill("74AB123222", LocalDate.of(2024, 9, 4), 15000);
        Bill bill4 = new Bill("74AB123222", LocalDate.of(2024, 9, 4), 13000);
        Bill bill5 = new Bill("74AB123222", LocalDate.of(2024, 9, 1), 17000);
        Bill bill6 = new Bill("74AB123222", LocalDate.of(2024, 9, 1), 9000);

    }

}
