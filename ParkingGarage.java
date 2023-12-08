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
    
    public void determineWhereToPark  (){
        //30 minutes to 10080 min
        //top level will park highest times
        //bottom will hold the lowest times
        int numPossibilities = 10080-30+1; 
        int times [] = new int [numPossibilities];
        for(int i = 0; i < numPossibilities; i++){
            times[i] = i+30;
        }
        
        //if 1 level you get 30-10080
        //if 2 levels you get
    }
    public int getSpaces (){
        return spaces;
    }
    
    public int getnumLevels(){
        return numLevels;
    }
    

    
    
}

