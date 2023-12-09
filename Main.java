package com.krisstelargueta.parkinggarage;
import java.util.Scanner;

public class Main {

    
    
    static int counter1;
    static int counter2;
    static int counter3;
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws TimeException { 
        ParkingGarage garage = new ParkingGarage(3,10);
        int numLevels = garage.getnumLevels();
        
        System.out.println("Welcome to the parking garage. Please select an option: ");
        System.out.println("1. Park your car");
        System.out.println("2. Retrieve your car");
        System.out.println("3. See open spots");
        
        int choice = sc.nextInt();
        
        switch (choice){
            case 1:
                parkCar(garage);
                break;
            case 2:
                System.out.println("Please enter the car id: ");
                int car_id = sc.nextInt();
                retrieveCar(car_id);
                break;
            case 3:
               // showSpots();
                break;
            default:
                System.out.println("Invalid choice. Please choose an option between 1-3");
                break;
        }
    }
        public static void parkCar(ParkingGarage garage) throws TimeException{
            System.out.println("How long is your stay?");
            int time = sc.nextInt(); //time in MINUTES
            Car car = new Car(((int) (Math.random() * 1000) + 1), time);
            int parkAtLevel = garage.determineWhereToPark(car.getParkingDuration());
            garage.parkCarGarage(car, time);
        }  
        
        public static void retrieveCar (int car_id,ParkingGarage garage){
            garage.
            System.out.println("Here is your car, have a great day.");              
        }
}
        