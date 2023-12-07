package com.krisstelargueta.parkinggarage;

import java.util.*;

public class ParkingGarage {
    ParkingLot parkingLot1 = new ParkingLot(10);
    static int counter1;
    static int counter2;
    static int counter3;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the parking garage. Please select an option: ");
        System.out.println("1. Park your car");
        System.out.println("2. Retrieve your car");
        System.out.println("3. See open spots");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                parkCar();
                break;
            case 2:
               // retrieveCar();
                break;
            case 3:
               // showSpots();
                break;
            default:
                System.out.println("Invalid choice. Please choose an option between 1-3");
                break;
        }
    }
        public static void parkCar(){
            System.out.println("What floor would you like to park on?");
            System.out.println("Floor 1");
            System.out.println("Floor 2");
            System.out.println("Floor 3");
            int floorChoice = sc.nextInt();
            switch(floorChoice){
                case 1:
                    if(counter1==10){
                        System.out.println("The floor is full! Please choose another");
                        parkCar();
                    }else{
                        
                    }
                case 2:
                    if(counter2==10){
                        System.out.println("The floor is full! Please choose another");
                    }else{
                        
                    }
                case 3: 
                    if(counter3==10){
                        System.out.println("The floor is full! Please choose another");
                    }else{
                        
                    }
                    
                default: 
                    System.out.println("Please choose a valid floor!");
                    parkCar();
            }   
        }   
        }
        
