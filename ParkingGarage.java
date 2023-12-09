package com.krisstelargueta.parkinggarage;

public class ParkingGarage {

    private ParkingLot [] levels;
    private int spaces;
    private int numLevels;
    private Space [] spots;
    
    public ParkingGarage(int floors, int spaces) {
    if (floors > 0) {
        numLevels = floors;
        levels = new ParkingLot[numLevels];
        this.spaces = spaces;

        for (int i = 0; i < numLevels; i++) {
            levels[i] = new ParkingLot(spaces);
        }
    } else {
        throw new IndexOutOfBoundsException("You cannot create a garage with less than 1 level");
    }
}
    
    //this parks the car at the level we determined in method determine where to park
    public void parkCarGarage (Car car, int time){
        if(time <= 1440){
        levels[determineWhereToPark(time)].parkCarLevel(car);
        } else {
            throw new ArrayIndexOutOfBoundsException("You cannot park over 24 hours");
        }
    }
    
    //this returns which level where we will be parking the car
    public int determineWhereToPark  (int time){
        
        //ex. 3 levels will have 480 minute interval each level
        // Level 1: 1- 480
        // Level 2: 481-960
        // Level 3: 961-1440
        
        //total range size
        int timePerLevel = 1440/numLevels;
        
        //max time at the highest level
        int currMax = timePerLevel;
        int currMin = 1;
        int currLevel = 0;
        boolean found = false;
        
        //this while loop will check if the time is within the range of minutes and if the current level is not full
        //if it is full, we will increment the min, max and go to the next level
        //when an acceptable level is found we will return the current level
        while(!found && currLevel < numLevels){
            if(time>=currMin && time <= currMax){
                if(!levels[currLevel].isFull()){
                    found = true;
                } else {
                    currLevel++;
                    currMin = currMax+1;
                    currMax += timePerLevel;
                }
            } else {
                currLevel++;
                currMin = currMax+1;
                currMax += timePerLevel;
            }
        }
        return currLevel;
    }
    
    //this will find a car in the level and return the car if it exists
    public Car findCar (int carID){
        for(ParkingLot level: levels){
            if(level.carExists(carID)){
                return level.findCar(carID);
            }
        }
        return null;
    }
    
    //this will iterate through the levels, check if the car exists in each level and then retrieve the car for the customer
    public void retrieveCarGarage (int carID){
        for(ParkingLot level: levels){
            if(level.carExists(carID)){
                level.retrieveCarLevel(carID);
            }
        }
    }
    
    //getter methods
    public int getSpaces (){
        return spaces;
    }
    
    public int getnumLevels(){
        return numLevels;
    }
    
    //this will print the arrays in order to visualize the parking garage
    public void printLevelsArray() {
        for (int i = 0; i < getnumLevels(); i++) {
            System.out.print("Level " + (i + 1) + ": [");
            spots = levels[i].getSpots();

            for (int j = 0; j < spots.length; j++) {
                if (!spots[j].isEmpty()) {
                    System.out.print(spots[j].getParkedCar().getCarID());
                } else {
                    System.out.print("Empty");
                }

                if (j < spots.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println("]");
        }
    }
    
    
}

