package com.krisstelargueta.parkinggarage;

public class ParkingGarage {

    private ParkingLot [] levels;
    private int spaces;
    private int numLevels;
    
    public ParkingGarage(int floors, int spaces){
        if(floors > 0){
          numLevels = floors;
          levels = new ParkingLot [numLevels];
          this.spaces = spaces;
        
          for(ParkingLot x: levels){
              x = new ParkingLot(spaces);
          }  
        } else {
            throw new IndexOutOfBoundsException("You cannot create a garage with less than 1 level");
        }
        
        
    }
    
    //this parks the car at the level we determined in method determine where to park
    public void parkCarGarage (Car car, int time){
        levels[determineWhereToPark(time)].parkCarLevel(car);
    }
    
    //this returns which level we are parking the car
    public int determineWhereToPark  (int time){
        
        //ex. 3 levels will have 480 minute interval each level
        // Level 1: 1- 479
        // Level 2: 481-960
        // Level 3: 961-1440
        
        //total range size
        int timePerLevel = 1440/numLevels;
        
        //max time at the lowest level
        int currMax = timePerLevel;
        int currMin = 1;
        int currLevel = 0;
        boolean found = false;
        
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
    public Car findCar (int carID){
        for(ParkingLot level: levels){
            if(level.carExists(carID)){
                return level.findCar(carID);
            }
        }
        return null;
    }
    
    public void retrieveCarGarage (int carID){
        Car car = findCar(carID);
        int carLoc = determineWhereToPark(car.getTime());
        levels[carLoc].retrieveCarLevel(car);
    }
    
    public int getSpaces (){
        return spaces;
    }
    
    public int getnumLevels(){
        return numLevels;
    }
    

    
    
}

