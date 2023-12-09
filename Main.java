package com.krisstelargueta.parkinggarage;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws TimeException {
        boolean exit = false;
        ParkingGarage garage = new ParkingGarage(3, 10);

        do {
            int numLevels = garage.getnumLevels();

            System.out.println("Welcome to the parking garage. Please select an option: ");
            System.out.println("1. Park your car");
            System.out.println("2. Retrieve your car");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    parkCar(garage);
                    break;
                case 2:
                    System.out.println("Please enter the car id: ");
                    int car_id = sc.nextInt();
                    retrieveCar(car_id, garage);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting the program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose an option between 1-3");
                    break;
            }
        } while (!exit);
    }

    public static void parkCar(ParkingGarage garage) throws TimeException {
       int time;

        do {
        System.out.println("How long is your stay? (Enter a time less than 1440 minutes): ");
        time = sc.nextInt();

        if (time <= 0 || time > 1440) {
            System.out.println("Invalid input. Please enter a time less than 1440 minutes.");
        }
        } while (time <= 0 || time > 1440);

        Car car = new Car(((int) (Math.random() * 1000) + 1), time);
        int parkAtLevel = garage.determineWhereToPark(car.getTime());
        garage.parkCarGarage(car, time);
        System.out.println("We have parked your car.\nCar ID: " + car.getCarID() + "\nLevel: " + (parkAtLevel+1));
        garage.printLevelsArray();
    }

    public static void retrieveCar(int car_id, ParkingGarage garage) {
        garage.retrieveCarGarage(car_id);
        System.out.println("Here is your car, have a great day.");
        garage.printLevelsArray();
    }
    
    
}