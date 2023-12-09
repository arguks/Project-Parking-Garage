package com.krisstelargueta.parkinggarage;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

 
    public static void main(String[] args) throws TimeException {
        boolean exit = false;
        ParkingGarage garage = new ParkingGarage(3, 10);

        //this will iterate until the user inputs 3 to exit the program
        do {
            int numLevels = garage.getnumLevels();

            System.out.println("Welcome to the parking garage. Please select an option: ");
            System.out.println("1. Park your car");
            System.out.println("2. Retrieve your car");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            //the switch cases will determin what the program will do based on user input
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

    //this method will park the users car, there is a loop that will not allow a user to enter a time above 1440 minutes
    //a car will also be randomly assigned a car id from 1-1000
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

    //this method will retrieve the car for the customer
    public static void retrieveCar(int car_id, ParkingGarage garage) {
        garage.retrieveCarGarage(car_id);
        System.out.println("Here is your car, have a great day.");
        garage.printLevelsArray();
    }
    
    
}